package com.company;

public class Imaginary implements number{
    private double real, imaginary;
    public Imaginary(double n, double i){
        this.real = n;
        this.imaginary = i;
    }
    public void print(){
        if(real == 0 && imaginary == 0){
            System.out.println("0");
        }
        else if(real == 0){
            System.out.println(imaginary + " i");
        }
        else if(imaginary == 0){
            System.out.println(real);
        }
        else{
            System.out.println(real + " + (" + imaginary + "i)");
        }
    }
    @Override
    public number add(number n) {
        if(n instanceof Imaginary){
            ((Imaginary) n).real += real;

            ((Imaginary) n).imaginary += imaginary;
        }
        return n;
    }

    @Override
    public number subtract(number n) {

        if(n instanceof Imaginary){
            ((Imaginary) n).real = -1 * ((Imaginary) n).real + real;
            ((Imaginary) n).imaginary = -1 * ((Imaginary) n).imaginary + imaginary;;
        }
        return n;
    }

    @Override
    public number multiply(number x) {
        if(x instanceof Imaginary){

            double n = ((Imaginary) x).real;
            double i = ((Imaginary) x).imaginary;

            ((Imaginary) x).real = n * real - i *imaginary;
            ((Imaginary) x).imaginary = n * imaginary + real * i;
        }
        return x;
    }

    @Override
    public number divide(number n) {

        if(n instanceof Imaginary){

            Imaginary i = new Imaginary(real,imaginary);

            double d = (Math.pow(((Imaginary) n).real, 2) - (-1 * Math.pow(((Imaginary) n).imaginary, 2)));
            System.out.println((i.real * ((Imaginary) n).real));

            i.real = ((i.real * ((Imaginary) n).real) - (i.imaginary * -1 * ((Imaginary) n).imaginary)) / d;

            i.imaginary = ((imaginary * ((Imaginary) n).real) + (-1 * real *((Imaginary) n).imaginary)) / d;

            return i;
        }

        return null;
    }
}

