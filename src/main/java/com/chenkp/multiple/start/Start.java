package com.chenkp.multiple.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan(basePackages={"com.chenkp.multiple"})//扫描加载哪些路径下的类。如果启动类在外层，不需要加此注解
public class Start {
	public static void main(String[] args) {
		SpringApplication.run(Start.class, args);
	}
}
