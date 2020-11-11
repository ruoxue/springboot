package com.wowotou.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * lm_album_picture(LmAlbumPicture)实体类
 *
 * @author makejava
 * @since 2020-06-01 00:53:56
 */
@Document("mi_album_picture")
public class MiAlbumPicture implements Serializable {
    private static final long serialVersionUID = -74895705116774973L;

    @Id
    private String id;

    private Integer tag;

    private String cover;

    private String size;

    private String spec;

    private String coverBig;

    private String sizeBig;

    private String specBig;

    private String coverSmall;

    private String coverMicro;

    private String sizeMicro;

    private Integer updateType;

    private String domain;

    private String bucket;

    private Integer uid;

    private String sizeMid;

    private String specMid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getCoverBig() {
        return coverBig;
    }

    public void setCoverBig(String coverBig) {
        this.coverBig = coverBig;
    }

    public String getSizeBig() {
        return sizeBig;
    }

    public void setSizeBig(String sizeBig) {
        this.sizeBig = sizeBig;
    }

    public String getSpecBig() {
        return specBig;
    }

    public void setSpecBig(String specBig) {
        this.specBig = specBig;
    }

    public String getCoverSmall() {
        return coverSmall;
    }

    public void setCoverSmall(String coverSmall) {
        this.coverSmall = coverSmall;
    }

    public String getCoverMicro() {
        return coverMicro;
    }

    public void setCoverMicro(String coverMicro) {
        this.coverMicro = coverMicro;
    }

    public String getSizeMicro() {
        return sizeMicro;
    }

    public void setSizeMicro(String sizeMicro) {
        this.sizeMicro = sizeMicro;
    }

    public Integer getUpdateType() {
        return updateType;
    }

    public void setUpdateType(Integer updateType) {
        this.updateType = updateType;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getSizeMid() {
        return sizeMid;
    }

    public void setSizeMid(String sizeMid) {
        this.sizeMid = sizeMid;
    }

    public String getSpecMid() {
        return specMid;
    }

    public void setSpecMid(String specMid) {
        this.specMid = specMid;
    }

}