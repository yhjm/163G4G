package com.qhit.sbm.goods.service.Impl;

import java.util.List;

import com.qhit.sbm.goods.Dao.Impl.GoodsDaoImpl;
import com.qhit.sbm.goods.bean.Goods;
import com.qhit.sbm.goods.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {

	@Override
	public List getGoodsId() {
		// TODO Auto-generated method stub
		
		return new GoodsDaoImpl().getGoodsId();
	}

	@Override
	public Goods getGoods(String goodsName, int goodsId) {
		// TODO Auto-generated method stub
		return new GoodsDaoImpl().getGoods(goodsName, goodsId);
	}

	@Override
	public int updateGoodsNum(String goodsName, int goodsId,int businessNum) {
		// TODO Auto-generated method stub
		return new GoodsDaoImpl().updateGoodsNum(goodsName, goodsId, businessNum);
	}

}
