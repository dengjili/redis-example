package priv.dengjl.redis_example.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisTemplateService {

	private static final Logger logger = LoggerFactory.getLogger(RedisTemplateService.class);

	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * SessionCallback 发送多个命令
	 */
	public void execMultCommand() {
		Object obj = redisTemplate.execute((RedisOperations operations) -> {
			operations.boundValueOps("key1").set("value1");
			operations.boundHashOps("hash").put("hash-key-1", "hash-value-1");
			return operations.boundValueOps("key1").get();
		});
		logger.debug("返回值为：{}", obj);
	}

	/**
	 * SessionCallback 事务
	 */
	public void execTransaction() {
		List obj = (List) redisTemplate.execute((RedisOperations operations) -> {
			// 监控
			operations.watch("key1");
			// 开启事务
			operations.multi();
			operations.boundValueOps("key1").set("value1");
			operations.boundHashOps("hash").put("hash-key-1", "hash-value-1");
			operations.opsForValue().get("key1");

			// 提交
			List exec = operations.exec();

			return exec;
		});
		logger.debug("返回值为：{}", obj);
	}
	
	/**
	 * SessionCallback 流水线
	 */
	public void execPipeLine() {
		List obj = (List) redisTemplate.executePipelined((RedisOperations operations) -> {
			operations.boundValueOps("key1").set("value1");
			operations.boundHashOps("hash").put("hash-key-1", "hash-value-1");
			operations.boundValueOps("key1").get();
			return null;
		});
		logger.debug("返回值为：{}", obj);
	}

}
