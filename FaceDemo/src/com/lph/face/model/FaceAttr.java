package com.lph.face.model;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class FaceAttr
{
    
    
    /**
     * 性别分析结果
     * Male 男性
     * Female  女性
     */
    private String gender;
    /**
     * 年龄分析结果。返回值为一个非负整数。
     */
    private String age;
    /**
     * 笑容分析结果。返回值包含以下属性：
     * value：值为一个 [0,100] 的浮点数，小数点后3位有效数字。数值越大表示笑程度高。
     * threshold：代表笑容的阈值，超过该阈值认为有笑容。
     */
    private JSONObject smile;
    /**
     * 是否佩戴眼镜的分析结果。返回值为：
     * None 不佩戴眼镜
     * Dark 佩戴墨镜
     * Normal   佩戴普通眼镜
     */
    private String glass;
    /**
     * 人脸姿势分析结果。返回值包含以下属性，每个属性的值为一个 [-180, 180] 的浮点数，小数点后 6 位有效数字。单位为角度。
     * pitch_angle：抬头
     * roll_angle：旋转（平面旋转）
     * yaw_angle：摇头
     */
    private JSONObject headpose;
    /**
     * 人脸模糊分析结果。返回值包含以下属性：
     * motionblur：人脸移动模糊度分析结果。
     * gaussianblur：人脸高斯模糊度分析结果。
     * blurness：新的人脸模糊分析结果。
     * 每个属性都包含以下字段：
     * value 的值为是一个浮点数，范围 [0,100]，小数点后 3 位有效数字
     * threshold 表示人脸模糊度是否影响辨识的阈值。
     */
    private JSONObject blur;
    /**
     * 眼睛状态信息。返回值包含以下属性：
     * left_eye_status：左眼的状态
     * right_eye_status：右眼的状态
     * 每个属性都包含以下字段。每个字段的值都是一个浮点数，范围 [0,100]，小数点后 3 位有效数字。字段值的总和等于 100。
     * occlusion：眼睛被遮挡的置信度
     * no_glass_eye_open：不戴眼镜且睁眼的置信度
     * normal_glass_eye_close：佩戴普通眼镜且闭眼的置信度
     * normal_glass_eye_open：佩戴普通眼镜且睁眼的置信度
     * dark_glasses：佩戴墨镜的置信度
     * no_glass_eye_close：不戴眼镜且闭眼的置信度
     */
    private JSONObject eyestatus;
    /**
     * 情绪识别结果。返回值包含以下字段。每个字段的值都是一个浮点数，范围 [0,100]，小数点后 3 位有效数字。
     * 每个字段的返回值越大，则该字段代表的状态的置信度越高。字段值的总和等于 100。
     * anger：愤怒
     * disgust：厌恶
     * fear：恐惧
     * happiness：高兴
     * neutral：平静
     * sadness：伤心
     * surprise：惊讶
     */
    private JSONObject emotion;
    /**
     * 人脸质量判断结果。返回值包含以下属性：
     * value：值为人脸的质量判断的分数，是一个浮点数，范围 [0,100]，小数点后 3 位有效数字。
     * threshold：表示人脸质量基本合格的一个阈值，超过该阈值的人脸适合用于人脸比对。
     */
    private JSONObject facequality;
    /**
     * 人种分析结果，返回值为：
     * Asian    亚洲人
     * White    白人
     * Black    黑人
     */
    private String ethnicity;
    /**
     * 颜值识别结果。返回值包含以下两个字段。每个字段的值是一个浮点数，范围 [0,100]，小数点后 3 位有效数字。
     * male_score：男性认为的此人脸颜值分数。值越大，颜值越高。
     * female_score：女性认为的此人脸颜值分数。值越大，颜值越高。
     */
    private JSONObject beauty;
    /**
     * 嘴部状态信息，包括以下字段。每个字段的值都是一个浮点数，范围 [0,100]，小数点后 3 位有效数字。字段值的总和等于 100。
     * surgical_mask_or_respirator：嘴部被医用口罩或呼吸面罩遮挡的置信度
     * other_occlusion：嘴部被其他物体遮挡的置信度
     * close：嘴部没有遮挡且闭上的置信度
     * open：嘴部没有遮挡且张开的置信度
     */
    private JSONObject mouthstatus;
    /**
     * 眼球位置与视线方向信息。返回值包括以下属性：
     * left_eye_gaze：左眼的位置与视线状态
     * right_eye_gaze：右眼的位置与视线状态
     * 每个属性都包括以下字段，每个字段的值都是一个浮点数，小数点后 3 位有效数字。
     * position_x_coordinate: 眼球中心位置的 X 轴坐标。
     * position_y_coordinate: 眼球中心位置的 Y 轴坐标。
     * vector_x_component: 眼球视线方向向量的 X 轴分量。
     * vector_y_component: 眼球视线方向向量的 Y 轴分量。
     * vector_z_component: 眼球视线方向向量的 Z 轴分量。
     */
    private JSONObject eyegaze;
    /**
     * 面部特征识别结果，包括以下字段。每个字段的值都是一个浮点数，范围 [0,100]，小数点后 3 位有效数字。每个字段的返回值越大，则该字段代表的状态的置信度越高。
     * health：健康
     * stain：色斑
     * acne：青春痘
     * dark_circle：黑眼圈
     */
    private JSONObject skinstatus;
    
    private static Map<String,String> genderMap = new HashMap<String,String>();
    private static Map<String,String> glassMap = new HashMap<String,String>();
    private static Map<String,String> ethnicityMap = new HashMap<String,String>();
    
    public FaceAttr()
    {
        genderMap.put("Male", "男性");
        genderMap.put("Female", "女性");
       
        glassMap.put("None", "不佩戴眼镜");
        glassMap.put("Dark", "佩戴墨镜");
        glassMap.put("Normal", "佩戴普通眼镜");
        
        ethnicityMap.put("ASIAN", "亚洲人");
        ethnicityMap.put("White", "白人人");
        ethnicityMap.put("Black", "黑人人");
        
    }
    public String getGender()
    {
        return gender;
    }
    public void setGender(String gender)
    {
        this.gender = genderMap.get(gender);
    }
   
    public String getAge()
    {
        return age;
    }
    public void setAge(String age)
    {
        this.age = age;
    }
    public JSONObject getSmile()
    {
        return smile;
    }
    public void setSmile(JSONObject smile)
    {
        this.smile = smile;
    }
    public String getGlass()
    {
        return glass;
    }
    public void setGlass(String glass)
    {
        this.glass = glassMap.get(glass);
    }
    public JSONObject getHeadpose()
    {
        return headpose;
    }
    public void setHeadpose(JSONObject headpose)
    {
        this.headpose = headpose;
    }
    public JSONObject getBlur()
    {
        return blur;
    }
    public void setBlur(JSONObject blur)
    {
        this.blur = blur;
    }
    public JSONObject getEyestatus()
    {
        return eyestatus;
    }
    public void setEyestatus(JSONObject eyestatus)
    {
        this.eyestatus = eyestatus;
    }
    public JSONObject getEmotion()
    {
        return emotion;
    }
    public void setEmotion(JSONObject emotion)
    {
        this.emotion = emotion;
    }
    public JSONObject getFacequality()
    {
        return facequality;
    }
    public void setFacequality(JSONObject facequality)
    {
        this.facequality = facequality;
    }
    public Object getEthnicity()
    {
        return ethnicity;
    }
    public void setEthnicity(Object ethnicity)
    {
        this.ethnicity = ethnicityMap.get(ethnicity);
    }
    public JSONObject getBeauty()
    {
        return beauty;
    }
    public void setBeauty(JSONObject beauty)
    {
        this.beauty = beauty;
    }
    public JSONObject getMouthstatus()
    {
        return mouthstatus;
    }
    public void setMouthstatus(JSONObject mouthstatus)
    {
        this.mouthstatus = mouthstatus;
    }
    public JSONObject getEyegaze()
    {
        return eyegaze;
    }
    public void setEyegaze(JSONObject eyegaze)
    {
        this.eyegaze = eyegaze;
    }
    public JSONObject getSkinstatus()
    {
        return skinstatus;
    }
    public void setSkinstatus(JSONObject skinstatus)
    {
        this.skinstatus = skinstatus;
    }
    @Override
    public String toString()
    {
        return "FaceAttr [gender=" + gender + ", age=" + age + ", smile="
            + smile + ", glass=" + glass + ", headpose=" + headpose + ", blur="
            + blur + ", eyestatus=" + eyestatus + ", emotion=" + emotion
            + ", facequality=" + facequality + ", ethnicity=" + ethnicity
            + ", beauty=" + beauty + ", mouthstatus=" + mouthstatus
            + ", eyegaze=" + eyegaze + ", skinstatus=" + skinstatus + "]";
    }
    
    
}
