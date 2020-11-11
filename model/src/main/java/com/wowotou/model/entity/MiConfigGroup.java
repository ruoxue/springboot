package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * (LmConfigGroup)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:53:59
 */
@Document("mi_config_group")
public class MiConfigGroup implements Serializable {
    private static final long serialVersionUID = -81523772324376361L;

    @Id
    private String id;

    private String name;

    private String title;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}