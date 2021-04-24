package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "olaMundoServlet", urlPatterns = {"/ola", "/oi"})
public class OlaMundoServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// html com msg Oi Mundo Servlet
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Olá Mundo Servlet</h2>");
		out.println("<h4>" + new Date() + "</h4>");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("Rodei a Servlet OlaMundo!"); // console
	
	}

}
