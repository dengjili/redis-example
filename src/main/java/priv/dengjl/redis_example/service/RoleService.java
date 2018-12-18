package priv.dengjl.redis_example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import priv.dengjl.redis_example.dao.RoleDao;
import priv.dengjl.redis_example.pojo.Role;

@Service
public class RoleService {
	@Autowired
	private RoleDao roleDao;

	/**
	 * 1.注解的condition和unless的区别，condition对传入值生效，unless对结果result生效，使用了错误的result导致报空错误 
	 * 2.key键生成策略，不能再key中直接调用工具类的方法，将方法写在同一个类下，使用#root.target.methodName(#p0.attributeName)对属性值进行操作，最佳解决方案：使用自定义key策略，将参数转为带操作的对象，返回key 
	 * 3.属性与NULL比较时，null 写在前面 ，null eq object
	 */
	@Cacheable(value = "redisCacheManager", key = "'redis_role_'+#id", unless="null eq #result")
	public Role getRole(Long id) {
		return roleDao.getRole(id);
	}

	@CacheEvict(value = "redisCacheManager", key = "'redis_role_'+#id")
	public int deleteRole(Long id) {
		return roleDao.deleteRole(id);
	}

	// 这里为了测试返回值写法，所有写的别扭
	@CachePut(value = "redisCacheManager", key = "'redis_role_'+#result.id")
	public Role insertRole(Role role) {
		roleDao.insertRole(role);
		return role;
	}

	@CachePut(value = "redisCacheManager", key = "'redis_role_'+#role.id")
	public int updateRole(Role role) {
		return roleDao.updateRole(role);
	}

	// 不适合使用缓存
	public List<Role> listRoles(String roleName, String note) {
		return null;
	}
}
