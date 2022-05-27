package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author panfx
 * @date 2020/12/21
 */
@RestController
public class DemoController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private RestTemplate template;

//    @NacosValue(value = "${name}", autoRefreshed = true)
    private String name;

    @GetMapping("/api/test")
    @ResponseBody
    public String test(HttpServletRequest request) {
        return "port=" + port + ";name=" + name;
    }

    @GetMapping("/api/get")
    @ResponseBody
    public String get(HttpServletRequest request) {
        return template.getForObject("http://fuxue-demo/api/test", String.class);
    }

    @PostMapping("/api/receive")
    public void receive(HttpServletRequest request) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        int index;
        byte[] bytes = new byte[1024];
        FileOutputStream downloadFile = new FileOutputStream("d://test.zip");
        while ((index = inputStream.read(bytes)) != -1) {
            downloadFile.write(bytes, 0, index);
            downloadFile.flush();
        }
        downloadFile.close();
        inputStream.close();

        System.out.println(inputStream);

    }
}
