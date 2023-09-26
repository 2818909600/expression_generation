package com.chen.expressionGeneration.Test;

import java.util.List;

public abstract class Equation {
    public int result;
    public abstract String toString();
    public abstract List<Equation> generateEquations(int number);
}
