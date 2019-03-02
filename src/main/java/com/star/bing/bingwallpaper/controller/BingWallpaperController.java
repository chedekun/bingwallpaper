package com.star.bing.bingwallpaper.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.star.bing.bingwallpaper.common.API;
import com.star.bing.bingwallpaper.common.ResultUtil;
import com.star.bing.bingwallpaper.entity.BingWallpaper;
import com.star.bing.bingwallpaper.service.BingWallpaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/bing/v1")
public class BingWallpaperController {

    @Autowired
    private BingWallpaperService bingWallpaperService;

    @ResponseBody
    @GetMapping("/")
    public String getBingWallPaperList(BingWallpaper bingWallpaper){
        Page<BingWallpaper> page = new Page<BingWallpaper>();
        page.setCurrent(bingWallpaper.getPage());
        page.setSize(bingWallpaper.getSize());

        IPage<BingWallpaper> iPage = bingWallpaperService.getBingWallPaperList(page,bingWallpaper);
        List<BingWallpaper> list = iPage.getRecords();
        List<Map<String,Object>> resultList = new ArrayList<Map<String, Object>>();
        if (!list.isEmpty() && list.get(0) != null){
            for (int i=0;i<list.size();i++){
                Map<String,Object> map = new HashMap<String, Object>();
                map.put("url", API.serviceUrl + list.get(i).getImageUrl());
                map.put("remark",list.get(i).getImageRemark());
                map.put("date",list.get(i).getImageDate());
                resultList.add(map);
            }
        }
        return ResultUtil.JsonResult(resultList);
    }
}
