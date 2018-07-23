package com.revature.servlet;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.MainDriver;

@WebServlet("/count")
public class CounterServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		MainDriver md = new MainDriver();
		Scanner scan = new Scanner(new InputStreamReader(req.getInputStream()));
		String json = "";
		if(scan != null) {
			json = scan.nextLine();
		}
		ObjectMapper mapper = new ObjectMapper();
		int countAdd = mapper.readValue(json, int.class);
		md.counter(countAdd);
		PrintWriter pw = res.getWriter();
		res.setContentType("application/json");
		String userJSON = mapper.writeValueAsString(countAdd);
		pw.write(userJSON);
		scan.close();
	}
}
