package org.zemo.learn.ioc.xml.document;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: XmlEntityResolver
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 17/07/2017 15:13
 * @Description 自定义的XmlEntityResolver实现dom4j里的EntityResolver接口并实现里面的
 */
public class XmlEntityResolver implements EntityResolver {

    /**
     * 如果自己写的xml配置文件中引入dtd的时候publicId与"-//RONGDI//DTD BEAN//CN"相同
     * 并且systemId与"http://zemochen.github.com/ioc/beans.dtd"相同，就从本地的相对项目的路径
     * 寻找dtd,返回一个dtd的输入源，若果找不到该dtd就会尝试到对应的网址上寻找
     */
    public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {

        if ("-//RONGDI//DTD BEAN//CN".equals(publicId)&&"http://zemochen.github.com/ioc/beans.dtd".equals(systemId)) {
            InputStream stream = this.getClass().
                    getResourceAsStream("org/zemo/learn/ioc/dtd/beans.dtd");
            return new InputSource(stream);
        }
        return null;
    }
}
