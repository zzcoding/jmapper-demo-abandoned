package com.demo.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.common.entity.TBaseInfo;
import com.demo.service.DemoService;
import com.jmapper.core.ServiceSupport;
import com.jmapper.core.util.PageModel;

@Service
public class DemoServiceImpl extends ServiceSupport implements DemoService {

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void save(TBaseInfo info) {
		info.setCreatTime(new Date());
		super.save(info);
	}

	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryPageList(Map<String, Object> parameterMap, PageModel pageModel) {
		parameterMap.put("tel", parameterMap.get("tel") == null ? null : "%" + parameterMap.get("tel") + "%");
		parameterMap.put("email", parameterMap.get("email") == null ? null : "%" + parameterMap.get("email") + "%");
		parameterMap.put("username", parameterMap.get("username") == null ? null : "%" + parameterMap.get("username") + "%");
		parameterMap.put("realname", parameterMap.get("realname") == null ? null : "%" + parameterMap.get("realname") + "%");
		return queryForPageListMapNamedParameterByMapper("sql.mapper.demo.queryForPageList", pageModel, parameterMap);
	}

	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryRealnameList() {
		return queryForListMapSimpleByMapper("sql.mapper.demo.queryRealnameList");
	}

	@Transactional(readOnly = true)
	public <T> T get(Class<T> classType, Object id) {
		return super.getEntity(classType, id);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void update(TBaseInfo tBaseInfo) {
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		TBaseInfo oldEnBaseInfo = get(TBaseInfo.class, tBaseInfo.getId());
		parameterMap.put("id", tBaseInfo.getId());
		generUpdateByRequirdEntity(tBaseInfo, oldEnBaseInfo, "where id=:id", parameterMap);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Long id) {
		executeUdateSimple("sql.mapper.demo.delete", id);
	}
}
