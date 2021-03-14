package org.bees.box.service;

import org.apache.dubbo.common.extension.SPI;

@SPI(value="lambo")
public interface CarService {

    public void gogogo();
}
