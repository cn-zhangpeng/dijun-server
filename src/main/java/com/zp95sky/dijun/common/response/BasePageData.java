package com.zp95sky.dijun.common.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 分页信息
 * @author 山海紫穹
 */
@ApiModel(value = "BasePageResult 分页信息", description = "分页信息")
@Data
public class BasePageData<T> {

	@ApiModelProperty("当前页")
	private Integer page;

	@ApiModelProperty("每页条数")
	private Integer pageSize;

	@ApiModelProperty("数据总数")
	private Long total;

	@ApiModelProperty("数据总数")
	private List<T> data;

}
