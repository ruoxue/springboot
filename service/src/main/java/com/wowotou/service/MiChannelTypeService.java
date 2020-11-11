package com.wowotou.service;

import com.wowotou.model.entity.MiBank;
import com.wowotou.model.entity.MiChannelType;

public interface MiChannelTypeService  extends  BaseMongoService<MiChannelType>{
    MiChannelType queryByType(short type);
}
