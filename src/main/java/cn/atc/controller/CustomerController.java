package cn.atc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.atc.pojo.Client;
import cn.atc.service.ClientService;

@Controller
@RequestMapping("/page")
public class CustomerController {
	@Autowired
	private ClientService client;
	@RequestMapping("/customer")
	public String Gocustomer(Model model) {
		List<Client>clients=client.getClient();
		model.addAttribute("clients", clients);
		return "customer";
	}
}
