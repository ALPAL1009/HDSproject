package com.hds.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "orderServlet",urlPatterns = "/orderServlet")
public class orderServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
        if(request.getParameter("Order Records") != null)
        {

            //			Create a list
            //			select *
            //			from database
            //

            //			List<object> orderList;
            //			orderList = 	configDataBase.viewDB();

            //request.setAttribute("orderList", orderList);
            RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/orderRecords.jsp");
            rd.forward(request, response);
        }

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getParameter("Add New Order") != null)
		{
			//get the Attributes and combine them and add new Order
			//and return back to Order records with new Order added
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/orderRecords.jsp");
			rd.forward(request, response);
		}

	}
}
