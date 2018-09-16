package com.lph.face.model;

import java.util.ArrayList;
import java.util.List;

public class FaceMessage
{
    private String image_id;
    private String request_id;
    private int time_used;
    private List<Face> faces = new ArrayList<>();
    public String getImage_id()
    {
        return image_id;
    }
    public void setImage_id(String image_id)
    {
        this.image_id = image_id;
    }
    public String getRequest_id()
    {
        return request_id;
    }
    public void setRequest_id(String request_id)
    {
        this.request_id = request_id;
    }
    public int getTime_used()
    {
        return time_used;
    }
    public void setTime_used(int time_used)
    {
        this.time_used = time_used;
    }
    public List<Face> getFaces()
    {
        return faces;
    }
    public void setFaces(List<Face> faces)
    {
        this.faces = faces;
    }
    @Override
    public String toString()
    {
        return "FaceMessage [image_id=" + image_id + ", request_id="
            + request_id + ", time_used=" + time_used + ", faces=" + faces
            + "]";
    }
    
    
}
