package org.bees.box;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.bees.box.service.CarService;

public class DubboSpiTest {

    public static void main(String[] args) {
        ExtensionLoader<CarService> extensionLoader = ExtensionLoader.getExtensionLoader(CarService.class);
        CarService lambo = extensionLoader.getExtension("lambo");
        lambo.gogogo();

    }
}
