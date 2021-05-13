package com.yu.springcloud.entities;

import lombok.Data;

/**
 *@descript 自写健康检查
 *              --返回体
 *         至于为什么不用枚举：返回体中看不到{status：“UP”}的json数据
 *@author yu
 *@date 2021/5/10 22:53
 *@version 1.0
 */
@Data
public final class Health {

    private Health(String status){
        this.status = status;
    }
    private String status;

    public static Health getHealth(){
        return HealthSingleton.buildSingletonHealth();
    }

    static class HealthSingleton{

        private static Health health;
        private static final String LOCK = "lock";

        static Health buildSingletonHealth(){
            if (health==null){
                //如果有多个线程同时进入判断内
                synchronized (LOCK){
                    //则进行双重判断
                    if (health==null){
                        health = new Health("UP");
                    }
                }
            }
            return health;
        }
    }
}
