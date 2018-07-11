package org.zemo.zk.publish.log;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: Log4jManager
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 17/10/2017 16:26
 * @Description log4j 日志管理
 */
public class Log4jManager extends LogManager<Logger>{
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(LogBackManager.class);

    @Override
    public Logger changeLogLevel(String loggerName, String level) {
        Logger logger = this.determineLogger(loggerName);

        if (logger == null){
            LOGGER.warn("不存在的logger name");
            return null;
        }

        logger.setLevel(Level.toLevel(level));
        return logger;
    }

    @Override
    protected Logger determineLogger(String loggerName) {
        if ("ROOT".equalsIgnoreCase(loggerName)) return org.apache.log4j.LogManager.getRootLogger();
        // don't use LogManager#getLogger here since getLogger will cause
        // making of new logger if logger not found
        return org.apache.log4j.LogManager.exists(loggerName);
    }
}
