package com.zp95sky.dijun.common.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * 分页信息
 * @author 山海紫穹
 */
@ApiModel(value = "BasePageData", description = "分页查询的数据结构")
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

	public static <T> BasePageData<T> buildEmptyData() {
		return buildEmptyData(0, 0, 0L);
	}

	public static <T> BasePageData<T> buildEmptyData(Integer page, Integer pageSize, Long total) {
		return buildData(page, pageSize, total, Collections.emptyList());
	}

	public static <T> BasePageData<T> buildData(Integer page, Integer pageSize, Long total, List<T> data) {
		BasePageData<T> result = new BasePageData<>();
		result.setPage(page);
		result.setPageSize(pageSize);
		result.setTotal(total);
		result.setData(data);
		return result;
	}

}
