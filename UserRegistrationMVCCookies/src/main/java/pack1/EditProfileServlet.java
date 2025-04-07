package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/edit")
public class EditProfileServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		Cookie arr[]=req.getCookies();
		String fname=null;
		if(arr.length==0)
		{
			req.setAttribute("msg", "Session Expired");
			req.getRequestDispatcher("Register.jsp").forward(req, res);
		}
		else
		{
			for(Cookie c:arr)
				if("c5".equals(c.getName()))
					fname=c.getName();
			req.setAttribute("fnaem", fname);
			req.getRequestDispatcher("EditProfile.jsp").forward(req, res);
		}
	}
}
