package org.bees.box.service.experiment;

import org.bees.box.entity.bean.CommonBean;
import org.bees.box.entity.dto.CommonBeanDto;

import java.util.List;

public interface CommonBeanService {

    List<CommonBean> getBeanList(CommonBeanDto dto);

    CommonBean getBean(CommonBeanDto dto);

//    Boolean validBeanBeforeInsert(List<CommonBeanDto> dtos);

    Integer insertBean(List<CommonBeanDto> dtos);

    Integer updateBeanBeforeUpdate(List<CommonBeanDto> dtos);

    Integer deleteBean(List<CommonBeanDto> dtos);

}
