package com.star.bing.bingwallpaper.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.star.bing.bingwallpaper.entity.BingWallpaper;

public interface BingWallpaperMapper extends BaseMapper<BingWallpaper> {

    IPage<BingWallpaper> getBingWallPaperList(Page<BingWallpaper> page, BingWallpaper bingWallpaper);
}
