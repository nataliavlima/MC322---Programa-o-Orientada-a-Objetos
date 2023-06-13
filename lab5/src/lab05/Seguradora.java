package lab05;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Seguradora {
     private final String cnpj;
	 private String nome;
	 private String telefone;
	 private String email;
	 private String endereco;
	 private ArrayList <Seguro> listaSeguros = new ArrayList<Seguro>();
	 private ArrayList <Cliente> listaClientes = new ArrayList<Cliente>();
	 private List < Sinistro > listaSinistros = new ArrayList<Sinistro>();

	 // Construtor
	 public Seguradora(String cnpj, String nome , String telefone , String email , String endereco ) {
		 this.cnpj = cnpj;
		 this.nome = nome;
		 this.telefone = telefone;
		 this.email = email;
		 this.endereco = endereco;
		 this.listaSeguros = new ArrayList<Seguro>();
		 this.listaClientes = new ArrayList<Cliente>();
		 this.listaSinistros = new ArrayList<Sinistro>();
	 	}

	 // Getters e setters
	 public String getCnpj() {
		 return cnpj;
	 	}

	 
	 public String getNome() {
		 return nome;
	 	}

	 public void setNome( String nome ) {
		 this.nome = nome;
	 	}
	 
	 public String getTelefone() {
		 return telefone;
	 	}

	 public void setTelefone( String telefone ) {
		 this.telefone = telefone;
	 	}

	 public String getEmail() {
		 return email;
	 	}

	 public void setEmail( String email ) {
		 this.email = email;
	 	}

	 public String getEndereco() {
		 return endereco;
	 	}

	 public void setEndereco( String endereco ) {
		 this.endereco = endereco;
	 	}

	 public ArrayList < Seguro > getListaSeguro(){
			return listaSeguros;
			}
	public void adicionaSeguro(Seguro seguro) {
		this.listaSeguros.add(seguro);
	}
	public ArrayList < Cliente> getListaClientes(){
		return listaClientes;
		}
	
	public void adicionaClientes(Cliente cliente) {
		this.listaClientes.add(cliente);
	}
	
	 public List < Sinistro > getListaSinistros(){
			return listaSinistros;
			}
	public void adicionaSinistros(Sinistro sinistro) {
		this.listaSinistros.add(sinistro);
	}
	
	// Verifica se o cliente ja foi cadastrado antes, se nao foi ele adiciona novo
	public boolean cadastrarCliente(Cliente cliente1) throws ParseException {
		int verifica = 1;
		
		for(Cliente cliente : listaClientes) {  // percorre toda a lista de clientes 
				if(cliente1 instanceof ClientePF) {
					if(cliente instanceof ClientePF) { 		// Declara que o Cliente pertence a essa classe filha
						if(((ClientePF) cliente1).getCpf().equals(((ClientePF) cliente).getCpf())) {
							verifica = 0;
						} 
					}
				}
			
				else if(cliente1 instanceof ClientePJ) {
					if(cliente instanceof ClientePJ) {
						if(((ClientePJ) cliente1).getCnpj().equals(((ClientePJ) cliente).getCnpj())) {
							verifica = 0;
							} 
					}
				}
				
		}
		if(verifica == 0) {
			System.out.println("Não foi possível adicionar cliente \"" + cliente1.getNome() + "\", já possui um cliente cadastrado com esse documento!\n");
			return false;
		} else if(verifica == 1) {
			listaClientes.add(cliente1);
			//System.out.println("Cliente cadastrado com sucesso! \n");
			return true;
		}
		return false;
	
	}
	// funcao de transformar uma string em int[]
	 public int[] transformaInt(String string) {
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


	// ele vai verificar e remover a partir do CPF ou CNPJ pois sao os unicos itens unicos de cada cliente
	public boolean removerCliente(String Documento) {
		int[] DocumentoInt = transformaInt(Documento);	
		for(Cliente cliente : listaClientes) {  // percorre toda a lista de clientes 
	
			// Documento com 11 digitos =  cpf (Pessoa fisica)
			if(DocumentoInt.length == 11){  
				if(cliente instanceof ClientePF) { 										// Declara que o Cliente pertence a essa classe filha
					if(((ClientePF) cliente).getCpf().equals(Documento)){
						listaClientes.remove(cliente); 									 // se o cpf pertence a lista com os cliente PF, ele remove
						System.out.println("Cliente removido com sucesso!\n");
						return true;
					}
				}
			}
			// Documento com 14 digitos =  cnpj (Pessoa juridica)
			else if(DocumentoInt.length == 14){
				if(cliente instanceof ClientePJ) {
					if(((ClientePJ) cliente).getCnpj().equals(Documento)) {
						listaClientes.remove(cliente);  // remove
						System.out.println("Cliente removido com sucesso!\n");
						return true;
					}
				}
			}
			else { // se nao tem nem 11 nem 14 numeros = documento invalido
				System.out.println("Não foi possível efetuar a remoção!\n");
				return false;
			}	
		}
		System.out.println("Não foi possível efetuar a remoção!\n");
		return false;	

	}
			
	
	// lista os clientes PF ou PJ dependendo do desejo do usuario
	public List<Cliente> listarClientes(String tipoCliente){
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		
		for(Cliente cliente : getListaClientes() ) { 
			//System.out.println(getListaClientes());	
			if(((tipoCliente.equals("[1]"))|| (tipoCliente.equals("1"))|| (tipoCliente.equals("PF"))) && (cliente instanceof ClientePF)) { // [1] = Pessoa Fisica
				listaClientes.add(cliente);	
				}
			else if((tipoCliente.equals("[2]") || (tipoCliente.equals("2"))|| (tipoCliente.equals("PJ"))) && (cliente instanceof ClientePJ)) { // [2] Pessoa Juridica
				listaClientes.add(cliente);	
			}
		}
		
		return listaClientes;
	}
	
	
	
	// Gerar seguro para PJ
	public boolean gerarSeguro(Date dataInicio, Date dataFim,  Frota frota, ClientePJ cliente) {
		SeguroPJ seguro = new SeguroPJ(dataInicio,dataFim,this, frota, cliente);
		  
	
			// Verifica se ja nao foi cadastrado antes 
			 if(listaSeguros.size() == 0) {  
				 adicionaSeguro(seguro);	
				 System.out.println("Seguro adicionado!\n");
			 }else if(this.listaSeguros.contains(seguro)){
					 return false;
				 }
			 else {
				 adicionaSeguro(seguro);
				 return true;
				 }
		 
		 
		return false;
	}
	
	// Gerar seguro para PF
		public boolean gerarSeguro( Date dataInicio,Date dataFim, Veiculo veiculo, ClientePF cliente) {
			SeguroPF seguro = new SeguroPF( dataInicio,dataFim,this, veiculo, cliente);
			  
		// Verifica se ja nao foi cadastrado antes 
			 if(listaSeguros.size() == 0) {  
				 adicionaSeguro(seguro);	
				 System.out.println("Seguro adicionado!\n");
			 }else if(this.listaSeguros.contains(seguro)){
					 return false;
				 }
			 else {
				 adicionaSeguro(seguro);
				 return true;
				 }
				
			 
			return false;
		}
		
	// Verifica se o seguro esta na lista -> se tiver ele "cancela" = remove da lista
		public boolean cancelaSeguro(Seguro seguroCancela) {
			for(Seguro s1 : listaSeguros) {
				if(s1.getId() == seguroCancela.getId()) {	// verifica o cadastro pelo ID registrado
					 System.out.println("Seguro cancelado!\n");
					 this.listaSeguros.remove(seguroCancela);
					 return true;
				 }else if(s1.getId() != seguroCancela.getId()) {		
				     System.out.println("Não foi possível cancelar esse seguro, ele não consta nos nossos registros!\n");
					 return false;
				 } 
			}
			
			return false;
		}
	
		
		
	// Pega todos os seguros de um cliente
	public ArrayList<Seguro> getSegurosPorCliente(String nomeCliente) {
		ArrayList < Seguro > listaSegurosCliente = new ArrayList<Seguro>();
	 	
	 	for(Seguro seguro : getListaSeguro()) {
	 		if(seguro instanceof SeguroPF) { // Caso o seguro seja PF
	 			String nomeClienteSeguro= ((SeguroPF) seguro).getCliente().getNome();
	 			if(nomeClienteSeguro.equals(nomeCliente)) {
		 			listaSegurosCliente.add(seguro);  // adiciona todos os seguro com o nome do cliente nessa lista nova
		 		}
		 		else if(listaSeguros.size() == 0) {  // se nao tiver nenhum seguro registrado (lista vazia) ele adiciona	
		 			 System.out.println("Sem registro de seguros para esse cliente!\n");
		 		 }
				}
	 		else if(seguro instanceof SeguroPJ) { // Caso o seguro seja PJ
	 			String nomeClienteSeguro= ((SeguroPJ) seguro).getCliente().getNome();
	 			if(nomeClienteSeguro.equals(nomeCliente)) {
		 			listaSegurosCliente.add(seguro);  // adiciona todos os seguro com o nome do cliente nessa lista nova
		 		}
		 		else if(listaSeguros.size() == 0) {  // se nao tiver nenhum seguro registrado (lista vazia) ele adiciona	
		 			 System.out.println("Sem registro de seguros para esse cliente!\n");
		 		 }
			}
	 	}	
	 	return listaSegurosCliente; // retorna a lista nova
	}
		
	// Visualiza o id registrado em um id
	 public boolean visualizarSinistro(int id){
		 for(Seguro seguro : getListaSeguro()) { // define o seguro um por um
		 		for(Sinistro sinistro : seguro.getListaSinistro()) { // seleciona o seguro e acessa a lista de sinistro deles
			 		int idNovo = sinistro.getId();
			 		if(idNovo == id) {
			 			System.out.println(sinistro.toString()+ "\n");
			 			return true;
			 		} 
			 	}
		 }
	 	return false;
	 }
	 
	// Vai listar todas as ocorrencias de sinistros de um cliente
		 public List < Sinistro > listarSinistros(String nomeCliente){
		 List < Sinistro > listaSinistrosCondutor = new ArrayList<Sinistro>();
		 	
		 	for(Sinistro sinistro : getListaSinistros()) {
		 		String nomeCondutorSinistro = sinistro.getCondutor().getNome();
		 		
		 		if(nomeCondutorSinistro.equals(nomeCliente)) {
		 			listaSinistrosCondutor.add(sinistro);  // adiciona todos os sinistros com o nome do cliente nessa lista nova
		 		}
		 		else if(listaSinistros.size() == 0) {  // se nao tiver nenhum sinistro registrado (lista vazia) ele adiciona	
		 			 System.out.println("Sem registro de sinistros para esse cliente!\n");
		 		 }
		 	}
		 	return listaSinistrosCondutor; // retorna a lista nova
		 }
		 
	 public double calcularReceita() {
		 double receita = 0.0;
		 for(Seguro seguro : listaSeguros)
			 receita += seguro.valorMensal;
		 return receita;
	 }
	 
	 // Vai listar todas as ocorrencias de sinistros de um cliente
	 public ArrayList < Sinistro >getSinistrosPorCliente(String nomeCliente){
		 ArrayList < Sinistro > listaSinistrosCliente = new ArrayList<Sinistro>();
		 
	 	for(Seguro seguro : getListaSeguro()) { // define o seguro um por um
	 		for(Sinistro sinistro : seguro.getListaSinistro()) { // seleciona o seguro e acessa a lista de sinistro deles
		 		
	 			if(seguro instanceof SeguroPF) { // Caso o seguro seja PF
		 			String nomeClienteSeguro= ((SeguroPF) seguro).getCliente().getNome();
		 			
		 			if(nomeClienteSeguro.equals(nomeCliente)) { // seleciona os sinistros dos clientes 
		 				listaSinistrosCliente.add(sinistro);
		 				}
			 		else if(listaSeguros.size() == 0) {  
			 			System.out.println("Sem registro de sinistros para esse cliente!\n");
			 		 }
					}
		 		else if(seguro instanceof SeguroPJ) { // Caso o seguro seja PJ
		 			String nomeClienteSeguro= ((SeguroPJ) seguro).getCliente().getNome();
		
		 			if(nomeClienteSeguro.equals(nomeCliente)) {
		 				listaSinistrosCliente.add(sinistro);
		 				}
			 		else if(listaSeguros.size() == 0) {  
			 			System.out.println("Sem registro de sinistros para esse cliente!\n");
			 		}
		 		}
			}
	 	}	
	 	return listaSinistrosCliente; // retorna a lista nova
	 }
	
	 
	 
	 

	 
		public String toString () {
			String saida = "";
			saida += " \nSeguradora:" + 
					  "\n Cnpj: " + getCnpj() + 
					  "\n Nome: " + getNome() + 
					  "\n Telefone: " + getTelefone() + 
					  "\n Email: " + getEmail() + 
					  "\n Endereço:  " + getEndereco()+ 
					  "\n Seguros: " + getListaSeguro() + 
					  "\n Clientes: " + getListaClientes() + 
					  "\n Sinistros: " + getListaSinistros() +
					  "\n";
	
			return saida;
			}
	
	}
