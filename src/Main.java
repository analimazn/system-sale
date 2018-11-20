import enums.EnumUser;
import entities.User;
import entities.Finance;
import models.modelEntities.ModelUser;

public class Main {

	public static void main(String[] args) {
		
		User adminOne = new User(EnumUser.Admin, "analimazn", "@123", "3030", "Ana Lima");
		User clientTwo = new User(EnumUser.Client, "analimazn", "@123", "3030", "Ana Lima");
		User clientOne = new User(EnumUser.Client, "pneuscia", "#123", "3742834950001", "Pneus CIA");
		
		ModelUser dataBaseUser = new ModelUser();
		
		dataBaseUser.addUser(adminOne);
		dataBaseUser.addUser(clientOne);
		dataBaseUser.addUser(clientTwo);
		
		System.out.println(dataBaseUser.getAllUsers());
	}

}
