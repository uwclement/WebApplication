

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String s=request.getParameter("t1");
		String t=request.getParameter("t2");
		String course=request.getParameter("c1");
		String sem=request.getParameter("s1");
		pw.println("<h1>Welcome:"+s+" "+t);
		pw.println("<h1>Your Course:" +course);
		
		
		
		
		
//		int number = Integer.parseInt(request.getParameter("num"));
//		int answer;
//		 StringBuilder binary = new StringBuilder();
//		if(number==0) {
//			pw.println("<h1>Binary: 0" +   "</h1>");
//		}
//		else {
//		while(number>0) {
//			int remainder = number %2;
//			binary.insert(0,remainder);
//			number /=2;
//		}
//		pw.println("<h1>Binary: " + binary.toString() + "</h1>");
//		}
//		pw.close();
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
