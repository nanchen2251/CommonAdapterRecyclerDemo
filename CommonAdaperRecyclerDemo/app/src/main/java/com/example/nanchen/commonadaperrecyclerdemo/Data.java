package com.example.nanchen.commonadaperrecyclerdemo;

/**
 * java 实体类
 * Created by 南尘 on 16-7-28.
 */
public class Data {

    private String text;
    private int imageId;
    private String imageUrl;

    public Data() {
    }

    public Data(String text, int imageId) {
        this.text = text;
        this.imageId = imageId;
    }

    public Data(String text,String imageUrl) {
        this.imageUrl = imageUrl;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
