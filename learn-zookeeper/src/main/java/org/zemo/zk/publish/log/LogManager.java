package org.zemo.zk.publish.log;

/**
 * @ClassName: LogManager
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 17/10/2017 16:20
 * @Description 日志管理基础类
 */
public abstract class LogManager<L> {

    public abstract L changeLogLevel(String loggerName, String level);

    protected abstract L determineLogger(String loggerName);
}
