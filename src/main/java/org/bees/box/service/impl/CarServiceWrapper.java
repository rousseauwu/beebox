package org.bees.box.service.impl;

import org.bees.box.service.CarService;

public class CarServiceWrapper implements CarService {
    private CarService carService;

    public CarServiceWrapper(CarService carService) {
        this.carService = carService;
    }

    @Override
    public void gogogo() {
        System.out.println("before");
        carService.gogogo();
    }
}
