package com.example.chenhaolong.myframe.bean;

/**
 * Name MyFrame
 * Created by chenhaolong on 2016/9/18.
 */

public class RvBean implements Cloneable {

    private String imageUrl;
    private String name;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public RvBean clone(){
        try {
            return (RvBean) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return new RvBean();
    }
}
