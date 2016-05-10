package com.base;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainAction {

	@RequestMapping("/top")
	public String top() {
		return "common/top";
	}

	@RequestMapping("/left")
	public String left() {
		return "common/left";
	}

	@RequestMapping("/index")
	public String index() {
		return "common/index";
	}

}
