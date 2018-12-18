package priv.dengjl.redis_example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import priv.dengjl.redis_example.dao.RoleDao;
import priv.dengjl.redis_example.pojo.Role;

public class TestMapperScanner {

	private static final Logger logger = LoggerFactory.getLogger(TestMapperScanner.class);
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybaties.xml");
		RoleDao RoleDao = context.getBean(RoleDao.class);
		Role role = RoleDao.getRole(10086L);
		
		logger.debug(role.toString());
	}


}
