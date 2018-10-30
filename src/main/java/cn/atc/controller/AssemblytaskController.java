package cn.atc.controller;

import cn.atc.pojo.*;
import cn.atc.service.AdminService;
import cn.atc.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/page")
public class AssemblytaskController {
	@Autowired
	private AssemblytaskService assemblytaskService;

	@Autowired
	private AdminService adminService;

	@RequestMapping("/assemblytask")
	public String toList() {
		return "assemblytask";
	}

	@RequestMapping("/assemblytask_list")
	@ResponseBody
	public Msg getAssemblytask(@RequestParam(value = "pn", defaultValue = "1") Integer pn, String fin) {
		try {
			// 閸︺劍鐓＄拠銏犲鐠嬪啰鏁ら敍灞肩炊閸忋儵銆夐惍浣蜂簰閸欏﹤鍨庢い鐢垫畱婢堆冪毈
			PageHelper.startPage(pn, 2);
			// 閻╁瓨甯存潻娑滎攽閺屻儴顕�
			List<Assemblytask> assemblytasks = null;
			if (fin == null) {
				assemblytasks = assemblytaskService.getAssemblytaskList();
			} else {
				assemblytasks = assemblytaskService.selectAllWithEntityById(fin);
			}
			// 閺屻儴顕楅崥搴ょ箻鐞涘苯瀵樼憗鍜冪礉楠炴湹绱堕崗銉╂付鐟曚浇绻涚紒顓熸▔缁�铏规畱妞ゅ灚鏆�
			PageInfo pageInfo = new PageInfo(assemblytasks, 1);
			return Msg.success().add("pageInfo", pageInfo);
		} catch (Exception e) {
			return Msg.fail();
		}

	}

	@RequestMapping(value = "/assemblytask_add", method = RequestMethod.POST)
	@ResponseBody
	public Msg save(Assemblytask assemblytask) {
		try {
			// 娴犲穬jax娑擃厽瀣侀崚鎵畱date娑撳搫鐡х粭锔胯閿涘矂娓堕幍瀣З鏉烆剚宕�
			String dateStr = assemblytask.getDateStr();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			assemblytask.setEstimatedTimeOfCompletion(sdf.parse(dateStr));
			assemblytaskService.saveAssemblytask(assemblytask);
		} catch (Exception e) {
			e.printStackTrace();
			return Msg.fail();
		}
		return Msg.success();
	}

	@RequestMapping(value = "/assemblytask_del/{ids}", method = RequestMethod.DELETE)
	@ResponseBody
	public Msg delete(@PathVariable("ids") String ids) {
		try {
			if (ids.contains("-")) {
				// 閹靛綊鍣洪崚鐘绘珟
				String[] strings = ids.split("-");
				for (String id : strings) {
					assemblytaskService.deleteAssemblytask(id);
				}
			} else {
				// 閸楁洑閲滈崚鐘绘珟
				assemblytaskService.deleteAssemblytask(ids);
			}
			return Msg.success();
		} catch (Exception e) {
			return Msg.fail();
		}

	}

	/**
	 * 閺囧瓨鏌婄憗鍛村帳娴犺濮熸稊锟�
	 */
	@RequestMapping(value = "/assemblytask_edit/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Msg update(Assemblytask assemblytask) {
		try {
			System.out.println(assemblytask);
			String dateStr = assemblytask.getDateStr();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			assemblytask.setEstimatedTimeOfCompletion(sdf.parse(dateStr));
			System.out.println(assemblytask);
			assemblytaskService.updateBySelective(assemblytask);
		} catch (Exception e) {
			return Msg.fail();
		}
		return Msg.success();
	}

	/**
	 * 閼惧嘲褰囬崡鏇氶嚋鐟佸懘鍘ゆ禒璇插娑旓缚淇婇幁顖ょ礉鐢箑鍙炬禒鏍х杽娴ｆ挷淇婇幁锟�
	 */
	@RequestMapping(value = "/assebmlytask1/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Msg getOne(@PathVariable("id") String id) {
		try {
			Assemblytask assemblytask = assemblytaskService.selectByIdWithEntitys(id);
			assemblytask.setDateStr(
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(assemblytask.getEstimatedTimeOfCompletion()));
			return Msg.success().add("assemblytask", assemblytask);
		} catch (Exception e) {
			return Msg.fail();
		}
	}

	/**
	 * TODO:鏉╂瑤閲滅拠閿嬬湴鎼存棁顕氶崷鈥礽nishedproductstypeController娑擃叏绱濋崠鍛service娑旂喎绨茬拠銉ф暏鐎瑰啰娈戦敍灞肩稻閺勵垰鐣犲▽陇顫︾�圭偟骞囬敍灞惧娴犮儲娈忛弮璺哄晸閸︺劏绻栭柌锟�
	 * 閼惧嘲褰囬幋鎰惂缁鐎�
	 * 
	 * @return
	 */
	@RequestMapping(value = "/finishedtypes")
	@ResponseBody
	public Msg getFinishedTypes() {
		List<FinishedProductsType> finishedTypesList = assemblytaskService.getFinishedTypesList();
		return Msg.success().add("finishedtypes", finishedTypesList);
	}

	@RequestMapping(value = "/assemblyLeaders")
	@ResponseBody
	public Msg getAssemblyLeaders() {
		List<Admin> admins = adminService.queryAll();
		return Msg.success().add("assemblyLeaders", admins);
	}

	/**
	 * TODO:鏉╂瑤閲滅拠閿嬬湴鎼存棁顕氶崷鈮抋rtformulaController娑擃叏绱濋崠鍛service娑旂喎绨茬拠銉ф暏鐎瑰啰娈戦敍灞肩稻閺勵垰鐣犲▽陇顫︾�圭偟骞囬敍灞惧娴犮儲娈忛弮璺哄晸閸︺劏绻栭柌锟�
	 * 閼惧嘲褰囬梿鏈垫闁板秵鏌熺猾璇茬��
	 * 
	 * @return
	 */
	@RequestMapping(value = "/partformulas")
	@ResponseBody
	public Msg getPartformulas() {
		List<PartFormula> partformulas = assemblytaskService.getParformulaList();
		return Msg.success().add("partformulas", partformulas);
	}
	

	@RequestMapping(value = "/AsseToPort")
	public String AsseToPort(String[] ids,Model model) {
		List<Assemblytask> list = assemblytaskService.selectAllWithEntityByids(ids);
		model.addAttribute("Asse", list);
		return "ExportExcelAsse";
	}
	
}
