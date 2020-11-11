/**
  * Copyright 2019 bejson.com 
  */
package com.wowotou.payservice.bean.pdd.order;
import java.util.List;

/**
 * Auto-generated: 2019-12-19 21:57:28
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class DeliveryInfoStore {

    private int srvShortTag;
    private String selectedServiceTransparentField;
    private int clickType;
    private String displayContent;
    private String displayTitle;
    private List<String> templateList;
    private boolean showDeliveryList;
    public void setSrvShortTag(int srvShortTag) {
         this.srvShortTag = srvShortTag;
     }
     public int getSrvShortTag() {
         return srvShortTag;
     }

    public void setSelectedServiceTransparentField(String selectedServiceTransparentField) {
         this.selectedServiceTransparentField = selectedServiceTransparentField;
     }
     public String getSelectedServiceTransparentField() {
         return selectedServiceTransparentField;
     }

    public void setClickType(int clickType) {
         this.clickType = clickType;
     }
     public int getClickType() {
         return clickType;
     }

    public void setDisplayContent(String displayContent) {
         this.displayContent = displayContent;
     }
     public String getDisplayContent() {
         return displayContent;
     }

    public void setDisplayTitle(String displayTitle) {
         this.displayTitle = displayTitle;
     }
     public String getDisplayTitle() {
         return displayTitle;
     }

    public void setTemplateList(List<String> templateList) {
         this.templateList = templateList;
     }
     public List<String> getTemplateList() {
         return templateList;
     }

    public void setShowDeliveryList(boolean showDeliveryList) {
         this.showDeliveryList = showDeliveryList;
     }
     public boolean getShowDeliveryList() {
         return showDeliveryList;
     }

}