package com.qhit.sbm.user.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.user.Dao.UserDao;
import com.qhit.sbm.user.bean.User;
import com.qhit.sbm.utils.DBManager;

public class UserDaoImpl implements UserDao {
	private Connection con =null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public User doLogin(String name, String passWord) {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		User user = null;
		String sql = "select * from tb_user where userName = ?  and  userPassword = ?";
		//System.out.println(sql);
		try {
			ps = con.prepareCall(sql);
			ps.setString(1, name);
			ps.setString(2, passWord);
			rs = ps.executeQuery();
			if (rs != null&&rs.next()){
				user = new User();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setUserPassword(rs.getString("userPassword"));
				user.setUserSex(rs.getString("userSex"));
				user.setUserAge(rs.getInt("userAge"));
				user.setTelephone(rs.getString("telephone"));
				user.setAddress(rs.getString("address"));
				user.setPic(rs.getString("pic"));
				user.setType(rs.getInt("type"));
				return user;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(ps, rs, con);
		}
		
		return null;
	}

	@Override
	public int updatePassword(String newPwd , int userId){
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "update tb_user set userPassword = ? where userId = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, newPwd);
			ps.setInt(2, userId);
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

	@Override
	public List selectUser(PageBean userPage) {
		// TODO Auto-generated method stub
		ArrayList<User> listu = new ArrayList<User>();
		User user = null;
		con = DBManager.getConnection();
		String sql = "select top  "
				+  userPage.getPageSize()
				+ "  *  from  tb_user  where userId not in    (select top  "
				+ userPage.getPageSize()*(userPage.getPageNum() - 1)
				+ "  userId from tb_user) ";
		//System.out.println(sql);
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs != null &&rs.next()){
				user = new User(
						rs.getInt("userId"), 
						rs.getInt("userAge"), 
						rs.getInt("type"), 
						rs.getString("userName"), 
						rs.getString("userPassword"), 
						rs.getString("userSex"), 
						rs.getString("telephone"), 
						rs.getString("address"), 
						rs.getString("pic"));
				listu.add(user);
			}
			return listu;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				DBManager.close(ps, rs, con);	
		}	
		return null;
	}

	@Override
	public int addUser(User addUser) {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "insert into tb_user values(?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, addUser.getUserName());
			ps.setString(2, addUser.getUserPassword());
			ps.setString(3, addUser.getUserSex());
			ps.setInt(4, addUser.getUserAge());
			ps.setString(5, addUser.getTelephone());
			ps.setString(6, addUser.getAddress());
			ps.setString(7, addUser.getPic());
			ps.setInt(8, addUser.getType());
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
