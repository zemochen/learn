package org.zemo.zk.publish.log;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: LogBackManager
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 17/10/2017 16:24
 * @Description logback 管理
 */
public class LogBackManager extends LogManager<Logger> {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(LogBackManager.class);

    @Override
    public Logger changeLogLevel(String loggerName, String level) {
        Logger logger = this.determineLogger(loggerName);
        if (logger == null) {
            LOGGER.warn("不存在的logger name");
            return null;
        }
        logger.setLevel(Level.toLevel(level));
        return logger;
    }

    @Override
    protected Logger determineLogger(String loggerName){
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        return loggerContext.getLogger(loggerName);
    }
}
