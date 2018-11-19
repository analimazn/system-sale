package entities;

import enums.EnumUser;

public class Finance {
	public EnumUser user;
	private String cnpj;
	private String socialReason;
	
	public Finance(String cnpj, String socialReason, EnumUser finance) {
		this.cnpj = cnpj;
		this.socialReason = socialReason;
		this.user = finance;
	}

	public EnumUser getUser() {
		return user;
	}

	public void setUser(EnumUser user) {
		this.user = user;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getSocialReason() {
		return socialReason;
	}

	public void setSocialReason(String socialReason) {
		this.socialReason = socialReason;
	}
}
