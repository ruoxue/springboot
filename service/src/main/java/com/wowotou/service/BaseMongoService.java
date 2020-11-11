package com.wowotou.service;

import com.mongodb.client.result.DeleteResult;
import com.wowotou.model.entity.MiAddon;

import java.util.List;

public interface BaseMongoService<T> {
    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
    T queryById(String _id );

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<T> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param m 实例对象
     * @return 实例对象
     */
    T insert(T m);

    /**
     * 修改数据
     *
     * @param m 实例对象
     * @return 实例对象
     */
    T update(T m);

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 是否成功
     */
    DeleteResult deleteById(String _id );
}
