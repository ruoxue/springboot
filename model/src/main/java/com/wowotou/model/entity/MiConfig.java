package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 配置参数表(LmConfig)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:53:59
 */
@Document("mi_config")
public class MiConfig implements Serializable {
    private static final long serialVersionUID = -16392456691451763L;

    @Id
    private String id;

    private String code;

    private Object value;

    private String remark;

    private String type;

    private int  status;

    private Integer cTime;

    private Integer mTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int  status) {
        this.status = status;
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