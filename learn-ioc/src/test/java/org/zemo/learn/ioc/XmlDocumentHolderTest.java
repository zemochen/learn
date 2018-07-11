package org.zemo.learn.ioc;

import org.dom4j.Document;
import org.dom4j.Element;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.zemo.learn.ioc.xml.document.XmlDocumentHolder;

/**
 * @ClassName: XmlDocumentHolderTest
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 17/07/2017 15:33
 * @Description ${TODO}
 */
public class XmlDocumentHolderTest {

    private XmlDocumentHolder xmlDocumentHolder;

    @Before
    public void setUp(){
        xmlDocumentHolder = new XmlDocumentHolder();
    }

    @Test
    public void testGetDocument(){
        String xmlPath = "/Volumes/Zemo SD/git/learn/learn-ioc/src/test/resources/xmlDocumentTest.xml";
        Document doc = xmlDocumentHolder.getDocument(xmlPath);
        Assert.assertNotNull(doc);

        Element root = doc.getRootElement();
        Assert.assertEquals(root.getName(), "beans");

        Document doc2 = xmlDocumentHolder.getDocument(xmlPath);
        Assert.assertEquals(doc, doc2);

    }

    @After
    public void tearDown(){
        xmlDocumentHolder = null;
    }
}
