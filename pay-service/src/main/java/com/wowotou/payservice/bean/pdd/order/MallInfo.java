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
public class MallInfo {

    private long id;
    private String name;
    private String logo;
    private String mallOrderPrice;
    private boolean canCompensate;
    private List<String> labels;
    public void setId(long id) {
         this.id = id;
     }
     public long getId() {
         return id;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setLogo(String logo) {
         this.logo = logo;
     }
     public String getLogo() {
         return logo;
     }

    public void setMallOrderPrice(String mallOrderPrice) {
         this.mallOrderPrice = mallOrderPrice;
     }
     public String getMallOrderPrice() {
         return mallOrderPrice;
     }

    public void setCanCompensate(boolean canCompensate) {
         this.canCompensate = canCompensate;
     }
     public boolean getCanCompensate() {
         return canCompensate;
     }

    public void setLabels(List<String> labels) {
         this.labels = labels;
     }
     public List<String> getLabels() {
         return labels;
     }

}