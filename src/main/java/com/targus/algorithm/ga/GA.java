package com.targus.algorithm.ga;

import com.targus.algorithm.base.SingleObjectiveOA;
import com.targus.base.OptimizationProblem;

import java.lang.reflect.Field;
import java.util.*;

public abstract class GA implements SingleObjectiveOA {
    protected OptimizationProblem problem;
    protected Population population;
    protected SelectionPolicy selectionPolicy;
    protected SurvivalPolicy survivalPolicy;
    protected CrossOverOperator crossOverOperator;
    protected MutationOperator mutationOperator;
    protected TerminalState terminalState;

    public GA(Builder builder) {
        this.problem = builder.problem;
        this.population = builder.population;
        this.selectionPolicy = builder.selectionPolicy;
        this.survivalPolicy = builder.survivalPolicy;
        this.crossOverOperator = builder.crossOverOperator;
        this.mutationOperator = builder.mutationOperator;
        this.terminalState = builder.terminalState;
    }

    public static abstract class Builder {
        protected OptimizationProblem problem;
        protected Population population;
        protected SelectionPolicy selectionPolicy;
        protected SurvivalPolicy survivalPolicy;
        protected CrossOverOperator crossOverOperator;
        protected MutationOperator mutationOperator;
        protected TerminalState terminalState;

        public Builder(OptimizationProblem problem) {
            this.problem = problem;
        }

        public abstract GA build();

        protected void basicBuild() {
            if (population == null) {
                population = new SimplePopulation(100);
            }
            if (selectionPolicy == null) {
                selectionPolicy = new RouletteWheelSelection();
            }
            if (survivalPolicy == null) {
                survivalPolicy = new SimpleSurvival();
            }
            if (crossOverOperator == null) {
                crossOverOperator = new OnePointCrossOver();
            }
            if (mutationOperator == null) {
                mutationOperator = new OneBitMutation();
            }
        }

        public Builder setPopulation(Population population) {
            this.population = population;
            return this;
        }

        public Builder setSelectionPolicy(SelectionPolicy policy) {
            this.selectionPolicy = policy;
            return this;
        }

        public Builder setSurvivalPolicy(SurvivalPolicy policy) {
            this.survivalPolicy = policy;
            return this;
        }

        public Builder setCrossOverOperator(CrossOverOperator operator) {
            this.crossOverOperator = operator;
            return this;
        }

        public Builder setMutationOperator(MutationOperator operator) {
            this.mutationOperator = operator;
            return this;
        }

        public Builder setTerminalState(TerminalState state) {
            this.terminalState = state;
            return this;
        }

    }

    protected boolean notRunnable() {
        Field[] fields = this.getClass().getDeclaredFields();

        return Arrays.stream(fields).anyMatch(Objects::isNull);
    }

    public TerminalState getTerminalState() {
        return terminalState;
    }

}
