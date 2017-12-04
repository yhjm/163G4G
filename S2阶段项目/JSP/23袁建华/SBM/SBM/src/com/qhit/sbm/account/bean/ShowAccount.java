package com.qhit.sbm.account.bean;

public class ShowAccount {
/*
 * 账单编号
 * 商品名称
 * 商品数量
 * 交易金额
 * 是否付款
 * 供应商名称
 * 商品描述
 * **/
	
	private int accountId;
	private String goodsName;
	//private int goodsNum;
	private float totalPrice;
	private int isPayed;
	private int businessNum;
	private String providerName;
	private String goodsIntro;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getBusinessNum() {
		return businessNum;
	}
	public void setBusinessNum(int businessNum) {
		this.businessNum = businessNum;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getIsPayed() {
		return isPayed;
	}
	public void setIsPayed(int isPayed) {
		this.isPayed = isPayed;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getGoodsIntro() {
		return goodsIntro;
	}
	public void setGoodsIntro(String goodsIntro) {
		this.goodsIntro = goodsIntro;
	}

	public ShowAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShowAccount(int accountId, String goodsName, float totalPrice,
			int isPayed, int businessNum, String providerName, String goodsIntro) {
		super();
		this.accountId = accountId;
		this.goodsName = goodsName;
		this.totalPrice = totalPrice;
		this.isPayed = isPayed;
		this.businessNum = businessNum;
		this.providerName = providerName;
		this.goodsIntro = goodsIntro;
	}
	
	
	
}
