package jfinal.plugin.hbase;

import com.jfinal.plugin.IPlugin;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.coprocessor.AggregationClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HbasePlugin implements IPlugin {
    private static final Logger logger = LoggerFactory.getLogger(Thread.currentThread().getClass());
    private String quorum;
    private String znode = "/hbase";
    private String encoding = "UTF-8";
    public HbasePlugin(String quorum) {
        this.quorum = quorum;
    }
    @Override
    public boolean start() {
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", quorum);
        config.set("hbase.zookeeper.znode.parent", znode);
        config.set("hbase.encoding", encoding);
        try {
            Hbase.connection = ConnectionFactory.createConnection(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Hbase.aggregationClient = new AggregationClient(config);
        return true;
    }
    @Override
    public boolean stop() {
        if (!Hbase.connection.isClosed()) {
            try {
                Hbase.connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            Hbase.aggregationClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}