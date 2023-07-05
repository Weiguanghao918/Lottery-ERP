package cn.itedus.lottery.erp;

import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author: Guanghao Wei
 * @date: 2023-06-05 15:29
 * @description: 抽奖系统ERP Application
 */
@SpringBootApplication
@EnableNacosDiscovery
public class LotteryErpApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(LotteryErpApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(LotteryErpApplication.class, args);
    }

}