import java.util.ArrayList;
import java.lang.Iterable;
import enums.EnumUser;
import entities.Client;
import entities.Finance;
import models.modelEntities.ModelClient;

public class Main {

	public static void main(String[] args) {
		
		Client adminOne = new Client(EnumUser.Admin, "analimazn", "@123", "3030", "Ana Lima");
		Client clientOne = new Client(EnumUser.Client, "pneuscia", "#123", "3742834950001", "Pneus CIA");
		
		ModelClient arrClients = new ModelClient();
		
		arrClients.addClient(adminOne);

	}

}
