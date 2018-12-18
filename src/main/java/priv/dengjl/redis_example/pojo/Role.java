package priv.dengjl.redis_example.pojo;

import java.io.Serializable;

public class Role implements Serializable {
	
	private static final long serialVersionUID = 2980826930048737261L;
	
	private Long id;
    private String roleName;
    private String note;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", note=" + note + "]";
	}
	
	
}
