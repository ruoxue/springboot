package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 权限节点(LmAuthRule)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:53:59
 */
@Document("mi_auth_rule")
public class MiAuthRule implements Serializable {
    private static final long serialVersionUID = 411343289155242705L;

    @Id
    private String id;
    /**
     * 链接
     */
    private String href;

    private String title;
    /**
     * 类型
     */
    private Object type;
    /**
     * 状态1 可以用，0 所有禁止使用
     */
    private Object status;
    /**
     * 1公开 0不公开
     */
    private Object authOpen;
    /**
     * 0 不显示，1 显示
     */
    private Object menuStatus;
    /**
     * 图标样式
     */
    private String icon;
    /**
     * 条件
     */
    private String condition;
    /**
     * 父栏目ID
     */
    private Integer pid;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 添加时间
     */
    private Integer cTime;

    private Integer mTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Object getAuthOpen() {
        return authOpen;
    }

    public void setAuthOpen(Object authOpen) {
        this.authOpen = authOpen;
    }

    public Object getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(Object menuStatus) {
        this.menuStatus = menuStatus;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getcTime() {
        return cTime;
    }

    public void setcTime(Integer cTime) {
        this.cTime = cTime;
    }

    public Integer getmTime() {
        return mTime;
    }

    public void setmTime(Integer mTime) {
        this.mTime = mTime;
    }
}