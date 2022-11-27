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
 * @since 2022-11-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Likes对象", description="")
public class Likes implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "收藏编号")
    @TableId(value = "like_id", type = IdType.AUTO)
    private Integer likeId;

    @ApiModelProperty(value = "收藏展品编号")
    @TableField("collection_id")
    private Integer collectionId;

    @ApiModelProperty(value = "收藏时间")
    @TableField("collection_time")
    private String collectionTime;

    @ApiModelProperty(value = "用户编号")
    @TableField("user_id")
    private Integer userId;


}
