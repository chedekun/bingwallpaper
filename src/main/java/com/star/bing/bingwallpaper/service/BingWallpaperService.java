package com.star.bing.bingwallpaper.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.star.bing.bingwallpaper.entity.BingWallpaper;

public interface BingWallpaperService extends IService<BingWallpaper> {
    IPage<BingWallpaper> getBingWallPaperList(Page<BingWallpaper> page, BingWallpaper bingWallpaper);
}
