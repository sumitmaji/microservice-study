package com.sum.licenceservice;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLException;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Application {

  @LoadBalanced
  @Bean
  public RestTemplate getRestTemplate(){
      return new RestTemplate();
  }

  public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
  }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server inMemoryH2DatabaseaServer() throws SQLException {
        return Server.createTcpServer(
                "-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
    }

}
