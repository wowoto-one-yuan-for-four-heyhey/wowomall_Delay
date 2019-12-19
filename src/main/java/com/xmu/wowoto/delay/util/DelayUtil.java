package com.xmu.wowoto.delay.util;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Tuple;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.RedisSub;
import java.util.Calendar;
import java.util.Set;


/**
 * @author MedalWill
 * @date 2019/12/18 11:26
 */
public class DelayUtil {
    private static final String ADDR = "106.15.92.198";

    private static final int PORT = 6379;

    private static JedisPool jedis = new JedisPool(ADDR, PORT);

    private static JedisPubSub sub ;

    public static void init() {

        new Thread(new Runnable() {

            public void run() {

                jedis.getResource().subscribe(sub, "__keyevent@0__:expired");//__keyevent@0__:expired是redis关于事件监听的东西

            }

        }).start();

    }

    public static void main(String[] args) throws InterruptedException {

        init();

        for(int i =0;i<10;i++){

            String orderId = "OID000000"+i;

            jedis.getResource().setex(orderId, 3, orderId);

            System.out.println(System.currentTimeMillis()+"ms:"+orderId+"订单生成");

        }

    }



    static class RedisSub extends JedisPubSub {

        @Override

        public void onMessage(String channel, String message) {

            System.out.println(System.currentTimeMillis()+"ms:"+message+"订单取消");

        }

    }


}
