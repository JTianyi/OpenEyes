package com.example.dllo.openeyes.model.bean;

/**
 * Created by mac on 16/8/16.
 * 发现界面需要的实体类
 * @author wangweijian
 */
public class FindNeedBean {
    private String needImage;
    private String needTitle;

    public FindNeedBean() {
    }

    public FindNeedBean(String needImage, String needTitle) {
        this.needImage = needImage;
        this.needTitle = needTitle;
    }

    public String getNeedImage() {
        return needImage;
    }

    public void setNeedImage(String needImage) {
        this.needImage = needImage;
    }

    public String getNeedTitle() {
        return needTitle;
    }

    public void setNeedTitle(String needTitle) {
        this.needTitle = needTitle;
    }
}
