package com.wowotou.model.entity;

import java.io.Serializable;

public class ClazzModel implements Serializable {
    private  String name;
    private  String _id;
    private  String serviceName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String toString() {
        return "ClazzModel{" +
                "name='" + name + '\'' +
                ", _id='" + _id + '\'' +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }
}
