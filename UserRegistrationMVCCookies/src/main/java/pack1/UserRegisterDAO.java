package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserRegisterDAO {

	public int insertUser(UserBean bean)
	{
		int rowCount=0;
		try
		{
			Connection con=DBConnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("insert into registration values(?,?,?,?,?,?)");
			pstmt.setString(1, bean.getUserName());
			pstmt.setString(2, bean.getPassword());
			pstmt.setString(3, bean.getfName());
			pstmt.setString(4, bean.getlName());
			pstmt.setString(5, bean.getMailId());
			pstmt.setInt(6, bean.getPhoneNo());
			rowCount=pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return rowCount;
	}
}
