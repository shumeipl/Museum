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
@ApiModel(value="Venues对象", description="")
public class Venues implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "场馆编号")
    @TableId(value = "venue_id", type = IdType.AUTO)
    private Integer venueId;

    @ApiModelProperty(value = "场馆名称")
    @TableField("venue_name")
    private String venueName;

    @ApiModelProperty(value = "场馆图片")
    private String photo;

    @ApiModelProperty(value = "场馆类型")
    private String type;

    @ApiModelProperty(value = "场馆位置")
    private String location;

    @ApiModelProperty(value = "营业时间")
    @TableField("open_time")
    private String openTime;

    @ApiModelProperty(value = "负责人编号")
    @TableField("work_id")
    private Integer workId;

    @ApiModelProperty(value = "负责人电话")
    private String phone;

    @ApiModelProperty(value = "点击次数")
    private Long clink;

    @ApiModelProperty(value = "场馆介绍")
    private String content;

    @ApiModelProperty(value = "最多人参观数")
    private Integer capacity;


}
