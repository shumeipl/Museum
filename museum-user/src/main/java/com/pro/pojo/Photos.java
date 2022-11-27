package com.pro.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="Photos对象", description="")
public class Photos implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "轮播图编号")
    @TableId("photo_id")
    private Integer photoId;

    @ApiModelProperty(value = "轮播图名称")
    private String name;

    @ApiModelProperty(value = "轮播图图片")
    private String photo;


}
