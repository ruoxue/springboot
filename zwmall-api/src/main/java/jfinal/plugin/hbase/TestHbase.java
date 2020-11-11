package jfinal.plugin.hbase;

import org.apache.commons.collections4.Get;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

public class TestHbase {
    private static HbasePlugin p;

    @BeforeClass
    public static void beforeClass() {
        // p = new HbasePlugin("127.0.0.1:2181");
        p = new HbasePlugin("node67:2181,node68:2181,node69:2181");
        p.start();
    }

    @AfterClass
    public static void afterClass() {
        p.stop();
    }

    @Test
    public void t1() {
        Hbase.createTable("sunyutable", new String[]{"f1", "f2"});
    }

    @Test
    @Ignore
    public void t2() {
        Hbase.deleteTable("sunyutable");
    }

    @Test
    public void t3() {
        HTableDescriptor desc = Hbase.tableDescriptor("sunyutable");
        System.out.println(desc);
    }

    @Test
    public void t4() {
        Put put = new Put(Bytes.toBytes("row1"));
        put.addColumn(Bytes.toBytes("f1"), Bytes.toBytes("q1"), Bytes.toBytes("f1列族q1列的值111"));
        put.addColumn(Bytes.toBytes("f1"), Bytes.toBytes("q2"), Bytes.toBytes("f1列族q2列的值111"));
        Hbase.put("sunyutable", put);
    }

    @Test
    public void t5() {
        List<Result> results = Hbase.scan("sunyutable");
        for (Result result : results) {
            byte[] value = result.getValue(Bytes.toBytes("f1"), Bytes.toBytes("q1"));
            System.out.println(Bytes.toString(value));
        }
    }

    @Test
    public void t7() {
        Delete del = new Delete(Bytes.toBytes("row1"));
        Hbase.delete("sunyutable", del);
    }

    @Test
    public void t8() {
//        Get g = new Get(Bytes.toBytes("row1"));
//        Result result = Hbase.get("sunyutable", g);
//        byte[] value = result.getValue(Bytes.toBytes("f1"), Bytes.toBytes("q1"));
//        System.out.println(Bytes.toString(value));
    }

    @Test
    @Ignore
    public void t9() {
        Hbase.addCoprocessor("sunyutable", "org.apache.hadoop.hbase.coprocessor.AggregateImplementation");
    }

    @Test
    public void t10() {
        System.out.println(Hbase.rowCount("sunyutable", new Scan()));
    }
}
