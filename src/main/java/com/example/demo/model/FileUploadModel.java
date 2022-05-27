package com.example.demo.model;

/**
 * @author panfx
 * @date 2021/2/20 12:51
 */
public class FileUploadModel {

    /**
     * 源文件URL
     */
    private String source;

    /**
     * 目标URL
     */
    private String target;

    public FileUploadModel(String source, String target) {
        this.source = source;
        this.target = target;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
