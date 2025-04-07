package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginDAO {
	public UserBean checkLogin(String Username, String Password)
	{
		UserBean bean=null;
		try
		{
			Connection con=DBConnect.getCon();
		PreparedStatement pstmt=	con.prepareStatement("select * from registration where username=? and password=?");
		pstmt.setString(1, Username);
		pstmt.setString(2, Password);
		ResultSet rs=pstmt.executeQuery();
		
		if(rs.next())
		{
			bean=new UserBean();
			bean.setUserName(rs.getString(1));
			bean.setPassword(rs.getString(2));
			bean.setfName(rs.getString(3));
			bean.setlName(rs.getString(4));
			bean.setMailId(rs.getString(5));
			bean.setPhoneNo(rs.getInt(5));
		}
		else {
			throw new SQLException("Error in your check user dao class");
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}
		
		return bean;
	}
	
}
