package com.iot.config.influxdb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author weiyunyun
 * @date 2020/2/13 15:55
 */
@Configuration
public class InfluxDBConfiguration {
    @Value("${spring.influx.user}")
    private String username;

    @Value("${spring.influx.password}")
    private String password;

    @Value("${spring.influx.url}")
    private String url;

    @Value("${spring.influx.database}")
    private String database;

    @Bean
    public InfluxDBConnect getInfluxDBConnect(){
        InfluxDBConnect influxDB = new InfluxDBConnect(username, password, url, database);
        influxDB.influxDbBuild();
        influxDB.createRetentionPolicy();
        return influxDB;
    }
}
