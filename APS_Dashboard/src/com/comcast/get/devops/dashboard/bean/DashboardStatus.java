package com.comcast.get.devops.dashboard.bean;

public class DashboardStatus {
	private  String Parameter;
	private  int Status;
	private  String DB_Status_Time;
	public String getDB_Status_Time() {
		return DB_Status_Time;
	}
	public String getParameter() {
		return Parameter;
	}
	public void setParameter(String parameter) {
		Parameter = parameter;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public void setDB_Status_Time(String dB_Status_Time) {
		DB_Status_Time = dB_Status_Time;
	}
}
