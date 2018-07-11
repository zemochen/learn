package org.zemo.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: ListPfmTest
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 7/1/16 20:51
 * @Description List 性能测试
 */
public class ListPfmTest {

    private static long start = 0l;
    private List<String> arrayListTest(){
        List<String> list = new ArrayList<String>(1000000);
        //每次向末尾追加元素时，ArrayList要优于LinkedList，否则，结果相反，因为ArrayList要有向后移动其他数据的损耗
        for (int i = 0; i < 1000000; i++) {
            list.add(0,i + "");
        }
        return list;
    }
    private List<String> linkedListTest(){
        List<String> list = new LinkedList<String>();
        //LinkedList 在任意位置添加元素，不影响性能
        for (int i = 0; i < 1000000; i++) {
            list.add(0,i + "");
        }
        return list;
    }

    public static void main(String[] args) {
        ListPfmTest test = new ListPfmTest();

        start = System.currentTimeMillis();
        List<String> arrayList = test.arrayListTest();
        System.out.println("arrayListTest used:"+(System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        List<String> linkedList = test.linkedListTest();
        System.out.println("linkedListTest used:"+(System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        System.out.println(arrayList.get(50));
        System.out.println("arrayList get() used:"+(System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        System.out.println(linkedList.get(50));
        System.out.println("linkedList get() used:"+(System.currentTimeMillis() - start));


    }

}
