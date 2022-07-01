package com.company;



public class UseOfThread {

    public static void main(String[] args) {

        long startingTime=System.currentTimeMillis();

        System.out.println("Name : "+ Thread.currentThread().getName()+"\n ID :"+Thread.currentThread().getId()+" Started");


        final double[] sumOfAllNumbers = {0};
        final double[] sumOfAllEvenNumbers={0};
        long bound=1000000000;
        long finalBound = bound;

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Name : "+ Thread.currentThread().getName()+",ID :"+Thread.currentThread().getId()+" Started");

                for(int i = 1; i<= finalBound; i++){
                    sumOfAllNumbers[0] +=i;
                }
                System.out.println("Name : "+ Thread.currentThread().getName()+",ID :"+Thread.currentThread().getId()+" Exiting");
            }
        },"Child Thread 1");
        t1.start();


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("Name : "+ Thread.currentThread().getName()+",ID :"+Thread.currentThread().getId()+" Started");

                for(int i=1;i<=finalBound;i++){
                    if(i%2==0){
                        sumOfAllEvenNumbers[0]+=i;
                    }
                }
                System.out.println("Name : "+ Thread.currentThread().getName()+",ID :"+Thread.currentThread().getId()+" Exiting");

            }
        },"Child Thread 2");
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {

        }

        System.out.println("Sum of all Numbers : "+sumOfAllNumbers[0]);
        System.out.println("Sum of all Even Numbers : "+sumOfAllEvenNumbers[0]);
        double cal=sumOfAllNumbers[0]/sumOfAllEvenNumbers[0];
        System.out.println("Division "+cal);

        System.out.println("Time Taken in (ms) : "+(System.currentTimeMillis()-startingTime));

        System.out.println("Name : "+ Thread.currentThread().getName()+",ID :"+Thread.currentThread().getId()+" Exiting");


    }
}
