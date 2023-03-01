package com.zp95sky.dijun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 山海紫穹
 */
@SpringBootApplication
@MapperScan("com.zp95sky.dijun.*.mapper")
public class DiJunApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiJunApplication.class, args);
	}

}
