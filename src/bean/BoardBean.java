package bean;

public class BoardBean {
	private int id;
	private String name;
	private String message;
	private String mail;
	private String createday;
	private String createtime;
	private String updateday;
	private String updatetime;
	public BoardBean(int id,String name, String message, String createday, String createtime, String updateday,
			String updatetime) {//取得用インスタンス
		super();
		this.id = id;
		this.name = name;
		this.message = message;
		this.createday = createday;
		this.createtime = createtime;
		this.updateday = updateday;
		this.updatetime = updatetime;
	}
	public BoardBean(String name, String message,String mail) {//配置用インスタンス
		super();
		this.name = name;
		this.message = message;
		this.mail = mail;
	}

	public BoardBean(int id, String name, String message) {//更新用インスタンス
		super();
		this.id = id;
		this.name = name;
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCreateday() {
		return createday;
	}
	public void setCreateday(String createday) {
		this.createday = createday;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getUpdateday() {
		return updateday;
	}
	public void setUpdateday(String updateday) {
		this.updateday = updateday;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}


}
