package org.zemo.zk.publish;

import org.I0Itec.zkclient.ZkClient;

/**
 * @ClassName: ZkPublish
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 27/10/2017 11:44
 * @Description Zookeeper 广播发布者
 */
public interface ZkPublish {

    void publish(ZkClient client, String rootNode, String value);
}
