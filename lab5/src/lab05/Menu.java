package lab05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



public class Menu {
	public static ArrayList<Cliente> fazer_cadastro_cliente(ArrayList<Cliente> listaClientesTotal) throws ParseException{
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		Scanner usuario = new Scanner(System.in);
		String tipoCliente;
		
		String nomeCliente;
		String telefone;
		String endereco;
		String email;
		ArrayList<Veiculo> listaVeiculo= new ArrayList<Veiculo>();
		ArrayList<Veiculo> listaVeiculoInicial =  new ArrayList<Veiculo>();
		ArrayList<Frota> listaFrota = new ArrayList<Frota>();
		
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
			
			System.out.println("Digite o telefone do cliente: ");
			telefone = usuario.nextLine();
			
			System.out.println("Digite o email do cliente: ");
			email = usuario.nextLine();
			
			System.out.println("Digite o endereço do cliente: ");
			endereco = usuario.nextLine();
			
			System.out.println("Vamos cadastrar o(s) veiculo(s) do cliente: ");
			listaVeiculo.add(fazer_cadastro_veiculo(listaVeiculoInicial)); 
			
			System.out.println("Digite o CPF do cliente: ");
			cpfCliente = usuario.nextLine();
			
			System.out.println("Qual a data de nascimento do cliente? Digite no formato dia/mês/ano");
			dataNascimentoString = usuario.nextLine();
			Date dataNascimento = formato.parse(dataNascimentoString);
			
			System.out.println("Digite a escolaridade do cliente: ");
			educacao = usuario.nextLine();
			
			System.out.println("Digite o gênero do cliente: ");
			genero = usuario.nextLine();
			usuario.nextLine();// limpa o scanner
			
			ClientePF c1 = new ClientePF(nomeCliente, telefone, endereco, email, cpfCliente, dataNascimento, educacao, genero); 
			c1.setListaVeiculo(listaVeiculo);
			listaClientesTotal.add(c1);
			System.out.println("\nDados cadastrados do cliente: \n");
			System.out.println(c1.toString());
		}
		else if(tipoCliente.equals("PJ")) {
			System.out.println("Digite o nome do cliente: ");
			nomeCliente = usuario.nextLine();   // Recebe o que o usuario digitou e insere na variavel respectiva
			
			System.out.println("Digite o telefone do cliente: ");
			telefone = usuario.nextLine();
			
			System.out.println("Digite o endereço do cliente: ");
			endereco = usuario.nextLine();
			
			System.out.println("Digite o email do cliente: ");
			email = usuario.nextLine();
			
			System.out.println("Vamos cadastrar a(s) frotas(s) do cliente: ");
			listaFrota.add(fazer_cadastro_frota(listaFrota)); 
			
			System.out.println("Digite o CNPJ do cliente: ");
			cnpj = usuario.nextLine();
			
			System.out.println("Digite a data de fundação do cliente: ");
			dataFundacaoString = usuario.nextLine();
			Date dataFundacao = formato.parse(dataFundacaoString);
			
			System.out.println("Digite a quantidade de funcionários do cliente: ");
			qtdFuncionarios = usuario.nextInt();
			usuario.nextLine();// limpa o scanner
			
			ClientePJ c2 = new ClientePJ(nomeCliente, telefone, endereco, email, cnpj, dataFundacao); 
			c2.setListaFrota(listaFrota);
			listaClientesTotal.add(c2);
			System.out.println("\nDados cadastrados do cliente: \n");
			System.out.println(c2.toString());
		}
		
		return listaClientesTotal;
	}
	public static Veiculo fazer_cadastro_veiculo(ArrayList<Veiculo> listaVeiculoTotal) {
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
		
		return v1;
	}
	
	
	public static Frota fazer_cadastro_frota(ArrayList<Frota> listaFrotaTotal) {
		String code; 
		ArrayList<Veiculo> listaVeiculo= new ArrayList<Veiculo>();
		ArrayList<Veiculo> listaVeiculoInicial =  new ArrayList<Veiculo>();
		Scanner usuario = new Scanner(System.in);
		
		System.out.println("Digite o código da frota: ");
		code = usuario.nextLine();   // Recebe o que o usuario digitou e insere na variavel respectiva
		
		System.out.println("Vamos cadastrar o(s) veiculo(s) do cliente: ");
		listaVeiculo.add(fazer_cadastro_veiculo(listaVeiculoInicial)); 
		
		Frota frota = new Frota(code);
		frota.setListaVeiculo(listaVeiculo);
		listaFrotaTotal.add(frota);
		
		return frota;
	}
	
	public static Condutor fazer_cadastro_condutor(ArrayList<Condutor> listaCondutorTotal) throws ParseException{
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		Scanner usuario = new Scanner(System.in);
		
		String nomeCondutor;
		String telefone;
		String endereco;
		String email;		
		String cpf;
		String dataNascimentoString;
		
		
		System.out.println("Digite o CPF do cliente: ");
		cpf = usuario.nextLine();
		
		System.out.println("Digite o nome do condutor: ");
		nomeCondutor = usuario.nextLine();   // Recebe o que o usuario digitou e insere na variavel respectiva
		
		System.out.println("Digite o telefone do cliente: ");
		telefone = usuario.nextLine();
		
		System.out.println("Digite o endereço do cliente: ");
		endereco = usuario.nextLine();
		
		System.out.println("Digite o email do cliente: ");
		email = usuario.nextLine();
		
		System.out.println("Qual a data de nascimento do cliente? Digite no formato dia/mês/ano");
		dataNascimentoString = usuario.nextLine();
		Date dataNascimento = formato.parse(dataNascimentoString);
		
		usuario.nextLine();// limpa o scanner
		
		Condutor c1 = new Condutor(cpf, nomeCondutor, telefone, endereco, email, dataNascimento); 
		listaCondutorTotal.add(c1);
		System.out.println("\nDados cadastrados do condutor: \n");
		System.out.println(c1.toString());
		
		return c1;
		}
	
	public static ArrayList<Seguradora>  fazer_cadastro_seguradora(ArrayList<Seguradora> listaSeguradoraTotal) {
		Scanner usuario = new Scanner(System.in);
		String cnpj;
		String nome;
		String telefone;
		String email;
		String endereco;
		
		System.out.println("Digite o cnpj da seguradora: ");
		cnpj = usuario.nextLine();   // Recebe o que o usuario digitou e insere na variavel respectiva
		
		System.out.println("Digite o nome da seguradora: ");
		nome = usuario.nextLine();   
		
		System.out.println("Digite o telefone da seguradora: ");
		telefone = usuario.nextLine();
		
		System.out.println("Digite o email da seguradora:");
		email = usuario.nextLine();
		
		System.out.println("Digite o endereço da seguradora: ");
		endereco = usuario.nextLine();
		usuario.nextLine();// limpa o scanner
		
		Seguradora s1 = new Seguradora(cnpj, nome, telefone, email, endereco);
		listaSeguradoraTotal.add(s1);
		return listaSeguradoraTotal;
	}
	
	// CADASTRAR CONDUTOR

	public static ArrayList<Cliente>  fazer_lista_cliente_seg(ArrayList<Seguradora> listaSeguradoraTotal) {
		//System.out.println(listaSeguradoraTotal);
		
		Scanner usuario = new Scanner(System.in);
		System.out.println("Qual o nome da seguradora?");	
		String nomeSeg = usuario.nextLine();
		
		
		ArrayList<Cliente> listarClientesSeg = new ArrayList<Cliente>();
			for(Seguradora seguradora1 : listaSeguradoraTotal ) { 
				
				String nomeSeguradora = seguradora1.getNome();
				if(nomeSeguradora.equals(nomeSeg)) {
					listarClientesSeg = seguradora1.getListaClientes();	
					}
			}
			System.out.println(listarClientesSeg);
			return listarClientesSeg;
	}
	/*
	public static ArrayList<Sinistro>  fazer_lista_sinistro_cli(ArrayList<Sinistro> listaSinistroTotal, String nomeCondutor) {
			
		ArrayList<Sinistro> listarSinistrosCli = new ArrayList<Sinistro>();
			for(Sinistro sinistro1 : listaSinistroTotal ) { 
				
				String nomeSinistro = sinistro1.getCondutor().getNome();
				if(nomeSinistro.equals(nomeCondutor)) {
					listarSinistrosCli.add(sinistro1);	
					return listarSinistrosCli;
					}
			}
			//System.out.println(listarSinistrosCli);
			return listarSinistrosCli;
	}*/
	
	public static ArrayList<Sinistro>  fazer_lista_sinistro_seguro(ArrayList<Sinistro> listaSinistroTotal) {
		
		Scanner usuario = new Scanner(System.in);
		System.out.println("Qual o ID do Seguro?");	
		String nomeSeg = usuario.nextLine();
		
		
		ArrayList<Sinistro> listarSinistrosSeg = new ArrayList<Sinistro>();
			for(Sinistro sinistro1 : listaSinistroTotal ) { 
				
				int idSinistro = sinistro1.getId();
				if(idSinistro == sinistro1.getId()) {
					listarSinistrosSeg.add(sinistro1);	
					}
			}
			System.out.println(listarSinistrosSeg);
			return listarSinistrosSeg;
	}
	
	
	public static ArrayList<Seguro> fazer_lista_seguros_cli(ArrayList<Seguradora> listaSeguradoraTotal) {
		Scanner usuario = new Scanner(System.in);
		ArrayList<Seguro> listaSeguroCli = new ArrayList<Seguro>();
		
		System.out.println("Digite o número da seguradora do seu cliente:");
		for(int i = 0; i < listaSeguradoraTotal.size(); i++) {
			System.out.println(i + ": " + listaSeguradoraTotal.get(i).getNome());
		}
		
		int segNum = usuario.nextInt();
		Seguradora seguradora1 = listaSeguradoraTotal.get(segNum); // seleciona a seguradora pelo index digitado
		
		usuario.nextLine();// limpa o scanner
		System.out.println("Digite o nome do cliente que você deseja listar os seguros:");
		String nomeCli = usuario.nextLine();
		
		listaSeguroCli = seguradora1.getSegurosPorCliente(nomeCli);
		System.out.println(listaSeguroCli);
			return listaSeguroCli;
	}
	
	public static ArrayList<Seguro>  fazer_lista_seguros_seg(ArrayList<Seguradora> listaSeguradoraTotal) {
		ArrayList<Seguro> listaSeguroSeg = new ArrayList<Seguro>();
		Scanner usuario = new Scanner(System.in);
		System.out.println("Digite o número da seguradora do seu cliente:");
		for(int i = 0; i < listaSeguradoraTotal.size(); i++) {
			System.out.println(i + ": " + listaSeguradoraTotal.get(i).getNome());
		}
		int segNum = usuario.nextInt();
		Seguradora seguradora1 = listaSeguradoraTotal.get(segNum); // seleciona a seguradora pelo index digitado
		listaSeguroSeg = seguradora1.getListaSeguro();
		System.out.println(listaSeguroSeg);
			return listaSeguroSeg;
	}
	
	public static ArrayList<Sinistro>  fazer_lista_sinistro_seg(ArrayList<Seguradora> listaSeguradoraTotal) {
		ArrayList<Sinistro> listaSinistroSeg = new ArrayList<Sinistro>();
		Scanner usuario = new Scanner(System.in);
		System.out.println("Digite o número da seguradora do seu cliente:");
		for(int i = 0; i < listaSeguradoraTotal.size(); i++) {
			System.out.println(i + ": " + listaSeguradoraTotal.get(i).getNome());
		}
		
		int segNum = usuario.nextInt();
		Seguradora seguradora1 = listaSeguradoraTotal.get(segNum); // seleciona a seguradora pelo index digitado
		listaSinistroSeg = seguradora1.getListaSinistros();
		System.out.println(listaSinistroSeg);
			return listaSinistroSeg;
	}
	
	
	
	// funcao de transformar uma string em int[]
		 public static int[] transformaInt(String string) {
			// retirar todos os caracteres nao numeros
			 string = string.replaceAll("[^0-9]+", "");
				
				// transforma em um vetor de int
				char[] arrayString = string.toCharArray();        // pega a string e escreve como array
				int[] stringInt = new int[arrayString.length];    // declara um vetor de int 
				
				for (int i = 0; i < arrayString.length; i++) {
					stringInt[i] = Integer.parseInt(string.substring(i, i+1));  // adiciona numero por numero convertido no vetor de int
				}
				return stringInt;
		 }
	
	public static ArrayList<Cliente> excluir_cliente(ArrayList<Cliente> listaClientesTotal) {
		Scanner usuario = new Scanner(System.in);
		
		System.out.println("Digite o numero do documento do cliente que deseja excluir: ");	
		String documento = usuario.nextLine();
		
		int[] DocumentoInt = transformaInt(documento);	
		for(Cliente cliente : listaClientesTotal) {  // percorre toda a lista de clientes 
	
			// Documento com 11 digitos =  cpf (Pessoa fisica)
			if(DocumentoInt.length == 11){  
				if(cliente instanceof ClientePF) { 										// Declara que o Cliente pertence a essa classe filha
					if(((ClientePF) cliente).getCpf().equals(documento)){
						listaClientesTotal.remove(cliente); 									 // se o cpf pertence a lista com os cliente PF, ele remove
						System.out.println("Cliente removido com sucesso!\n");
						System.out.println(listaClientesTotal);
						return listaClientesTotal;
					}
				}
			}
			// Documento com 14 digitos =  cnpj (Pessoa juridica)
			else if(DocumentoInt.length == 14){
				if(cliente instanceof ClientePJ) {
					if(((ClientePJ) cliente).getCnpj().equals(documento)) {
						listaClientesTotal.remove(cliente);  // remove
						System.out.println("Cliente removido com sucesso!\n");
						System.out.println(listaClientesTotal);
						return listaClientesTotal;
					}
				}
			}
			else { // se nao tem nem 11 nem 14 numeros = documento invalido
				System.out.println("Não foi possível efetuar a remoção!\n");
			
			}	
		}
			
		return listaClientesTotal;
	}
		
		
	public static ArrayList<Veiculo> excluir_veiculo(ArrayList<Veiculo> listaVeiculoTotal) {
		Scanner usuario = new Scanner(System.in);
		
		System.out.println("Qual a placa do veículo que você deseja excluir?");	
		String placa = usuario.nextLine();
		
		
		for(Veiculo veiculo1: listaVeiculoTotal) {
			String placaVeiculo = veiculo1.getPlaca();
					
			if(placaVeiculo.equals(placa)) {
				listaVeiculoTotal.remove(veiculo1);	
				System.out.println(listaVeiculoTotal);
				return listaVeiculoTotal;
				}
		}
		
		return listaVeiculoTotal;
	}

	public static ArrayList<Sinistro> excluir_sinistro(ArrayList<Sinistro> listaSinistroTotal) {
		Scanner usuario = new Scanner(System.in);
		
		System.out.println("Qual o ID que você deseja excluir?");	
		int id = usuario.nextInt();
		
		
		for(Sinistro sinistro1 : listaSinistroTotal) {
			int idSinistro = sinistro1.getId();
					
			if(idSinistro == id) {
				listaSinistroTotal.remove(sinistro1);	
				System.out.println(listaSinistroTotal);
				return listaSinistroTotal;
				}
		}
		
		return listaSinistroTotal;
	}
	
	public static ArrayList<Seguro> excluir_seguro(ArrayList<Seguro> listaSeguroTotal) {
		Scanner usuario = new Scanner(System.in);
		
		System.out.println("Qual o ID que você deseja excluir?");	
		int id = usuario.nextInt();
		
		
		for(Seguro seguro1 : listaSeguroTotal) {
			int idSeguro = seguro1.getId();
					
			if(idSeguro == id) {
				listaSeguroTotal.remove(seguro1);	
				System.out.println(listaSeguroTotal);
				return listaSeguroTotal;
				}
		}
		
		return listaSeguroTotal;
	}
	
	public static void fazer_cadastro(ArrayList<Condutor> listaCondutorTotal, ArrayList<Seguro> listaSeguroTotal,ArrayList<Frota> listaFrotaTotal  ,ArrayList<Cliente> listaClientesTotal, ArrayList<Seguradora> listaSeguradoraTotal,ArrayList<Sinistro> listaSinistroTotal,ArrayList<Veiculo> listaVeiculoTotal) throws ParseException {
		
		String opcao1;
		int opcaoVoltar = 0;
		
		
		String tipoCliente;
		try (Scanner usuario = new Scanner(System.in)) {
			
			// Menu para Cadastro
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("O que você deseja cadastrar? \nDigite o número da opção descrita\n");
			System.out.println("1.1: Cadastrar cliente");
			System.out.println("1.2: Cadastrar veiculo");
			System.out.println("1.3: Cadastrar frota");
			System.out.println("1.4: Cadastrar seguradora");
			System.out.println("1.5: Cadastrar condutor");
			System.out.println("0: Voltar");
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("\n");
		
			
			
		// Selecao do usuario
			System.out.println("Opção selecionada: ");
			opcao1 = usuario.nextLine();
			usuario.nextLine();// limpa o scanner
			
		do {
		if(opcao1.equals(Operacoes.CADASTRAR_CLIENTE.operacao)) {
			listaClientesTotal = fazer_cadastro_cliente(listaClientesTotal);
			break;
		} else if(opcao1.equals(Operacoes.CADASTRAR_VEICULO.operacao)) {
			Veiculo veiculo = fazer_cadastro_veiculo(listaVeiculoTotal);
			break;
			
		} else if(opcao1.equals(Operacoes.CADASTRAR_FROTA.operacao)) {
			Frota frota = fazer_cadastro_frota(listaFrotaTotal);
			break;
			
		} else if(opcao1.equals(Operacoes.CADASTRAR_SEGURADORA.operacao)) {
			listaSeguradoraTotal = fazer_cadastro_seguradora(listaSeguradoraTotal);
			break;
		
		} else if(opcao1.equals(Operacoes.CADASTRAR_CONDUTOR.operacao)) {
			Condutor condutor = fazer_cadastro_condutor(listaCondutorTotal);
			break;
		
		} else if(opcao1.equals(Operacoes.VOLTAR.operacao)) {
			opcaoVoltar = 1;
			menuOperacoes(listaCondutorTotal, listaSeguroTotal,listaFrotaTotal, listaClientesTotal,listaSeguradoraTotal,listaSinistroTotal,listaVeiculoTotal);
			break;
			}
		} while(opcaoVoltar != 1);}

	}
	
	public static void fazer_lista(ArrayList<Condutor> listaCondutorTotal, ArrayList<Seguro> listaSeguroTotal,ArrayList<Frota> listaFrotaTotal  ,ArrayList<Cliente> listaClientesTotal, ArrayList<Seguradora> listaSeguradoraTotal,ArrayList<Sinistro> listaSinistroTotal,ArrayList<Veiculo> listaVeiculoTotal) throws ParseException {
		String opcao1;
		int opcaoVoltar = 0;
		
		
		try (Scanner usuario = new Scanner(System.in)) {
			
			// Menu para Cadastro
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("O que você deseja listar? \nDigite o número da opção descrita\n");
			System.out.println("2.1: Listar clientes por seguradora");
			System.out.println("2.2: Listar seguros por cliente");
			System.out.println("2.3: Listar seguros por seguradora");
			System.out.println("2.4: Listar sinistros por seguradora");
			System.out.println("2.5: Listar sinistros por seguro");
			System.out.println("0: Voltar");
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
			
		} else if(opcao1.equals(Operacoes.LISTAR_SEGUROS_CLI.operacao)) {
			fazer_lista_seguros_cli(listaSeguradoraTotal);
			break;
		} else if(opcao1.equals(Operacoes.LISTAR_SEGUROS_SEG.operacao)) {
			fazer_lista_seguros_seg(listaSeguradoraTotal);
			break;
		} else if(opcao1.equals(Operacoes.LISTAR_SINISTROS_SEG.operacao)) {
			fazer_lista_sinistro_seg(listaSeguradoraTotal);
			break;
		} else if(opcao1.equals(Operacoes.LISTAR_SINISTROS_SEGURO.operacao)) {
			fazer_lista_sinistro_seguro(listaSinistroTotal);
			break;
		} else if(opcao1.equals(Operacoes.VOLTAR.operacao)) {
			opcaoVoltar = 1;
			menuOperacoes(listaCondutorTotal, listaSeguroTotal,listaFrotaTotal, listaClientesTotal,listaSeguradoraTotal,listaSinistroTotal,listaVeiculoTotal);
			break;
			}
		} while(opcaoVoltar != 1);
	}
	}
	public static void excluir(ArrayList<Condutor> listaCondutorTotal, ArrayList<Seguro> listaSeguroTotal,ArrayList<Frota> listaFrotaTotal  ,ArrayList<Cliente> listaClientesTotal, ArrayList<Seguradora> listaSeguradoraTotal,ArrayList<Sinistro> listaSinistroTotal,ArrayList<Veiculo> listaVeiculoTotal)  throws ParseException{
		
		String opcao1;
		int opcaoVoltar = 0;
		
		
		try (Scanner usuario = new Scanner(System.in)) {
			
			// Menu para Cadastro
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("O que você deseja excluir? \nDigite o número da opção descrita\n");
			System.out.println("3.1: Excluir cliente");
			System.out.println("3.2: Excluir veículo");
			System.out.println("3.3: Excluir sinistro");
			System.out.println("3.3: Excluir seguro");
			System.out.println("0: Voltar");
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("\n");
		
		// Selecao do usuario
			System.out.println("Opção selecionada: ");
			opcao1 = usuario.nextLine();
			usuario.nextLine();// limpa o scanner
		
		do {
		if(opcao1.equals(Operacoes.EXCLUIR_CLIENTE.operacao)) {
			listaClientesTotal = excluir_cliente(listaClientesTotal);
			break;
			
		} else if(opcao1.equals(Operacoes.EXCLUIR_VEICULO.operacao)) {
			listaVeiculoTotal = excluir_veiculo(listaVeiculoTotal);
			break;
			
		}else if(opcao1.equals(Operacoes.EXCLUIR_SINISTRO.operacao)) {
			listaSinistroTotal = excluir_sinistro(listaSinistroTotal);
			break;
		}else if(opcao1.equals(Operacoes.EXCLUIR_SEGURO.operacao)) {
			listaSeguroTotal = excluir_seguro(listaSeguroTotal);
			break;	
					
		}else if(opcao1.equals(Operacoes.VOLTAR.operacao)) {
			opcaoVoltar = 1;
			menuOperacoes(listaCondutorTotal, listaSeguroTotal,listaFrotaTotal,listaClientesTotal,listaSeguradoraTotal,listaSinistroTotal,listaVeiculoTotal);
			break;
		}
			
		} while(opcaoVoltar != 1);
		}

	}
	
	
	

	public static void calculo_receita_seguradora(ArrayList<Seguradora> listaSeguradoraTotal) {
		Scanner usuario = new Scanner(System.in);
		
		System.out.println("Digite o número da seguradora você deseja calcular a receita?");
		for(int i = 0; i < listaSeguradoraTotal.size(); i++) {
			System.out.println(i + ": " + listaSeguradoraTotal.get(i).getNome());
		}
		int segNum = usuario.nextInt();
		Seguradora seg = listaSeguradoraTotal.get(segNum); // seleciona a seguradora pelo index digitado
		double receita = seg.calcularReceita();
		System.out.println("A receita da seguradora" + seg.getNome() + " foi de R$" + receita);
		
	}
	
	
	
	public static void menuOperacoes(ArrayList<Condutor> listaCondutorTotal, ArrayList<Seguro> listaSeguroTotal,ArrayList<Frota> listaFrotaTotal  ,ArrayList<Cliente> listaClientesTotal, ArrayList<Seguradora> listaSeguradoraTotal,ArrayList<Sinistro> listaSinistroTotal,ArrayList<Veiculo> listaVeiculoTotal) throws ParseException {
		// Menu de Operações
		
		int opcao = 0;
		//Operacoes opcao2;
		
		
		try (Scanner usuario = new Scanner(System.in)) {
			while(true) {
			
			// Menu para Cadastro
				System.out.println("------------------------------------------------------------------");
				System.out.println("Digite... ");
				System.out.println("1: Para CADASTROS ");
				System.out.println("2: Para LISTAR");
				System.out.println("3: Para EXCLUIR");
				System.out.println("4: Para CALCULAR RECEITA SEGURADORA");
				System.out.println("5: Para SAIR");
				System.out.println("------------------------------------------------------------------");
				System.out.println("\n");
			
			// Selecao do usuario
				System.out.println("Opção selecionada: ");
				opcao = usuario.nextInt();
				usuario.nextLine();// limpa o scanner
				
				if (opcao == MenuOperacoes.CADASTRAR.operacao) { // listar Clientes cadastrados
					
					fazer_cadastro(listaCondutorTotal, listaSeguroTotal,listaFrotaTotal,listaClientesTotal,listaSeguradoraTotal,listaSinistroTotal,listaVeiculoTotal);
						
				} else if(opcao == MenuOperacoes.LISTAR.operacao) {
					fazer_lista(listaCondutorTotal, listaSeguroTotal,listaFrotaTotal,listaClientesTotal, listaSeguradoraTotal, listaSinistroTotal,listaVeiculoTotal);
					
				} else if(opcao == MenuOperacoes.EXCLUIR.operacao) {
					excluir(listaCondutorTotal, listaSeguroTotal,listaFrotaTotal,listaClientesTotal, listaSeguradoraTotal, listaSinistroTotal,listaVeiculoTotal);
					
					
				} else if(opcao == MenuOperacoes.CALCULAR_RECEITA.operacao) {
					calculo_receita_seguradora(listaSeguradoraTotal);
					
				} else if(opcao == MenuOperacoes.SAIR.operacao) {
					break;
				}
									
			}
		
			}
		}
	}
	
	
