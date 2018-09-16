package com.lph.utils;

import java.io.File;

import com.alibaba.fastjson.JSONObject;
import com.lph.face.model.FaceMessage;


public class JsonTest
{
    public static void main(String[] args)
    {
        String filePath = System.getProperty("user.dir") + File.separator
            + "src" + File.separator + "return_faceDemo.json";
        String jsonStr = FileUtils.readFile4Str(filePath);
        FaceMessage responseStr = JSONObject.parseObject(jsonStr,FaceMessage.class);
        System.out.println(responseStr);
    }
}
