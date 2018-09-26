package cn.atc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PartFormulaController {
	
	//跳转编写配方表页面
	@RequestMapping("/toPartForm")
	public String toPartForm() {
		
		return "partformula";
	}
}
