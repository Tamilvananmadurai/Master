package com.comcast.get.devops.dashboard.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.comcast.get.devops.dashboard.bean.DashboardStatus;
import com.comcast.get.devops.dashboard.bean.LoginBean;
import com.comcast.get.devops.dashboard.service.LoginService;

/**
 * Servlet implementation class LoginControl
 */
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginBean objLoginBean=new LoginBean();
		LoginService objLoginService=new LoginService();
		int choice=Integer.parseInt(request.getParameter("choice"));
		ArrayList<DashboardStatus> DB_sts;
		DB_sts=new ArrayList<DashboardStatus>();
		switch(choice)
		{
		case 1:
			String Username=request.getParameter("Username");
			String Password=request.getParameter("Password");
			objLoginBean.setUsername(Username);
			objLoginBean.setPassword(Password);
			String Validation=objLoginService.validate(Username,Password);
			System.out.println("failure"+Validation);
			switch(Username)
			{
			case "WFA":
				if (Validation.equals("failure"))
				{
					RequestDispatcher rd=request.getRequestDispatcher("/index.jsp?msg=null");
					rd.forward(request, response);
				}
				if (Validation.equals("success"))
				{
					RequestDispatcher rd=request.getRequestDispatcher("/index_WFA.jsp?msg=success");
					rd.forward(request, response);
				}
				break;
			case "ACTIVATION":
				if (Validation.equals("failure"))
				{
					RequestDispatcher rd=request.getRequestDispatcher("/index.jsp?msg=null");
					rd.forward(request, response);
				}
				if (Validation.equals("success"))
				{
					RequestDispatcher rd=request.getRequestDispatcher("/index_ACTIVATION.jsp?msg=success");
					rd.forward(request, response);
				}
				break;
			case "RECON":
				if (Validation.equals("failure"))
				{
					RequestDispatcher rd=request.getRequestDispatcher("/index.jsp?msg=null");
					rd.forward(request, response);
				}
				if (Validation.equals("success"))
				{
					RequestDispatcher rd=request.getRequestDispatcher("/index_RECON.jsp?msg=success");
					rd.forward(request, response);
				}
				break;
			case "PROV":
				if (Validation.equals("failure"))
				{
					RequestDispatcher rd=request.getRequestDispatcher("/index.jsp?msg=null");
					rd.forward(request, response);
				}
				if (Validation.equals("success"))
				{
					RequestDispatcher rd=request.getRequestDispatcher("/index_PROV.jsp?msg=success");
					rd.forward(request, response);
				}
				break;
			default:
				RequestDispatcher rd=request.getRequestDispatcher("/index.jsp?msg=null");
				rd.forward(request, response);
				break;
			
			}
			break;
		case 2:
		System.out.println("WFA____Control");
		String ApplicationName="WFA";
		int WFA_sts=objLoginService.LOB_StatusService(ApplicationName);
		System.out.println("WFA_STATUS"+WFA_sts);
		request.setAttribute("WFA_sts1",WFA_sts);
		RequestDispatcher rd2=request.getRequestDispatcher("/WFA_Dashboard.jsp");
		rd2.forward(request,response);
		break;
		case 3:
			System.out.println("WFA____Control");
			String ApplicationName_Prov="TPP";
			int TPP_sts=objLoginService.LOB_StatusService(ApplicationName_Prov);
			ApplicationName_Prov="NPS";
			int NPS_sts=objLoginService.LOB_StatusService(ApplicationName_Prov);
			ApplicationName_Prov="CDVR";
			int CDVR_sts=objLoginService.LOB_StatusService(ApplicationName_Prov);
			ApplicationName_Prov="OP";
			int OP_sts=objLoginService.LOB_StatusService(ApplicationName_Prov);
			ApplicationName_Prov="EDIP";
			int EDIP_sts=objLoginService.LOB_StatusService(ApplicationName_Prov);
			request.setAttribute("TPP_sts1",TPP_sts);
			request.setAttribute("NPS_sts1",NPS_sts);
			request.setAttribute("CDVR_sts1",CDVR_sts);
			request.setAttribute("OP_sts1",OP_sts);
			request.setAttribute("EDIP_sts1",EDIP_sts);
			RequestDispatcher rd3=request.getRequestDispatcher("/PROV_Dashboard.jsp");
			rd3.forward(request,response);
			break;
		case 4:
			System.out.println("WFA____Control");
			String ApplicationName_Recon="CASPERO";
			int CASPERO_sts=objLoginService.LOB_StatusService(ApplicationName_Recon);
			ApplicationName_Prov="GSO";
			int GSO_sts=objLoginService.LOB_StatusService(ApplicationName_Recon);
			ApplicationName_Prov="PCAHRT";
			int PCAHRT_sts=objLoginService.LOB_StatusService(ApplicationName_Recon);
			ApplicationName_Prov="DART";
			int DART_sts=objLoginService.LOB_StatusService(ApplicationName_Recon);
			ApplicationName_Prov="NETREC";
			int NETREC_sts=objLoginService.LOB_StatusService(ApplicationName_Recon);
			request.setAttribute("CASPERO_sts1",CASPERO_sts);
			request.setAttribute("GSO_sts1",GSO_sts);
			request.setAttribute("PCAHRT_sts1",PCAHRT_sts);
			request.setAttribute("DART_sts1",DART_sts);
			request.setAttribute("NETREC_sts1",NETREC_sts);
			RequestDispatcher rd4=request.getRequestDispatcher("/RECON_Dashboard.jsp");
			rd4.forward(request,response);
			break;
		case 5:
			
			break;
		
		case 11:
			DB_sts=objLoginService.DB_Status_Service("WFA");
			request.setAttribute("DB_sts1",DB_sts);
			RequestDispatcher rd11=request.getRequestDispatcher("/DB_WFA.jsp");
			rd11.forward(request,response);
			break;
		case 12:
			DB_sts=objLoginService.DB_Status_Service("TPP");
			request.setAttribute("DB_sts1",DB_sts);
			RequestDispatcher rd12=request.getRequestDispatcher("/DB_WFA.jsp");
			rd12.forward(request,response);
			break;
		case 13:
			DB_sts=objLoginService.DB_Status_Service("NPS");
			request.setAttribute("DB_sts1",DB_sts);
			RequestDispatcher rd13=request.getRequestDispatcher("/DB_WFA.jsp");
			rd13.forward(request,response);
			break;
		case 14:
			DB_sts=objLoginService.DB_Status_Service("EDIP");
			request.setAttribute("DB_sts1",DB_sts);
			RequestDispatcher rd14=request.getRequestDispatcher("/DB_WFA.jsp");
			rd14.forward(request,response);
			break;
		case 15:
			DB_sts=objLoginService.DB_Status_Service("CDVR");
			request.setAttribute("DB_sts1",DB_sts);
			RequestDispatcher rd15=request.getRequestDispatcher("/DB_WFA.jsp");
			rd15.forward(request,response);
			break;
		case 16:
			DB_sts=objLoginService.DB_Status_Service("OP");
			request.setAttribute("DB_sts1",DB_sts);
			RequestDispatcher rd16=request.getRequestDispatcher("/DB_WFA.jsp");
			rd16.forward(request,response);
			break;
		
	}
	// TODO Auto-generated method stub
	}
}


