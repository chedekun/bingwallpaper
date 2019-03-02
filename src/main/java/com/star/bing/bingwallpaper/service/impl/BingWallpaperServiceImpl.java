package com.star.bing.bingwallpaper.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.star.bing.bingwallpaper.entity.BingWallpaper;
import com.star.bing.bingwallpaper.mapper.BingWallpaperMapper;
import com.star.bing.bingwallpaper.service.BingWallpaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BingWallpaperServiceImpl extends ServiceImpl<BingWallpaperMapper, BingWallpaper> implements BingWallpaperService {

    @Autowired
    private BingWallpaperMapper bingWallpaperMapper;

    @Override
    public IPage<BingWallpaper> getBingWallPaperList(Page<BingWallpaper> page, BingWallpaper bingWallpaper) {
        return bingWallpaperMapper.getBingWallPaperList(page,bingWallpaper);
    }
}
