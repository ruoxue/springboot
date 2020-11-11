package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * (LmRegion)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:54:01
 */
@Document("mi_region")
public class MiRegion implements Serializable {
    private static final long serialVersionUID = 151157488889941684L;
    /**
     * 表id
     */
    @Id
    private String id;
    /**
     * 地区名称
     */
    private String name;
    /**
     * 地区等级 分省市县区
     */
    private Object level;
    /**
     * 父id
     */
    private Integer pid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getLevel() {
        return level;
    }

    public void setLevel(Object level) {
        this.level = level;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

}