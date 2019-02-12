package com.sise.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sise.entity.Category;
import com.sise.service.CategoryService;
import com.sise.service.ProductService;

@Controller
public class IndexPageController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @RequestMapping("forehome")
	public String home(Model model) {
        List<Category> cs= categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
         model.addAttribute("cs", cs);
        return "fore/home";
    }
    
    @RequestMapping("forehome1")
    public ModelAndView list(Model model){
    	ModelAndView mv = new ModelAndView();
        List<Category> cs= categoryService.list();
        mv.addObject("cs", cs);
        mv.setViewName("admin/listCategory");
        return mv;
    }

}
