package com.star.bing.bingwallpaper.timer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.star.bing.bingwallpaper.common.API;
import com.star.bing.bingwallpaper.common.TimeUtil;
import com.star.bing.bingwallpaper.entity.BingWallpaper;
import com.star.bing.bingwallpaper.service.BingWallpaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

@Component
public class Timer {

    @Autowired
    private BingWallpaperService bingWallpaperService;

    String imageName;

    @Scheduled(cron = "0 0 1 ? * *")
    public void saveBingWallpaper(){
        String imageInfo = getImageInfo();
        JSONObject imageObj = JSONObject.parseObject(imageInfo);
        JSONArray jsonArray = imageObj.getJSONArray("images");
        imageName = jsonArray.getJSONObject(0).getString("url");
        String imageRemark = jsonArray.getJSONObject(0).getString("copyright");
        String filePath = "/bing/" + TimeUtil.getNowYear() + "/" + TimeUtil.getNowMonth();
        String imageUrl = "https://cn.bing.com" + imageName;
        String[] str = imageName.split("/");
        imageName = str[str.length -1];
        boolean b = downImage(imageUrl,filePath);
        if (b){
            BingWallpaper bingWallpaper = new BingWallpaper();
            bingWallpaper.setImageDate(TimeUtil.getNow());
            bingWallpaper.setImageUrl(filePath + "/" + imageName);
            bingWallpaper.setImageRemark(imageRemark);
            bingWallpaperService.save(bingWallpaper);
        }else {
            System.err.println("缓存图片失败");
        }

    }

    public String getImageInfo (){
        StringBuffer sb = new StringBuffer();
        try {
            //建立URL
            URL url = new URL(API.bingUrl);

            //打开http
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();

            //获得输入
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            //将bufferReader的值给放到buffer里
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                sb.append(str);
            }
            //关闭bufferReader和输入流
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            //断开连接
            httpURLConnection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    boolean downImage(String imageUrl, String filePath){

        boolean b = true;
        try {
            //构造url
            URL url = new URL(imageUrl);
            //打开连接
            URLConnection connection = url.openConnection();
            //设置请求超时时间
            connection.setConnectTimeout(5 * 1000);
            //输入流
            InputStream inputStream = connection.getInputStream();
            //数据缓冲
            byte[] bytes = new byte[1024];
            //读取数据长度
            int len;
            //输出的文件流
            File file = new File("/var/ftp" + filePath);
            if (!file.exists()){
                file.mkdirs();
            }
            OutputStream outputStream = new FileOutputStream(file.getPath() + "/" + imageName);
            //开始读取
            while ((len = inputStream.read(bytes)) != -1){
                outputStream.write(bytes, 0, len);
            }
            //完毕,关闭所有链接
            outputStream.close();
            inputStream.close();

        } catch (Exception e) {
            b = false;
            e.printStackTrace();
        }
        return b;
    }
}
