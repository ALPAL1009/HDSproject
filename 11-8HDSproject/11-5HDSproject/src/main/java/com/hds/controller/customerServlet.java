package com.hds.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "customerServlet", urlPatterns = "/customerServlet")
public class customerServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getParameter("Customer Records") != null)
		{

			//			Create a list
			//			select *
			//			from database
			//

			//			List<object> customerList;
			//			customerList = 	configDataBase.viewDB();

			//request.setAttribute("customerList", customerList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/customerRecords.jsp");
			rd.forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getParameter("Get Customer") != null)
		{
			System.out.println("Getting Customer");
			String cusInfo = request.getParameter("requestCusId");

//			CODE SOMETHING LIKE
//				SELECT *
//						FROM CUSTOMER (TABLE)
//				WHRERE ID = cusInfo

			request.setAttribute("requestCusId", cusInfo);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/salesReceipt.jsp");
			rd.forward(request, response);
		}

	}
}
