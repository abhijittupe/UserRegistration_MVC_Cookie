package pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class UserRegistrationServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserBean ub=new UserBean();
		ub.setUserName(req.getParameter("uname"));
		ub.setPassword(req.getParameter("pwd"));
		ub.setfName(req.getParameter("fname"));
		ub.setlName(req.getParameter("lname"));
		ub.setMailId(req.getParameter("mail"));
		ub.setPhoneNo(Integer.parseInt(req.getParameter("phone")));
		
		UserRegisterDAO obj=new UserRegisterDAO();
		int rowCount=obj.insertUser(ub);
		
		if(rowCount>0)
		{
			req.setAttribute("msg", "User registered Successfully");
			req.getRequestDispatcher("Register.jsp").forward(req, res);
		}
		else
		{
			req.setAttribute("msg", "User registration failed ");
			req.getRequestDispatcher("Register.jsp").forward(req, res);
		}
	}
}
