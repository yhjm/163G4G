package com.qhit.sbm.provider.bean;

public class Provider {
	/*providerId int primary key identity(1,1),	--供应商ID
	providerName nvarchar(20) not null,		--供应商姓名
	providerDetail nvarchar(20),	--供应商描述
	contact nvarchar(20) not null,	--联系人
	telephone nvarchar(15) not null,	--供应商电话
	facsimile nvarchar(15) not null,	--供应商传真
	address
	*/
	
	private int providerId ;
	private String providerName;
	private String providerDetail;
	private String contact;
	private String telephone;
	private String facsimile;
	private String address;
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getProviderDetail() {
		return providerDetail;
	}
	public void setProviderDetail(String providerDetail) {
		this.providerDetail = providerDetail;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFacsimile() {
		return facsimile;
	}
	public void setFacsimile(String facsimile) {
		this.facsimile = facsimile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Provider() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Provider(int providerId, String providerName, String providerDetail,
			String contact, String telephone, String facsimile, String address) {
		super();
		this.providerId = providerId;
		this.providerName = providerName;
		this.providerDetail = providerDetail;
		this.contact = contact;
		this.telephone = telephone;
		this.facsimile = facsimile;
		this.address = address;
	}
	public Provider(String providerName, String providerDetail, String contact,
			String telephone, String facsimile, String address) {
		super();
		this.providerName = providerName;
		this.providerDetail = providerDetail;
		this.contact = contact;
		this.telephone = telephone;
		this.facsimile = facsimile;
		this.address = address;
	}
	
	
	
	
	
}
