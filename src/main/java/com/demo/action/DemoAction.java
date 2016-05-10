package com.demo.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.ActionHelper;
import com.common.JsonUtil;
import com.common.entity.TBaseInfo;
import com.demo.service.DemoService;
import com.jmapper.core.util.PageModel;

@Controller
public class DemoAction {

	Logger logger = Logger.getLogger(DemoAction.class);

	@Autowired
	DemoService demoServiceImpl;

	@RequestMapping("/demo")
	public String demo() {
		return "demo/demoList";
	}

	@RequestMapping("/new")
	public String newdemo() {
		return "demo/demoNew";
	}

	@RequestMapping("/demo/list")
	@ResponseBody
	public Object demoList(HttpServletRequest request, PageModel pageModel) {
		//获得请求中的参数，并封装为一个Map
		Map<String, Object> requestParamters = ActionHelper.getRequestParamters(request);
		//分页查询
		List<Map<String, Object>> queryPageList = demoServiceImpl.queryPageList(requestParamters, pageModel);
		//处理分页查询返回结果并异步返回给页面端
		return ActionHelper.generPageResponseBody(queryPageList, pageModel);
	}

	//跳转编辑页面
	@RequestMapping("/demo/edit/{id}")
	public String demoEdit(@PathVariable Long id,Model model) {
		//获取数据库中待编辑的对象
		TBaseInfo tBaseInfo = demoServiceImpl.get(TBaseInfo.class, id);
		//转化对象为json字符串并放入返回的model里
		String json = JsonUtil.toJson(tBaseInfo);
		model.addAttribute("json", json);
		return "demo/demoEdit";
	}
	
	@RequestMapping("/demo/update")
	@ResponseBody
	public Object update(TBaseInfo info){
		try {
			demoServiceImpl.update(info);
			return ActionHelper.response(true, "更新成功！");
		} catch (Exception e) {
			return ActionHelper.response(false, e.getLocalizedMessage());
		}
	}
	
	@RequestMapping("/demo/delete/{id}")
	@ResponseBody
	public Object delete(@PathVariable Long id){
		try {
			demoServiceImpl.delete(id);
			return ActionHelper.response(true, "删除成功！");
		} catch (Exception e) {
			return ActionHelper.response(false, e.getLocalizedMessage());
		}
	}
	
	
	@RequestMapping("/demo/add")
	public String demoAdd() {
		return "demo/demoAdd";
	}

	@RequestMapping("/demo/realname/list")
	@ResponseBody
	public Object realnameList() {
		//获取realname字段列表并异步返回前端
		return demoServiceImpl.queryRealnameList();
	}

	@RequestMapping("/demo/save")
	@ResponseBody
	public Object save(TBaseInfo info) {
		try {
			demoServiceImpl.save(info);
			return ActionHelper.response(true, "添加成功！");
		} catch (Exception e) {
			return ActionHelper.response(false, e.getLocalizedMessage());
		}
	}

}
