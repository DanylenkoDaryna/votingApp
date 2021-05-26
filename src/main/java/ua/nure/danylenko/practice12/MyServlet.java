package ua.nure.danylenko.practice12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int x= Integer.parseInt(request.getParameter("x"));
		int y= Integer.parseInt(request.getParameter("y"));
		String op= request.getParameter("operation");
		PrintWriter pw = response.getWriter();
        pw.println("<html><body>");
		if(op!=null) {
			switch (op) {
			case "minus":
				pw.println(x-y);
				break;
			case "plus":
				pw.println(x+y);
				break;
			case "mul":
				pw.println(x*y);
				break;
			case "div":
				pw.println(x/y);
				break;
			default:
				break;
            }

		}
		pw.println("<a href=index.html>Back</a>" +
				"</body></html>");
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
