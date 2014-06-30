package com.dtv.as.varnish;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try {
			int a = Integer.parseInt(req.getParameter("a"));
			int b = Integer.parseInt(req.getParameter("b"));
			
			int result = a * b;
			
			PrintWriter writer = res.getWriter();
			writer.println("Input: " + a + ", " + b);
			writer.println("Result: " + result);
			
		} catch (NumberFormatException nfe) {
			PrintWriter writer = res.getWriter();
			writer.println(nfe.toString());
		}
	}
}
