package com.trojan.algs.less4;

public class MainClass {
    public static void main(String[] args) {
        RelatedList rl = new RelatedList();
        rl.push("Ivan1",10);
        rl.push("Ivan2",20);
        rl.push("Ivan3",30);
        rl.push("Ivan4",40);

        System.out.println(rl);


        System.out.println(rl.find("Ivan3", 20));


        System.out.println(rl.delete("Ivan2", 20));
        System.out.println(rl);
    }
}
