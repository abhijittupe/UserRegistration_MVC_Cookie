package pack1;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		Cookie arr[]=req.getCookies();
		if(arr.length==0)
		{
			req.setAttribute("msg", "Session Expired");
			req.getRequestDispatcher("Register.jsp").forward(req, res);
		}
		else
		{
			ServletContext context=req.getServletContext();
			context.removeAttribute("userbean");
			arr[0].setMaxAge(0);
			res.addCookie(arr[0]);
			req.setAttribute("msg", "User Logged Out successfully");
		}
		req.getRequestDispatcher("Register.jsp").forward(req, res);
	}
}
