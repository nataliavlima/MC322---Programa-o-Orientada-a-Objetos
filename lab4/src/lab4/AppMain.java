package lab4;

import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> working
import java.util.Scanner;




public class AppMain {
<<<<<<< HEAD
	public static void main(String[] args) throws ParseException {
=======
	
	
	public static void main(String[] args) throws ParseException {
		// Listas a serem utilizadas para armazenar todo mundo cadastrado
		List<Cliente> listaClientesTotal = new ArrayList<Cliente>();
		List<Seguradora> listaSeguradoraTotal = new ArrayList<Seguradora>();
		List<Sinistro> listaSinistroTotal = new ArrayList<Sinistro>();
		ArrayList<Veiculo> listaVeiculoTotal = new ArrayList<Veiculo>();
		
>>>>>>> working
		// Declaracao das Datas no formato dd/MM/yyyy que serao usadas nos clientes e sinistro
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			
			String DL2 = "08/02/2013";
			String DL3 = "09/03/2014";
			Date dataL2 = formato.parse(DL2);
			Date dataL3 = formato.parse(DL3);
			
			String DF1 = "12/01/2002";
			String DF2 = "13/02/1993";
			String DF3 = "14/03/1994";
			String DF4 = "15/04/2015";
			
			Date dataF1 = formato.parse(DF1);
			Date dataN2 = formato.parse(DF2);
			Date dataN3 = formato.parse(DF3);
			Date dataF4 = formato.parse(DF4);
			
			
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
				
			ArrayList<Veiculo> veiculosC3 = new ArrayList<Veiculo>();
				Veiculo carro1C3 = new Veiculo("DEF3930", "Fiat", "Uno", 2014);
				Veiculo carro2C3 = new Veiculo("DET7740", "Volkswagen", "Saveiro", 2012);
				Veiculo carro3C3 = new Veiculo("EGO7757", "Volkswagen", "Polo", 2019);
							
			ArrayList<Veiculo> veiculosC4 = new ArrayList<Veiculo>();	
				Veiculo carro1C4 = new Veiculo("NUI4876", "Toyota", "Corolla", 2014);
				
							
			// Cadastro dos clientes (2 PJ's e 2 PF's)
			ClientePJ c1 = new ClientePJ("Fio a Fio", "Av Mato Grosso, Campo Grande-MS", veiculosC1, "76.145.846/0001-81", dataF1, 200);
			ClientePF c2 = new ClientePF("Natália Vieira Lima", "Av 1 n°9", veiculosC2, "048.973.971-70", dataN2, dataL2, "Superior incompleto", "Feminino", "3 salarios minimos");
			ClientePF c3 = new ClientePF("Luis Paulo", "Av 3 n°8",  veiculosC3, "440.776.838-07", dataN3, dataL3, "Superior incompleto", "Masculino", "5 salarios minimos");
			ClientePJ c4 = new ClientePJ("Clinica VS", "Av Dom Aquino, Campo Grande-MS", veiculosC4, "22 130 543 0001 66", dataF4, 50);
			
			// Adicionar os veiculos aos clientes
			c1.adicionaVeiculo(carro1C1);
<<<<<<< HEAD
			c1.adicionaVeiculo(carro2C1);
=======
>>>>>>> working
			c2.adicionaVeiculo(carro1C2);
			c3.adicionaVeiculo(carro1C3);
			c3.adicionaVeiculo(carro2C3);
			c3.adicionaVeiculo(carro3C3);
			c4.adicionaVeiculo(carro1C4);
			
			// Declara Seguradora
			Seguradora seg1 = new Seguradora("Porto Seguro", "(11) 99999-9999", "portoSeguros@email.br", "São Paulo-SP");
			
			// Adiciona os clientes
			seg1.cadastrarCliente(c1);
			seg1.cadastrarCliente(c2);
			seg1.cadastrarCliente(c3);
			seg1.cadastrarCliente(c4);
			
<<<<<<< HEAD
			// Adiciona sinistros
=======
			// Adiciona sinistros (Pelo metodo adicionaSinistros e pelo gerarSinistros)
>>>>>>> working
			Sinistro s1 = new Sinistro(dataS1, "Campo Grande", seg1,carro1C1, c1);
			seg1.adicionaSinistros(s1);
			seg1.gerarSinistro(dataS2, "Brasília", seg1,carro2C3, c3);
			seg1.gerarSinistro(dataS3, "Campinas-SP", seg1,carro1C1, c1);
			seg1.gerarSinistro(dataS4, "SP", seg1,carro1C2, c1);
			
			// Executar funcoes da Seguradora
			System.out.println("--------------------------------------------------------------------------\n");
			System.out.println(seg1.listarClientes("PF")); // Listar Clientes de Pessoa Fisica
			System.out.println("--------------------------------------------------------------------------\n");
			seg1.visualizarSinistro(100000);
			System.out.println("--------------------------------------------------------------------------\n");
			System.out.println(seg1.listarSinistros("Fio a Fio"));
<<<<<<< HEAD
=======
			
			/* O preco do seguro ja e' atualizado automaticamente pelo cadastro do cliente
			*  Colocarei para imprimir para ver que automaticamente ja foi, adicionarei um carro e atualizarei o seguro
			*/
			
			System.out.println("--------------------------------------------------------------------------\n");
			System.out.println("Seguro Inicial do cliente1: R$"+ seg1.calcularPrecoSeguroCliente(c1));
			c1.adicionaVeiculo(carro2C1);
			System.out.println("Atualizando o seguro do cliente1: R$"+ seg1.calcularPrecoSeguroCliente(c1));
			System.out.println("--------------------------------------------------------------------------\n");
			// Imprimindo todos os seguros 
			System.out.println("Seguro Cliente2 : R$" + seg1.calcularPrecoSeguroCliente(c2));
			System.out.println("Seguro Cliente3 : R$" + seg1.calcularPrecoSeguroCliente(c3));
			System.out.println("Seguro Cliente4 : R$" + seg1.calcularPrecoSeguroCliente(c4));
			
>>>>>>> working
			System.out.println("--------------------------------------------------------------------------\n");
			System.out.println("Receita da Seguradora: R$" + seg1.calcularReceita());
			System.out.println("\n--------------------------------------------------------------------------\n");
			
<<<<<<< HEAD
			// Menu de Operações
			int opcao = 0;
			int opcao1 = 0;
			try (Scanner usuario = new Scanner(System.in)) {
				String tipoCliente;
				int id;
				String nomeCliente;
				
				do { 
				// Menu para Cadastro
					System.out.println("------------------------------------------------------------------");
					System.out.println("Digite... ");
					System.out.println("1: Para CADASTROS ");
					System.out.println("2: Para LISTAR");
					System.out.println("3: Para EXCLUIR");
					System.out.println("4: Para GERAR SINISTRO");
					System.out.println("5: Para TRANSFERIR SEGURO");  // Sinistro
					System.out.println("6: Para CALCULAR RECEITA SEGURADORA");
					System.out.println("7: Para SAIR");
					System.out.println("------------------------------------------------------------------");
					System.out.println("\n");
				
				// Selecao do usuario
					System.out.println("Opção selecionada: ");
					opcao = usuario.nextInt();
					usuario.nextLine();// limpa o scanner
					
					if (opcao == MenuOperacoes.CADASTRAR.operacao) { // listar Clientes cadastrados
							System.out.println("Digite o tipo de cliente que deseja listar [1] Pessoa Física ou [2] Pessoa Jurídica: ");
							tipoCliente = usuario.nextLine();
							System.out.println(seg1.listarClientes(tipoCliente));
							break;
					} else if(opcao == MenuOperacoes.LISTAR.operacao) {
						
						break;		
					} else if(opcao == MenuOperacoes.EXCLUIR.operacao) {
						
						break;
					} else if(opcao == MenuOperacoes.GERAR_SINISTRO.operacao) {
						
						break;
					} else if(opcao == MenuOperacoes.TRANSFERIR_SEGURO.operacao) {
						
						break;
					} else if(opcao == MenuOperacoes.CALCULAR_RECEITA.operacao) {
						
						break;
					} else if(opcao == MenuOperacoes.SAIR.operacao) {
						break;
					}
										
					/*	
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
						}*/
					}while(opcao != 6);
					
				}

			
			
	

	}

}
=======
			
			
			// Adicionando alguns dos Clientes, Seguradoras, Sinistros e Veiculos acima para ter listas a serem exibidas no Menu Operacoes
			listaClientesTotal.add(c1);
			listaClientesTotal.add(c2);
			listaClientesTotal.add(c3);
			listaClientesTotal.add(c4);
			listaSeguradoraTotal.add(seg1);
			listaSinistroTotal.add(s1);
			Sinistro s2 = new Sinistro(dataS2, "Brasília", seg1,carro2C3, c3);
			Sinistro s3 = new Sinistro(dataS3, "Campinas-SP", seg1,carro1C1, c1);
			Sinistro s4 = new Sinistro(dataS4, "SP", seg1,carro1C2, c1);
			listaSinistroTotal.add(s2);
			listaSinistroTotal.add(s3);
			listaSinistroTotal.add(s4);
			listaVeiculoTotal.add(carro1C4);
			listaVeiculoTotal.add(carro1C1);
			listaVeiculoTotal.add(carro2C1);
			listaVeiculoTotal.add(carro1C2);
			listaVeiculoTotal.add(carro1C3);
			
			// Menu de Operacoes
			Menu.menuOperacoes(listaClientesTotal, listaSeguradoraTotal,listaSinistroTotal ,listaVeiculoTotal);

			
	}}
>>>>>>> working
