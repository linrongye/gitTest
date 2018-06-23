package cn.linry.controller;

import cn.linry.domain.Order;
import cn.linry.domain.item;
import cn.linry.service.OrdersService;
import cn.linry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TurnController {

    @Autowired
    private OrdersService service;
    @RequestMapping("itemEdit")
    public String turnitemEdit(Model model,@RequestParam(value = "id",required = false) Integer id){
        model.addAttribute("item",service.findOrdersById(id));
        return "itemEdit";
    }

    @Value("${my.pricLocation}")
    private String path;
    @RequestMapping("updateItem")
    public void updateItem(item item, MultipartFile pictureFile){
        String name="";
        String filename="";
            if(pictureFile!=null&&(name=pictureFile.getOriginalFilename())!=null&&!name.equals("")){

               filename=name.substring( name.lastIndexOf("."));
               filename=System.currentTimeMillis()+filename;
            }
            File file=new File(path+"\\"+filename);
        try {
            pictureFile.transferTo(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @RequestMapping("aa")
    @ResponseBody
    public void tr(@RequestBody  Map<String,String> map){
        Map<String,String> map1=new HashMap<String,String>();
        map1.put("1","1");
        //return map1;
    }

    @RequestMapping("itemList")
    public String turnitemList(){
        return "itemList";
    }
}
