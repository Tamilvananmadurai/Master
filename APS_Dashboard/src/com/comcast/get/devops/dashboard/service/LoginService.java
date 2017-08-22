package com.comcast.get.devops.dashboard.service;

import java.util.ArrayList;
import com.comcast.get.devops.dashboard.DAO.*;
import com.comcast.get.devops.dashboard.bean.DashboardStatus;

public class LoginService {
	LoginDAO objLoginDAO =new LoginDAO();
	ArrayList<DashboardStatus> DB_sts;
	public String validate(String Username,String Password)
	{
		String result ="failure";
		String Validation_pwd=objLoginDAO.validateDAO(Username);
		if(Validation_pwd.equals(Password))
		{
			result="success";
			System.out.println("Done");
		}
		System.out.println("failure");
		return result;
	}
	public int LOB_StatusService(String ApplicationName)
	{
		int sts=objLoginDAO.LOB_Status_DAO(ApplicationName);
		return sts;
	}
	public ArrayList<DashboardStatus> DB_Status_Service(String App_name)
	{
		DB_sts=new ArrayList<DashboardStatus>();
		DB_sts=objLoginDAO.DB_Status_DAO(App_name);
		return DB_sts;
	}
	
	

}
