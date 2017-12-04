package com.qhit.sbm.common.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qhit.sbm.common.Dao.CommonDao;
import com.qhit.sbm.utils.DBManager;

public class CommonDaoImpl implements CommonDao {
	  private Connection con = null;
	  private PreparedStatement ps = null;
	  private ResultSet rs = null;
	@Override
	public int getCount(String table, String[] arg0, String[] arg1) {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "select count(*) con from  "+table+"  where ";
		if(arg0 == null || arg1 ==null){
			sql += "  1 = 1"	;
			System.out.println(sql);
		}else{
			for(int i = 0;i<arg0.length;i++){
				sql += arg0[i] + " = ";
				sql += arg1[i] + " and ";
			}
		}
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
		if(rs != null && rs.next()){
			return  rs.getInt("con");
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(ps, rs, con);
		}		
		return 0;
	}

}
