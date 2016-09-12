package com.blossoming.maker.Model;

/**
 * Created by Blossoming on 2016/9/12.
 */
public class ItemEvents {
    private int index;
    private String imageUrl;
    public ItemEvents(int index,String imageUrl)
    {
        this.index=index;
        this.imageUrl=imageUrl;
    }
    public int getIndex()
    {
        return index;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
