package org.zemo.thift;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.zemo.thift.tutorial.Calculator;

/**
 * @ClassName: JavaService
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 07/11/2017 16:26
 * @Description ${TODO}
 */
public class JavaService {
    public static CalculatorHandler handler;

    public static Calculator.Processor processor;

    public static void main(String[] args) {
        handler = new CalculatorHandler();
        processor = new Calculator.Processor(handler);
        Runnable simple = new Runnable() {
            @Override
            public void run() {
                simple(processor);
            }
        };

        Runnable secure = new Runnable() {
            @Override
            public void run() {
                secure(processor);
            }
        };

        new Thread(simple).start();
        new Thread(secure).start();
    }

    public static void simple(Calculator.Processor processor) {

        try {
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
            // Use this for a multithreaded server
            // TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));

            System.out.println("Starting the simple server....");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

    public static void secure(Calculator.Processor processor) {
        try {
            /*
             * Use TSSLTransportParameters to setup the required SSL parameters. In this example
             * we are setting the keystore and the keystore password. Other things like algorithms,
             * cipher suites, client auth etc can be set.
             */
            TSSLTransportFactory.TSSLTransportParameters params = new TSSLTransportFactory.TSSLTransportParameters();
            params.setKeyStore(".keystore", "thrift", null, null);

            TServerTransport serverTransport = TSSLTransportFactory.getServerSocket(9091, 0, null, params);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
            // Use this for a multi threaded server
            // TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));

            System.out.println("Starting the secure server...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
