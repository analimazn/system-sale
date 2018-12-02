package products;

import enums.EnumProduct;
import enums.EnumVehicle;
import systemSale.Sale;

public class Vehicle extends Product {
	protected String chassis;
	protected String licensePlate;
	protected EnumVehicle modality;
	
	public Vehicle(Sale idSale, String id, EnumProduct type, EnumVehicle modality, double price, 
			String description, String chassis, String licensePlate) {
		super(idSale, id, type, price, description);
		this.modality = modality;
		this.chassis = chassis;
		this.licensePlate = licensePlate;
		}
		
		public EnumVehicle getModality() {
		return modality;
	}

	public void setModality(EnumVehicle modality) {
		this.modality = modality;
	}

		public String getChassis() {
		return chassis;
	}

	public void setChassis(String chassis) {
		this.chassis = chassis;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getVehicle() {
		StringBuilder sb = new StringBuilder();
		sb.append("IdSale: " + super.idSale).append("\n");
		sb.append("ID: " + super.id).append("\n");
		sb.append("ProductType: " + super.type).append("\n");
		sb.append("Modality: " + this.modality).append("\n");
		sb.append("Price" + super.price).append("\n");
		sb.append("Description" + super.description).append("\n");
		return sb.toString();
	}

}
