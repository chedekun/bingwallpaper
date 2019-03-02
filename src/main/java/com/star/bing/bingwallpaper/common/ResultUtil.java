package com.star.bing.bingwallpaper.common;

import com.alibaba.fastjson.JSONObject;


public class ResultUtil {

    public static String JsonResult(Object data){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",200);
        jsonObject.put("data",JSONObject.toJSON(data));
        return jsonObject.toJSONString();
    }
}
