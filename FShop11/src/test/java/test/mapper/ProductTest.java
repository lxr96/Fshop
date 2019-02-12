package test.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sise.dao.ProductMapper;
import com.sise.entity.ProductExample;
import com.sise.entity.ProductExample.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ProductTest {
	
	@Autowired
	ProductMapper productMapper;
	
	@Test
	public void  show() {
		ProductExample productExample = new ProductExample();
		Criteria criteria = productExample.createCriteria();
		criteria.andIdIsNotNull();
		System.out.println(productMapper.selectByExample(productExample));
	
	}

}
