import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Infix {
    public Boolean isNum(String str){
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                return true;
            }
        }
        return false;
    }
    public String add(String num1, String num2){
        return String.valueOf(Float.parseFloat(num1) + Float.parseFloat(num2));
    }
    public String sub(String num1, String num2){
        return String.valueOf(Float.parseFloat(num1) - Float.parseFloat(num2));
    }
    public String mul(String num1, String num2){
        return String.valueOf(Float.parseFloat(num1) * Float.parseFloat(num2));
    }
    public String div(String num1, String num2){
        return String.valueOf(Float.parseFloat(num1) / Float.parseFloat(num2));
    }
    public float infix(String[] tokens) {
        // please enter your code here...
        List<String> Tokens = new ArrayList<String>(Arrays.asList(tokens));
        int start, end;
        Boolean First;//有乘除？
        while(Tokens.size()>1){
            First = false;
            start = 1;
            end = Tokens.size()-1;
            for(int i = 0; i < Tokens.size(); i++){
                if(Tokens.get(i).equals("(")){
                    start = i + 1;
                }
                if(Tokens.get(i).equals(")")){
                    end = i;
                    break;
                }
            }
            for(int i = start; i < end; i++){
                if(Tokens.get(i).equals("*")||Tokens.get(i).equals("/")){
                    First = true;
                }
            }
            for(int i = start; i < end; i++){
                if(Tokens.get(i-1).equals("(")&&Tokens.get(i+1).equals(")")){
                    Tokens.remove(i+1);
                    Tokens.remove(i-1);
                    break;
                }
                else if(isNum(Tokens.get(i-1))&&isNum(Tokens.get(i+1))&&(!First||Tokens.get(i).equals("*")||Tokens.get(i).equals("/"))){
                    switch(Tokens.get(i).charAt(0)){
                        case '+':
                            Tokens.set(i, add(Tokens.get(i-1), Tokens.get(i+1)));
                            break;
                        case '-':
                            Tokens.set(i, sub(Tokens.get(i-1), Tokens.get(i+1)));
                            break;
                        case '*':
                            Tokens.set(i, mul(Tokens.get(i-1), Tokens.get(i+1)));
                            break;
                        case '/':
                            Tokens.set(i, div(Tokens.get(i-1), Tokens.get(i+1)));
                            break;
                    }
                    Tokens.remove(i+1);
                    Tokens.remove(i-1);
                    break;
                }
            }
        }
        return Float.parseFloat(Tokens.get(0));
    }
}