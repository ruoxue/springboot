package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 后台资金变动(LmAdminCharge)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:53:55
 */
@Document("mi_admin_charge")
public class MiAdminCharge implements Serializable {
    private static final long serialVersionUID = -30068852928838117L;

    @Id
    private String id;
    /**
     * 会员ID
     */
    private Object aid;
    /**
     * 变更余额
     */
    private Double money;
    /**
     * 变更前余额
     */
    private Double before;
    /**
     * 变更后余额
     */
    private Double after;
    /**
     * 备注
     */
    private String memo;
    /**
     * 创建时间
     */
    private Integer ctime;

    private String linkid;

    private Integer mtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getAid() {
        return aid;
    }

    public void setAid(Object aid) {
        this.aid = aid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getBefore() {
        return before;
    }

    public void setBefore(Double before) {
        this.before = before;
    }

    public Double getAfter() {
        return after;
    }

    public void setAfter(Double after) {
        this.after = after;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getCtime() {
        return ctime;
    }

    public void setCtime(Integer ctime) {
        this.ctime = ctime;
    }

    public String getLinkid() {
        return linkid;
    }

    public void setLinkid(String linkid) {
        this.linkid = linkid;
    }

    public Integer getMtime() {
        return mtime;
    }

    public void setMtime(Integer mtime) {
        this.mtime = mtime;
    }

}