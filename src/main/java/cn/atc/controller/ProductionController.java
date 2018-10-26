package cn.atc.controller;

import cn.atc.pojo.Assembly;
import cn.atc.pojo.Employee;
import cn.atc.pojo.Msg;
import cn.atc.pojo.Production;
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
public class ProductionController {
    @Autowired
    private ProductionService productionService;

    @RequestMapping("/production")
    public String toList(){
        return "production";
    }

    @RequestMapping("/production_list")
    @ResponseBody
    public Msg getProduction(@RequestParam(value = "pn", defaultValue = "1") Integer pn){
        try {
            //在查询前调用，传入页码以及分页的大小
            PageHelper.startPage(pn, 2);
            //直接进行查询
            List<Production> productions= productionService.getProductionList();
            //查询后进行包装，并传入需要连续显示的页数
            PageInfo pageInfo=new PageInfo(productions,1);
            return Msg.success().add("pageInfo",pageInfo);
        }catch (Exception e){
            return Msg.fail();
        }
    }


    @RequestMapping(value = "/production_add",method = RequestMethod.POST)
    @ResponseBody
    public Msg save(Production production){
        try {
            //从ajax中拿到的date为字符串，需手动转换
            String dateStr=production.getDateStr();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            production.setFinishedTime(sdf.parse(dateStr));
            productionService.saveproduction(production);
        }catch (Exception e){
            e.printStackTrace();
            return Msg.fail();
        }
        return Msg.success();
    }


    @RequestMapping(value = "/production_del/{ids}",method = RequestMethod.DELETE)
    @ResponseBody
    public Msg delete(@PathVariable("ids") String ids){
        try {
            if(ids.contains("-")){
                //批量删除
                String[] strings = ids.split("-");
                for(String id:strings){
                    productionService.deleteProduction(Long.parseLong(id));
                }
            }
            else {
                //单个删除
                productionService.deleteProduction(Long.parseLong(ids));
            }
            return Msg.success();
        }catch (Exception e){
            return Msg.fail();
        }

    }


    @RequestMapping(value = "/production_edit/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Msg update(Production production) {
        try {
            System.out.println(production);
            String dateStr=production.getDateStr();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            production.setFinishedTime(sdf.parse(dateStr));
            System.out.println(production);
            productionService.updateBySelective(production);
        } catch (Exception e) {
            return Msg.fail();
        }
        return Msg.success();
    }


    @RequestMapping(value = "/production1/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getOne(@PathVariable("id") long id) {
        try {
            Production production = productionService.selectByIdWithEntitys(id);
            production.setDateStr(
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                            .format(production.getFinishedTime()
                            )
            );
            return Msg.success().add("production", production);
        } catch (Exception e) {
            return Msg.fail();
        }
    }

    @RequestMapping(value = "/productionPeople")
    @ResponseBody
    public Msg getProductionPeople(){
        List<Employee> employeeList = productionService.getProductionPeople();
        return Msg.success().add("productionPeople",employeeList);
    }


}
