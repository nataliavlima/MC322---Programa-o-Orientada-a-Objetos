package lab4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/* ERROS:
 * ver a lista de veiculo vinculado a um cliente
 * testar listar clientes por seguradora
 * arrumar opcao de voltar
 * nao funcionou listar sinistros por clientes 
 */

public class Menu {
	public static List<Cliente> fazer_cadastro_cliente(List<Cliente> listaClientesTotal) throws ParseException{
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		Scanner usuario = new Scanner(System.in);
		String tipoCliente;
		
		String nomeCliente;
		String endereco;
		ArrayList<Veiculo> listaVeiculo= new ArrayList<Veiculo>();
		ArrayList<Veiculo> listaVeiculoInicial =  new ArrayList<Veiculo>();
		
		String cpfCliente;
		String genero;
		String dataLicencaString;
		String educacao;
		String dataNascimentoString;
		String classeEconomica;
		
		String cnpj;
		String dataFundacaoString;
		int qtdFuncionarios;
		
		System.out.println("Qual tipo de cliente você deseja cadastrar?\n Digite 'PF' para Cliente Pessoa Física ou 'PJ' para Cliente Pessoa Jurídica\n");
		tipoCliente =  usuario.nextLine(); 
		
		if(tipoCliente.equals("PF")) {
			System.out.println("Digite o nome do cliente: ");
			nomeCliente = usuario.nextLine();   // Recebe o que o usuario digitou e insere na variavel respectiva
			
			System.out.println("Digite o endereço do cliente: ");
			endereco = usuario.nextLine();
			
			System.out.println("Vamos cadastrar o(s) veiculo(s) do cliente: ");
			listaVeiculo = fazer_cadastro_veiculo(listaVeiculoInicial); 
			
			System.out.println("Digite o CPF do cliente: ");
			cpfCliente = usuario.nextLine();
			
			System.out.println("Digite a data de nascimento do cliente: ");
			dataNascimentoString = usuario.nextLine();
			Date dataNascimento = formato.parse(dataNascimentoString);
			
			System.out.println("Digite a data de licença do cliente: ");
			dataLicencaString = usuario.nextLine();
			Date dataLicenca = formato.parse(dataLicencaString);
			
			System.out.println("Digite a escolaridade do cliente: ");
			educacao = usuario.nextLine();
			
			System.out.println("Digite o gênero do cliente: ");
			genero = usuario.nextLine();
			
			System.out.println("Digite a classe econômica do cliente: ");
			classeEconomica = usuario.nextLine();
			usuario.nextLine();// limpa o scanner
			
			ClientePF c1 = new ClientePF(nomeCliente,endereco,listaVeiculo, cpfCliente, dataNascimento,dataLicenca, educacao, genero, classeEconomica); 
			listaClientesTotal.add(c1);
			System.out.println("\nDados cadastrados do cliente: \n");
			System.out.println(c1.toString());
		}
		else if(tipoCliente.equals("PJ")) {
			System.out.println("Digite o nome do cliente: ");
			nomeCliente = usuario.nextLine();   // Recebe o que o usuario digitou e insere na variavel respectiva
			
			System.out.println("Digite o endereço do cliente: ");
			endereco = usuario.nextLine();
			
			System.out.println("Vamos cadastrar o(s) veiculo(s) do cliente: ");
			listaVeiculo = fazer_cadastro_veiculo(listaVeiculo); 
			
			System.out.println("Digite o CPF do cliente: ");
			cnpj = usuario.nextLine();
			
			System.out.println("Digite a data de nascimento do cliente: ");
			dataFundacaoString = usuario.nextLine();
			Date dataFundacao = formato.parse(dataFundacaoString);
			
			System.out.println("Digite a escolaridade do cliente: ");
			qtdFuncionarios = usuario.nextInt();
			usuario.nextLine();// limpa o scanner
			
			ClientePJ c2 = new ClientePJ(nomeCliente,endereco,listaVeiculo, cnpj, dataFundacao,qtdFuncionarios); 
			listaClientesTotal.add(c2);
			System.out.println("\nDados cadastrados do cliente: \n");
			System.out.println(c2.toString());
		}
		
		return listaClientesTotal;
	}
	public static ArrayList<Veiculo> fazer_cadastro_veiculo(ArrayList<Veiculo> listaVeiculoTotal) {
		String placa; 
		String marca;
		String modelo;
		int anoFabricacao;
		Scanner usuario = new Scanner(System.in);
		
		System.out.println("Digite a placa do veículo: ");
		placa = usuario.nextLine();   // Recebe o que o usuario digitou e insere na variavel respectiva
		
		System.out.println("Digite a marca do veículo: ");
		marca = usuario.nextLine();
		
		System.out.println("Digite o modelo do veículo:");
		modelo = usuario.nextLine();
		
		System.out.println("Digite o ano de fabricação: ");
		anoFabricacao = usuario.nextInt();
		//usuario.nextLine();// limpa o scanner
		
		Veiculo v1 = new Veiculo(placa,marca, modelo, anoFabricacao);
		listaVeiculoTotal.add(v1);
		
		System.out.println("\nDados cadastrados do veículo: \n");
		System.out.println(v1.toString());
		/*
		System.out.println("\nDeseja cadastrar outro veículo? Digite '1' para Sim e '2' para Não");
		int resposta = usuario.nextInt();
		if(resposta == 1) {
			fazer_cadastro_veiculo(listaVeiculoTotal);
		}
		*/
		return listaVeiculoTotal;
	}
	
	
	public static List<Seguradora>  fazer_cadastro_seguradora(List<Seguradora> listaSeguradoraTotal) {
		Scanner usuario = new Scanner(System.in);
		String nome;
		String telefone;
		String email;
		String endereco;
		
		System.out.println("Digite o nome da seguradora: ");
		nome = usuario.nextLine();   // Recebe o que o usuario digitou e insere na variavel respectiva
		
		System.out.println("Digite o telefone da seguradora: ");
		telefone = usuario.nextLine();
		
		System.out.println("Digite o email da seguradora:");
		email = usuario.nextLine();
		
		System.out.println("Digite o endereço da seguradora: ");
		endereco = usuario.nextLine();
		usuario.nextLine();// limpa o scanner
		
		Seguradora s1 = new Seguradora(nome, telefone, email, endereco);
		listaSeguradoraTotal.add(s1);
		return listaSeguradoraTotal;
	}
	

	public static List<Cliente>  fazer_lista_cliente_seg(List<Seguradora> listaSeguradoraTotal) {
		Scanner usuario = new Scanner(System.in);
		System.out.println("Qual o nome da seguradora?");	
		String nomeSeg = usuario.nextLine();
		
		
		List<Cliente> listarClientesSeg = new ArrayList<Cliente>();
			for(Seguradora seguradora1 : listaSeguradoraTotal ) { 
				
				String nomeSeguradora = seguradora1.getNome();
				if(nomeSeguradora.equals(nomeSeg)) {
					listarClientesSeg = seguradora1.getListaClientes();	
					}
			}
			System.out.println(listarClientesSeg);
			return listarClientesSeg;
	}

	public static List<Sinistro>  fazer_lista_sinistro_cli(List<Sinistro> listaSinistroTotal) {
		Scanner usuario = new Scanner(System.in);
		System.out.println("Qual o nome do cliente?");	
		String nomeCli = usuario.nextLine();
		
		
		List<Sinistro> listarSinistrosCli = new ArrayList<Sinistro>();
			for(Sinistro sinistro1 : listarSinistrosCli ) { 
				
				String nomeSinistro = sinistro1.getCliente().getNome();
				if(nomeSinistro.equals(nomeCli)) {
					listarSinistrosCli.add(sinistro1);	
					}
			}
			System.out.println(listarSinistrosCli);
			return listarSinistrosCli;
	}/*

	public static void fazer_lista_sinistro_seg() {
		
	}
	

	public static void fazer_lista_veiculo_cli() {
		
	}

	public static void fazer_lista_veiculo_seg() {
		
	}
	public static void excluir_cliente() {
		
	}

	public static void excluir_veiculo() {
		
	}

	public static void excluir_sinsitro() {
		
	}
	*/
	
	public static void fazer_cadastro(List<Cliente> listaClientesTotal, List<Seguradora> listaSeguradoraTotal,ArrayList<Veiculo> listaVeiculoTotal) throws ParseException {
		
		String opcao1;
		int opcaoVoltar = 0;
		
		
		String tipoCliente;
		try (Scanner usuario = new Scanner(System.in)) {
			
			// Menu para Cadastro
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("O que você deseja cadastrar? \nDigite exatamente igual a opção descrita\n");
			System.out.println("Cadastrar cliente");
			System.out.println("Cadastrar veiculo");
			System.out.println("Cadastrar seguradora");
			System.out.println("Voltar");
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("\n");
		
		// Selecao do usuario
			System.out.println("Opção selecionada: ");
			opcao1 = usuario.nextLine();
			usuario.nextLine();// limpa o scanner
			
		do {
		if(opcao1.equals(Operacoes.CADASTRAR_CLIENTE.operacao)) {
			fazer_cadastro_cliente(listaClientesTotal);
			break;
		} else if(opcao1.equals(Operacoes.CADASTRAR_VEICULO.operacao)) {
			fazer_cadastro_veiculo(listaVeiculoTotal);
			break;
		} else if(opcao1.equals(Operacoes.CADASTRAR_SEGURADORA.operacao)) {
			fazer_cadastro_seguradora(listaSeguradoraTotal);
			
			break;
		
		} else if(opcao1.equals(Operacoes.VOLTAR.operacao)) {
			opcaoVoltar = 1;
			break;
		}
		} while(opcaoVoltar != 1);
		}

	}
	public static void fazer_lista(List<Cliente> listaClientesTotal, List<Seguradora> listaSeguradoraTotal,List<Sinistro> listaSinistroTotal, ArrayList<Veiculo> listaVeiculoTotal) {
		
	
		//String opcao1 = operacao.getOperacao();
		String opcao1;
		int opcaoVoltar = 0;
		
		
		try (Scanner usuario = new Scanner(System.in)) {
			
			// Menu para Cadastro
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("O que você deseja listar? \nDigite exatamente igual a opção descrita\n");
			System.out.println("Listar clientes por seguradora");
			System.out.println("Listar sinistros por seguradoras");
			System.out.println("Listar sinistros por clientes");
			System.out.println("Listar veículo por clientes");
			System.out.println("Listar veículo por seguradora");
			System.out.println("Voltar");
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("\n");
		
		// Selecao do usuario
			System.out.println("Opção selecionada: ");
			opcao1 = usuario.nextLine();
			usuario.nextLine();// limpa o scanner
			
		do {
		if(opcao1.equals(Operacoes.LISTAR_CLIENTE.operacao)) {
			fazer_lista_cliente_seg(listaSeguradoraTotal);
			break;
			//System.out.println(seg1.listarClientes(tipoCliente));
			
		} 
		else if(opcao1.equals(Operacoes.LISTAR_SINISTROS_CLI.operacao)) {
			fazer_lista_sinistro_cli(listaSinistroTotal);
			
			break;
			
		}/*else if(opcao1.equals(Operacoes.LISTAR_SINISTROS_SEG.operacao)) {
			fazer_lista_sinistro_seg();
			break;
			
		}else if(opcao1.equals(Operacoes.LISTAR_VEICULO_CLI.operacao)) {
			fazer_lista_veiculo_cli();
			break;
			
		}else if(opcao1.equals(Operacoes.LISTAR_VEICULO_SEG.operacao)) {
			fazer_lista_veiculo_seg();
			break;
			
		}else if(opcao1.equals(Operacoes.VOLTAR.operacao)) {
			opcaoVoltar = 1;
			break;
		}
			*/
		} while(opcaoVoltar != 1);
		}

	}/*
	public static void excluir() {
		
		String opcao1;
		int opcaoVoltar = 0;
		
		
		try (Scanner usuario = new Scanner(System.in)) {
			
			// Menu para Cadastro
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("O que você deseja excluir? \nDigite exatamente igual a opção descrita\n");
			System.out.println("Excluir cliente");
			System.out.println("Excluir veículo");
			System.out.println("Excluir sinistro");
			System.out.println("Voltar");
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("\n");
		
		// Selecao do usuario
			System.out.println("Opção selecionada: ");
			opcao1 = usuario.nextLine();
			usuario.nextLine();// limpa o scanner
		
		do {
		if(opcao1.equals(Operacoes.EXCLUIR_CLIENTE.operacao)) {
			excluir_cliente();
			break;
			
		} else if(opcao1.equals(Operacoes.EXCLUIR_VEICULO.operacao)) {
			excluir_veiculo();
			
			break;
			
		}else if(opcao1.equals(Operacoes.EXCLUIR_SINISTRO.operacao)) {
			excluir_sinsitro();
			break;
			
					
		}else if(opcao1.equals(Operacoes.VOLTAR.operacao)) {
			opcaoVoltar = 1;
			break;
		}
			
		} while(opcaoVoltar != 1);
		}

	}*/
	public static void menuOperacoes(List<Cliente> listaClientesTotal, List<Seguradora> listaSeguradoraTotal, List<Sinistro> listaSinistroTotal,	ArrayList<Veiculo> listaVeiculoTotal) throws ParseException {
		// Menu de Operações
		
		int opcao = 0;
		//Operacoes opcao2;
		
		
		try (Scanner usuario = new Scanner(System.in)) {
			
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
					
					fazer_cadastro(listaClientesTotal, listaSeguradoraTotal ,listaVeiculoTotal);
						break;
				} else if(opcao == MenuOperacoes.LISTAR.operacao) {
					fazer_lista(listaClientesTotal, listaSeguradoraTotal, listaSinistroTotal,listaVeiculoTotal);
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
