package cn.atc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.atc.pojo.Client;
import cn.atc.pojo.FinishedProductsType;
import cn.atc.pojo.Orderform;
import cn.atc.service.ClientService;
import cn.atc.util.GsonUtil;
import cn.atc.util.PageUtil;

@Controller
@RequestMapping("/page")
public class CustomerController {
	@Autowired
	private ClientService client;
@RequestMapping("/customer")
	public String Gocustomer(Model model,String currentPage, String clientCompany) {
	int temp=1;
	if(currentPage!=null && !currentPage.trim().equals("")){
		temp=Integer.parseInt(currentPage);
	}	
	PageUtil<Client>pageUtil=client.queryAll(temp,5,clientCompany);
		model.addAttribute("pageUtil",pageUtil);
		List<Client>clients=client.getClient();
		model.addAttribute("clientCompany", clientCompany);
		model.addAttribute("clients", clients);
		return "customer";
	}
		
	
	@RequestMapping("/addCustomer")
	@ResponseBody
	public String add(Model model,Client clients){
		int add = client.add(clients);
		if(add>0){
			return "true";
		}else {
			return "false";
		}			
	}
	@RequestMapping("/deleteCustomer")
	@ResponseBody
	public String delete(int[] ids) {
		if(client.delete(ids)>0) {
			return "ok";
		}
		return "no";
	}
	@RequestMapping("/doupdateCustomer")
	@ResponseBody
	public String doupdate(Model model,int id) {
			Client clients=client.queryId(id);
			model.addAttribute("clients", clients);
			model.addAttribute("id", id);
			String json = GsonUtil.GsonString(clients);
		return json;
	}	
	@RequestMapping("/updateCustomer")
	@ResponseBody
	public String update(Model model,Client clients) {
		
				if(client.update(clients)>0) {
					return "true";
				}
		return "false";
	}
}
