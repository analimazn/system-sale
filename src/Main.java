import enums.EnumProduct;
import enums.EnumStatus;
import enums.EnumUser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import controller.controllerEntities.ControllerFinancial;
import controller.controllerEntities.ControllerUser;
import controller.controllerSystemSale.ControllerSale;
import entities.*;
import models.modelEntities.*;
import models.modelSystemSale.*;
import products.*;
import systemSale.Bid;
import systemSale.Sale;
import utils.Address;

public class Main {

	public static void main(String[] args) {
		
		 Scanner scanner = new Scanner(System.in);
			
		 int selected ;
		 do {
			   System.out.println("\n                                 *** System Sale ***");
			   System.out.println("\n                   ===============================================");
			   System.out.println("                       1 - Leilão             	           		   ");
			   System.out.println("                       2 - Usuário                         		   ");
			   System.out.println("                       3 - Entidade Financeira                      ");		
			   System.out.println("                       0 - Sair			          				   ");  			
			   System.out.println("                   ===============================================\n");
	
			   selected = scanner.nextInt();
			   
			   switch (selected) {
			   case 1: ControllerSale.menu();
				   break;
			   case 2: ControllerUser.menu();
				   break;
			   case 3: ControllerFinancial.menu();
			   		   break;			
			   case 0:
				   break;
			   default:
				   System.out.println("Opção Inválida!");
				   break;
			   }
	
		 }while (selected != 0);
		  System.out.println("Finalizado.");
		  }


}
