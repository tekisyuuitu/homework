package dto;

public class LoginInfoDto {
	private String EmpID;		// 社員ID
	private String Department;			// 部署
	private String Name;			//名前
	private String MailAdress;			//メール
	private String PassWord;		//パスワード
	/**
	 * @return empID
	 */
	public synchronized String getEmpID() {
		return EmpID;
	}
	/**
	 * @param empID セットする empID
	 */
	public synchronized void setEmpID(String empID) {
		EmpID = empID;
	}
	/**
	 * @return department
	 */
	public synchronized String getDepartment() {
		return Department;
	}
	/**
	 * @param department セットする department
	 */
	public synchronized void setDepartment(String department) {
		Department = department;
	}
	/**
	 * @return name
	 */
	public synchronized String getName() {
		return Name;
	}
	/**
	 * @param name セットする name
	 */
	public synchronized void setName(String name) {
		Name = name;
	}
	/**
	 * @return mailAdress
	 */
	public synchronized String getMailAdress() {
		return MailAdress;
	}
	/**
	 * @param mailAdress セットする mailAdress
	 */
	public synchronized void setMailAdress(String mailAdress) {
		MailAdress = mailAdress;
	}
	/**
	 * @return passWord
	 */
	public synchronized String getPassWord() {
		return PassWord;
	}
	/**
	 * @param passWord セットする passWord
	 */
	public synchronized void setPassWord(String passWord) {
		PassWord = passWord;
	}
	@Override
	public String toString() {
		return "LoginInfoDto [EmpID=" + EmpID + ", Department=" + Department + ", Name=" + Name + ", MailAdress="
				+ MailAdress + ", PassWord=" + PassWord + "]";
	}

}
