package cn.atc.controller;

import cn.atc.pojo.*;
import cn.atc.service.AdminService;
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
public class AssemblytaskController {
    @Autowired
    private AssemblytaskService assemblytaskService;

    @Autowired
    private AdminService adminService;

    @RequestMapping("/assemblytask")
    public String toList(){
        return "assemblytask";
    }

    @RequestMapping("/assemblytask_list")
    @ResponseBody
    public Msg getAssemblytask(@RequestParam(value = "pn", defaultValue = "1") Integer pn){
        try {
            //鍦ㄦ煡璇㈠墠璋冪敤锛屼紶鍏ラ〉鐮佷互鍙婂垎椤电殑澶у皬
            PageHelper.startPage(pn, 2);
            //鐩存帴杩涜鏌ヨ
            List<Assemblytask> assemblytasks= assemblytaskService.getAssemblytaskList();
            //鏌ヨ鍚庤繘琛屽寘瑁咃紝骞朵紶鍏ラ渶瑕佽繛缁樉绀虹殑椤垫暟
            PageInfo pageInfo=new PageInfo(assemblytasks,1);
            return Msg.success().add("pageInfo",pageInfo);
        }catch (Exception e){
            return Msg.fail();
        }

    }

    @RequestMapping(value = "/assemblytask_add",method = RequestMethod.POST)
    @ResponseBody
    public Msg save(Assemblytask assemblytask){
        try {
            //浠巃jax涓嬁鍒扮殑date涓哄瓧绗︿覆锛岄渶鎵嬪姩杞崲
            String dateStr=assemblytask.getDateStr();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            assemblytask.setEstimatedTimeOfCompletion(sdf.parse(dateStr));
            assemblytaskService.saveAssemblytask(assemblytask);
        }catch (Exception e){
            e.printStackTrace();
            return Msg.fail();
        }
        return Msg.success();
    }

    @RequestMapping(value = "/assemblytask_del/{ids}",method = RequestMethod.DELETE)
    @ResponseBody
    public Msg delete(@PathVariable("ids") String ids){
        try {
            if(ids.contains("-")){
                //鎵归噺鍒犻櫎
                String[] strings = ids.split("-");
                for(String id:strings){
                    assemblytaskService.deleteAssemblytask(id);
                }
            }
            else {
                //鍗曚釜鍒犻櫎
                assemblytaskService.deleteAssemblytask(ids);
            }
            return Msg.success();
        }catch (Exception e){
            return Msg.fail();
        }

    }

    /**
     *  鏇存柊瑁呴厤浠诲姟涔�
     */
    @RequestMapping(value = "/assemblytask_edit/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Msg update(Assemblytask assemblytask) {
        try {
            System.out.println(assemblytask);
            String dateStr=assemblytask.getDateStr();
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
     * 鑾峰彇鍗曚釜瑁呴厤浠诲姟涔︿俊鎭紝甯﹀叾浠栧疄浣撲俊鎭�
     */
    @RequestMapping(value = "/assebmlytask1/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getOne(@PathVariable("id") String id) {
        try {
            Assemblytask assemblytask = assemblytaskService.selectByIdWithEntitys(id);
            assemblytask.setDateStr(
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                            .format(assemblytask.getEstimatedTimeOfCompletion()
                            )
            );
            return Msg.success().add("assemblytask", assemblytask);
        } catch (Exception e) {
            return Msg.fail();
        }
    }


    /**
     * TODO:杩欎釜璇锋眰搴旇鍦‵inishedproductstypeController涓紝鍖呮嫭service涔熷簲璇ョ敤瀹冪殑锛屼絾鏄畠娌¤瀹炵幇锛屾墍浠ユ殏鏃跺啓鍦ㄨ繖閲�
     * 鑾峰彇鎴愬搧绫诲瀷
     * @return
     */
    @RequestMapping(value = "/finishedtypes")
    @ResponseBody
    public Msg getFinishedTypes(){
        List<FinishedProductsType> finishedTypesList = assemblytaskService.getFinishedTypesList();
        return Msg.success().add("finishedtypes",finishedTypesList);
    }

    @RequestMapping(value = "/assemblyLeaders")
    @ResponseBody
    public Msg getAssemblyLeaders(){
        List<Admin> admins = adminService.queryAll();
        return Msg.success().add("assemblyLeaders",admins);
    }

    /**
     * TODO:杩欎釜璇锋眰搴旇鍦≒artformulaController涓紝鍖呮嫭service涔熷簲璇ョ敤瀹冪殑锛屼絾鏄畠娌¤瀹炵幇锛屾墍浠ユ殏鏃跺啓鍦ㄨ繖閲�
     * 鑾峰彇闆朵欢閰嶆柟绫诲瀷
     * @return
     */
    @RequestMapping(value = "/partformulas")
    @ResponseBody
    public Msg getPartformulas(){
        List<PartFormula> partformulas = assemblytaskService.getParformulaList();
        return Msg.success().add("partformulas",partformulas);
    }

}
