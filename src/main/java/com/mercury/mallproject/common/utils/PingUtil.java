package com.mercury.mallproject.common.utils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PingUtil {

    private static final Logger logger = LoggerFactory.getLogger(PingUtil.class);

    public synchronized static boolean ping(String host, int port, int timeOut) {
        boolean flag = false;
        Socket socket = null;
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(host.trim(), port), timeOut);
            flag = true;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            logger.error("Ping " + host + ":" + port + "错误" + flag, e);
            return false;
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Ping " + host + ":" + port + "错误" + flag, e);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Connect device failed：" + e.getMessage());
            logger.error("Ping " + host + ":" + port + "错误" + flag, e);
            return false;
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception e) {
            }
        }
        logger.info("测试Ping " + host + ":" + port + "状态" + flag);
        return flag;
    }


    public static void main(String[] args) {
        ping("www.baidu.com", 80, 3000);
        ping("oapi.dingtalk.com", 80, 3000);

    }

}