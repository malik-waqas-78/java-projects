package com.company;

import java.util.Random;

public class BishopBoundCars extends Car implements Runnable{


    private Bridge bridge;
    BishopBoundCars(String name,Bridge bridge) {

        this.name = name;
        this.bridge = bridge;
    }

    @Override
    public void run() {
        bridge.bishopCrossBridge(this);
    }
}
