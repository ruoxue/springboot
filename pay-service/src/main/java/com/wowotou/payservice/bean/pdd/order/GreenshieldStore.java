/**
  * Copyright 2019 bejson.com 
  */
package com.wowotou.payservice.bean.pdd.order;

/**
 * Auto-generated: 2019-12-19 21:57:28
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class GreenshieldStore {

    private String $http;
    private boolean isServerRendered;
    private boolean isFinishInitLoading;
    private String accessToken;
    private String errorRedirectUrl;
    public void set$http(String $http) {
         this.$http = $http;
     }
     public String get$http() {
         return $http;
     }

    public void setIsServerRendered(boolean isServerRendered) {
         this.isServerRendered = isServerRendered;
     }
     public boolean getIsServerRendered() {
         return isServerRendered;
     }

    public void setIsFinishInitLoading(boolean isFinishInitLoading) {
         this.isFinishInitLoading = isFinishInitLoading;
     }
     public boolean getIsFinishInitLoading() {
         return isFinishInitLoading;
     }

    public void setAccessToken(String accessToken) {
         this.accessToken = accessToken;
     }
     public String getAccessToken() {
         return accessToken;
     }

    public void setErrorRedirectUrl(String errorRedirectUrl) {
         this.errorRedirectUrl = errorRedirectUrl;
     }
     public String getErrorRedirectUrl() {
         return errorRedirectUrl;
     }

}