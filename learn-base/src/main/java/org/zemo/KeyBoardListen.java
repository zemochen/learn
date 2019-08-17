package org.zemo;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @ClassName: KeyBoardListen
 * @author: superzemo
 * @email: zeming.chen@dmall.com
 * @Date 2019-08-17
 * @Description 键盘点击事件监控
 */
public class KeyBoardListen extends JFrame {

    /**
     * @param args
     */
    char charA;

    public KeyBoardListen() {
        this.setSize(500, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("my jframe");
        this.setVisible(true);
        this.addKeyListener(new MyKeyListener());


    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new KeyBoardListen();
    }

}

//监听键盘类
class MyKeyListener extends KeyAdapter {
    private long lastTime = System.currentTimeMillis();
    long time = 1000000;

    public void keyPressed(KeyEvent e) {
        char charA = e.getKeyChar();
        Long currTime = System.currentTimeMillis();
        System.out.println((currTime % time) + ":" + charA + "(" + e.getKeyCode() + "),use:" + (lastTime - currTime));
        lastTime = currTime;
    }
}