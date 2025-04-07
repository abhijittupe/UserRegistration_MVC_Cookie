package pack1;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateProfileServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Cookie arr[]=req.getCookies();
		String fname=null;
		if(arr.length==0)
		{
			req.setAttribute("msg", "Session Expired");
			req.getRequestDispatcher("Register.jsp").forward(req, res);
		}
		else
		{
			ServletContext context=req.getServletContext();
			UserBean bean=(UserBean)context.getAttribute("userbean");
			bean.setfName(req.getParameter("u_fname"));
			bean.setlName(req.getParameter("u_lname"));
			bean.setMailId(req.getParameter("u_mailid"));
			bean.setPhoneNo(Integer.parseInt(req.getParameter("u_phone")));
			
			int rowCount=new UpdateProfileDAO().updateData(bean);
			if(rowCount==0) {
				req.setAttribute("msg", "Data not updated");
				req.getRequestDispatcher("Register.jsp").forward(req, res);
			}
			else {
				req.setAttribute("msg", "data updated successfully");
				for(Cookie c:arr)
					if("c5".equals(c.getName()))
						fname=c.getValue();
				req.setAttribute("fname", fname);
				req.getRequestDispatcher("UpdateProfile.jsp").forward(req, res);
			}
		}
		
	}
}
