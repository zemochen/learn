package org.zemo.zk.publish;

import org.I0Itec.zkclient.IZkDataListener;

/**
 * @ClassName: ZkListener
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 26/10/2017 17:52
 * @Description zookeeper 监听者
 */
public interface ZkListener extends IZkDataListener{
    void update(String paramString1, String paramString2);

    void listen();
}
