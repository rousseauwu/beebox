package org.bees.box.service.experiment.impl;

import org.bees.box.entity.dto.CommonBeanDto;
import org.bees.box.service.experiment.CommbeanServiceSurppot;
import org.bees.box.service.experiment.CommonBeanService;

import java.util.List;

public abstract class AbstractCommonBeanService implements CommonBeanService {


    private CommbeanServiceSurppot commbeanServiceSurppot;

    abstract boolean validBeanBeforeInsert();

    @Override
    public Integer insertBean(List<CommonBeanDto> dtos) {
        if (!validBeanBeforeInsert()) {
            System.out.println("error");
        }
        commbeanServiceSurppot.convertBean(dtos);
        return insertBean(dtos);
    }
}
