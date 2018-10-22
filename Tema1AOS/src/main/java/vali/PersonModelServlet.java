package vali;

import java.io.*;

import javax.servlet.*;

import javax.servlet.http.*;

public class PersonModelServlet extends HttpServlet {

	private static final long serialVersionUID = 3879549936840760632L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		PersonModel personTest = new PersonModel();
		personTest.setName(name);
		personTest.setEmail(email);
		PersonDatabaseAccess personTestDatabaseAccess = new PersonDatabaseAccess("personaos");
		personTest = personTestDatabaseAccess.createOrUpdate(personTest);
		//check in front-end if user is added
		response.getWriter().write("<html>" + "<body>" + "Id: " + personTest.getId() + "</body>" + "</html>");
		response.getWriter().flush();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
