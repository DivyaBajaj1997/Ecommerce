package com.deloitte.ecommerce;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.deloitte.ecommerce.dao.DaoImpl;
import com.deloitte.ecommerce.entity.Customer;
import com.deloitte.ecommerce.service.Service;
import com.deloitte.ecommerce.service.ServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/second")
public class HomeServlet extends HttpServlet {

	private Service service = new ServiceImpl(new DaoImpl());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		HttpSession session = req.getSession();
		String signedOutVal = req.getParameter("signout");
		boolean sessionDestroyed = false;
		if (signedOutVal != null && signedOutVal.equals("true")) {
			session.invalidate();
			sessionDestroyed = true;
		}
		Object usernameObj = null;
		if (!sessionDestroyed) {
			usernameObj = session.getAttribute("username");
		}

		if (usernameObj == null || usernameObj.toString().isEmpty()) {
			resp.getWriter().println("you are not signed in yet\n");
			String signInLink = "<a href='/html/form.html'>Sign In </a> ";
			writer.println(signInLink);
			return;
		}
		String username = usernameObj.toString();
		Customer user = service.getUserByMobileNumber(username);
		writer.println("Welcome " + user.getName());
		String signoutLink = "<a href='/second?signout=true'>Sign out </a> ";
		writer.println(signoutLink);

	}

}
