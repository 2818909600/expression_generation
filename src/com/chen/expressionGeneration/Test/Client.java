package com.chen.expressionGeneration.Test;


import java.util.List;

public class Client {
    public static void main(String[] args) {
        Equation equation;
        EquationFactory equationFactory = new ThreeOperandEquationFactory();
        char[] operators = EquationUtils.generationRandomOperators(2);
        List<Equation> equations=equationFactory.generateEquations(20,0,100,operators,false);
        EquationUtils.printHeader(20,100);
        EquationUtils.printGenerationEquations(equations);
        EquationUtils.printCalculations(equations);
    }
}
