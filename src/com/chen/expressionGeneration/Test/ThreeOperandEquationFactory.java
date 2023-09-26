package com.chen.expressionGeneration.Test;

import java.util.List;

public class ThreeOperandEquationFactory implements EquationFactory{
    private ThreeOperandEquation threeOperandEquation;

    public ThreeOperandEquationFactory() {
        this.threeOperandEquation=new ThreeOperandEquation();
    }

    @Override
    public List<Equation> generateEquations(int number,int min,int max,char[] operators,boolean operatorIsRandom) {
        threeOperandEquation.setMinAndMax(min, max);
        threeOperandEquation.setOperators(operators);
        threeOperandEquation.setOperatorIsRandoom(operatorIsRandom);
        return threeOperandEquation.generateEquations(number);
    }

}
