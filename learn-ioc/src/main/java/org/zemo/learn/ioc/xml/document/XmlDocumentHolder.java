package org.zemo.learn.ioc.xml.document;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: XmlDocumentHolder
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 17/07/2017 15:05
 * @Description ${TODO}
 */
public class XmlDocumentHolder implements DocumentHolder {

    /**
     * 由于可能配置多个配置文件，所以定义一个Map用配置文件的路径关联他们的Document对象
     */
    private Map<String, Document> documents = new HashMap<String, Document>();

    /**
     * 根据路径获取Document对象
     * @param xmlPath
     * @return
     */
    public Document getDocument(String xmlPath) {

        /**
         * 从Document池中获取Document
         */
        Document doc = this.documents.get(xmlPath);

        //如果未加载过，穿透到真实路径加载
        if (doc == null) {
            this.documents.put(xmlPath, this.readDocument(xmlPath));

        }
        return this.documents.get(xmlPath);
    }

    /**
     * 根据路径从真实环境中获取Document
     * @param xmlPath
     * @return
     */
    private Document readDocument(String xmlPath) {

        try {
            SAXReader reader = new SAXReader(true);
            //设置用来验证的dtd的输入源
            reader.setEntityResolver(new XmlEntityResolver());

            //根据xml的路径读取出Document对象
            File xmlFile = new File(xmlPath);
            Document doc = reader.read(xmlFile);

            return doc;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }
}
