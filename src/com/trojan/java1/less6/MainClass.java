package com.trojan.java1.less6;

import java.io.*;

public class MainClass {
    private static void fisFosExample() {
        InputStream in;
        OutputStream out;
        try{
            FileOutputStream fos = new FileOutputStream("test.txt", true);
            String s = "Hello world!";
            fos.write(s.getBytes());
            fos.close();

            FileInputStream fis = new FileInputStream("test.txt");
//            System.out.println(fis.read());
            int b;
            while((b = fis.read()) != -1){
                System.out.print((char) b);
            }
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try{
            PrintStream ps= new PrintStream(new FileOutputStream("test.txt", true));
            ps.println("234");
//        Scanner scanner = new Scanner(new FileInputStream("test.txt"));
//        while(scanner.hasNext()){
//            System.out.print(scanner.hasNext());
//        }
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        }



       // Scanner s = new Scanner(System.in);
        //String m = "Hello world";
       // String n = "Hello";
        //n = n + " world";
        //String o = s.nextLine();

       // System.out.println(m == n);
       // System.out.println(m == o);
        //System.out.println(m.equals(o));

//        long startTine = System.nanoTime();
//        String ex = "Example";
//        for (int i = 0; i <30; i++){
//            ex += i;
//        }
//        float deltaTime = System.nanoTime() - startTine;
//        System.out.printf("Delta: %f\n", deltaTime*0.000001f);
//
//        startTine = System.nanoTime();
//
//        StringBuilder ss = new StringBuilder("Example");
//        for (int i = 0; i <30; i++){
//            ss.append(i);
//        }
//        deltaTime = System.nanoTime() - startTine;
//        System.out.printf("Delta: %f\n", deltaTime*0.000001f);
    }
}

