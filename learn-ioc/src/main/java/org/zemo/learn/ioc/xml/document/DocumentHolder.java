package org.zemo.learn.ioc.xml.document;

import org.dom4j.Document;

/**
 * @ClassName: DocumentHolder
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 17/07/2017 15:04
 * @Description ${TODO}
 */
public interface DocumentHolder {

    /**
     * 根据xml文件路径或得到dom4j里面的Document对象
     * @param xmlPath
     * @return
     */
    public Document getDocument(String xmlPath);
}
