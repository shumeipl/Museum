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
 * @since 2022-11-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Collections对象", description="")
public class Collections implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "藏品编号")
    @TableId(value = "collection_id", type = IdType.AUTO)
    private Integer collectionId;

    @ApiModelProperty(value = "藏品类别")
    private String type;

    @ApiModelProperty(value = "有关历史")
    private String history;

    @ApiModelProperty(value = "场馆名称")
    @TableField("venue_name")
    private String venueName;

    @ApiModelProperty(value = "场馆位置")
    private String location;

    @ApiModelProperty(value = "藏品介绍")
    private String profile;

    @ApiModelProperty(value = "点击次数")
    private Integer clink;

    @ApiModelProperty(value = "藏品年代")
    private String year;

    @ApiModelProperty(value = "藏品所在馆id")
    @TableField("venue_id")
    private Integer venueId;

    @ApiModelProperty(value = "藏品图片")
    private String photo;

    @ApiModelProperty(value = "藏品名称")
    @TableField("collection_name")
    private String collectionName;


}
