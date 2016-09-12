package com.blossoming.maker.Model;

/**
 * Created by Blossoming on 2016/9/12.
 */
public class EventsInfo {
    private int eventImage;
    private String eventInfo;
    public EventsInfo(int eventImage,String eventInfo){
        this.eventImage=eventImage;
        this.eventInfo=eventInfo;
    }

    public void setEventImage(int eventImage) {
        this.eventImage = eventImage;
    }

    public void setEventInfo(String eventInfo) {
        this.eventInfo = eventInfo;
    }

    public int getEventImage() {
        return eventImage;
    }

    public String getEventInfo() {
        return eventInfo;
    }
}
