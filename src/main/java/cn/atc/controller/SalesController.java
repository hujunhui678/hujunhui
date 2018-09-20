package cn.atc.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.atc.pojo.Client;
import cn.atc.pojo.Finishedproductstype;
import cn.atc.pojo.Orderform;
import cn.atc.service.ClientService;
import cn.atc.service.FinishedproductstypeService;
import cn.atc.service.OrderformService;
import cn.atc.util.PageUtil;
@Controller
@RequestMapping("/page")
public class SalesController {
	@Autowired
		private FinishedproductstypeService finishedproductstype;
	@Autowired
		private OrderformService orderform;
	@Autowired
		private ClientService client;
	@RequestMapping("/sales")
	public String Gosales(Model model,String currentPage) {
		int temp=1;
		if(currentPage!=null && !currentPage.trim().equals("")){
			temp=Integer.parseInt(currentPage);
		}	
		List<Finishedproductstype>finishedproductstypes=finishedproductstype.getFinishedproductstype();
		List<Client>clients=client.getClient();
		PageUtil<Orderform>pageUtil=orderform.queryAll(temp,2);
		model.addAttribute("pageUtil",pageUtil);
		model.addAttribute("finishedproductstypes",finishedproductstypes);
		model.addAttribute("clients",clients);
		return "sales";
	}	

}
