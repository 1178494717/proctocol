package com.lph.face.model;

import java.util.Map;

public class Face
{
    private Map<String,Map<String,Integer>> landmark;
    private FaceAttr attributes;
    private FaceRecAttr face_rectangle;
    private String face_token;
    
    public Map<String, Map<String, Integer>> getLandmark()
    {
        return landmark;
    }
    public void setLandmark(Map<String, Map<String, Integer>> landmark)
    {
        this.landmark = landmark;
    }
    public FaceAttr getAttributes()
    {
        return attributes;
    }
    public void setAttributes(FaceAttr attributes)
    {
        this.attributes = attributes;
    }
    public FaceRecAttr getFace_rectangle()
    {
        return face_rectangle;
    }
    public void setFace_rectangle(FaceRecAttr face_rectangle)
    {
        this.face_rectangle = face_rectangle;
    }
    public String getFace_token()
    {
        return face_token;
    }
    public void setFace_token(String face_token)
    {
        this.face_token = face_token;
    }
    @Override
    public String toString()
    {
        return "Face [landmark=" + landmark + ", attributes=" + attributes
            + ", face_rectangle=" + face_rectangle + ", face_token="
            + face_token + "]";
    }
    
    
}
