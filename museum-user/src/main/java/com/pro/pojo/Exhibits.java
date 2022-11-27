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
@ApiModel(value="Exhibits对象", description="")
public class Exhibits implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "展览编号")
    @TableId(value = "exhibit_id", type = IdType.AUTO)
    private Integer exhibitId;

    @ApiModelProperty(value = "展览标题")
    @TableField("exhibit_title")
    private String exhibitTitle;

    @ApiModelProperty(value = "展览图片")
    private String photo;

    @ApiModelProperty(value = "展览所在馆id")
    @TableField("venue_id")
    private Integer venueId;

    @ApiModelProperty(value = "展览详情")
    private String content;

    @ApiModelProperty(value = "展览开始时间")
    @TableField("start_time")
    private String startTime;

    @ApiModelProperty(value = "参展人数")
    private Integer people;

    @ApiModelProperty(value = "结束时间")
    @TableField("end_time")
    private String endTime;

    @ApiModelProperty(value = "状态，1表示举办完成，0表示取消，-1表示延期，2表示还未开始，3表示还未结束")
    private Integer state;


}
