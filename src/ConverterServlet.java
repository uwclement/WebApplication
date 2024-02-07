

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConverterServlet
 */
@WebServlet("/ConverterServlet")
public class ConverterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConverterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
	           Integer number = Integer.parseInt(request.getParameter("number"));
	           String myBtn = request.getParameter("btn");
	           String convertedNumber;
	           String description;
	           request.setAttribute("numberToConvert","Number "+ number);
	           if(request.getParameter("number") ==""){
	               request.setAttribute("requiredNumber","Warning: Number to be converted required!");
	           }
	           else {
	               if(myBtn.equals("binary")){
	                   StringBuilder binaryStringBuilder = new StringBuilder();
	                   while (number > 0) {
	                       int remainder = number % 2;
	                       binaryStringBuilder.insert(0, remainder);
	                       number = number / 2;
	                   }
	                   convertedNumber = binaryStringBuilder.toString();
	                   description="Decimal number converted to binary";
	               }
	                   else if (myBtn.equals("hexa")) {
	                	    StringBuilder hexStringBuilder = new StringBuilder();
	                	    while (number > 0) {
	                	        int remainder = number % 16;
	                	        char hexDigit = (char) (remainder < 10 ? remainder + '0' : remainder + 'A' - 10);
	                	        hexStringBuilder.insert(0, hexDigit);
	                	        number = number / 16;
	                	    }
	                	    convertedNumber = hexStringBuilder.toString();
	                	    description = "Decimal number converted to Hexadecimal";
	                	}
	                   else if(myBtn.equals("octal")) {
	                   StringBuilder octalStringBuilder = new StringBuilder();
	                   while (number > 0) {
	                       int remainder = number % 8;
	                       octalStringBuilder.insert(0, remainder);
	                       number = number / 8;
	                   }
	                   convertedNumber = octalStringBuilder.toString();
	                   description="Decimal number converted to Octal";
	               }
	               else {
	                   convertedNumber=number.toString();
	                   description="Decimal number not converted";
	               }
	               request.setAttribute("convertedNumber","Result "+convertedNumber);
	               request.setAttribute("description",description);
	           }

	       } catch (Exception ex){
	           ex.printStackTrace();
	           request.setAttribute("error","An expected error occurred!!");
	       }
	        RequestDispatcher dispatch = request.getRequestDispatcher("converter.html");
	        try {
	            dispatch.forward(request, response);
	        } catch (ServletException e) {
	            throw new RuntimeException(e);
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        
	    }
	        doGet(request, response);
}
		
	

}
