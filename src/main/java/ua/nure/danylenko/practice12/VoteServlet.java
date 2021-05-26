package ua.nure.danylenko.practice12;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VoteServlet
 */
public class VoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
    	ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<>();
		map.put("Football", 1);
		map.put("Biathlon", 1);
		map.put("Basketball", 1);
		ServletContext context = getServletContext();
		context.setAttribute("voteMap",map);
    	super.init();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String var = request.getParameter("sport");
		ServletContext context = getServletContext();	
		
		ConcurrentHashMap<String,Integer> map = (ConcurrentHashMap<String, Integer>)
				context.getAttribute("voteMap");
		
		switch (var) {
		case "Football":
			int n=map.get("Football")+1;
			map.replace("Football", n);
			context.setAttribute("voteMap",map);
			break;
		case "Biathlon":
			int n1=map.get("Biathlon")+1;
			map.replace("Biathlon", n1);
			context.setAttribute("voteMap",map);
			break;
		case "Basketball":
			int n2=map.get("Basketball")+1;
			map.replace("Basketball", n2);
			context.setAttribute("voteMap",map);
			break;
		default:
			break;
		}
		
		RequestDispatcher rd =
				request.getRequestDispatcher("Vote.jsp");
			rd.forward(request, response);
				
				// (2) generate a result
				// (3) save a result as an attribute in container
				// (4) go to view layer

		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
