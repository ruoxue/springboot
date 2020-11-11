package com.wowotou.service;


import com.wowotou.model.entity.MiPayAccount;

import java.util.List;

/**
 * (MiPayAccount)表服务接口
 *
 * @author makejava
 * @since 2020-06-02 00:38:48
 */
public interface MiPayAccountService extends  BaseMongoService<MiPayAccount> {

    MiPayAccount queryByUserid(String appId);

    void updateAccountmTime(String id);

    MiPayAccount queryByChannelId(String channelId);
}