package com.common.interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.common.ActionHelper;
import com.common.exception.XssException;

/**
 * xss脚本注入处理拦截器
 */
public class XssProcessInterceptor implements HandlerInterceptor {
	public static List<String> arrTagList = new ArrayList<String>();
	static {
		  arrTagList.add("<script");  
		  arrTagList.add("<javascript");  
          arrTagList.add("<embed");  
          arrTagList.add("<style");  
          arrTagList.add("<frame");  
          arrTagList.add("<object");  
          arrTagList.add("<iframe");  
          arrTagList.add("<frameset");  
          arrTagList.add("<meta");  
          arrTagList.add("<xml");  
          arrTagList.add("<applet");  
          arrTagList.add("<link");  
          arrTagList.add("onload");  
          arrTagList.add("<img");  
          arrTagList.add("<a");  
          arrTagList.add("onmouse");  
          arrTagList.add("onblur");  
          arrTagList.add("onchange");  
          arrTagList.add("onclick");  
          arrTagList.add("ondblclick");  
          arrTagList.add("onkey");  
          arrTagList.add("onfocus");  
          arrTagList.add("onselect");  
          arrTagList.add("eval");  
          arrTagList.add("href=");  
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Map<String, Object> requestParamters = ActionHelper.getRequestParamters(request);
		for(Map.Entry<String, Object> entry :  requestParamters.entrySet()){
			if(entry.getValue()!=null && entry.getValue() instanceof String){
				cleanXSS(entry.getValue().toString());
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}
	
	private void cleanXSS(String value) throws XssException {
		System.out.println(value);
       for(String xssString : arrTagList){
    	   String lowerCaseValue = value.toLowerCase();
    	   if(lowerCaseValue.indexOf(xssString)>=0)
   			  throw new XssException("请求参数中有xss注入字符串！");
   		  
       }
    }
	
	public static void main(String[] args) {
		
		  Pattern pattern = Pattern.compile("[\\s\\S]*[j|J][a|A][v|V][a|A][s|S][c|C][r|R][i|I][p|P][t|T][\\s\\S]*");
 		  Matcher matcher = pattern.matcher("javascript是电风扇的");
 		  System.out.println(matcher.matches());
 		
	}
}