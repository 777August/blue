package project3;

import java.util.StringTokenizer;

public class Expression {
    String infix;
    GenericStack<String> postStack = new GenericStack<>();
    String post = "";

    public Expression(String infix) {
        this.infix = infix;
    }

    public String getInfix() {
        return infix;
    }

    public void setInfix(String infix) {
        this.infix = infix;
    }

    //Convert Infix to Postfix
    public String inToPost() throws StackException {
        GenericStack<String> operators = new GenericStack<>();

        //delete all space
        infix = infix.replace(" ","");

        //split the infix expression through "()+-*/"
        StringTokenizer st = new StringTokenizer(infix, "()+-*/",true);
        Object o;

        //As long as there are more tokens, get the next token.
        while(st.hasMoreTokens()){
            o = st.nextElement();

            //If the token is an operand, append it to the postfix string.
            if(judgeNum(o)){
                post = post + o.toString() + " ";

                // If the token is "(", push it onto the stack.
            }else if(o.toString().equals("(")){
                operators.push(o);

                //If the token is an operator
            }else if(!o.toString().equals(")")){

                //If the stack is empty, push the operator onto the stack.
                if(operators.isEmpty()){
                    operators.push(o);

                    //If the stack is not empty, pop operators of greater or equal
                    //precedence from the stack and append them to postfix
                    //string, stop when you encounter “(" or an operator of lower
                    //precedence or when the stack is empty. And then, push the
                    //new operator onto the stack.
                }else{
                    if(o.equals("*") || o.equals("/")){
                        while(operators.peek().equals("*")||operators.peek().equals("/")){
                            post = post + operators.pop().toString() + " ";
                        }
                        operators.push(o);
                    }else{
                        while(!(operators.isEmpty()||operators.peek().equals("("))){
                            post = post + operators.pop().toString() + " ";
                        }
//                        if(operators.isEmpty()||operators.peek().equals("(")){
//                            operators.push(o);
//                        }

                        operators.push(o);

                    }
                }
            }else{

                //When you encounter a ")", pop operators off the stack and
                //append them to the end of the postfix string until you encounter
                //matching "(".
                    while (!operators.peek().equals("(")){
                        post = post + operators.pop().toString() + " ";
                        if(operators.isEmpty()){
                            break;
                        }
                    }
                    operators.pop();



            }

        }
        while(!operators.isEmpty()){
            post = post + operators.pop().toString() + " ";
        }
        return post;
    }


    //judge the Character is a number or not
    public boolean judgeNum(Object o){
        if(o.toString().length()==1){
            if(o.equals("+")||o.equals("-")||o.equals("*")||o.equals("/")||o.equals("(")||o.equals(")")){
                return false;
            }else return true;
        }else return true;
    }


    //Evaluate Postfix Expressions
    public int evaluate() throws StackException {
        GenericStack<Integer> value = new GenericStack<>();
        StringTokenizer st = new StringTokenizer(post, " ",false);
        Object o;
        while(st.hasMoreTokens()) {
            o = st.nextElement();
            if(o.toString().equals(" ")){
                continue;
            }

            //When an operand is entered, push it onto a stack
            if (judgeNum(o)) {
                value.push(Integer.valueOf(o.toString()));
            }else{

                //When an operator is entered, pop the top two
                //operands off the stack, apply the operator to the
                //two operands, push the result on the stack.
                int a = value.pop();
                int b = value.pop();
                switch (o.toString()){
                    case "+": value.push(b + a);break;
                    case "-": value.push(b - a);break;
                    case "*": value.push(b * a);break;
                    case "/": value.push(b / a);break;
                }
            }

        }
        return value.pop();
    }
}
