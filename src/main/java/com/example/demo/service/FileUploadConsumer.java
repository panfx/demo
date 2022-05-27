package com.example.demo.service;

import com.example.demo.model.FileUploadModel;
import com.example.demo.service.FileUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author panfx
 * @date 2021/2/20 12:09
 */
public class FileUploadConsumer implements Runnable {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run() {
        while (true) {
            FileUploadModel fileUploadModel = null;
            try {
                // 获取队列数据
                fileUploadModel = FileUploadService.queue.poll(1, TimeUnit.SECONDS);

                // 读取文件的输入流
                URL sourceUrl = new URL(fileUploadModel.getSource());
                InputStream is = sourceUrl.openStream();

                // 将输入流转化为输出流
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                int readIndex = -1;
                byte[] fileBytes = new byte[1024];
                while ((readIndex = is.read(fileBytes, 0, fileBytes.length)) != -1) {
                    os.write(fileBytes, 0, readIndex);
                }

                os.flush();
                os.close();
                is.close();

                // 调用目标URL并将文件流传入
                RestTemplate restTemplate = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                headers.add("Accept","application/json");
                headers.add("Content-Type","application/octet-stream");
                HttpEntity httpEntity = new HttpEntity(os.toByteArray(), headers);
                restTemplate.postForObject(fileUploadModel.getTarget(), httpEntity, String.class);
            } catch (Exception e) {
                logger.error("上传文件失败，放回至队列队尾", e);
                // 处理失败将数据放回队列
                if (fileUploadModel != null) {
                    FileUploadService.queue.offer(fileUploadModel);
                }
            }
        }
    }
}
