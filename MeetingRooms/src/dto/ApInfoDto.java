package dto;

import java.util.Date;

public class ApInfoDto {
	private String ApTime1;		// 部署
	private String ApTime2;			// 時間割
	private String ApTime3;			// 時間割
	private String ApTime4;			// 時間割
	private String ApTime5;			// 時間割
	private String ApTime6;			// 時間割
	private String EmpID;			//予約者ID
	private Date UpdateTime;		//更新時間
	/**
	 * @return apTime1
	 */
	public synchronized String getApTime1() {
		return ApTime1;
	}
	/**
	 * @param apTime1 セットする apTime1
	 */
	public synchronized void setApTime1(String apTime1) {
		ApTime1 = apTime1;
	}
	/**
	 * @return apTime2
	 */
	public synchronized String getApTime2() {
		return ApTime2;
	}
	/**
	 * @param apTime2 セットする apTime2
	 */
	public synchronized void setApTime2(String apTime2) {
		ApTime2 = apTime2;
	}
	/**
	 * @return apTime3
	 */
	public synchronized String getApTime3() {
		return ApTime3;
	}
	/**
	 * @param apTime3 セットする apTime3
	 */
	public synchronized void setApTime3(String apTime3) {
		ApTime3 = apTime3;
	}
	/**
	 * @return apTime4
	 */
	public synchronized String getApTime4() {
		return ApTime4;
	}
	/**
	 * @param apTime4 セットする apTime4
	 */
	public synchronized void setApTime4(String apTime4) {
		ApTime4 = apTime4;
	}
	/**
	 * @return apTime5
	 */
	public synchronized String getApTime5() {
		return ApTime5;
	}
	/**
	 * @param apTime5 セットする apTime5
	 */
	public synchronized void setApTime5(String apTime5) {
		ApTime5 = apTime5;
	}
	/**
	 * @return apTime6
	 */
	public synchronized String getApTime6() {
		return ApTime6;
	}
	/**
	 * @param apTime6 セットする apTime6
	 */
	public synchronized void setApTime6(String apTime6) {
		ApTime6 = apTime6;
	}
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
	 * @return updateTime
	 */
	public synchronized Date getUpdateTime() {
		return UpdateTime;
	}
	/**
	 * @param updateTime セットする updateTime
	 */
	public synchronized void setUpdateTime(Date updateTime) {
		UpdateTime = updateTime;
	}
	@Override
	public String toString() {
		return "ApInfoDto [ApTime1=" + ApTime1 + ", ApTime2=" + ApTime2 + ", ApTime3=" + ApTime3 + ", ApTime4="
				+ ApTime4 + ", ApTime5=" + ApTime5 + ", ApTime6=" + ApTime6 + ", EmpID=" + EmpID + ", UpdateTime="
				+ UpdateTime + "]";
	}

}
