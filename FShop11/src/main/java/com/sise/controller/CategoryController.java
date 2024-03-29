/**
* 模仿天猫整站ssm 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package com.sise.controller;

import com.sise.util.ImageUtil;
import com.sise.util.UploadedImageFile;
import com.sise.entity.Category;
import com.sise.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
 
@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
  
    @RequestMapping("admin_category_list")
    public ModelAndView list(Model model){
    	ModelAndView mv = new ModelAndView();
        List<Category> cs= categoryService.list();
        mv.addObject("cs", cs);
        mv.setViewName("admin/listCategory");
        return mv;
    }
    
//    @RequestMapping(value="admin_category_add",method=RequestMethod.POST)
//    public String add(Category c) {
//        categoryService.add(c);
//        System.out.println("testName"+c.getName()+c.getOrderCid());
//        return "redirect:/admin_category_list";
//    }
    @RequestMapping("admin_category_add")
    public String add(Category c, HttpSession session) throws IOException {
        categoryService.add(c);
        System.out.println(session.getServletContext().getRealPath("img/category")+c.getId()+".jpg");
        return "redirect:/admin_category_list";
    }

    @RequestMapping("admin_category_delete")
    public String delete(int id,HttpSession session) throws IOException {
        categoryService.delete(id);
        
        return "redirect:/admin_category_list";
    }

    @RequestMapping("admin_category_edit")
    public String edit(int id,Model model) throws IOException {
        Category c= categoryService.get(id);
        model.addAttribute("c", c);
        return "admin/editCategory";
    }
    @RequestMapping("admin_category_update")
    public String update(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
        categoryService.update(c);
        MultipartFile image = uploadedImageFile.getImage();
        if(null!=image &&!image.isEmpty()){
            File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
            File file = new File(imageFolder,c.getId()+".jpg");
            image.transferTo(file);
            BufferedImage img = ImageUtil.change2jpg(file);
            ImageIO.write(img, "jpg", file);
        }
        return "redirect:/admin_category_list";
    }
}
