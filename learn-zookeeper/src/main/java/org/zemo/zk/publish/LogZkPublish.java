package org.zemo.zk.publish;

import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: LogZkPublish
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 30/10/2017 09:41
 * @Description 日志广播发布者
 */
public class LogZkPublish implements ZkPublish {

    private static final Logger logger = LoggerFactory.getLogger(LogZkPublish.class);

    @Override
    public void publish(ZkClient client, String rootNode, String value) {
        String path = ZkUtils.getZkPath(rootNode, "/root");
        if (!client.exists(rootNode)) {
            logger.warn("[zookeeper publish]path:{} not exist",rootNode);
            ZkUtils.mkPaths(client, path);
            client.createPersistent(path);
        }
        logger.debug("[zookeeper publish]write:{} to path:{}", value, path);
        client.writeData(path, value);
    }

    public static void main(String[] args) {

        ZkClient client = new ZkClient("127.0.0.1:2181", 6000);
        client.setZkSerializer(new ZkUtils.StringSerializer("UTF-8"));
        new LogZkPublish().publish(client,LogZkListener.ZOOKEEPER_ROOT_NODE_PREFIX,"debug");
    }
}
