package com.wowotou.common;

import com.csvreader.CsvReader;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class CsvUtil {
    public static List<String[]> readCSV(String filePath) throws Exception {
        char separator = ',';
        CsvReader reader = null;
        List<String[]> dataList = new ArrayList<String[]>();
        String[] strings=new String[]{};
        try {
            //如果生产文件乱码，windows下用gbk，linux用UTF-8
            reader = new CsvReader(filePath, separator, Charset.forName("UTF-8"));

            // 读取表头
            reader.readHeaders();
            String[] headArray = reader.getHeaders();//获取标题
            System.out.println(headArray[0] + headArray[1] + headArray[2]);

            strings=new String[6];
            strings[0]=headArray[0];
            strings[1]=headArray[1];
            strings[2]=headArray[2];
            strings[3]=headArray[3];
            strings[4]=headArray[4];
            strings[5]=headArray[5];

            // 逐条读取记录，直至读完
            while (reader.readRecord()) {
                strings=new String[6];
                strings[0]=reader.get(0);
                strings[1]=reader.get(1);
                strings[2]=reader.get(2);
                strings[3]=reader.get(3);
                strings[4]=reader.get(4);
                strings[5]=reader.get(5);
                //strings[3]=reader.get(3);

                dataList.add(strings);
                // 读这行的第一列
//                System.out.println(reader.get("支付宝交易号"));
                // 读这行的第二列
//                System.out.println(reader.get(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                reader.close();
            }
        }
        return dataList;
    }
}
