package ua.nure.danylenko.practice12;

import java.io.IOException;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VoteServlet2
 */
@WebServlet("/VoteServlet2")
public class VoteServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	 @Override
	    public void init() throws ServletException {
		 VoteContainer footbInfo= new VoteContainer("Football", 0, new TreeSet());
		 VoteContainer biatInfo= new VoteContainer("Biathlon", 0, new TreeSet());
		 VoteContainer basketInfo= new VoteContainer("Basketball", 0, new TreeSet());
 
		 ServletContext context = getServletContext();
			ConcurrentHashMap<String,VoteContainer> map = new ConcurrentHashMap<>();
			map.put("Football", footbInfo);
			map.put("Biathlon", biatInfo);
			map.put("Basketball", basketInfo);
			context.setAttribute("playersMap",map);
	    	super.init();
	    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String var = request.getParameter("sport");
		String player = request.getParameter("player");
		ServletContext context = getServletContext();	
		
		ConcurrentHashMap<String,VoteContainer> map = (ConcurrentHashMap<String, VoteContainer>)
				context.getAttribute("playersMap");
		
		switch (var) {
		case "Football":
			int n=map.get("Football").getCount()+1;
			map.get("Football").setCount(n);
			map.get("Football").getPlayers().add(player);
		//	map.replace("Football",);
			context.setAttribute("playersMap",map);
			break;
		case "Biathlon":
			int n1=map.get("Biathlon").getCount()+1;
			map.get("Biathlon").setCount(n1);
			map.get("Biathlon").getPlayers().add(player);
			//map.replace("Biathlon", n1);
			context.setAttribute("playersMap",map);
			break;
		case "Basketball":
			int n2=map.get("Basketball").getCount()+1;
			map.get("Basketball").setCount(n2);
			map.get("Basketball").getPlayers().add(player);
			//map.replace("Basketball", n2);
			context.setAttribute("playersMap",map);
			break;
		default:
			break;
		}
		
		RequestDispatcher rd =
				request.getRequestDispatcher("Vote2.jsp");
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
