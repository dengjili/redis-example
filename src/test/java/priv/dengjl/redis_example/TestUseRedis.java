package priv.dengjl.redis_example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import priv.dengjl.redis_example.service.RedisTemplateService;

public class TestUseRedis {

	private static final Logger logger = LoggerFactory.getLogger(TestUseRedis.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybaties.xml");
		RedisTemplateService redisTemplate = applicationContext.getBean(RedisTemplateService.class);
		
		redisTemplate.execMultCommand();
		redisTemplate.execMultCommand();
		redisTemplate.execPipeLine();
	}

}
