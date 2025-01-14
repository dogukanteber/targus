package com.targus.ui;

import com.targus.base.OptimizationProblem;
import com.targus.base.Solution;
import com.targus.problem.wsn.WSNOptimizationProblem;
import com.targus.ui.controllers.*;
import com.targus.ui.widgets.PotentialPosition;
import com.targus.ui.widgets.Sensor;
import com.targus.ui.widgets.Target;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.event.ActionEvent;

public class Mediator {
    private MainController mainController;
    private InputsController inputsController;
    private ObjectiveValueDisplayController objectiveValueDisplayController;
    private SimplifiedObjectiveValueDisplayController simplifiedObjectiveValueDisplayController;
    private MapController mapController;
    private ProgressBarController progressBarController;
    private CreateProblemInstanceController createProblemInstanceController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void setInputsController(InputsController inputsController) {
        this.inputsController = inputsController;
    }

    public void setObjectiveValueDisplayController(ObjectiveValueDisplayController objectiveValueDisplayController) {
        this.objectiveValueDisplayController = objectiveValueDisplayController;
    }

    public void setSimplifiedObjectiveValueDisplayController(
            SimplifiedObjectiveValueDisplayController simplifiedObjectiveValueDisplayController) {
        this.simplifiedObjectiveValueDisplayController = simplifiedObjectiveValueDisplayController;
    }

    public void setMapController(MapController mapController) {
        this.mapController = mapController;
    }

    public void setProgressBarController(ProgressBarController progressBarController) {
        this.progressBarController = progressBarController;
    }

    public void setCreateProblemInstanceController(CreateProblemInstanceController createProblemInstanceController) {
        this.createProblemInstanceController = createProblemInstanceController;
    }

    public void resizeMapPane(double width, double height) {
        mapController.resizePane(width, height);
    }

    public void display() {
        objectiveValueDisplayController.display();
    }

    public void removeChild(Object child) {
        mapController.removeChild(child);
        display();
    }

    public void addTarget(Target target) {
        inputsController.addTarget(target);
        display();
    }

    public void addSensor(Sensor sensor) {
        inputsController.addSensor(sensor);
        display();
    }

    public void removeSensor(Sensor sensor) {
        inputsController.removeSensor(sensor);
        display();
    }

    public void removeChildren() {
        mapController.removeChildren();
        display();
    }

    public void addPotentialPosition(PotentialPosition potentialPosition) {
        inputsController.addPotentialPosition(potentialPosition);
        display();
    }

    public void clearTargets() {
        inputsController.clearTargets();
        display();
    }

    public void clearPotentialPositions() {
        inputsController.clearPotentialPositions();
        display();
    }

    public void clearSensors() {
        inputsController.clearSensors();
        display();
    }

    public void resetRegion() {
        mapController.resetRegion();
    }

    public void setProgressLabelText(String text) {
        progressBarController.setProgressLabelText(text);
    }

    public void bindProgressBar(ReadOnlyDoubleProperty property) {
        progressBarController.bindProgressBar(property);
    }

    public Solution getSolution() {
        return inputsController.getSolution();
    }

    public OptimizationProblem getOptimizationProblem() {
        return inputsController.getWsnOptimizationProblem();
    }

    public void loadFromFile(ActionEvent event) {
        inputsController.handleLoadFromFile(event);
    }

    public void exportToFile(ActionEvent event) {
        inputsController.handleExportToFile(event);
    }

    public void solve() {
        inputsController.handleSolve();
    }

    public void clean() {
        inputsController.handleCleanSolution();
    }

    public void simplifiedDisplay(double weightedSensorValue, double weightedMConnValue, double weightedKCovValue) {
        simplifiedObjectiveValueDisplayController.simplifiedDisplay(weightedSensorValue, weightedMConnValue, weightedKCovValue);
    }

    public void createProblemInstance(WSNOptimizationProblem wsnOptimizationProblem, int width, int height, int distance, int numberNodes) {
        inputsController.createProblemInstance(wsnOptimizationProblem, width, height, distance, numberNodes);
    }

    public void setProgressBarVisible(boolean visible) {
        progressBarController.setProgressBarVisible(visible);
    }


    public void addTargetToPane(Target target) {
        mapController.addTargetToPane(target);
    }

    public void addPotentialPositionToPane(PotentialPosition potentialPosition) {
        mapController.addPotentialPositionToPane(potentialPosition);
    }

    public void addSensorToPane(Sensor sensor) {
        mapController.addSensorToPane(sensor);
    }

    public void bringTargetsToFront() {
        mapController.bringTargetsToFront();
    }

    public void bringPotentialPositionsToFront() {
        mapController.bringPotentialPositionsToFront();
    }

    public void bringSensorDevicesToFront() {
        mapController.bringSensorDevicesToFront();
    }

    public void displayNonApplicable() {
        objectiveValueDisplayController.displayNonApplicable();
    }

    public void simplifiedDisplayNonApplicable() {
        simplifiedObjectiveValueDisplayController.simplifiedDisplayNonApplicable();
    }

    public String getAlgorithm() {
        return mainController.getAlgorithm();
    }

    public String getMutation() {
        return mainController.getMutation();
    }

    public Double getMutationRate() {
        return mainController.getMutationRate();
    }

    public String getTermination() {
        return mainController.getTermination();
    }

    public int getTerminationValue() {
        return mainController.getTerminationValue();
    }
}
