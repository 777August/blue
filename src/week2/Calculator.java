package week2;

import jdk.jfr.StackTrace;

import java.util.Scanner;

//对结果的溢出没有处理，我用浮点数好像怎么样都不会溢出啊
//异常类我没有写，因为就用到了一次
//没有参考别的代码，都是自己写的，所以思路可能会有点乱，多多担待
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //空格和括号其实可以处理，但是懒了...
        System.out.println("请输入要计算的表达式（不带空格,括号用英文）:");
        String expression = sc.nextLine();

        for(int i = 0;i < expression.length();i++){
            if(Character.isDigit(expression.charAt(i))||
            expression.charAt(i) =='+'||
            expression.charAt(i) =='-'||
            expression.charAt(i) =='*'||
            expression.charAt(i) =='/'||
            expression.charAt(i) =='('||
            expression.charAt(i) ==')'


            ){}else if(expression.charAt(i) =='='){//考虑到用户可能在最后会输入等号，在这里处理一下
                expression = expression.substring(0,expression.length()-1);
            }else{
                throw new RuntimeException("非法的输入");
            }
        }

        System.out.print(value(brace(expression)));
    }

    //递归实现将所有的括号打开，最终返回值为只带加减乘除的算式
    public static String brace(String expression){
        //找到最小级别的括号，并记录两个括号的角标
        int i;
        for(i = 0;i < expression.length();i++){
            if(expression.charAt(i) == ')'){
                break;
            }else if(i == expression.length()-1){//找不到括号时，递归结束
                return expression;
            }
        }

        int j = i;
        while(expression.charAt(j) !='('){
            j--;
        }
        j++;

        //得到括号中的内容并计算结果，将结果替换原表达式括号的位置
        //  （a+b），计算后结果为c，将（a+b）替换为c
        String s = expression.substring(j,i);
        String value = String.valueOf(value(s));
        expression = expression.replace('(' + s + ')',value);
        //递归寻找剩余的括号
        return brace(expression);
    }
    //计算表达式
    //先算乘除，再算加,最后算减，大体思路是：
    //找到运算符，确定运算符前后的两个数字a,b
    //计算结果得到c，用结果替换原来的位置    a*b --> c
    //递归调用value方法，处理下一个运算符
    //只需要看乘法部分的的代码就可以了，后面的仅仅是改了一个符号
    //减法部分由于会出现负数，会有更多的处理，会有所不同
    public static double value(String expression){
        for(int i = 0;i < expression.length();i++){
            if(expression.charAt(i) == '*'){
                int a1 = i - 1,a2 = i;
                int b1 = i + 1,b2 = i+1;

                //确定边界，防止角标越界
                while (Character.isDigit(expression.charAt(a1))||expression.charAt(a1) == '.'||expression.charAt(a1) == '-'){
                    a1--;
                    if(a1 == -1){
                        break;
                    }
                }a1++;
                double a = Double.parseDouble(expression.substring(a1,a2));
                while (Character.isDigit(expression.charAt(b2))||expression.charAt(b2) == '.'||expression.charAt(b2)=='-'){
                    b2++;
                    if(b2 == expression.length()){
                        break;
                    };
                }
                double b = Double.parseDouble(expression.substring(b1,b2));
                double c = a * b;
                String new1 = Double.toString(c);
                String old = expression.substring(a1,b2);
                expression = expression.replace(old,new1);
                return value(expression);
            }else if(expression.charAt(i) =='/'){
                int a1 = i - 1,a2 = i;
                int b1 = i + 1,b2 = i+1;

                while (Character.isDigit(expression.charAt(a1))||expression.charAt(a1) == '.'||expression.charAt(a1) == '-'){
                    a1--;
                    if(a1 == -1){
                        break;
                    }
                }a1++;
                double a = Double.parseDouble(expression.substring(a1,a2));
                while (Character.isDigit(expression.charAt(b2))||expression.charAt(b2) == '.'||expression.charAt(b2)=='-'){
                    b2++;
                    if(b2 == expression.length()){
                        break;
                    };
                }
                double b = Double.parseDouble(expression.substring(b1,b2));
                double c = a / b;
                String new1 = Double.toString(c);
                String old = expression.substring(a1,b2);
                expression = expression.replace(old,new1);
                return value(expression);
            }
        }
        for(int i = 0;i < expression.length();i++) {
            if (expression.charAt(i) == '+') {
                int a1 = i - 1, a2 = i;
                int b1 = i + 1, b2 = i + 1;

                while (Character.isDigit(expression.charAt(a1)) || expression.charAt(a1) == '.' || expression.charAt(a1) == '-') {
                    a1--;
                    if (a1 == -1) {
                        break;
                    }
                }
                a1++;
                double a = Double.parseDouble(expression.substring(a1, a2));
                while (Character.isDigit(expression.charAt(b2)) || expression.charAt(b2) == '.' || expression.charAt(b2) == '-') {
                    b2++;
                    if (b2 == expression.length()) {
                        break;
                    }
                    ;
                }
                double b = Double.parseDouble(expression.substring(b1, b2));
                double c = a + b;
                String new1 = Double.toString(c);
                String old = expression.substring(a1, b2);
                expression = expression.replace(old, new1);
                return value(expression);
            }
        }

        //此时只剩减法了
            for(int i = 0;i < expression.length();i++){

            if(expression.charAt(i) =='-'){
                int a1 = i - 1,a2 = i;
                int b1 = i + 1,b2 = i+1;

                //如果a1=-1说明第一个数是负数
                if(a1 == -1){
                    //避免出现-1--1的情况无法处理
                    expression = expression.replace("--","+");
                    for(int j = 0;j < expression.length();j++){
                        if(expression.charAt(j) =='+'){
                            return value(expression);
                        }
                    }

                    //避开第一个-，如果再出现-，全变为+后计算取相反数
                    for(int j = 1;j < expression.length();j++){
                        if(expression.charAt(j) =='-'){
                           expression = expression.replace('-','+').substring(1);
                           return -value(expression);

                        }
                    }
                    //如果只剩一个负数，返回这个值即可
                    return Double.parseDouble(expression);
                }
                while (Character.isDigit(expression.charAt(a1))||expression.charAt(a1) == '.'||expression.charAt(a1) == '-'){
                    a1--;
                    if(a1 == -1){
                        break;
                    }
                }a1++;
                double a = Double.parseDouble(expression.substring(a1,a2));
                while (Character.isDigit(expression.charAt(b2))||expression.charAt(b2) == '.'||expression.charAt(b2)=='-'){
                    b2++;
                    if(b2 == expression.length()){
                        break;
                    };
                }
                double b = Double.parseDouble(expression.substring(b1,b2));
                double c = a - b;
                String new1 = Double.toString(c);
                String old = expression.substring(a1,b2);
                expression = expression.replace(old,new1);
                return value(expression);
            }
        }
    return Double.parseDouble(expression);

    }


}
