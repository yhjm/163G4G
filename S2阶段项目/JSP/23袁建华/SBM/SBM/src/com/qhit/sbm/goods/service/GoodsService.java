package com.qhit.sbm.goods.service;

import java.util.List;

import com.qhit.sbm.goods.bean.Goods;

public interface GoodsService {
	
	public Goods getGoods (String goodsName,int goodsId);
	public List getGoodsId();
	public int updateGoodsNum(String goodsName,int goodsId,int businessNum);

}
