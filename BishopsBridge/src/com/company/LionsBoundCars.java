package com.company;

public class LionsBoundCars extends Car implements Runnable{


    private Bridge bridge;
    LionsBoundCars(String name,Bridge bridge){

        this.name=name;
        this.bridge=bridge;
    }

    @Override
    public void run() {
        bridge.liONCrossBridge(this);
    }
}
