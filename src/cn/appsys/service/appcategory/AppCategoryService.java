package cn.appsys.service.appcategory;

import java.util.List;

import cn.appsys.pojo.AppCategory;

public interface AppCategoryService {

	/**
	 * 根据父id查询分类列表
	 * @param parentId
	 * @return
	 */
	List<AppCategory> getAppCategoryListByParentId(Integer parentId);

}
