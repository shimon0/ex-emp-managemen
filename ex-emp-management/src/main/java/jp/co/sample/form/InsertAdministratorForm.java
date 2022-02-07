package jp.co.sample.form;

/**
 * @author smone
 *
 */
public class InsertAdministratorForm {
	private String name;
	private String mailAddres;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailAddres() {
		return mailAddres;
	}
	public void setMailAddres(String mailAddres) {
		this.mailAddres = mailAddres;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "InsertAdministratorForm [name=" + name + ", mailAddres=" + mailAddres + ", password=" + password + "]";
	}
	
	

}
