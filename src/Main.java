import enums.EnumUser;
import entities.User;
import entities.Finance;
import models.modelEntities.ModelUser;

public class Main {

	public static void main(String[] args) {		
		//Users de teste
		User adminOne = new User("teste1", "@123", EnumUser.Admin, "00001", "Teste1", "00000000000000");
		User clientTwo = new User("teste2", "@123", EnumUser.Client, "00002", "Teste2", "11111111111111");
		User clientUpdate = new User("teste4", "@123555", EnumUser.Client, "00002", "Teste4", "222222222222");

		//Validando métodos do User
		//ModelUser.addUser(adminOne);
		//ModelUser.addUser(clientTwo);
		
		ModelUser.findUser(clientTwo.getIdentifier());
		ModelUser.updateUser(clientUpdate);
		ModelUser.removeUser(adminOne.getIdentifier());
		ModelUser.getListUsers();

	}

}
