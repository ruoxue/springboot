package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 公用_插件表(LmAddon)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:53:53
 */
@Document("mi_addon")
public class MiAddon implements Serializable {
    private static final long serialVersionUID = -76730024048570887L;
    /**
     * 主键
     */
    @Id
    private String id;
    /**
     * 中文名
     */
    private String title;
    /**
     * 插件名或标识
     */
    private String name;
    /**
     * 封面
     */
    private String images;
    /**
     * 组别
     */
    private String group;
    /**
     * 插件描述
     */
    private String description;
    /**
     * 作者
     */
    private String author;
    /**
     * 版本号
     */
    private String version;
    /**
     * 需求版本
     */
    private String require;

    private String website;
    /**
     * 设置
     */
    private String config;
    /**
     * 钩子[0:不支持;1:支持]
     */
    private int isHook;
    /**
     * 状态[-1:删除;0:禁用;1启用]
     */
    private int status;
    /**
     * 创建时间
     */
    private Long cTime;
    /**
     * 修改时间
     */
    private Long mTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getcTime() {
        return cTime;
    }

    public void setcTime(Long cTime) {
        this.cTime = cTime;
    }

    public Long getmTime() {
        return mTime;
    }

    public void setmTime(Long mTime) {
        this.mTime = mTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRequire() {
        return require;
    }

    public void setRequire(String require) {
        this.require = require;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

//

    public int getIsHook() {
        return isHook;
    }

    public void setIsHook(int isHook) {
        this.isHook = isHook;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}