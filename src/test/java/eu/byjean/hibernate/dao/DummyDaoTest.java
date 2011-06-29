package eu.byjean.hibernate.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByType;

import eu.byjean.hibernate.dao.DummyDao;

@RunWith(UnitilsJUnit4TestClassRunner.class)
@DataSet
public class DummyDaoTest{

	@SpringApplicationContext({"application-context.xml"})
    private ApplicationContext applicationContext;
	
	@SpringBeanByType
	DummyDao dao;
	
	@Test
	public void testFindDummy(){
		dao.getById(1L);
	}
}
