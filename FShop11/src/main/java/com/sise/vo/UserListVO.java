package com.sise.vo;

public class UserListVO {
	private Integer id;

    private String uId;

    private String status;

    private String kind;

    private String createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "UserListVO [id=" + id + ", uId=" + uId + ", status=" + status + ", kind=" + kind + ", createTime="
				+ createTime + "]";
	}
    
}
