package cn.atc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PartFormulaController {
	
	//��ת��д�䷽��ҳ��
	@RequestMapping("/toPartForm")
	public String toPartForm() {
		
		return "partformula";
	}
}
