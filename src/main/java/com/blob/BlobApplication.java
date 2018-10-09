package com.blob;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.blob.module.*.dao")//必须加这个，不加报错，如果不加，也可以在每个mapper上添加@Mapper注释
@ServletComponentScan
public class BlobApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlobApplication.class, args);
	}
}
