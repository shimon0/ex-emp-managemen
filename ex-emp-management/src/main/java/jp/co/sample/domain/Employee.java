package jp.co.sample.domain;

import java.util.Date;

public class Employee {

	//*ID*/
	private Integer id;
	
	//*蜷榊燕*/
	private String name;
	
	//*逕ｻ蜒�*/
	private String image;
	
	//*諤ｧ蛻･*/
	private String gender;
	
	//*蜈･遉ｾ譌･*/
	private java.util.Date hireDate;
	
	//*繝｡繝ｼ繝ｫ繧｢繝峨Ξ繧ｹ*/
	private String mailAddress;
	
	//*驛ｵ萓ｿ逡ｪ蜿ｷ*/
	private String zipCode;
	
	//*菴乗園*/
	private String address;
	
	//*髮ｻ隧ｱ逡ｪ蜿ｷ*/
	private String telephone;
	
	//*邨ｦ譁�*/
	private Integer salary;
	
	//*迚ｹ諤ｧ*/
	private String characteristics;
	
	//*謇ｶ鬢贋ｺｺ謨ｰ*/
	private Integer dependentsCount;

	
	public Employee(){}



	public Employee(Integer id, String name, String image, String gender, Date hireDate, String mailAddress,
			String zipCode, String address, String telephone, Integer salary, String characteristics,
			Integer dependentsCount) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.gender = gender;
		this.hireDate = hireDate;
		this.mailAddress = mailAddress;
		this.zipCode = zipCode;
		this.address = address;
		this.telephone = telephone;
		this.salary = salary;
		this.characteristics = characteristics;
		this.dependentsCount = dependentsCount;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public java.util.Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(java.util.Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}

	public Integer getDependentsCount() {
		return dependentsCount;
	}

	public void setDependentsCount(Integer dependentsCount) {
		this.dependentsCount = dependentsCount;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", image=" + image + ", gender=" + gender + ", hireDate="
				+ hireDate + ", mailAddress=" + mailAddress + ", zipCode=" + zipCode + ", address=" + address
				+ ", telephone=" + telephone + ", salary=" + salary + ", characteristics=" + characteristics
				+ ", dependentsCount=" + dependentsCount + "]";
	}
	
	

	

}





