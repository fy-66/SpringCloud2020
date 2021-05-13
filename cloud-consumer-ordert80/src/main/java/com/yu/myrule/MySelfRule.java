package com.yu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@descript 改变负载均衡算法
 *          不能定义在ComponentScan下，即启动类所在包和子包下
 *@author yu
 *@date 2021/5/11 12:21
 *@version 1.0
 */
@Configuration
public class MySelfRule {

    /**
     * @descript 共有七种：RoundRobbieRule、RandomRule、RetryRule、BestAvailableRule、WeightedResponseTimeRule、
     * AvailabilityFilteringRule、WeightedResponseTimeRule、ZoneAvoidanceRule
     *
     *          --默认为轮询：RoundRobbieRule
     *          --改为随机算法：RandomRule
     * @author yu
     * @date 2021/5/11
     * @return com.netflix.loadbalancer.IRule
     */
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
