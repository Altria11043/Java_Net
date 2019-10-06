package com.zca.udp;

/**
 * 老师端
 * @author Altria
 * @date: 2019/10/6 21:36
 */
public class TalkTeachen01 {
    public static void main(String[] args) {
        new Thread(new TalkReceive(8888)).start();
        new Thread(new TalkSend(6666, "localhost", 9999)).start();
    }
}
