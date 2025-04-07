package pack1;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		UserLoginDAO uLogDAO_obj= new UserLoginDAO();
		UserBean bean=uLogDAO_obj.checkLogin(req.getParameter("uname"), req.getParameter("pwd")	);
		if(bean==null)
		{
			req.setAttribute("msg", "Invalid Credentials");
			req.getRequestDispatcher("Register.jsp").forward(req, res);
		}
		else
		{
			ServletContext context=req.getServletContext();
			context.setAttribute("userbean", bean);
			Cookie ck=new Cookie("c5",bean.getfName());
			res.addCookie(ck);
			req.getRequestDispatcher("Home.jsp").forward(req, res);
			
		}
	}
	
}
