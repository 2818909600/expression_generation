package com.chen.expressionGeneration.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class EquationUtils {
    public static void printHeader(int equationNumber,int numberRange){
        StringBuilder stringBuilder=new StringBuilder("------------------------------------\n");
        stringBuilder.append("-程序输出"+equationNumber+"道"+numberRange+"以内的加减法算式的习题-\n");
        stringBuilder.append("-每次运行程序都可以得到一套"+equationNumber+"道题的习题及答案-\n");
        stringBuilder.append("------------------------------------\n");
        System.out.println(stringBuilder.toString());
    }
    public static void printGenerationEquations(List<Equation> equations){
        Iterator<Equation> iterator = equations.iterator();
        Equation equation;
        int i=0;
        while (iterator.hasNext()){
            equation=iterator.next();
            String result="第"+(i+1)+"题:"+equation.toString()+equation.result+"\t\t";
            System.out.print(result);
            if((i+1)%5==0){
                System.out.println();
            }
            i++;
        }
    }
    public static void printCalculations(List<Equation> equations){
        Iterator<Equation> iterator = equations.iterator();
        Equation equation;
        int i=0;
        StringBuilder stringBuilder = new StringBuilder("------------------------------------\n");
        stringBuilder.append("-下面是习题的参考答案\n");
        stringBuilder.append("------------------------------------\n");
        while (iterator.hasNext()){
            equation=iterator.next();
            stringBuilder.append("第"+(i+1)+"题参考答案:"+equation.result+"\n");
            i++;
        }
        System.out.println(stringBuilder.toString());
    }
    public static char[] generationRandomOperators(int number){
        List<Character> operators=new ArrayList();
        Random random=new Random();
        for(int i=0;i<number;i++){
            int m = random.nextInt(2);
            if(m==0){
                operators.add('+');
            }else {
                operators.add('-');
            }
        }
        int size = operators.size();
        char[] chars = new char[size];
        for(int i=0;i<size;i++){
            chars[i]=operators.get(i);
        }
        return chars;
    }

}
