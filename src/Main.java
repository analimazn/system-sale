import enums.EnumUser;
import entities.*;
import models.modelEntities.*;

public class Main {

	public static void main(String[] args) {		
		/*Users de teste
		User adminOne = new User("teste1", "@123", EnumUser.Admin, "00001", "Teste1", "00000000000000");
		User clientTwo = new User("teste2", "@123", EnumUser.Client, "00002", "Teste2", "11111111111111");
		User clientThree= new User("teste2", "@123", EnumUser.Client, "00002", "Teste2", "11111111111111");
		User clientUpdate = new User("teste4", "@123555", EnumUser.Client, "00002", "Teste4", "222222222222");

		//Validando métodos do User
		ModelUser.addUser(adminOne);
		ModelUser.addUser(clientTwo);
		ModelUser.addUser(clientThree);
		
		ModelUser.findUser(clientTwo.getId());
		ModelUser.updateUser(clientUpdate);
		ModelUser.removeUser(adminOne.getId());
		ModelUser.getListUser();*/
		
		Financial financial1 = new Financial("2323", "111111111111111", "Bradesco");
		Financial financial2 = new Financial("2424", "22222222222222", "Itau" );
		Financial financial3 = new Financial("2424", "22222222222222", "Itau" );
		Financial financialUp = new Financial("2424", "555555555555", "BB" );

		//Validando métodos do Financial
		ModelFinancial.addFinancial(financial1);
		ModelFinancial.addFinancial(financial2);
		ModelFinancial.addFinancial(financial3);
		
		ModelFinancial.findFinancial(financial1.getId());
		ModelFinancial.updateFinancial(financialUp);
		ModelFinancial.removeFinancial(financial1.getId());
		ModelFinancial.getListFinancial();
		
	}

}
