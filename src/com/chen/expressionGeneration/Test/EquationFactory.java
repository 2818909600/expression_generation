package com.chen.expressionGeneration.Test;

import java.util.List;

public interface EquationFactory {
    public List<Equation> generateEquations(int number,int min,int max,char[] operators,boolean operatorIsRandom);
}
