package priv.dengjl.redis_example;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import priv.dengjl.redis_example.pojo.Role;
import priv.dengjl.redis_example.service.RoleService;

public class TestCache {

	private static final Logger logger = LoggerFactory.getLogger(TestCache.class);

	public static void main(String[] args) {
		String type = "3";
		switch (type) {
		case "1":
			testQuery();
			break;
		case "2":
			testInsert();
			break;
		case "3":
			testDelete();
			break;
		default:
			break;
		}
	}

	private static void testDelete() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybaties.xml");
		RoleService service = applicationContext.getBean(RoleService.class);
		int deleteRole = service.deleteRole(3280L);
		logger.debug("返回值：{}", deleteRole);
	}

	private static void testInsert() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybaties.xml");
		RoleService service = applicationContext.getBean(RoleService.class);
		Role role = new Role();
		long randomNum = (long) new Random().nextInt(10000);
		role.setId(randomNum);
		role.setRoleName("abc" + randomNum);
		role.setNote("note " + randomNum);
		Role insertRole = service.insertRole(role);
		logger.debug("返回值：{}", insertRole);
	}

	private static void testQuery() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybaties.xml");
		logger.debug("第一次查询：{}", applicationContext);
		RoleService service = applicationContext.getBean(RoleService.class);
		Role role = service.getRole(10086L);
		logger.debug("第一次查询：{}", role);
		role = service.getRole(3282L);
		logger.debug("第2次查询：{}", role);
	}

}
