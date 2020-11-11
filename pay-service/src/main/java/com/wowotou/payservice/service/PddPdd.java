//package com.wowotou.payservice.service;
//
//import com.mfypay.common.selenium.SeleniumUtil;
//import com.mfypay.pay.util.USERAGENT;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//import java.util.List;
//
//public class PddPdd {
//
//    public static   String DDtoDMS_photo(Double d){
//
//        String[] array=d.toString().split("[.]");
//        String degrees=array[0];//得到度
//
//        Double m=Double.parseDouble("0."+array[1])*60;
//        String[] array1=m.toString().split("[.]");
//        String minutes=array1[0];//得到分
//
//        Double s=Double.parseDouble("0."+array1[1])*60;
//        String[] array2=s.toString().split("[.]");
//        String seconds=array2[0];//得到秒
//
//
//
//if (array2[1].length()>2)
//{
//    seconds=seconds+"."+array2[1].substring(0,2);
//}else {
//    seconds=seconds+"."+array2[1];
//}
//
//
//
//
//
//
//
//
//
//
//        System.out.println(degrees+"°"+minutes+"′"+seconds);
//        return  degrees+"°"+minutes+"′"+seconds;
//    }
//
//
//    public  static String   load(String url,String ua,String s){
//        WebDriver driver = SeleniumUtil.getDriver(url, ua);
//
//
//        driver.get(url);
//
//
//        WebElement mobile = driver.findElement(By.id("localvalue"));
//        mobile.sendKeys(s);
//        WebElement codeBtn = driver.findElement(By.id("localsearch"));
//
//        codeBtn.click();
//
//
//        WebElement no_0 = driver.findElement(By.id("no_0"));
//        String text = no_0.getText();
//
//        text=text.substring(text.indexOf("坐标："));
//      text=  text.replace("坐标：","");
//        String[] split = text.split(",");
//        String jingdu=split[0];
//        String weidu=split[1];
//        System.out.println(jingdu);
//        System.out.println(weidu);
//        jingdu = DDtoDMS_photo(Double.valueOf(jingdu));//load2("http://www.minigps.net/fc.html", USERAGENT.NORMALUA, jingdu);
//        weidu = DDtoDMS_photo(Double.valueOf(weidu));//load2("http://www.minigps.net/fc.html", USERAGENT.NORMALUA, weidu);
//        System.out.println(jingdu);
//        System.out.println(weidu);
//        SeleniumUtil.closeDriver(driver);
//        return  jingdu+"="+weidu;
//    }
//
//
//
//
//
//
//
//
//
//    public  static String   load2(String url,String ua,String duuu){
//        WebDriver driver = SeleniumUtil.getDriver(url, ua);
//
//
//        driver.get(url);
//
//
//        WebElement mobile = driver.findElement(By.id("input_du"));
//        mobile.sendKeys(duuu);
//
//        List<WebElement> but = driver.findElements(By.className("but"));
//
//        but.get(0).click();
//
//        WebElement no_0 = driver.findElement(By.id("calculated_DFM"));
//String s=no_0.getText();
//        System.out.println(no_0.getText());
//
//
//
//        SeleniumUtil.closeDriver(driver);
//        return  s;
//    }
//
//
//
//
//
//
//
//
//
//
//}
