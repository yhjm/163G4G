package com.qhit.sbm.account.service.Impl;

import java.util.List;

import com.qhit.sbm.account.Dao.Impl.AccountDaoImpl;
import com.qhit.sbm.account.bean.ShowAccount;
import com.qhit.sbm.account.service.AccountService;
import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.goods.bean.Goods;

public class AccountServiceImpl implements AccountService {

	@Override
	public int accountPage() {
		// TODO Auto-generated method stub
		return new AccountDaoImpl().accountPage();
	}


	@Override
	public List<ShowAccount> allPage(PageBean pagebean) {
		// TODO Auto-generated method stub
		return new AccountDaoImpl().allPage(pagebean);
	}


	@Override
	public List<ShowAccount> selectPage(PageBean pagebean, String goodsName,
			int isPayed) {
		// TODO Auto-generated method stub
		return new AccountDaoImpl().selectPage(pagebean, goodsName, isPayed);
	}


	@Override
	public int selectCount(String goodsName, int isPayed) {
		// TODO Auto-generated method stub
		return new AccountDaoImpl().selectCount(goodsName, isPayed);
	}


	@Override
	public int updateAccount(String accountId, int isPayed) {
		// TODO Auto-generated method stub
		return new AccountDaoImpl().updateAccount(accountId, isPayed);
	}


	@Override
	public int deleteAccount(String accountId) {
		// TODO Auto-generated method stub
		return new AccountDaoImpl().deleteAccount(accountId);
	}


	@Override
	public int addAccount(Goods goods, int isPayed, int providerId,
			int businessNum) {
		// TODO Auto-generated method stub
		return new AccountDaoImpl().addAccount(goods, isPayed, providerId, businessNum);
	}

}
