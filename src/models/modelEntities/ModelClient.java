package models.modelEntities;

import java.util.ArrayList;
import entities.Client;

public class ModelClient {
	public ArrayList<Client> list = new ArrayList<Client>();
	
	public void ModelUser(ArrayList<Client> list) {
		this.list = list;
	}
	
	public Boolean addClient(Client client) {
		list.add(client);
		
		for(Client name : list)
		{
		    System.out.println(name.getUser());
		}
		return true;
	}

	public ArrayList<Client> getList() {
		return list;
	}

	public void setList(ArrayList<Client> list) {
		this.list = list;
	}
}
