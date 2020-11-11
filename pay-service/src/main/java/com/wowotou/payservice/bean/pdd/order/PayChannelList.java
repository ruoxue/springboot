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
public class PayChannelList {

    private String channel;
    private int rank;
    private String name;
    private NameStyle nameStyle;
    private String hint;
    private String hintIcon;
    private HintStyle hintStyle;
    private int appId;
    private boolean display;
    private boolean disabled;
    private String navToApp;
    private boolean recommend;
    private boolean signed;
    private boolean selected;
    private boolean defaultSelected;
    private int paymentType;
    public void setChannel(String channel) {
         this.channel = channel;
     }
     public String getChannel() {
         return channel;
     }

    public void setRank(int rank) {
         this.rank = rank;
     }
     public int getRank() {
         return rank;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setNameStyle(NameStyle nameStyle) {
         this.nameStyle = nameStyle;
     }
     public NameStyle getNameStyle() {
         return nameStyle;
     }

    public void setHint(String hint) {
         this.hint = hint;
     }
     public String getHint() {
         return hint;
     }

    public void setHintIcon(String hintIcon) {
         this.hintIcon = hintIcon;
     }
     public String getHintIcon() {
         return hintIcon;
     }

    public void setHintStyle(HintStyle hintStyle) {
         this.hintStyle = hintStyle;
     }
     public HintStyle getHintStyle() {
         return hintStyle;
     }

    public void setAppId(int appId) {
         this.appId = appId;
     }
     public int getAppId() {
         return appId;
     }

    public void setDisplay(boolean display) {
         this.display = display;
     }
     public boolean getDisplay() {
         return display;
     }

    public void setDisabled(boolean disabled) {
         this.disabled = disabled;
     }
     public boolean getDisabled() {
         return disabled;
     }

    public void setNavToApp(String navToApp) {
         this.navToApp = navToApp;
     }
     public String getNavToApp() {
         return navToApp;
     }

    public void setRecommend(boolean recommend) {
         this.recommend = recommend;
     }
     public boolean getRecommend() {
         return recommend;
     }

    public void setSigned(boolean signed) {
         this.signed = signed;
     }
     public boolean getSigned() {
         return signed;
     }

    public void setSelected(boolean selected) {
         this.selected = selected;
     }
     public boolean getSelected() {
         return selected;
     }

    public void setDefaultSelected(boolean defaultSelected) {
         this.defaultSelected = defaultSelected;
     }
     public boolean getDefaultSelected() {
         return defaultSelected;
     }

    public void setPaymentType(int paymentType) {
         this.paymentType = paymentType;
     }
     public int getPaymentType() {
         return paymentType;
     }

}