package cn.atc.controller;

import cn.atc.pojo.*;
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
public class AssemblyController {
    @Autowired
    private AssemblyService assemblyService;

    @RequestMapping("/assembly")
    public String toList(){
        return "assembly";
    }

    @RequestMapping("/assembly_list")
    @ResponseBody
    public Msg getAssembly(@RequestParam(value = "pn", defaultValue = "1") Integer pn,String per){
        try {
            //在查询前调用，传入页码以及分页的大小
            PageHelper.startPage(pn, 2);
            //直接进行查询
            List<Assembly> assemblys= null;
            if(per == null) {
            	assemblys= assemblyService.getAssemblyList();
            }else {
            	assemblys = assemblyService.selectAllWithAssemblyPeopleByPer(per);
            }
            //查询后进行包装，并传入需要连续显示的页数
            PageInfo pageInfo=new PageInfo(assemblys,1);
            return Msg.success().add("pageInfo",pageInfo);
        }catch (Exception e){
            return Msg.fail();
        }

    }

    @RequestMapping(value = "/assembly_add",method = RequestMethod.POST)
    @ResponseBody
    public Msg save(Assembly assembly){
        try {
            //从ajax中拿到的date为字符串，需手动转换
            String dateStr=assembly.getDateStr();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            assembly.setFinishTime(sdf.parse(dateStr));
            assemblyService.saveAssemblytask(assembly);
        }catch (Exception e){
            e.printStackTrace();
            return Msg.fail();
        }
        return Msg.success();
    }

    @RequestMapping(value = "/assembly_del/{ids}",method = RequestMethod.DELETE)
    @ResponseBody
    public Msg delete(@PathVariable("ids") String ids){
        try {
            if(ids.contains("-")){
                //批量删除
                String[] strings = ids.split("-");
                for(String id:strings){
                    assemblyService.deleteAssembly(Long.parseLong(id));
                }
            }
            else {
                //单个删除
                assemblyService.deleteAssembly(Long.parseLong(ids));
            }
            return Msg.success();
        }catch (Exception e){
            return Msg.fail();
        }

    }


    @RequestMapping(value = "/assembly_edit/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Msg update(Assembly assembly) {
        try {
            System.out.println(assembly);
            String dateStr=assembly.getDateStr();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            assembly.setFinishTime(sdf.parse(dateStr));
            System.out.println(assembly);
            assemblyService.updateBySelective(assembly);
        } catch (Exception e) {
            return Msg.fail();
        }
        return Msg.success();
    }



    @RequestMapping(value = "/assebmly1/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getOne(@PathVariable("id") long id) {
        try {
            Assembly assembly = assemblyService.selectByIdWithEntitys(id);
            assembly.setDateStr(
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                            .format(assembly.getFinishTime()
                            )
            );
            return Msg.success().add("assembly", assembly);
        } catch (Exception e) {
            return Msg.fail();
        }
    }

    @RequestMapping(value = "/assemblypeople")
    @ResponseBody
    public Msg getAssemblypeople(){
        List<Employee> employeeList = assemblyService.getAssemblypeople();
        return Msg.success().add("assemblypeople",employeeList);
    }



}
