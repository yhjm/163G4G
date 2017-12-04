package com.qhit.sbm.account.service;

import java.util.List;

import com.qhit.sbm.account.bean.ShowAccount;
import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.goods.bean.Goods;

public interface AccountService {
	
	public int accountPage();
	public List<ShowAccount> allPage(PageBean pagebean);
	public int selectCount(String goodsName,int isPayed);
	public List<ShowAccount> selectPage(PageBean pagebean ,String goodsName,int isPayed);
	public int updateAccount(String accountId,int isPayed);
	public int deleteAccount(String accountId);
	public int addAccount(Goods goods,int isPayed,int providerId,int businessNum);
}
