package com.qhit.sbm.provider.service;

import java.util.List;

import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.provider.bean.Provider;

public interface ProviderService {
	
	public List getProviderId();
	public List getProvider();
	public List selectProvider (PageBean providerPage);
	public int addProvider(Provider addProvider);
}
