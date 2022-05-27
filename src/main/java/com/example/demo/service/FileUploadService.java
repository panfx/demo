package com.example.demo.service;

import com.example.demo.model.FileUploadModel;
import org.springframework.stereotype.Service;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author panfx
 * @date 2021/2/20 11:39
 */
@Service
public class FileUploadService {

    public static LinkedBlockingQueue<FileUploadModel> queue = new LinkedBlockingQueue<>(10000);

//    static {
//        new Thread(new FileUploadConsumer()).start();
//    }

    /**
     * 将源文件上传至目标地址
     * @param source 源文件URL
     * @param target 目标URL
     * @returns
     */
    public boolean uploadFile(String source, String target) {
        return queue.offer(new FileUploadModel(source, target));
    }
}
