package com.wowotou.service;


import com.wowotou.model.entity.MiPayChannel;


/**
 * (MiPayChannel)表服务接口
 *
 * @author makejava
 * @since 2020-06-02 00:38:48
 */
public interface MiPayChannelService extends  BaseMongoService<MiPayChannel> {


    MiPayChannel queryByType(short type);

    MiPayChannel queryByTypeId(String id);
}