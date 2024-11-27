package example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class GreetingServlet
 */
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//This method gets invoked when the servlet is requested.

		//This method is sending HTML respnse back to client.

		

		

		

		//Setting the MIMe type for HTMl Response

		//MIME => Multi-purpose Internet Mail Extension(text/html)

		

		response.setContentType("text/html");

		//Obtaining a Writer object to send the response

		PrintWriter out = response.getWriter();

		

		//Setting the response Text

		String responseText = "<h1 style = 'color:red'>Welcome to Servlets</h1>";

		

		//Sending the response

		out.println(responseText);
	}

}


