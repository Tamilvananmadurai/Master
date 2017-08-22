package com.comcast.get.devops.dashboard.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import com.comcast.get.devops.dashboard.bean.DashboardStatus;

public class LoginDAO {
	DashboardStatus objDashboardStatus=new DashboardStatus();
	ArrayList<DashboardStatus> DB_sts;
	public String validateDAO(String Username)
	{
		String result;
		result="null";
		String filename="D:/CSV files/Login.csv";
		File file=new File(filename);
		try
		{
			Scanner inputStream=new Scanner(file);
		
		while(inputStream.hasNext())
		{
			String data= inputStream.next();
			System.out.println(data);
			String[] Login= data.split(",");
			System.out.println(Login[0]);
			if (Login[0].equals(Username)){
				result=Login[1];
				System.out.println("result");
			}
		 }
		
		inputStream.close();
		
		}
		catch (FileNotFoundException e ){
			e.printStackTrace();
		}
		return result;
	}
	public int LOB_Status_DAO(String ApplicationName)
	{
		String filename;
		int sts,sts_b,sts_c;
		sts=0;
		sts_b=0;
		sts_c=0;
		switch(ApplicationName)
		{
		case "WFA":
			filename="D:/CSV files/WFA.txt";
			break;
		case "TPP":
			filename="D:/CSV files/TPP.txt";
			break;
		case "NPS":
			filename="D:/CSV files/NPS.txt";
			break;
		case "EDIP":
			filename="D:/CSV files/EDIP.txt";
			break;
		case "OP":
			filename="D:/CSV files/OP.txt";
			break;
		case "CDVR":
			filename="D:/CSV files/CDVR.txt";
			break;
		case "CASPERO":
			filename="D:/CSV files/CASPERO.txt";
			break;
		case "GSO":
			filename="D:/CSV files/GSO.txt";
			break;
		case "DART":
			filename="D:/CSV files/DART.txt";
			break;
		case "NETREC":
			filename="D:/CSV files/NETREC.txt";
			break;
		case "PCAHRT":
			filename="D:/CSV files/PCAHRT.txt";
			break;
		default:
			filename="D:/CSV files/EDIP.txt";
			break;
		}
		
		File file=new File(filename);
		try
		{
			Scanner inputStream=new Scanner(file);
		
		while(inputStream.hasNext())
		{
			String data= inputStream.next();
			System.out.println(data);
			String[] Login= data.split(",");
			System.out.println(Login[1]);
			if (Login[3].equals("BAD")){
				sts_b=1;
			}
			if (Login[3].equals("CRITICAL")){
				sts_c=2;
			}
		 }
		inputStream.close();
		}
		catch (FileNotFoundException e ){
			e.printStackTrace();
		}
		
		if(sts_c==2)
		{
		sts=3;	
		}
		else if(sts_b==1)
		{
		sts=2;
		}
		else
		{
		sts=1;	
		}
		return sts;
	}

	public ArrayList<DashboardStatus> DB_Status_DAO(String App_name)
	{   String filename;
		int stsjms,stsweb,stsurl,stsdba,stsdbs,stslog,stscpu,stsdis,stsmem,stsds,stsdep,stsver,stsport,stspro;
		stsjms=0;stsweb=0;stsurl=0;stsdba=0;stsdbs=0;stslog=0;stscpu=0;stsdis=0;stsmem=0;stsds=0;stsdep=0;stsver=0;stsport=0;stspro=0;
		DB_sts=new ArrayList<DashboardStatus>();
		switch(App_name)
		{
		case "WFA":
			filename="D:/CSV files/WFA.txt";
			break;
		case "TPP":
			filename="D:/CSV files/TPP.txt";
			break;
		case "NPS":
			filename="D:/CSV files/NPS.txt";
			break;
		case "EDIP":
			filename="D:/CSV files/EDIP.txt";
			break;
		case "OP":
			filename="D:/CSV files/OP.txt";
			break;
		case "CDVR":
			filename="D:/CSV files/CDVR.txt";
			break;
		case "CASPERO":
			filename="D:/CSV files/CASPERO.txt";
			break;
		case "GSO":
			filename="D:/CSV files/GSO.txt";
			break;
		case "DART":
			filename="D:/CSV files/DART.txt";
			break;
		case "NETREC":
			filename="D:/CSV files/NETREC.txt";
			break;
		case "PCAHRT":
			filename="D:/CSV files/PCAHRT.txt";
			break;
		default:
			filename="D:/CSV files/EDIP.txt";
			break;
		}
		File file=new File(filename);
		try
		{
			Scanner inputStream=new Scanner(file);
		
		while(inputStream.hasNextLine())
		{   String Current_Date,Parameter,Status;
			String data= inputStream.nextLine();
			System.out.println(data);
			String[] Login= data.split(",");
			System.out.println(Login[1]);
			if (Login[4].equals(null))
			{
			}
			else
			{
			if (Login[3].equals("CRITICAL"))
			{stsjms=3;
			}
			if (Login[3].equals("BAD") && stsjms!=3 )
			{stsjms=2;
			}	
			if (Login[3].equals("OK") && stsjms==0)
			{stsjms=1;
			}	
			}	
			
			if (Login[9].equals("null"))
			{
			}
			else
			{
			if (Login[3].equals("CRITICAL"))
			{stsweb=3;
			}
			if (Login[3].equals("BAD") && stsweb!=3 )
			{stsweb=2;
			}	
			if (Login[3].equals("OK") && stsweb==0)
			{stsweb=1;
			}	
			}	
			
			
			if (Login[15].equals("null"))
			{
			}
			else
			{
			if (Login[3].equals("Not Accessible"))
			{stsurl=2;
			}	
			if (Login[3].equals("Accessible")&& stsurl==0)
			{stsurl=1;
			}	
			}	
			
			
			if (Login[17].equals("null"))
			{
			}
			else
			{
			if (Login[3].equals("Not Accessible"))
			{stsdba=2;
			}	
			if (Login[3].equals("Accessible")&& stsdba==0)
			{stsdba=1;
			}	
			}
			
			
			if (Login[18].equals("null"))
			{
			}
			else
			{
			if (Login[3].equals("CRITICAL"))
			{stsdbs=3;
			}
			if (Login[3].equals("BAD") && stsdbs!=3 )
			{stsdbs=2;
			}	
			if (Login[3].equals("OK") && stsdbs==0)
			{stsdbs=1;
			}	
			}	
			
			
			if (Login[19].equals("null"))
			{
			}
			else
			{
			if (Login[3].equals("CRITICAL"))
			{stslog=3;
			}
			if (Login[3].equals("BAD") && stslog!=3 )
			{stslog=2;
			}	
			if (Login[3].equals("OK") && stslog==0)
			{stslog=1;
			}	
			}	
			
			
			if (Login[22].equals("null"))
			{
			}
			else
			{
			if (Login[3].equals("CRITICAL"))
			{stscpu=3;
			}
			if (Login[3].equals("BAD") && stscpu!=3 )
			{stscpu=2;
			}	
			if (Login[3].equals("OK") && stscpu==0)
			{stscpu=1;
			}	
			}
			
			
			
			if (Login[27].equals("null"))
			{
			}
			else
			{
			if (Login[3].equals("CRITICAL"))
			{stsds=3;
			}
			if (Login[3].equals("BAD") && stsds!=3 )
			{stsds=2;
			}	
			if (Login[3].equals("OK") && stsds==0)
			{stsds=1;
			}	
			}
			
			
			
			if (Login[30].equals("null"))
			{
			}
			else
			{
			if (Login[3].equals("CRITICAL"))
			{stsdep=3;
			}
			if (Login[3].equals("BAD") && stsdep!=3 )
			{stsdep=2;
			}	
			if (Login[3].equals("OK") && stsdep==0)
			{stsdep=1;
			}	
			}
			
			
			if (Login[34].equals("null"))
			{
			}
			else
			{
			if (Login[3].equals("CRITICAL"))
			{stsver=3;
			}
			if (Login[3].equals("BAD") && stsver!=3 )
			{stsver=2;
			}	
			if (Login[3].equals("OK") && stsver==0)
			{stsver=1;
			}	
			}
			
			
			
			if (Login[35].equals("null"))
			{
			}
			else
			{
			if (Login[3].equals("CRITICAL"))
			{stsport=3;
			}
			if (Login[3].equals("BAD") && stsport!=3 )
			{stsport=2;
			}	
			if (Login[3].equals("OK") && stsport==0)
			{stsport=1;
			}	
			}
			
			
			
			if (Login[37].equals("null"))
			{
			}
			else
			{
			if (Login[3].equals("CRITICAL"))
			{stspro=3;
			}
			if (Login[3].equals("BAD") && stspro!=3 )
			{stspro=2;
			}	
			if (Login[3].equals("OK") && stspro==0)
			{stspro=1;
			}	
			}
			
			
		 }
		
		if (stsjms!=0)
		{
			DashboardStatus objDashboardStatus=new DashboardStatus();
			objDashboardStatus.setParameter("JMS_QUEUE");
			objDashboardStatus.setStatus(stsjms);
			DB_sts.add(objDashboardStatus);
		}
		if (stsweb!=0)
		{
			DashboardStatus objDashboardStatus=new DashboardStatus();
			objDashboardStatus.setParameter("WEBLOGIC_SERVER");
			objDashboardStatus.setStatus(stsweb);
			DB_sts.add(objDashboardStatus);
		}
		if (stsurl!=0)
		{
			DashboardStatus objDashboardStatus=new DashboardStatus();
			objDashboardStatus.setParameter("URL_STATUS");
			objDashboardStatus.setStatus(stsurl);
			DB_sts.add(objDashboardStatus);
		}
		if (stsdba!=0)
		{
			DashboardStatus objDashboardStatus=new DashboardStatus();
			objDashboardStatus.setParameter("DB_AVAILABILITY");
			objDashboardStatus.setStatus(stsdba);
			DB_sts.add(objDashboardStatus);
		}
		if (stsdbs!=0)
		{  
			DashboardStatus objDashboardStatus=new DashboardStatus();
			objDashboardStatus.setParameter("DB_BLOCKING_SESSION");
			objDashboardStatus.setStatus(stsdbs);
			DB_sts.add(objDashboardStatus);
		}
		if (stslog!=0)
		{
			DashboardStatus objDashboardStatus=new DashboardStatus();
			objDashboardStatus.setParameter("LOG_MONITORING");
			objDashboardStatus.setStatus(stslog);
			DB_sts.add(objDashboardStatus);
		}
		if (stscpu!=0)
		{
			DashboardStatus objDashboardStatus=new DashboardStatus();
			objDashboardStatus.setParameter("HARDWARE_STATUS");
			objDashboardStatus.setStatus(stscpu);
			DB_sts.add(objDashboardStatus);
		}
		if (stsds!=0)
		{
			DashboardStatus objDashboardStatus=new DashboardStatus();
			objDashboardStatus.setParameter("DATA_SOURCE");
			objDashboardStatus.setStatus(stsds);
			DB_sts.add(objDashboardStatus);
		}
		if (stsdep!=0)
		{
			DashboardStatus objDashboardStatus=new DashboardStatus();
			objDashboardStatus.setParameter("DEPLOYMENT_STATUS");
			objDashboardStatus.setStatus(stsdep);
			DB_sts.add(objDashboardStatus);
		}
		if (stsver!=0)
		{
			DashboardStatus objDashboardStatus=new DashboardStatus();
			objDashboardStatus.setParameter("VERSION_MONITORING");
			objDashboardStatus.setStatus(stsver);
			DB_sts.add(objDashboardStatus);
		}
		if (stsport!=0)
		{
			DashboardStatus objDashboardStatus=new DashboardStatus();
			objDashboardStatus.setParameter("PORT_MONITORING");
			objDashboardStatus.setStatus(stsport);
			DB_sts.add(objDashboardStatus);
		}
		if (stspro!=0)
		{
			DashboardStatus objDashboardStatus=new DashboardStatus();
			objDashboardStatus.setParameter("PROCESS_MONITORING");
			objDashboardStatus.setStatus(stspro);
			DB_sts.add(objDashboardStatus);
		}
		
		
		
		inputStream.close();
		}
		catch (FileNotFoundException e ){
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		return DB_sts;
	}
	
	

}
