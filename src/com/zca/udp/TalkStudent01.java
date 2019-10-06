package com.zca.udp;

/**
 * 学生端
 * @author Altria
 * @date: 2019/10/6 21:36
 */
public class TalkStudent01 {
    public static void main(String[] args) {
        new Thread(new TalkSend(7777, "localhost", 8888)).start();
        new Thread(new TalkReceive(9999)).start();
    }
}
