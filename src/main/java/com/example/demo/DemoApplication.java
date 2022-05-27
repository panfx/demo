package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@EnableDiscoveryClient
@SpringBootApplication
//@NacosPropertySource(dataId = "fuxue", groupId = "fuxue_group", autoRefreshed = true)
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
//
//        FileUploadService fileUploadService = run.getBean(FileUploadService.class);
//        for (int i = 0; i < 1000; i++) {
//            String sourceUrl = "https://codeload.github.com/panfx/eclipse_upload2/zip/master";
//
//            fileUploadService.uploadFile(sourceUrl, "http://localhost:8080/api/receive");
//        }
    }

}
