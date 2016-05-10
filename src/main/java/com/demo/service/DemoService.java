package com.demo.service;

import java.util.List;
import java.util.Map;

import com.common.entity.TBaseInfo;
import com.jmapper.core.util.PageModel;

public interface DemoService {
	/**
	 * 保存对象
	 * 
	 * @param user
	 */
	public void save(TBaseInfo user);

	/**
	 * 删除对象
	 * 
	 * @param id
	 */
	public void delete(Long id);

	/**
	 * 根据key获得数据库中的对象
	 * 
	 * @param classType
	 * @param id
	 * @return
	 */
	public <T> T get(Class<T> classType, Object id);

	/**
	 * 更新对象
	 * 
	 * @param tBaseInfo
	 */
	public void update(TBaseInfo tBaseInfo);

	/**
	 * 分页查询对象
	 * 
	 * @param parameterMap
	 * @param pageModel
	 * @return
	 */
	public List<Map<String, Object>> queryPageList(Map<String, Object> parameterMap, PageModel pageModel);

	/**
	 * 获取realname列表
	 * 
	 * @return
	 */
	public List<Map<String, Object>> queryRealnameList();

}
