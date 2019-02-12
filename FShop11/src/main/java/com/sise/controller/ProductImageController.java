/**
* 模仿天猫整站ssm 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package com.sise.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sise.entity.Category;
import com.sise.entity.Product;
import com.sise.entity.ProductImage;
import com.sise.service.CategoryService;
import com.sise.service.ProductImageService;
import com.sise.service.ProductService;
import com.sise.util.ImageUtil;
import com.sise.util.UploadedImageFile;




@Controller
@RequestMapping("")
public class ProductImageController {
    @Autowired
    ProductService productService;

    @Autowired
    ProductImageService productImageService;
    
    @Autowired
    CategoryService categoryService;


    @RequestMapping("admin_productImage_add")
    public String add(ProductImage  pi, HttpSession session, MultipartFile uploadedImageFile) {
        
        String fileName =  UUID.randomUUID().toString().replaceAll("-", "")+ ".jpg";
        String imageFolder;
        String imageFolder_small=null;
        String imageFolder_middle=null;
        if(ProductImageService.type_single.equals(pi.getType())){
            imageFolder= session.getServletContext().getRealPath("img/productSingle");
            imageFolder_small= session.getServletContext().getRealPath("img/productSingle_small");
            imageFolder_middle= session.getServletContext().getRealPath("img/productSingle_middle");
        }
        else{
            imageFolder= session.getServletContext().getRealPath("img/productDetail");
        }

        File f = new File(imageFolder, fileName);
        f.getParentFile().mkdirs();
        try {
            uploadedImageFile.transferTo(f);
            BufferedImage img = ImageUtil.change2jpg(f);
            ImageIO.write(img, "jpg", f);

            if(ProductImageService.type_single.equals(pi.getType())) {
                File f_small = new File(imageFolder_small, fileName);
                File f_middle = new File(imageFolder_middle, fileName);

                ImageUtil.resizeImage(f, 56, 56, f_small);
                ImageUtil.resizeImage(f, 217, 190, f_middle);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        String url = imageFolder+"\\"+fileName;
        System.out.println(url);
        pi.setUrl(fileName);
        productImageService.add(pi);
        
        return "redirect:admin_productImage_list?pid="+pi.getPid();
    }

    @RequestMapping("admin_productImage_delete")
    public String delete(int id,HttpSession session) {
        ProductImage pi = productImageService.get(id);

        String fileName = pi.getId()+ ".jpg";
        String imageFolder;
        String imageFolder_small=null;
        String imageFolder_middle=null;

        if(ProductImageService.type_single.equals(pi.getType())){
            imageFolder= session.getServletContext().getRealPath("img/productSingle");
            imageFolder_small= session.getServletContext().getRealPath("img/productSingle_small");
            imageFolder_middle= session.getServletContext().getRealPath("img/productSingle_middle");
            File imageFile = new File(imageFolder,fileName);
            File f_small = new File(imageFolder_small,fileName);
            File f_middle = new File(imageFolder_middle,fileName);
            imageFile.delete();
            f_small.delete();
            f_middle.delete();

        }
        else{
            imageFolder= session.getServletContext().getRealPath("img/productDetail");
            File imageFile = new File(imageFolder,fileName);
            imageFile.delete();
        }


        productImageService.delete(id);


        return "redirect:admin_productImage_list?pid="+pi.getPid();
    }

    @RequestMapping("admin_productImage_list")
    public String list(int pid, Model model) {
        Product p =productService.get(pid);
        Category c=categoryService.get(p.getCid());
        List<ProductImage> pisSingle = productImageService.list(pid, ProductImageService.type_single);
        List<ProductImage> pisDetail = productImageService.list(pid, ProductImageService.type_detail);


        model.addAttribute("p", p);
        model.addAttribute("c", c);
        model.addAttribute("pisSingle", pisSingle);
        model.addAttribute("pisDetail", pisDetail);

        return "admin/listProductImage";
    }
    
    @RequestMapping("admin_productImage_save")
    public String addTest(HttpSession session, MultipartFile pictureFile) throws IllegalStateException, IOException {
    	
    	//使用UUID给图片重命名，并去掉四个“-”
    			String name = "1";
    			//获取文件的扩展名
    			String ext = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
    			//设置图片上传路径
    			String url = session.getServletContext().getRealPath("img/productDetail");
    			System.out.println(url+"/"+name + "." + ext);
    			//以绝对路径保存重名命后的图片
    			pictureFile.transferTo(new File(url+"/"+name + "." + ext));
    			//把图片存储路径保存到数据库
    
 
    	
//        System.out.println("success"+session.getServletContext().getRealPath("img/productDetail"));
//        System.out.println(uploadedImageFile.getOriginalFilename());
//        String fileName = "1"+ ".jpg";
//        String imageFolder;
//
//        imageFolder= session.getServletContext().getRealPath("img/productDetail");
//
//        File f = new File(imageFolder, fileName);
//        f.getParentFile().mkdirs();
//        try {
//            uploadedImageFile.transferTo(f);
//            BufferedImage img = ImageUtil.change2jpg(f);
//            ImageIO.write(img, "jpg", f);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return "redirect:admin_productImage_file";
    }
    @RequestMapping("admin_productImage_file")
    public String urlgo() {
    	return "admin/addProductImage";
    }
}

/**
* 模仿天猫整站ssm 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	
