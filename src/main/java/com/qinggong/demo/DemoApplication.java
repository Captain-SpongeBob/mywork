package com.qinggong.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 主程序入口
 * 
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DemoApplication {
	private final static Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		logger.warn("starting DemoApplication...");
		SpringApplication application = new SpringApplication(DemoApplication.class);
		application.setBannerMode(Mode.OFF);
		application.run(args);
		long end = System.currentTimeMillis();
		logger.warn("started DemoApplication in {} seconds", (end - start) / 1000);
	}
}
