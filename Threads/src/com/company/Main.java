package com.company;

public class Main {
    public static void main(String[] args) {
        long startingTime=System.currentTimeMillis();
        long bound=1000000000;
        double sumOfAllNumbers=0;
        double sumOfAllEvenNumbers=0;;
        for(int i = 1; i<= bound; i++){
            sumOfAllNumbers +=i;
        }
        for(int i = 1; i<= bound; i++){
            if(i%2==0){
                sumOfAllEvenNumbers +=i;
            }
        }
        System.out.println("Sum of all Numbers : "+sumOfAllNumbers);
        System.out.println("Sum of all Even Numbers : "+sumOfAllEvenNumbers);
        double cal=sumOfAllNumbers/sumOfAllEvenNumbers;
        System.out.println("Division "+cal);

        System.out.println("Time Taken in (ms) : "+(System.currentTimeMillis()-startingTime));
    }
}
