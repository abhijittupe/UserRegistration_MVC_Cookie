package pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProfileDAO {
	public int updateData(UserBean bean)
	{	
		int rowCount=0;
		
		try {
			Connection con=DBConnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("update registration set firstname=?,lastname=?,mailid=?,phone=? where username=?");
			pstmt.setString(1, bean.getfName());
			pstmt.setString(2, bean.getlName());
			pstmt.setString(3, bean.getMailId());
			pstmt.setInt(4, bean.getPhoneNo());
			pstmt.setString(5, bean.getUserName());
			
			rowCount=pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rowCount;
	}
	
	
}
