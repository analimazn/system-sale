package entities;

public class Financial {
	private String id;
	private String cnpj;
	private String socialReason;
	
	public Financial(String id, String cnpj, String socialReason) {
		this.id = id;
		this.cnpj = cnpj;
		this.socialReason = socialReason;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getFinancial() {
		StringBuilder sb = new StringBuilder();
		sb.append("Razão Social: " + this.socialReason).append("\n");
		sb.append("CNPJ: " + this.cnpj).append("\n");
		return sb.toString();
	}

}
