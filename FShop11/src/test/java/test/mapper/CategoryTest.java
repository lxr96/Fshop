package test.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sise.dao.CategoryMapper;
import com.sise.entity.CategoryExample;
import com.sise.entity.CategoryExample.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class CategoryTest {
	@Autowired
	CategoryMapper categoryMapper;
	
	@Test
	public void show() {
		CategoryExample categoryExample = new CategoryExample();
		Criteria criteria = categoryExample.createCriteria();
		criteria.andIdIsNotNull();
		System.out.println(categoryMapper.selectByExample(categoryExample));
	}

}
