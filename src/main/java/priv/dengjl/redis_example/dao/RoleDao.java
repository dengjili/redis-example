package priv.dengjl.redis_example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import priv.dengjl.redis_example.pojo.Role;

@Repository
public interface RoleDao {

    public Role getRole(Long id);

    public int deleteRole(Long id);

    public int insertRole(Role role);

    public int updateRole(Role role);

    public List<Role> findRoles(@Param("roleName") String roleName, @Param("note") String note);
}