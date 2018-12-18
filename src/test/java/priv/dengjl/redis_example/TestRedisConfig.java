package priv.dengjl.redis_example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class TestRedisConfig {

	private static final Logger logger = LoggerFactory.getLogger(TestRedisConfig.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("redis-config.xml");
		RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);
		ValueOperations opsForValue = redisTemplate.opsForValue();
		
		// 1.设置值
		opsForValue.set("name", "张三");
		// 2.获取值
		String name = (String) opsForValue.get("name");
		logger.debug("从redis中获取name值：{}", name);
	}

}
