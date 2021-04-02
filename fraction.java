package com.company;

public class fraction implements number {

    private int numerat;
    private int denom;

    public fraction(int n, int d){
        this.numerat= n;
        if(d != 0) {
            this.denom = d;
        }
        else{
            System.out.println("0 error. Quitting.");
            System.exit(0);
        }
    }
    public int numer(){
        return numerat;
    }

    public int den() {
        return denom;
    }

    private int LCM(int n, int d){
        int lcm;
        if (d > n){
            lcm = d;}
        else{
            lcm = n;}
        while(true) {
            if(lcm % n == 0 && lcm % d == 0) {
                return lcm;
            }
            ++lcm;
        }
    }
    private int GCF(int n, int d){
        int gcf=1;

        for(int i = 2; i <= d && i <= n; i++){
            if(n % i == 0 && d % i == 0){
                gcf = i;
            }
        }
        return gcf;
    }
    public void print(){

        if(numerat == 0){
            System.out.println("0");
        }
        else if(denom == 1){
            System.out.println(numerat);
        }
        else if(denom == numerat){
            System.out.println(1);
        }
        else{
            System.out.println(numerat + "/" + denom);
        }
    }

    @Override
    public number add(number n) {
        if(n instanceof fraction) {
            int lcm = LCM(denom, ((fraction) n).denom);

            ((fraction) n).numerat *= lcm / ((fraction) n).denom;
            ((fraction) n).denom = lcm;
            ((fraction) n).numerat += numerat * (lcm / denom);
        }
        return n;
    }

    @Override
    public number subtract(number n) {
        if(n instanceof fraction) {
            int lcm = LCM(denom,((fraction) n).denom);

            ((fraction) n).numerat *= -1 * lcm / ((fraction) n).denom;
            ((fraction) n).denom = lcm;
            ((fraction) n).numerat += numerat * (lcm / denom);
        }
        return n;
    }

    @Override
    public number multiply(number n) {
        if(n instanceof fraction) {
            ((fraction) n).numerat *= numerat;
            ((fraction) n).denom *= denom;

            int gc = GCF(((fraction) n).numerat,((fraction) n).denom);

            ((fraction) n).numerat /= gc;
            ((fraction) n).denom /= gc;
        }
        return n;
    }

    @Override
    public number divide(number n) {
        if(n instanceof fraction) {
            ((fraction) n).numerat *= denom;
            ((fraction) n).denom *= numerat;

            int g = GCF(((fraction) n).numerat,((fraction) n).denom);

            ((fraction) n).numerat /= g;
            ((fraction) n).denom /= g;
        }
        return n;
    }
}
