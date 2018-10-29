package cn.atc.controller;

import cn.atc.pojo.*;
import cn.atc.service.AdminService;
import cn.atc.util.IDUtil;
import cn.atc.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/page")
public class ProductivetaskController {
	@Autowired
	private ProductiveTaskService productiveTaskService;

	@Autowired
	private AdminService adminService;

	@Autowired
	private ProductionPlanService productionplanService;

	@Autowired
	private PartTypeService parttypeService;

	@RequestMapping("/productivetask")
	public String toList() {
		return "productivetask";
	}

	@RequestMapping("/productivetask_list")
	@ResponseBody
	public Msg productivetask(@RequestParam(value = "pn", defaultValue = "1") Integer pn, String sid) {
		try {
			// 鍦ㄦ煡璇㈠墠璋冪敤锛屼紶鍏ラ〉鐮佷互鍙婂垎椤电殑澶у皬
			PageHelper.startPage(pn, 2);
			// 鐩存帴杩涜鏌ヨ
			List<Productivetask> productivetasks = null;
			if (sid == null) {
				productivetasks = productiveTaskService.getProductivetaskList();
			} else {
				productivetasks = productiveTaskService.selectAllWithEntityById(sid);
			}
			// 鏌ヨ鍚庤繘琛屽寘瑁咃紝骞朵紶鍏ラ渶瑕佽繛缁樉绀虹殑椤垫暟
			PageInfo pageInfo = new PageInfo(productivetasks, 1);
			return Msg.success().add("pageInfo", pageInfo);
		} catch (Exception e) {
			return Msg.fail();
		}
	}

	/**
	 * 鑾峰彇鍗曚釜鐢熶骇浠诲姟涔︿俊鎭紝甯﹀叾浠栧疄浣撲俊鎭�
	 */
	@RequestMapping(value = "/productivetask1", method = RequestMethod.GET)
	@ResponseBody
	public Msg getOne(@RequestParam(value = "id", defaultValue = "1") String id) {
		Productivetask productivetask = productiveTaskService.selectByIdWithEntitys(id);
		System.out.println(productivetask);

		productivetask.setDateStr(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(productivetask.getEstimatedTimeOfCompletion()));
		System.out.println(productivetask);
		return Msg.success().add("productivetask", productivetask);

		// try {
		// Productivetask productivetask =
		// productiveTaskService.selectByIdWithEntitys(id);
		// productivetask.setDateStr(
		// new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
		// .format(productivetask.getEstimatedTimeOfCompletion()
		// )
		// );
		// return Msg.success().add("productivetask", productivetask);
		// } catch (Exception e) {
		// return Msg.fail();
		// }
	}

	@RequestMapping(value = "/productivetask_add", method = RequestMethod.POST)
	@ResponseBody
	public Msg save(Productivetask productivetask) {
		try {
			long id = IDUtil.getId();
			productivetask.setId(((Long) id).toString());
			String dateStr = productivetask.getDateStr();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			productivetask.setEstimatedTimeOfCompletion(sdf.parse(dateStr));
			productiveTaskService.saveProductiveTask(productivetask);
			return Msg.success();
		} catch (Exception e) {
			e.printStackTrace();
			return Msg.fail();
		}

	}

	@RequestMapping(value = "/productivetask_edit/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Msg update(Productivetask productivetask) {
		try {
			String dateStr = productivetask.getDateStr();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			productivetask.setEstimatedTimeOfCompletion(sdf.parse(dateStr));
			productiveTaskService.updateBySelective(productivetask);
		} catch (Exception e) {
			e.printStackTrace();
			return Msg.fail();
		}
		return Msg.success();
	}

	@RequestMapping(value = "/productivetask_del/{ids}", method = RequestMethod.DELETE)
	@ResponseBody
	public Msg delete(@PathVariable("ids") String ids) {
		try {
			if (ids.contains("-")) {
				// 鎵归噺鍒犻櫎
				String[] strings = ids.split("-");
				for (String id : strings) {
					productiveTaskService.deleteProductiveTask(id);
				}
			} else {
				// 鍗曚釜鍒犻櫎
				productiveTaskService.deleteProductiveTask(ids);
			}
			return Msg.success();
		} catch (Exception e) {
			e.printStackTrace();
			return Msg.fail();
		}
	}

	@RequestMapping(value = "/productionplans")
	@ResponseBody
	public Msg getProductionplans() {
		List<ProductionPlan> productionplans = productionplanService.queryAll();
		return Msg.success().add("productionplans", productionplans);
	}

	@RequestMapping("/partTypes")
	@ResponseBody
	public Msg getPartTypes() {
		List<PartType> partTypes = parttypeService.queryAll();
		return Msg.success().add("partTypes", partTypes);
	}

	@RequestMapping("/productionLeaders")
	@ResponseBody
	public Msg getProductionLeaders() {
		List<Admin> admins = adminService.queryAll();
		return Msg.success().add("admins", admins);
	}

	/**
	 * 渚涘叾浠栬皟鐢�
	 * 
	 * @return
	 */
	@RequestMapping("/productiveTaskIds")
	@ResponseBody
	public Msg getAllProductiveTaskId() {
		List<String> productiveTaskIds = productiveTaskService.getAllProductiveTaskId();
		return Msg.success().add("productiveTaskIds", productiveTaskIds);
	}
}
