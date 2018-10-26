package cn.atc.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.DoubleAdder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.atc.common.FinishedproductClient;
import cn.atc.pojo.Client;
import cn.atc.pojo.FinishedProductsType;
import cn.atc.pojo.Orderform;
import cn.atc.service.ClientService;
import cn.atc.service.FinishedProductsTypeService;
import cn.atc.service.OrderformService;
import cn.atc.util.DateConverter;
import cn.atc.util.GsonUtil;
import cn.atc.util.IDUtils;
import cn.atc.util.PageUtil;

@Controller
@RequestMapping("/page")
public class SalesController {
	@Autowired
	private FinishedProductsTypeService finishedproductstype;
	@Autowired
	private OrderformService orderform;
	@Autowired
	private ClientService client;

	@RequestMapping("/sales")
	public String Gosales(Model model, String currentPage, String state, String id) {
		int temp = 1;
		if (currentPage != null && !currentPage.trim().equals("")) {
			temp = Integer.parseInt(currentPage);
		}
		List<FinishedProductsType> finishedproductstypes = finishedproductstype.getFinishedproductstype();
		List<Client> clients = client.getClient();
		PageUtil<Orderform> pageUtil = orderform.queryAll(temp, 5, state, id);
		model.addAttribute("pageUtil", pageUtil);
		model.addAttribute("finishedproductstypes", finishedproductstypes);
		model.addAttribute("clients", clients);
		model.addAttribute("id", id);
		model.addAttribute("state", state);
		return "sales";
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String delete(Long[] ids) {
		if (orderform.delete(ids) > 0) {
			return "ok";
		}
		return "no";
	}

	@RequestMapping("/doaddSales")
	@ResponseBody
	public String doadd(Model model, Orderform orderforms, @RequestParam(defaultValue = "0") int finishedType,
			@RequestParam(defaultValue = "1") int clientId) {
		List<FinishedProductsType> finishedproductstypes = finishedproductstype.getFinishedproductstype();
		List<Client> clients = client.getClient();
		model.addAttribute("finishedproductstypes", finishedproductstypes);
		model.addAttribute("clients", clients);
		model.addAttribute("finishedType", finishedType);
		model.addAttribute("clientId", clientId);
		IDUtils idUtils = new IDUtils();
		FinishedproductClient finishedproductClient = new FinishedproductClient(idUtils.genItemId(),
				finishedproductstypes, clients);
		return GsonUtil.GsonString(finishedproductClient);
	}

	@RequestMapping("/addSales")
	@ResponseBody
	public String add(Model model, Orderform orderforms) {
		orderforms.setOrderDate(new Date());
		int add = orderform.add(orderforms);
		if (add > 0) {
			return "true";
		} else {
			return "false";
		}
	}

	@RequestMapping("/doupdateSales")
	public String doupdate(Model model, String id) {
		Orderform order = orderform.queryId(id);
		List<Orderform> orderforms = orderform.getquery();
		model.addAttribute("order", order);
		model.addAttribute("orderforms", orderforms);
		model.addAttribute("id", id);
		return "sales_modify";
	}

	@RequestMapping("/updateSales")
	@ResponseBody
	public String update(Orderform orderforms) {
		if (orderform.update(orderforms) > 0) {
			return "true";
		}
		return "false";
	}

}
