package lab3;

import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws ParseException {
	
		// Declaracao das Datas no formato dd/MM/yyyy que serao usadas nos clientes e sinistro
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		String DL1 = "07/01/2012";
		String DL2 = "08/02/2013";
		String DL3 = "09/03/2014";
		String DL4 = "10/04/2015";
		String DL5 = "11/05/2016";
		Date dataL1 = formato.parse(DL1);
		Date dataL2 = formato.parse(DL2);
		Date dataL3 = formato.parse(DL3);
		Date dataL4 = formato.parse(DL4);
		Date dataL5 = formato.parse(DL5);
		
		String DF1 = "12/01/2012";
		String DF2 = "13/02/2013";
		String DF3 = "14/03/2014";
		String DF4 = "15/04/2015";
		String DF5 = "16/05/2016";
		Date dataF1 = formato.parse(DF1);
		Date dataF2 = formato.parse(DF2);
		Date dataF3 = formato.parse(DF3);
		Date dataF4 = formato.parse(DF4);
		Date dataF5 = formato.parse(DF5);
		
		String DS1 = "12/12/2022";
		String DS2 = "13/11/2023";
		String DS3 = "14/10/2021";
		String DS4 = "15/09/2020";
		
		Date dataS1 = formato.parse(DS1);
		Date dataS2 = formato.parse(DS2);
		Date dataS3 = formato.parse(DS3);
		Date dataS4 = formato.parse(DS4);
				
		// Cria listas de veiculos que serão cadastrados nos clientes
		ArrayList<Veiculo> veiculosC1 = new ArrayList<Veiculo>();
			Veiculo carro1C1 = new Veiculo("QAA7811", "Toyota", "Etios", 2016);
			Veiculo carro2C1 = new Veiculo("CMG3164", "Chevrolet", "Corsa", 2003);
						
		ArrayList<Veiculo> veiculosC2 = new ArrayList<Veiculo>();
			Veiculo carro1C2 = new Veiculo("OTM2022", "Chevrolet", "Onix", 2020);
			veiculosC2.add(carro1C2);
			
		ArrayList<Veiculo> veiculosC3 = new ArrayList<Veiculo>();
			Veiculo carro1C3 = new Veiculo("DEF3930", "Fiat", "Uno", 2014);
			Veiculo carro2C3 = new Veiculo("DET7740", "Volkswagen", "Saveiro", 2012);
			Veiculo carro3C3 = new Veiculo("EGO7757", "Volkswagen", "Polo", 2019);
			veiculosC3.add(carro1C3);
			veiculosC3.add(carro2C3);
			veiculosC3.add(carro3C3);
		
		ArrayList<Veiculo> veiculosC4 = new ArrayList<Veiculo>();	
			Veiculo carro1C4 = new Veiculo("NUI4876", "Toyota", "Corolla", 2014);
			
		ArrayList<Veiculo> veiculosC5 = new ArrayList<Veiculo>();	
			
		// Cadastro dos clientes (2 PJ's e 2 PF's)
		ClientePJ c1 = new ClientePJ("Fio a Fio", "Av Mato Grosso, Campo Grande-MS", dataL1, "Pós Graduação", "feminino", "6 salarios minimos", veiculosC1, "76.145.846/0001-81", dataF1);
		ClientePF c2 = new ClientePF("Natália Vieira Lima", "Av 1 n°9", dataL2, "Superior incompleto", "Feminino", "3 salarios minimos", veiculosC2, "048.973.971-70", dataF2);
		ClientePF c3 = new ClientePF("Luis Paulo", "Av 3 n°8", dataL3, "Superior incompleto", "Masculino", "5 salarios minimos", veiculosC3, "440.776.838-07", dataF3);
		ClientePJ c4 = new ClientePJ("Clinica VS", "Av Dom Aquino, Campo Grande-MS", dataL4, "Superior compleo", "feminino", "4 salarios minimos", veiculosC4, "22 130 543 0001 66", dataF4);
		/* Cliente com o CPF incorreto  --> */  ClientePF c5 = new ClientePF("Sofia Oliveira", "Brasília",dataL5, "Ensino médio completo", "Feminino", "2 salarios minimos", veiculosC5, "000.000.000-00", dataF5);
		
		// Validacao dos documentos (CPF's e CNPJ's)
			System.out.print("CNPJ de " + c1.getNome());
				c1.validarCnpj();
			System.out.print("CPF de " + c2.getNome());
				c2.validarCpf();
			System.out.print("CPF de " + c3.getNome());
				c3.validarCpf();	
			System.out.print("CNPJ de " + c4.getNome());
				c4.validarCnpj();
			System.out.print("CPF de " + c5.getNome());
				c5.validarCpf();   // CPF invalido verificado!
		
		// Cadastro de Veiculos nas listas de Veiculos de cada cliente cadastrado
		c1.adicionaVeiculo(carro1C1);
		c1.adicionaVeiculo(carro2C1);
		c2.adicionaVeiculo(carro1C2);    
		c3.adicionaVeiculo(carro1C3);
		c3.adicionaVeiculo(carro2C3);
		c3.adicionaVeiculo(carro3C3);
		c4.adicionaVeiculo(carro1C4);
		
		// Cadastrando seguradoras
		Seguradora seg1 = new Seguradora("Porto Seguro", "(11) 99999-9999", "portoSeguros@email.br", "São Paulo-SP");
		seg1.adicionaClientes(c1); // Cliente PJ
		Seguradora seg2 = new Seguradora("Allianz", "(19) 98888-8888", "allianz@email.br", "Campinas-SP");
		
		// Cadastrando sinistro pelo metodo 'adiciona' e pelo 'gerarSinistro'
		Sinistro s1 = new Sinistro(dataS1, "Campo Grande", seg1,carro1C2, c2);
		seg1.adicionaSinistros(s1);
		seg1.gerarSinistro(dataS2, "Brasília", seg1,carro2C3, c3);
		seg1.gerarSinistro(dataS3, "Campinas-SP", seg1,carro1C1, c1);
		seg1.gerarSinistro(dataS4, "SP", seg1,carro1C2, c1);
				
		
		// Adicionar clientes na seguradora 1 pela funcao de cadastro 
		seg1.cadastrarCliente(c2); // Cliente PF
		seg1.cadastrarCliente(c3);
		seg1.cadastrarCliente(c4);
		seg1.cadastrarCliente(c4); // Nao vai adicionar propositalmente por conta do cliente 4 ja estar inserido 
		
		// Mostrar que o remover clientes da seguradora 1 
		seg1.removerCliente("22 130 543 0001 66"); // cliente PJ (c4 = Clinica VS)
		seg1.removerCliente("440.776.838-07");     // cliente PF (c3 = Luis Paulo)
		
		// Adiciona novamente para ter mais banco de dados no Menu
		seg1.cadastrarCliente(c3);
		seg1.cadastrarCliente(c4);
		
		// Mostra a lista com os dois clientes (c3 e c4) removidos
		System.out.println(seg1.getListaClientes());
		
	
		// Gerar um toString de pelo menos uma classe
		System.out.println("Cliente 01: \n" + c1.toString());
		System.out.println("Seguradora 01: \n" + seg1.toString());
		System.out.println("Veículo do Cliente03: \n" + veiculosC3.toString());
		System.out.println("\n"+ s1.toString());
		
		/*
		 *  Menu interativo com as funcoes da Seguradora:
		 */
		
		int opcao = 0;
		try (Scanner usuario = new Scanner(System.in)) {
			String tipoCliente;
			int id;
			String nomeCliente;
			
			do { 
			// Menu para Cadastro
				System.out.println("------------------------------------------------------------------");
				System.out.println("Digite... ");
				System.out.println("1: Para listar Clientes cadastrados ");
				System.out.println("2: Para visualizar Sinistro pelo ID");
				System.out.println("3: Para listar todos os Sinistros do cliente");
				System.out.println("4: Para listar todos os clientes cadastrados na seguradora");
				System.out.println("5: Para listar todos os sinistros cadastrados na seguradora");  // Sinistro
				System.out.println("6: Para sair");
				System.out.println("------------------------------------------------------------------");
				System.out.println("\n");
			
			// Selecao do usuario
				System.out.println("Opção selecionada: ");
				opcao = usuario.nextInt();
				usuario.nextLine();// limpa o scanner
				
				switch(opcao) {
					
					case 1: // listar Clientes cadastrados
						System.out.println("Digite o tipo de cliente que deseja listar [1] Pessoa Física ou [2] Pessoa Jurídica: ");
						tipoCliente = usuario.nextLine();
						System.out.println(seg1.listarClientes(tipoCliente));
						break;
						
					case 2: // visualizar Sinistro pelo ID
						System.out.println("Digite a ID do Sinistro desejado (ID >= 100000): ");
						id = usuario.nextInt();
						seg1.visualizarSinistro(id);		
						break;
						
						
					case 3: // listar todos os Sinistros do cliente
						System.out.println("Digite o nome do cliente que deseja listar os sinistros: ");
						nomeCliente = usuario.nextLine();
						System.out.println(seg1.listarSinistros(nomeCliente));
						break;
						
					case 4: // listar todos os clientes cadastrados
						System.out.println(seg1.getListaClientes());
						break;
						
					case 5: // listar todos os sinistros cadastrados
						System.out.println(seg1.getListaSinistros());
					
					case 6:
						break;
					}
				}while(opcao != 6);
		}

		// Declaracao das variaveis a serem utilizadas

		}
	}