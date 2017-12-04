package com.qhit.struts2_T04.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.qhit.struts2_T04.bean.User;
import com.qhit.struts2_T04.dao.UserDAo;
import com.qhit.struts2_T04.utils.DBManager;

public class UserDaoImpl implements UserDAo {

	private Connection con = null;
	private PreparedStatement ps = null;
	
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "insert into tb_user values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getUpwd());
			ps.setInt(3, user.getSex());
			ps.setString(4, user.getEduction());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return 0;
	}

}
