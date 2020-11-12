package com.hds.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "inventoryServlet", urlPatterns = "/inventoryServlet")
public class inventoryServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getParameter("Inventory") != null)
		{

			//			Create a list
			//			select *
			//			from database
			//

			//			List<object> productList;
			//			productList = 	configDataBase.viewDB();

			//request.setAttribute("productList", productList);
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/inventory.jsp");
			rd.forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if(request.getParameter("Add New Product") != null)
		{
			//get the Attributes and combine them and add new product
			//and return back to product records with new product added
			RequestDispatcher rd = request.getRequestDispatcher("/employeeSection/inventory.jsp");
			rd.forward(request, response);
		}

	}
}
