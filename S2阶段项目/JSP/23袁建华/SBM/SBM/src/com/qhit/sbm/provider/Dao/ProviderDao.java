package com.qhit.sbm.provider.Dao;

import java.util.List;

import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.provider.bean.Provider;

public interface ProviderDao {
	public List getProviderId();
	public List getProvider();
	public List selectProvider (PageBean providerPage);
	public int addProvider(Provider addProvider);
}
