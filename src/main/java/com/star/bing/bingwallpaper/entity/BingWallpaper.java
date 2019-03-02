package com.star.bing.bingwallpaper.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

@Data
@TableName("bing_wallpaper")
public class BingWallpaper extends Model<BingWallpaper> {

    /**
     * 主键
     */
    @TableId(value = "kid", type = IdType.UUID)
    private String kid;

    /**
     * 链接
     */
    @TableField(value = "image_url")
    private String imageUrl;

    /**
     * 说明
     */
    @TableField(value = "image_remark")
    private String imageRemark;

    /**
     * 日期
     */
    @TableField(value = "image_date")
    private String imageDate;

    /**
     * 点赞
     */
    @TableField(value = "image_like")
    private int imageLike;

    /**
     * 下载
     */
    @TableField(value = "image_down")
    private int imageDown;

    /**
     * 起始页
     */
    @TableField(exist = false)
    private int page;

    /**
     * 每页条数
     */
    @TableField(exist = false)
    private int size;
}
