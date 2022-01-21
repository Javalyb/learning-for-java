package priv.lyb.nettyrpc.service;

import priv.lyb.nettyrpc.netty.TestService;

/**
 * @Author: lyb
 * @Description:
 * @Date: 22:13 2022/01/01
 */
public class TestServiceImpl implements TestService {
    @Override
    public String hello(String msg) {
        System.out.println("TestServiceImpl中的hello方法被调用，参数：" + msg);
        return "你好客户端，我已经收到你的消息：" + msg;
    }
}
