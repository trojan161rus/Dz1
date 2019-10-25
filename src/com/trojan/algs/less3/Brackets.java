package com.trojan.algs.less3;

public class Brackets {
    private static void error(char ch, int i){
        System.out.println(String.format("Error: %c at %d", ch, i));
    }

    private static void err(){
        System.out.println("no");
    }

    private static void val(){
        System.out.println("yes");
    }

    public static void check(String input){
        int flag = -1;
        int size = input.length();
        Stack st = new Stack(size);
        for (int i = 0; i < size; i++) {
            char ch = input.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[' || ch == '<'){
                st.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}' || ch == '>'){
                if (st.isEmpty()){
                    err();
                    flag = 0;
                    break;
                } else flag = 1;
                char c = (char) st.pop();
                if (!((c == '[' && ch == ']') || (c == '(' && ch == ')')||(c == '{' && ch == '}')||(c == '<' && ch == '>'))){
                    err();
                    flag = 0;
                    return;
                } else flag = 1;
            }
        }
        if (!st.isEmpty()){
            err();
            flag = 0;
        }
        if (flag == 1) val();
    }
}
