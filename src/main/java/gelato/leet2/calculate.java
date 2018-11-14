package gelato.leet2;

import java.util.Stack;

public class calculate {
    public int calculate(String s) {
        int v = 0;
        Stack<Character> ope = new Stack<>();
        Stack<Integer> num = new Stack<>();
        char [] cs = s.replace(" ","").toCharArray();
        Integer opr = null;
        for(int i = 0; i < cs.length; i++){
            if('0' <= cs[i] && cs[i] <= '9'){
                if(opr == null ){
                    opr = cs[i] - '0';
                }else {
                    opr = opr * 10  + (cs[i] - '0');
                }
            }else{
                if(opr != null){
                    num.push(opr);
                    opr = null;
                }
                if(cs[i] == '('){
                    ope.push(cs[i]);
                }else if(cs[i] == '+' || cs[i] == '-'){
                    ope.push(cs[i]);
                }else  if(cs[i] == ')'){
                    Stack<Integer> num2 = new Stack<>();
                    Stack<Character> ope2 = new Stack<>();
                    while (ope.peek() != '('){
                        ope2.push(ope.pop());
                        num2.push(num.pop());
                    }
                    num2.push(num.pop());
                    while (!ope2.empty()){
                        int n1 = num2.pop(), n2 = num2.pop();
                        num2.push((ope2.pop() == '+' ? n1 + n2 : n1 - n2));
                    }
                    num.push(num2.pop());
                    ope.pop();
                }
            }
        }
        if(opr != null) num.push(opr);
        Stack<Integer> num2 = new Stack<>();
        Stack<Character> ope2 = new Stack<>();
        while (!ope.empty())ope2.push(ope.pop());
        while (!num.empty())num2.push(num.pop());
        while (!ope2.empty()){
            int n1 = num2.pop(), n2 = num2.pop();
            num2.push((ope2.pop() == '+' ? n1 + n2 : n1 - n2));
        }
        if(!num2.empty()) {
            num.push(num2.pop());
        }
        return num.peek();
    }
}
