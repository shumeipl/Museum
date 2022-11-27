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
 * @since 2022-11-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Booking对象", description="")
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "预约单号")
    @TableId(value = "booking_id", type = IdType.AUTO)
    private Integer bookingId;

    @ApiModelProperty(value = "预约时间")
    @TableField("booking_time")
    private String bookingTime;

    @ApiModelProperty(value = "预约内容")
    @TableField("exhibit_title")
    private String exhibitTitle;

    @ApiModelProperty(value = "负责区域的工作人员编号")
    @TableField("worker_id")
    private Integer workerId;

    @ApiModelProperty(value = "预约用户编号")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty(value = "审核状态")
    @TableField("audit_state")
    private String auditState;

    @ApiModelProperty(value = "审核内容")
    @TableField("audit_content")
    private String auditContent;

    @ApiModelProperty(value = "展览Id")
    @TableField("exhibit_id")
    private Integer exhibitId;

    @TableField("venue_name")
    private String venueName;


}
