package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Bridge {
    ArrayList<Car> cars=new ArrayList<Car>();
    Semaphore lionsCarSem=new Semaphore(2);
   // Semaphore bishopCarSem=new Semaphore(2);
    Random rand;
    public Bridge(){
        rand=new Random();
    }
    public void addCar(Car car){
        System.out.println(car.name+" is being added.");
        cars.add(car);
    }
    public void removeCar(Car car){
        System.out.println(car.name+" is being removed.");
        cars.remove(car);
    }

    public void printAllCarsOnTheBridge(){
        for(Car car: cars){
            System.out.println(car.name+" is driving on bridge.");
        }
    }


    public void bishopCrossBridge(BishopBoundCars car) {
        while (true) {
            try
            {
                Thread.sleep(rand.nextInt(5000));
                lionsCarSem.acquire();
                //Acquire is ued when sending signals between two threads.
                if(cars.size()==0||(cars.get(cars.size()-1).name.contains("Bishop"))){
                    addCar(car);
                    lionsCarSem.release();
                    Thread.sleep(4000/4);
                    removeCar(car);
                    break;
                }else{
                    System.out.println(car.name+" is waiting to cross!");
                    lionsCarSem.release();
                }
                printAllCarsOnTheBridge();

            }
            catch(InterruptedException iex)
            {   //prints the stack trace of the Exception to System.err.  Helps diagnose Exception.
                iex.printStackTrace();
            }


        }
    }
    public void liONCrossBridge(LionsBoundCars car) {
        while (true) {
            try
            {
                Thread.sleep(rand.nextInt(500));
                lionsCarSem.acquire();
                //Acquire is ued when sending signals between two threads.
                if(cars.size()==0||(cars.get(cars.size()-1).name.contains("Lion"))){
                    addCar(car);
                    lionsCarSem.release();
                    Thread.sleep(4000);
                    removeCar(car);
                    break;
                }else{
                System.out.println(car.name+" is waiting to cross!");
                lionsCarSem.release();
                }
                printAllCarsOnTheBridge();
            }
            catch(InterruptedException iex)
            {   //prints the stack trace of the Exception to System.err.  Helps diagnose Exception.
                iex.printStackTrace();
            }

        }
    }
}
