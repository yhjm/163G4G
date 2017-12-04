package com.qhit.sbm.account.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qhit.sbm.account.Dao.AccountDao;
import com.qhit.sbm.account.bean.ShowAccount;
import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.goods.bean.Goods;
import com.qhit.sbm.utils.DBManager;

public class AccountDaoImpl implements AccountDao {

	private  Connection con = null; 
	private  PreparedStatement ps = null;
	private ResultSet rs = null;
	
	/*获取 
	* 账单编号
	 * 商品名称
	 * 商品数量
	 * 交易金额
	 * 是否付款
	 * 供应商名称
	 * 商品描述
	*/
	@Override
	public int accountPage() {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "select count(*) con  from ( "
				+ "select a.accountId,g.goodsName,a.businessNum,a.totalPrice,a.isPayed,p.providerName,g.goodsIntro "
				+ " from tb_account a  left join tb_goods g on a.goodsId = g.goodsId"
				+ "   left join tb_provider p on a.providerId = p.providerId  ) tb";
		
		try {
			ps = con.prepareStatement(sql);
			 rs = ps.executeQuery();
			 System.out.println(sql);
			if(rs != null&rs.next()){
				return rs.getInt("con");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(ps, rs, con);
		}
		return 0;
	}

	@Override
	public List<ShowAccount> allPage(PageBean pagebean) {
		// TODO Auto-generated method stub
		List<ShowAccount> salist = new ArrayList<ShowAccount>();
		ShowAccount sa = null;
		con = DBManager.getConnection();
		String sql = " select top  "
				+ pagebean.getPageSize()
				+ " a.accountId,g.goodsName,a.businessNum,a.totalPrice,a.isPayed,p.providerName,g.goodsIntro "
				+ "  from tb_account a  left join tb_goods g on a.goodsId = g.goodsId"
				+ "   left join tb_provider p on a.providerId = p.providerId "
				+ " where a.accountId not in "
				+ " (select top "
				+ pagebean.getPageSize()*(pagebean.getPageNum() - 1)
				+ "  a.accountId from tb_account a  left join tb_goods g on a.goodsId = g.goodsId"
				+ " left join tb_provider p on a.providerId = p.providerId )";
		try {
			ps = con.prepareStatement(sql);
			System.out.println(sql);
			rs = ps.executeQuery();
		
			while(rs != null & rs.next()){
				sa = new ShowAccount(		
						rs.getInt("accountId"), 
						rs.getString("goodsName"), 
						rs.getFloat("totalPrice"),
						rs.getInt("isPayed"), 
						rs.getInt("businessNum"), 
						rs.getString("providerName"), 
						rs.getString("goodsIntro"));
					salist.add(sa);
			}
			return salist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(ps, rs, con);
			
		}
		
		return null;
	}


	@Override
	public List<ShowAccount> selectPage(PageBean pagebean, String goodsName,
			int isPayed) {
		// TODO Auto-generated method stub
		List<ShowAccount> salist = new ArrayList<ShowAccount>();
		ShowAccount sa = null;
		con = DBManager.getConnection();
		String sql = " select top  "
				+ pagebean.getPageSize()
				+ " a.accountId,g.goodsName,a.businessNum,a.totalPrice,a.isPayed,p.providerName,g.goodsIntro "
				+ "  from tb_account a  left join tb_goods g on a.goodsId = g.goodsId"
				+ "   left join tb_provider p on a.providerId = p.providerId "
				+ " where a.accountId not in "
				+ " (select top "
				+ pagebean.getPageSize()*(pagebean.getPageNum() - 1)
				+ "  a.accountId from tb_account a  left join tb_goods g on a.goodsId = g.goodsId"
				+ " left join tb_provider p on a.providerId = p.providerId ) "
				+ " or  g.goodsName = "
				+ goodsName
				+" or a.isPayed =  "
				+ isPayed
				+ "";
		try {
			ps = con.prepareStatement(sql);
			System.out.println(sql);
			rs = ps.executeQuery();
		
			while(rs != null & rs.next()){
				sa = new ShowAccount(		
						rs.getInt("accountId"), 
						rs.getString("goodsName"), 
						rs.getFloat("totalPrice"),
						rs.getInt("isPayed"), 
						rs.getInt("businessNum"), 
						rs.getString("providerName"), 
						rs.getString("goodsIntro"));
					salist.add(sa);
			}
			return salist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(ps, rs, con);
			
		}
		
		return null;
	}

	@Override
	public int selectCount(String goodsName, int isPayed) {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "select count(*) con  from ( "
				+ "select a.accountId,g.goodsName,a.businessNum,a.totalPrice,a.isPayed,p.providerName,g.goodsIntro "
				+ " from tb_account a  left join tb_goods g on a.goodsId = g.goodsId"
				+ "   left join tb_provider p on a.providerId = p.providerId "
				+ "where 1 = 1  or  g.goodsName = "
				+ goodsName
				+" or  "
				+"  a.isPayed = "
				+isPayed
				+ " ) tb";
		
		try {
			ps = con.prepareStatement(sql);
			 rs = ps.executeQuery();
			 System.out.println(sql);
			if(rs != null&rs.next()){
				return rs.getInt("con");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(ps, rs, con);
		}
		return 0;
		
	}

	@Override
	public int updateAccount(String accountId, int isPayed) {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "update tb_account set isPayed = "+isPayed+"where  accountId = "+accountId;
		try {
			ps = con.prepareStatement(sql);
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
	public int deleteAccount(String accountId) {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "delete from tb_account where  accountId = "+accountId;
		try {
			ps = con.prepareStatement(sql);
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
	public int addAccount(Goods goods, int isPayed, int providerId,
			int businessNum) {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "insert into  tb_account(providerId,totalPrice,isPayed,accountDate,goodsId,businessNum) values(?,?,?,getDate(),?,?) ";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, providerId);
			ps.setFloat(2, goods.getGoodsPrice()*businessNum);
			ps.setInt(3, isPayed);
			ps.setInt(4, goods.getGoodsId());
			ps.setInt(5, businessNum);
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
