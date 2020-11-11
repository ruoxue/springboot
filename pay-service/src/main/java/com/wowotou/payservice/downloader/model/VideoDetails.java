package com.wowotou.payservice.downloader.model;

/*-
 * #
 * Java youtube video and audio downloader
 *
 * Copyright (C) 2020 Igor Kiulian
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #
 */


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VideoDetails {

    private String videoId;
    private String title;
    private int lengthSeconds;
    private List<String> keywords;
    private String shortDescription;
    private List<String> thumbnails;
    private String author;
    private long viewCount;
    private BigDecimal averageRating;
    private boolean isLiveContent;
    private String uploadDate;

    public VideoDetails() {
    }

    public VideoDetails(JSONObject json) {
        videoId = json.getString("videoId");
        title = json.getString("title");
        lengthSeconds = json.getIntValue("lengthSeconds");
        keywords = json.containsKey("keywords") ? json.getJSONArray("keywords").toJavaList(String.class) : new ArrayList<String>();
        shortDescription = json.getString("shortDescription");
        JSONArray jsonThumbnails = json.getJSONObject("thumbnail").getJSONArray("thumbnails");
        thumbnails = new ArrayList<>(jsonThumbnails.size());
        for (int i = 0; i < jsonThumbnails.size(); i++) {
            JSONObject jsonObject = jsonThumbnails.getJSONObject(i);
            if (jsonObject.containsKey("url"))
                thumbnails.add(jsonObject.getString("url"));
        }
        averageRating = json.getBigDecimal("averageRating");
        viewCount = json.getLongValue("viewCount");
        author = json.getString("author");
        isLiveContent = json.getBooleanValue("isLiveContent");
        uploadDate = json.getString("uploadDate");
    }

    public String videoId() {
        return videoId;
    }

    public String title() {
        return title;
    }

    public int lengthSeconds() {
        return lengthSeconds;
    }

    public List<String> keywords() {
        return keywords;
    }

    public String description() {
        return shortDescription;
    }

    public List<String> thumbnails() {
        return thumbnails;
    }

    public String author() {
        return author;
    }

    public long viewCount() {
        return viewCount;
    }

    public BigDecimal getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(BigDecimal averageRating) {
        this.averageRating = averageRating;
    }

    public boolean isLive() {
        return isLiveContent;
    }

    public String uploadDate(){
        return uploadDate;
    }

    @Override
    public String toString() {
        return "VideoDetails{" +
                "videoId='" + videoId + '\'' +
                ", title='" + title + '\'' +
                ", lengthSeconds=" + lengthSeconds +
                ", keywords=" + keywords +
                ", shortDescription='" + shortDescription + '\'' +
                ", thumbnails=" + thumbnails +
                ", author='" + author + '\'' +
                ", viewCount=" + viewCount +
                ", averageRating=" + averageRating +
                ", isLiveContent=" + isLiveContent +
                ", uploadDate='" + uploadDate + '\'' +
                '}';
    }
}
