package com.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.jmapper.core.util.PageModel;

/**
 * 
 * Function: Action辅助类. Project Name:jmapper-web File Name:ActionHelper.java
 * Package Name:com.common Date:2016年4月25日下午5:42:30 Copyright (c) 2016,
 * zinggozhao@163.com All Rights Reserved.
 * 
 * @author 赵广
 */
public class ActionHelper {
	/**
	 * 分页返回格式
	 * 
	 * @param obj
	 * @param page
	 * @return
	 */
	public static Map<String, Object> generPageResponseBody(Object obj, PageModel page) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCount", page.getRecordCount());
		map.put("items", obj);
		return map;
	}

	/**
	 * 对象转json字符串
	 */
	public static String generJsonString(Object obj) {
		String json = "";
		try {
			json = JsonUtil.toJson(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;

	}

	/**
	 * 输出json
	 * 
	 * @param obj
	 * @throws IOException
	 */

	public static void generJson(Object obj, HttpServletResponse response, Logger logger) {

		String json = "";
		try {
			json = JsonUtil.toJson(obj);
			logger.debug(json);
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().flush();
			response.getWriter().print(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取前端请求中的参数，转化为Map
	 * 
	 * @param request
	 * @return
	 */
	public static Map<String, Object> getRequestParamters(HttpServletRequest request) {
		Logger logger = Logger.getLogger(ActionHelper.class);
		@SuppressWarnings("unchecked")
		Map<String, Object[]> requestParameter = request.getParameterMap();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		for (Map.Entry<String, Object[]> map : requestParameter.entrySet()) {
			if (map.getValue().length > 1)
				parameterMap.put(map.getKey(), map.getValue());
			else
				parameterMap.put(map.getKey(), map.getValue()[0]);
		}
		logger.info(parameterMap);
		return parameterMap;

	}

	/**
	 * 异常输出
	 * 
	 * @param obj
	 * @param page
	 * @param response
	 * @param logger
	 */
	public static void generException(String msg, HttpServletResponse response, Logger logger) {
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("error", true);
		json.put("msg", msg);
		ActionHelper.generJson(json, response, logger);
	}

	public static void generSuccess(String msg, HttpServletResponse response, Logger logger) {
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("ajax", true);
		json.put("msg", msg);
		ActionHelper.generJson(json, response, logger);
	}

	/**
	 * 输出text
	 * 
	 * @param obj
	 * @throws IOException
	 */
	public static void generText(String str, HttpServletResponse response, Logger logger) {

		try {
			logger.info(str);
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print(str);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 异步返回请求
	 * 
	 * @param state
	 *            返回success/error
	 * @param error
	 *            错误信息
	 * @param response
	 * @param logger
	 * @throws IOException
	 */

	public static void response(boolean state, String msg, HttpServletResponse response, Logger logger) {
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("success", state);
		json.put("msg", msg);
		generJson(json, response, logger);
	}
	
	public static Map<String, Object> response(boolean state, String msg) {
		Map<String, Object> json = new HashMap<String, Object>();
		json.put("success", state);
		json.put("msg", msg);
		return json;
	}
}
