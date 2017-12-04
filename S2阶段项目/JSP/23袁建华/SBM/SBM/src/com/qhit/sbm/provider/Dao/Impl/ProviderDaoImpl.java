package com.qhit.sbm.provider.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.provider.Dao.ProviderDao;
import com.qhit.sbm.provider.bean.Provider;
import com.qhit.sbm.provider.bean.ProviderId;
import com.qhit.sbm.utils.DBManager;

public class ProviderDaoImpl implements ProviderDao {

	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	@Override
	public List getProviderId() {
		// TODO Auto-generated method stub
		List <ProviderId> listpro = new ArrayList<ProviderId>();
		ProviderId pi =null;
		con = DBManager.getConnection();
		String sql = "select providerId from tb_provider";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs != null& rs.next()){
				pi = new ProviderId();
				pi.setProviderId(rs.getInt("providerId"));
				listpro.add(pi);
			}
			return listpro;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(ps, rs, con);
		}
		
		return null;
	}
	@Override
	public List getProvider() {
		// TODO Auto-generated method stub
		List <Provider> listpro = new ArrayList<Provider>();
		Provider p =null;
		con = DBManager.getConnection();
		String sql = "select * from tb_provider";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs != null& rs.next()){
				p = new Provider(
						rs.getInt("providerId"),
						 rs.getString("providerName"), 
						 rs.getString("providerDetail"), 
						 rs.getString("contact"), 
						 rs.getString("telephone"), 
						 rs.getString("facsimile"), 
						 rs.getString("address"));			
				listpro.add(p);
			}
			return listpro;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(ps, rs, con);
		}
		return null;
	}
	@Override
	public List selectProvider(PageBean providerPage) {
		// TODO Auto-generated method stub
		List <Provider> listpro = new ArrayList<Provider>();
		Provider p =null;
		con = DBManager.getConnection();
		String sql =
				"select top "
				+ providerPage.getPageSize()
				+ " * from tb_provider where providerId not in (select top  "
				+ providerPage.getPageSize()*(providerPage.getPageNum() - 1)
				+ "  providerId  from tb_provider)";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs != null && rs.next()){
				p = new Provider(
									rs.getInt("providerId"), 
									rs.getString("providerName"), 
									rs.getString("providerDetail"), 
									rs.getString("contact"), 
									rs.getString("telephone"), 
									rs.getString("facsimile"), 
									rs.getString("address")); 
				listpro.add(p);
			}
			return listpro;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(ps, rs, con);
		}
		return null;
	}
	@Override
	public int addProvider(Provider addProvider) {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "insert into tb_provider values(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, addProvider.getProviderName());
			ps.setString(2, addProvider.getProviderDetail());
			ps.setString(3, addProvider.getContact());
			ps.setString(4, addProvider.getTelephone());
			ps.setString(5, addProvider.getFacsimile());
			ps.setString(6, addProvider.getAddress());
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
