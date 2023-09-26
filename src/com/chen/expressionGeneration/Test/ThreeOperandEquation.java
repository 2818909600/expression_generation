package com.chen.expressionGeneration.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreeOperandEquation extends Equation{
    private int leftNum;
    private int middleNum;
    private int rightNum;
    private char leftOperator;
    private char rightOperator;
    private int equationNumber;
    private List<ThreeOperandEquation> equationList;
    private int min;
    private int max;
    private char[] operators;
    private boolean operatorIsRandoom;
    public ThreeOperandEquation() {
        this.equationList=new ArrayList<>();
        this.min=0;
        this.max=100;
        this.operators=new char[]{'+','+'};
        this.operatorIsRandoom=false;

    }

    public int getLeftNum() {
        return leftNum;
    }

    public void setLeftNum(int leftNum) {
        this.leftNum = leftNum;
    }

    public int getMiddleNum() {
        return middleNum;
    }

    public void setMiddleNum(int middleNum) {
        this.middleNum = middleNum;
    }

    public int getRightNum() {
        return rightNum;
    }

    public void setRightNum(int rightNum) {
        this.rightNum = rightNum;
    }

    public char getLeftOperator() {
        return leftOperator;
    }

    public void setLeftOperator(char leftOperator) {
        this.leftOperator = leftOperator;
    }

    public char getRightOperator() {
        return rightOperator;
    }

    public void setRightOperator(char rightOperator) {
        this.rightOperator = rightOperator;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public boolean isOperatorIsRandoom() {
        return operatorIsRandoom;
    }

    public void setOperatorIsRandoom(boolean operatorIsRandoom) {
        this.operatorIsRandoom = operatorIsRandoom;
    }

    public  boolean isEqual(ThreeOperandEquation e1, ThreeOperandEquation e2) {
        boolean flag = false;
        if(e1.getLeftOperator() != e2.getLeftOperator() ||
                e1.getRightOperator() != e2.getRightOperator()) {

            flag = false;
        }
        else {
            flag = e1.getLeftNum() == e2.getLeftNum() &&
                    e1.getMiddleNum() == e2.getMiddleNum() &&
                    e1.getRightNum() == e2.getRightNum();
        }
        return flag;
    }

    public  boolean occursIn(ThreeOperandEquation e, List<ThreeOperandEquation> ex, int n) {
        boolean b = false;
        for(int i = 0; i < n-1; i++) {
            if(isEqual(e, ex.get(i))) {
                b = true;
                break;
            }
        }
        return b;
    }
    private int generateNum(int min, int max){
        Random random=new Random();
        return random.nextInt(max-min+1)+min;
    }
    private ThreeOperandEquation generateEquation(int min, int max, char[] operators){
        ThreeOperandEquation equation=new ThreeOperandEquation();
        int leftNum,middleNum,rightNum,result;
        do{
            leftNum = generateNum(min, max);
            middleNum = generateNum(min, max);
            rightNum = generateNum(min,max);
            if(operators[0]=='+'){
                result=leftNum+middleNum;
            }else {
                result=leftNum-middleNum;
            }
            if(operators[1]=='+'){
                result+=rightNum;
            }else {
                result-=rightNum;
            }
        }while (result<min || result >max);
        equation.setLeftNum(leftNum);
        equation.setMiddleNum(middleNum);
        equation.setRightNum(rightNum);
        equation.setLeftOperator(operators[0]);
        equation.setRightOperator(operators[1]);
        equation.setResult(result);
        return equation;
    }
    public void setMinAndMax(int min,int max){
        this.min=min;
        this.max=max;
    }
    public void setOperators(char[] operators){
        this.operators=operators;
    }

    @Override
    public List<Equation> generateEquations(int number) {
        int effectiveEquationNumber=0;
        List<Equation> equations = new ArrayList<>();
        while (true){
            if(operatorIsRandoom){
                operators=EquationUtils.generationRandomOperators(2);
            }
            ThreeOperandEquation equation=new ThreeOperandEquation().generateEquation(min,max,operators);
            equationList.add(equation);
            equationNumber++;
            if(!occursIn(equation,equationList,equationNumber)){
                effectiveEquationNumber++;
                equations.add(equation);
            }
            if(effectiveEquationNumber == number){
                break;
            }
        }
        return equations;
    }

    @Override
    public String toString() {
        return ""+leftNum+leftOperator+middleNum+rightOperator+rightNum+"=";
    }
}
