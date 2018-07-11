package org.zemo.zk.publish;

import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zemo.zk.publish.log.LogBackManager;
import org.zemo.zk.publish.log.LogManager;

/**
 * @ClassName: LogZkListenerImpl
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 27/10/2017 16:20
 * @Description zk日志节点监听，日志级别存储在zk节点中，该节点发生变化，改变集群日志级别
 */
public class LogZkListener implements ZkListener {

    private static final Logger logger = LoggerFactory.getLogger(LogZkListener.class);
    /**
     * zookeeper存放配置的根节点
     */
    public static String ZOOKEEPER_ROOT_NODE_PREFIX = "/conf/logs";

    private ZkClient zkClient;

    /**
     * 监听的zookeeper上节点路径
     */
    private String[] zknodes;

    public LogZkListener(ZkClient zkClient, String[] zknodes) {
        this.zkClient = zkClient;
        this.zknodes = zknodes;

    }

    @Override
    public void update(String loggerName, String level) {
        LogManager<ch.qos.logback.classic.Logger> logManager = new LogBackManager();
        ch.qos.logback.classic.Logger logger = logManager.changeLogLevel(loggerName, level);
    }

    @Override
    public void handleDataChange(String s, Object o) throws Exception {
//        update();
        logger.info("zkListener.handleDataChange.param(s):" + s);
        logger.info("zkListener.handleDataChange.param(o):" + o.toString());

    }

    @Override
    public void handleDataDeleted(String s) throws Exception {
        zkClient.unsubscribeDataChanges(s, this);
    }

    @Override
    public void listen() {
        logger.debug("szookeeper listening " + this.zknodes
                + " data changes...");

        initRootNode();
        for (String node : this.zknodes) {
            String zknode = ZOOKEEPER_ROOT_NODE_PREFIX + node;
            // 如果不存在根节点则创建
            if (!zkClient.exists(zknode)) {
                logger.error("zookeeper [" + zknode + "] is not exists!");
                String[] paths = node.split("/");
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < paths.length; i++) {
                    sb.append("/");
                    sb.append(paths[i]);
                    logger.debug("zookeeper 创建zookeeper配置节点："
                            + ZOOKEEPER_ROOT_NODE_PREFIX
                            + sb.toString());
                    if (this.zkClient
                            .exists(ZOOKEEPER_ROOT_NODE_PREFIX
                                    + sb.toString())) {
                        continue;
                    }
                    this.zkClient
                            .createPersistent(ZOOKEEPER_ROOT_NODE_PREFIX
                                    + sb.toString());
                }
            }
            logger.info("[zk listener]开始监听:{}" , zknode );
            zkClient.subscribeDataChanges(zknode,this);
        }
    }

    /**
     * 建立跟节点
     */
    private void initRootNode() {
        if (ZOOKEEPER_ROOT_NODE_PREFIX == null
                || "".equals(ZOOKEEPER_ROOT_NODE_PREFIX.trim())) {
            return;
        }
        if (!zkClient.exists(ZOOKEEPER_ROOT_NODE_PREFIX)) {
            logger.error("zookeeper [" + ZOOKEEPER_ROOT_NODE_PREFIX
                    + "] is not exists!");
            String[] paths = ZOOKEEPER_ROOT_NODE_PREFIX.split("/");
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < paths.length; i++) {
                sb.append("/");
                sb.append(paths[i]);
                // logger.debug("szookeeper 创建zookeeper配置节点：" + zknode);
                logger.debug("zookeeper 创建zookeeper配置节点：" + sb.toString());
                if (this.zkClient.exists(sb.toString())) {
                    continue;
                }
                this.zkClient.createPersistent(sb.toString());
            }
        }
    }

    public static void main(String[] args) {
        ZkClient client = new ZkClient("127.0.0.1:2181", 6000);
        client.setZkSerializer(new ZkUtils.StringSerializer("UTF-8"));
        String[] nodes = {"/root"};

        new LogZkListener(client, nodes).listen();
        while (true) {

        }
    }
}
