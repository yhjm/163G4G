package com.qhit.sbm.goods.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qhit.sbm.goods.Dao.GoodsDao;
import com.qhit.sbm.goods.bean.Goods;
import com.qhit.sbm.goods.bean.GoodsId;
import com.qhit.sbm.provider.bean.ProviderId;
import com.qhit.sbm.utils.DBManager;

public class GoodsDaoImpl implements GoodsDao {

	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	
	@Override
	public Goods getGoods (String goodsName,int goodsId){
		// TODO Auto-generated method stub
		Goods goods = null;
		con = DBManager.getConnection();
		String sql = "select * from tb_goods where goodsName =  "
				+  goodsName
				+" and  goodsId =  "
				+goodsId;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs != null & rs.next()){
				goods = new Goods(
						rs.getInt("goodsId"), 
						rs.getString("goodsName"), 
						rs.getInt("goodsNum"), 
						rs.getFloat("goodsPrice"), 
						rs.getString("goodsUnit"), 
						rs.getString("goodsIntro"));
				return goods;
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
	public List getGoodsId() {
		// TODO Auto-generated method stub
		List <GoodsId> listpro = new ArrayList<GoodsId>();
		GoodsId gi =null;
		con = DBManager.getConnection();
		String sql = "select goodsId from tb_goods";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs != null& rs.next()){
				gi = new GoodsId();
				gi.setGoodsId(rs.getInt("goodsId"));
				listpro.add(gi);
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
	public int updateGoodsNum(String goodsName, int goodsId,int businessNum) {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "update tb_goods set goodsNum +="
				+  businessNum
				+ "  where goodsName =  "
				+  goodsName
				+" and  goodsId =  "
				+goodsId;
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

}
