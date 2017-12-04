package com.qhit.sbm.provider.service.Impl;

import java.util.List;

import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.provider.Dao.Impl.ProviderDaoImpl;
import com.qhit.sbm.provider.bean.Provider;
import com.qhit.sbm.provider.service.ProviderService;

public class ProviderServiceImpl implements ProviderService {

	@Override
	public List getProviderId() {
		// TODO Auto-generated method stub
		return new ProviderDaoImpl().getProviderId();
	}

	@Override
	public List getProvider() {
		// TODO Auto-generated method stub
		return new ProviderDaoImpl().getProvider();
	}

	@Override
	public List selectProvider(PageBean providerPage) {
		// TODO Auto-generated method stub
		return new ProviderDaoImpl().selectProvider(providerPage);
	}

	@Override
	public int addProvider(Provider addProvider) {
		// TODO Auto-generated method stub
		return new ProviderDaoImpl().addProvider(addProvider);
	}

}
