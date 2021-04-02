package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Enter I to use Imaginary and F to use Fractions");
            String input=scanner.nextLine();
            if(input.equals("F")){
                System.out.println("what is the numerator of first fraction");
                int num1=Integer.parseInt(scanner.nextLine());
                System.out.println("what is the denom of first fraction");
                int den1=Integer.parseInt(scanner.nextLine());
                System.out.println("what is the numerator of second fraction");
                int num2=Integer.parseInt(scanner.nextLine());
                System.out.println("what is the denom of second fraction");
                int den2=Integer.parseInt(scanner.nextLine());
                fraction f = new fraction(num1,den1);
                fraction f2 = new fraction(num2,den2);
                System.out.println("enter +,-,*, or /");
                String in = scanner.nextLine();
                if(in.equals("+")){
                    ((fraction) f.add(f2)).print();
                }
                else if(in.equals("-")){
                    ((fraction) f.subtract(f2)).print();
                }
                else if(in.equals("*")){
                    ((fraction) f.multiply(f2)).print();
                }
                else{
                    ((fraction) f2.divide(f)).print();
                }
            }
            else{
                System.out.println("what is the real of first number");
                int real1=Integer.parseInt(scanner.nextLine());
                System.out.println("what is the imaginary of first number");
                int im1=Integer.parseInt(scanner.nextLine());
                System.out.println("what is the real of second number");
                int real2=Integer.parseInt(scanner.nextLine());
                System.out.println("what is the imaginary of second number");
                int im2=Integer.parseInt(scanner.nextLine());
                Imaginary imaginary = new Imaginary(im1,real1);
                Imaginary imaginary2 = new Imaginary(im2,real2);
                System.out.println("enter +,-,*, or /");
                String in = scanner.nextLine();
                if(in.equals("+")){
                    ((Imaginary)imaginary.add(imaginary2)).print();
                }
                else if(in.equals("-")){
                    ((Imaginary)imaginary.subtract(imaginary2)).print();
                }
                else if(in.equals("*")){
                    ((Imaginary)imaginary.multiply(imaginary2)).print();
                }
                else{
                    ((Imaginary)imaginary.divide(imaginary2)).print();
                }
            }

        }catch (Exception e){
            System.out.println("error");
        }
    }
}

