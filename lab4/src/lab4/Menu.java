package lab4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/* ERROS:
 * 16:33 - calcular seguro depois de ajustar a transferencia
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
			
			System.out.println("Qual a data de nascimento do cliente? Digite no formato dia/mês/ano");
			dataNascimentoString = usuario.nextLine();
			Date dataNascimento = formato.parse(dataNascimentoString);
			
			System.out.println("Qual a data de licença do cliente? Digite no formato dia/mês/ano");
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
		//System.out.println(listaSeguradoraTotal);
		
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
	
	public static List<Sinistro>  fazer_lista_sinistro_cli(List<Sinistro> listaSinistroTotal, String nomeCli) {
			
		List<Sinistro> listarSinistrosCli = new ArrayList<Sinistro>();
			for(Sinistro sinistro1 : listaSinistroTotal ) { 
				
				String nomeSinistro = sinistro1.getCliente().getNome();
				if(nomeSinistro.equals(nomeCli)) {
					listarSinistrosCli.add(sinistro1);	
					return listarSinistrosCli;
					}
			}
			
			return listarSinistrosCli;
	}

	public static List<Sinistro>  fazer_lista_sinistro_seg(List<Sinistro> listaSinistroTotal) {
		
		Scanner usuario = new Scanner(System.in);
		System.out.println("Qual o nome da Seguradora?");	
		String nomeSeg = usuario.nextLine();
		
		
		List<Sinistro> listarSinistrosSeg = new ArrayList<Sinistro>();
			for(Sinistro sinistro1 : listaSinistroTotal ) { 
				
				String nomeSinistro = sinistro1.getSeguradora().getNome();
				if(nomeSinistro.equals(nomeSeg)) {
					listarSinistrosSeg.add(sinistro1);	
					}
			}
			System.out.println(listarSinistrosSeg);
			return listarSinistrosSeg;
	}
	

	public static ArrayList<Veiculo> fazer_lista_veiculo_cli(List<Cliente> listaClientesTotal) {
		Scanner usuario = new Scanner(System.in);
		System.out.println("Qual o nome do Cliente?");	
		String nomeCli = usuario.nextLine();
		
		
		ArrayList<Veiculo> listaVeiculoCli = new ArrayList<Veiculo>();
			for(Cliente cliente1: listaClientesTotal) {
				String nomeCliente = cliente1.getNome();
						
				if(nomeCliente.equals(nomeCli)) {
					listaVeiculoCli = cliente1.getListaVeiculo();	
					}
			}
			System.out.println(listaVeiculoCli);
			return listaVeiculoCli;
	}

	public static ArrayList<Veiculo> fazer_lista_veiculo_seg(List<Seguradora> listaSeguradoraTotal) {
		Scanner usuario = new Scanner(System.in);
		ArrayList<Veiculo> listaVeiculoSeg = new ArrayList<Veiculo>();
		
		System.out.println("Digite o número da seguradora você deseja calcular a receita?");
		for(int i = 0; i < listaSeguradoraTotal.size(); i++) {
			System.out.println(i + ": " + listaSeguradoraTotal.get(i).getNome());
		}
		
		int segNum = usuario.nextInt();
		Seguradora seguradora1 = listaSeguradoraTotal.get(segNum); // seleciona a seguradora pelo index digitado
				
		for(int i = 0; i < seguradora1.getListaClientes().size(); i++) { // percorre toda a lista de clientes da seguradora selecionada
			Cliente cliente1 = seguradora1.getListaClientes().get(i);
				for(int j = 0;j < cliente1.getListaVeiculo().size(); j++) { // percorre toda a lista de veiculo do cliente com o index(j)
				listaVeiculoSeg.add(cliente1.getListaVeiculo().get(j)); // adiciona cada veiculo do cliente(j) na lista que ira retornar
				}
		}
	
		System.out.println(listaVeiculoSeg);
		return listaVeiculoSeg;
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
	
	public static List<Cliente> excluir_cliente(List<Cliente> listaClientesTotal) {
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

	public static List<Sinistro> excluir_sinistro(List<Sinistro> listaSinistroTotal) {
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
	
	public static void fazer_cadastro(List<Cliente> listaClientesTotal, List<Seguradora> listaSeguradoraTotal,List<Sinistro> listaSinistroTotal,ArrayList<Veiculo> listaVeiculoTotal) throws ParseException {
		
		String opcao1;
		int opcaoVoltar = 0;
		
		
		String tipoCliente;
		try (Scanner usuario = new Scanner(System.in)) {
			
			// Menu para Cadastro
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("O que você deseja cadastrar? \nDigite o número da opção descrita\n");
			System.out.println("1.1: Cadastrar cliente");
			System.out.println("1.2: Cadastrar veiculo");
			System.out.println("1.3: Cadastrar seguradora");
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
			listaVeiculoTotal = fazer_cadastro_veiculo(listaVeiculoTotal);
			break;
		} else if(opcao1.equals(Operacoes.CADASTRAR_SEGURADORA.operacao)) {
			listaSeguradoraTotal = fazer_cadastro_seguradora(listaSeguradoraTotal);
			break;
		
		} else if(opcao1.equals(Operacoes.VOLTAR.operacao)) {
			opcaoVoltar = 1;
			menuOperacoes(listaClientesTotal,listaSeguradoraTotal,listaSinistroTotal,listaVeiculoTotal);
			break;
			}
		} while(opcaoVoltar != 1);}

	}
	
	public static void fazer_lista(List<Cliente> listaClientesTotal, List<Seguradora> listaSeguradoraTotal,List<Sinistro> listaSinistroTotal,ArrayList<Veiculo> listaVeiculoTotal) throws ParseException {
		String opcao1;
		int opcaoVoltar = 0;
		
		
		try (Scanner usuario = new Scanner(System.in)) {
			
			// Menu para Cadastro
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("O que você deseja listar? \nDigite exatamente igual a opção descrita\n");
			System.out.println("2.1: Listar clientes por seguradora");
			System.out.println("2.2: Listar sinistros por seguradora");
			System.out.println("2.3: Listar sinistros por clientes");
			System.out.println("2.4: Listar veículo por clientes");
			System.out.println("2.5: Listar veículo por seguradora");
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
			
		} 
		else if(opcao1.equals(Operacoes.LISTAR_SINISTROS_CLI.operacao)) {
			System.out.println("Qual o nome do cliente?");	
			String nomeCli = usuario.nextLine();
			List<Sinistro> listarSinistrosSeg = new ArrayList<Sinistro>();
			listarSinistrosSeg = fazer_lista_sinistro_cli(listaSinistroTotal, nomeCli);
			System.out.println(listarSinistrosSeg);
			break;
			
		}	else if(opcao1.equals(Operacoes.LISTAR_SINISTROS_SEG.operacao)) {
			fazer_lista_sinistro_seg(listaSinistroTotal);
			break;
			
		}else if(opcao1.equals(Operacoes.LISTAR_VEICULO_CLI.operacao)) {
			fazer_lista_veiculo_cli(listaClientesTotal);
			break;
			
		}else if(opcao1.equals(Operacoes.LISTAR_VEICULO_SEG.operacao)) {
			fazer_lista_veiculo_seg(listaSeguradoraTotal);
			break;
			
		}else if(opcao1.equals(Operacoes.VOLTAR.operacao)) {
			opcaoVoltar = 1;
			menuOperacoes(listaClientesTotal,listaSeguradoraTotal,listaSinistroTotal,listaVeiculoTotal);
			break;
		}
			
		} while(opcaoVoltar != 1);
		}

	}
	public static void excluir(List<Cliente> listaClientesTotal, List<Seguradora> listaSeguradoraTotal,List<Sinistro> listaSinistroTotal,ArrayList<Veiculo> listaVeiculoTotal)  throws ParseException{
		
		String opcao1;
		int opcaoVoltar = 0;
		
		
		try (Scanner usuario = new Scanner(System.in)) {
			
			// Menu para Cadastro
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("O que você deseja excluir? \nDigite exatamente igual a opção descrita\n");
			System.out.println("3.1: Excluir cliente");
			System.out.println("3.2: Excluir veículo");
			System.out.println("3.3: Excluir sinistro");
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
			
					
		}else if(opcao1.equals(Operacoes.VOLTAR.operacao)) {
			opcaoVoltar = 1;
			menuOperacoes(listaClientesTotal,listaSeguradoraTotal,listaSinistroTotal,listaVeiculoTotal);
			break;
		}
			
		} while(opcaoVoltar != 1);
		}

	}
	
	public static List<Sinistro> gerar_sinistro(List<Cliente> listaClientesTotal, List<Seguradora> listaSeguradoraTotal,List<Sinistro> listaSinistroTotal,ArrayList<Veiculo> listaVeiculoTotal) throws ParseException{
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		Scanner usuario = new Scanner(System.in);
		
		System.out.println("Qual da data do sinistro? Digite no formato dia/mês/ano");
		String dataSinistroString = usuario.nextLine();
		Date dataSinistro = formato.parse(dataSinistroString);
		
		System.out.println("Qual o endereço do sinistro?");
		String endereco = usuario.nextLine();
		
		
		System.out.println("Vamos cadastrar agora a Seguradora!");
		listaSeguradoraTotal = fazer_cadastro_seguradora(listaSeguradoraTotal);
		Seguradora seguradoraSin = listaSeguradoraTotal.get(listaSeguradoraTotal.size() -1);
		
		System.out.println("Vamos cadastrar agora o Cliente!");
		listaClientesTotal = fazer_cadastro_cliente(listaClientesTotal);
		Cliente clienteSin = listaClientesTotal.get(listaClientesTotal.size() -1);
		
		Veiculo veiculoSin = listaVeiculoTotal.get(listaVeiculoTotal.size() -1);
		
		
		Sinistro sinistro1 = new Sinistro(dataSinistro, endereco, seguradoraSin, veiculoSin, clienteSin);
		listaSinistroTotal.add(sinistro1);
		System.out.println(sinistro1);
		return listaSinistroTotal;
		
	}
	
	public static double calcula_seguro(Cliente cliente, List<Sinistro> listaSinistroTotal) throws ParseException {
		List<Sinistro> listarSinistrosCli = new ArrayList<Sinistro>();
		listarSinistrosCli = fazer_lista_sinistro_cli(listaSinistroTotal, cliente.getNome()) ;
		
		int quantidadeSinistros = listarSinistrosCli.size();
		 
		 double seguro = (cliente.calculaScore(cliente) * (1 + quantidadeSinistros));
		 cliente.valorSeguro = seguro;
		 return seguro;
	}
	public static void calculo_receita_seguradora(List<Seguradora> listaSeguradoraTotal) {
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
	
	public static List<Cliente> transferir_seguro(List<Cliente> listaClientesTotal, List<Seguradora> listaSeguradoraTotal, List<Sinistro> listaSinistroTotal,ArrayList<Veiculo> listaVeiculoTotal) throws ParseException {
		Scanner usuario = new Scanner(System.in);
		
		System.out.println("Digite o número do cliente que irá retirar os veículos para transferir o seguro:\n");
		for(int i = 0; i < listaClientesTotal.size()- 1; i++) {
			System.out.println(i + ": " + listaClientesTotal.get(i).getNome());
		}
		int clienteN1 = usuario.nextInt();
		
		System.out.println("Digite o número do cliente que irá receber os veículos na transferência do seguro:\n");
		for(int i = 0; i < listaClientesTotal.size()- 1; i++) {
			System.out.println(i + ": " + listaClientesTotal.get(i).getNome());
		}
		
		int clienteN2 = usuario.nextInt();
		ArrayList<Veiculo> listaVeiculoVazia = null;
		ArrayList<Veiculo> listaVeiculoTransferida = null;
		
		
		// Seleciona o cliente na posicao da lista selecionada pelo usuario
		Cliente cliente1 = listaClientesTotal.get(clienteN1);
		Cliente cliente2 = listaClientesTotal.get(clienteN2);
		
		// Calcula os seguros inicialmente
		/*double seguro1 = calcula_seguro(cliente1, listaSinistroTotal);
		double seguro2 = calcula_seguro(cliente2, listaSinistroTotal);
		
		System.out.println("O valor do seguro inicial de " + cliente1.getNome() + " era de R$ " + seguro1 );
		System.out.println("O valor do seguro inicial de " + cliente2.getNome() + " era de R$ " + seguro2 + "\n");
		*/
		// Modifica os veiculos
		listaVeiculoTransferida = cliente1.getListaVeiculo();
		cliente1.setListaVeiculo(listaVeiculoVazia);	// retira os carros do cliente1
		
		
		// Adicionando cada veiculo novo na lista que o cliente2 ja tinha
		for(int j = 0; j < listaVeiculoTransferida.size(); j++) {
			cliente2.adicionaVeiculo(listaVeiculoTransferida.get(j));
			
		}
		
		System.out.println(cliente2.getNome() + " recebeu os veiculos:" + listaVeiculoTransferida);
		
		System.out.println("Veículos atuais de " +cliente2.getNome() +":" + cliente2.getListaVeiculo());
		System.out.println("A lista de veículos de " +cliente1.getNome() + " foi esvaziada");
		
		List<Cliente> clientesSelecionados = new ArrayList<Cliente>();
		clientesSelecionados.add(cliente1);
		clientesSelecionados.add(cliente2);
		
		return clientesSelecionados;
	}
	
	public static void menuOperacoes(List<Cliente> listaClientesTotal, List<Seguradora> listaSeguradoraTotal, List<Sinistro> listaSinistroTotal,	ArrayList<Veiculo> listaVeiculoTotal) throws ParseException {
		// Menu de Operações
		
		int opcao = 0;
		//Operacoes opcao2;
		
		
		try (Scanner usuario = new Scanner(System.in)) {
			
			
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
					
					fazer_cadastro(listaClientesTotal,listaSeguradoraTotal,listaSinistroTotal,listaVeiculoTotal);
						break;
				} else if(opcao == MenuOperacoes.LISTAR.operacao) {
					fazer_lista(listaClientesTotal, listaSeguradoraTotal, listaSinistroTotal,listaVeiculoTotal);
					break;		
				} else if(opcao == MenuOperacoes.EXCLUIR.operacao) {
					excluir(listaClientesTotal, listaSeguradoraTotal, listaSinistroTotal,listaVeiculoTotal);
					break;
				} else if(opcao == MenuOperacoes.GERAR_SINISTRO.operacao) {
					listaSinistroTotal = gerar_sinistro(listaClientesTotal, listaSeguradoraTotal, listaSinistroTotal,listaVeiculoTotal);
					break;
				} else if(opcao == MenuOperacoes.TRANSFERIR_SEGURO.operacao) {
					List<Cliente> clientesSelecionados = new ArrayList<Cliente>();
					clientesSelecionados = transferir_seguro(listaClientesTotal, listaSeguradoraTotal, listaSinistroTotal,listaVeiculoTotal);
					
					// recalcula os valores dos seguros
					System.out.println("-------------------------------------");
					System.out.println(calcula_seguro(clientesSelecionados.get(0), listaSinistroTotal));
					System.out.println(calcula_seguro(clientesSelecionados.get(1), listaSinistroTotal));
					//seguro2 = calcula_seguro(cliente2, listaSinistroTotal);	
					
					break;
				} else if(opcao == MenuOperacoes.CALCULAR_RECEITA.operacao) {
					calculo_receita_seguradora(listaSeguradoraTotal);
					
					break;
				} else if(opcao == MenuOperacoes.SAIR.operacao) {
					break;
				}
									
				
				}while(opcao != 7);
			
			}
		
	}
	
	
}
