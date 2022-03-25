package br.com.recode.ag;

import java.util.Scanner;

import br.com.recode.ag.services.ClienteServices;
import br.com.recode.ag.services.DestinoServices;
import br.com.recode.ag.services.PromocaoServices;
import br.com.recode.ag.services.JoinTablesServices;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int opcao;
		boolean repetir = true;
		ClienteServices clienteServices = new ClienteServices();
		DestinoServices destinoServices = new DestinoServices();
		PromocaoServices promocaoServices = new PromocaoServices();
		JoinTablesServices joinTablesServices = new JoinTablesServices();
		
		
		do {
			System.out.println("");
			System.out.println("______________________BEM-VINDO � Queer Trip______________________");
			System.out.println("");
			System.out.println("Digite uma das op��es abaixo.");
			System.out.println("0 para SAIR");
			System.out.println("1 para CRUD CLIENTES");
			System.out.println("2 para CRUD DESTINOS");
			System.out.println("3 para CRUD PROMO��ES");
			System.out.println("4 para exibir DESTINOS E PROMO��ES");
			System.out.println("5 para exibir CLIENTES COM SEUS DESTINOS ESCOLHIDOS");
			opcao = sc.nextInt();
			
			switch (opcao) {
			case 0:
				System.out.println("Fechando MENU - Queer Trip.");
				repetir = false;
				break;
			case 1:
				clienteServices.menu();
				break;
			case 2:
				destinoServices.menu();
				break;
			case 3:
				promocaoServices.menu();
				break;
			case 4:
				joinTablesServices.imprimirDestinoOuPromocao();
				break;
			case 5:
				joinTablesServices.imprimeViajantes();
				break;
			default:
				System.out.println("Op��o inv�lida, digite uma op��o de 0 a 5.");
				break;
			}
		} while (repetir);
		
		
		
		
		sc.close();
	}

}
