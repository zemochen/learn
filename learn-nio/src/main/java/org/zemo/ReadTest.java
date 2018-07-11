package org.zemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName: ReadTest
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 19/10/2016 14:51
 * @Description ${TODO}
 */
public class ReadTest {


    public static void main(String[] args) {
        try {
            String path = ReadTest.class.getResource("/nio.txt").getPath();
            File file = new File(path);
            RandomAccessFile accessFile = new RandomAccessFile(file, "rw");
            FileChannel inChannel = accessFile.getChannel();
            //create buffer with capacity of 48 bytes
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            //read into buffer.
            int bytesRead = inChannel.read(byteBuffer);
            while (bytesRead != -1) {
                System.out.println();
                System.out.println(" Read:" + bytesRead);
                //make buffer ready for read
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    // read 1 byte at a time
                    System.out.print((char)byteBuffer.get());
                }
                //make buffer ready for writing
                byteBuffer.clear();
                bytesRead = inChannel.read(byteBuffer);
            }
            accessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
