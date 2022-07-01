package com.company;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Main {

    public static ArrayList<Car> cars=new ArrayList<>();
    public static ArrayList<Thread> carThreads=new ArrayList<>();
    public static void main(String[] args) {
        Bridge bridge=new Bridge();

        cars.add(new BishopBoundCars("Bishop1",bridge));
        cars.add(new BishopBoundCars("Bishop2",bridge));
        cars.add(new BishopBoundCars("Bishop3",bridge));
        cars.add(new LionsBoundCars("Lion1",bridge));
        cars.add(new LionsBoundCars("Lion2",bridge));

        for(Car car:cars){
            if(car.name.contains("Bishop")){
                BishopBoundCars bishopCar= (BishopBoundCars) car;
                Thread t=new Thread(bishopCar);
                carThreads.add(t);

            }else{
                LionsBoundCars bishopCar= (LionsBoundCars) car;
                Thread t=new Thread(bishopCar);
                carThreads.add(t);
            }
        }

        for(Thread thread: carThreads){
            thread.start();
        }

    }
}



