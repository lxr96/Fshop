package test.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sise.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ProuductTest {
	@Autowired
	ProductService productService;
	@Test
	public void show() {
//		System.out.println(productService.getProductAll());
//		System.out.println(productService.listProductListVO());
//		System.out.println(productService.listProductLikeName(2, 3, null));
	}

}
