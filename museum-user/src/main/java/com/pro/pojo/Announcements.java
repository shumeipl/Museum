package com.pro.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xhw
 * @since 2022-11-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Announcements对象", description="")
public class Announcements implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "公告编号")
    @TableId(value = "a_id", type = IdType.AUTO)
    private Integer aId;

    @ApiModelProperty(value = "标题")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "图片")
    @TableField("photo")
    private String photo;

    @ApiModelProperty(value = "简介")
    @TableField("profile")
    private String profile;

    @ApiModelProperty(value = "内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private String createTime;


}
