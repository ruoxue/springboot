package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * (LmAdminLog)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:53:55
 */
@Document("mi_admin_log")
public class MiAdminLog implements Serializable {
    private static final long serialVersionUID = 507511984647464179L;
    /**
     * 表id
     */
    @Id
    private String id;
    /**
     * 管理员id
     */
    private Integer adminId;

    private String username;

    private String logUrl;

    private String logContent;
    /**
     * 日志描述
     */
    private String logTitle;

    private String logAgent;
    /**
     * ip地址
     */
    private String logIp;
    /**
     * 日志时间
     */
    private Integer cTime;

    private Integer mTime;

    private short status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLogUrl() {
        return logUrl;
    }

    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }

    public String getLogTitle() {
        return logTitle;
    }

    public void setLogTitle(String logTitle) {
        this.logTitle = logTitle;
    }

    public String getLogAgent() {
        return logAgent;
    }

    public void setLogAgent(String logAgent) {
        this.logAgent = logAgent;
    }

    public String getLogIp() {
        return logIp;
    }

    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }


}