package lab4;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Seguradora {
	 private String nome;
	 private String telefone;
	 private String email;
	 private String endereco;
	 private List < Sinistro > listaSinistros = new ArrayList<Sinistro>();
	 private List < Cliente > listaClientes = new ArrayList<Cliente>();

	 // Construtor
	 public Seguradora( String nome , String telefone , String email , String endereco ) {
		 this.nome = nome;
		 this.telefone = telefone;
		 this.email = email;
		 this.endereco = endereco;
		 this.listaSinistros = new ArrayList<Sinistro>();
		 this.listaClientes = new ArrayList<Cliente>();
	 	}

	 // Getters e setters
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

	 public List < Sinistro > getListaSinistros(){
			return listaSinistros;
			}
	public void adicionaSinistros(Sinistro sinistro) {
		this.listaSinistros.add(sinistro);
	}
	public List < Cliente> getListaClientes(){
		return listaClientes;
		}
	
	public void adicionaClientes(Cliente cliente) {
		this.listaClientes.add(cliente);
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
			calcularPrecoSeguroCliente(cliente1);
			System.out.println("Cliente cadastrado com sucesso! \n");
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
			if(((tipoCliente.equals("[1]"))|| (tipoCliente.equals("1"))) && (cliente instanceof ClientePF)) { // [1] = Pessoa Fisica
				listaClientes.add(cliente);	
				}
			else if((tipoCliente.equals("[2]") || (tipoCliente.equals("2"))) && (cliente instanceof ClientePJ)) { // [2] Pessoa Juridica
				listaClientes.add(cliente);	
			}
		}
		
		return listaClientes;
	}
	
	public boolean gerarSinistro(Date data, String endereco,Seguradora seguradora,Veiculo veiculo,Cliente cliente){
		 
		 Sinistro s1 = new Sinistro(data,endereco,seguradora,veiculo,cliente);
		  
		 
		 if(listaSinistros.size() == 0) {  // se nao tiver nenhum sinistro registrado (lista vazia) ele adiciona
			 adicionaSinistros(s1);	
			 System.out.println("Sinistro adicionado!\n");
		 }
		 for(Sinistro sinistro  : listaSinistros) { 	// percorre a lista de sinistro inteira
			 
			 if(s1.getId() == sinistro.getId()) {	// ve se esse sinistro ja foi registrado antes(id unico!)
				 System.out.println("Sinistro já registrado!\n");
				 return false;
			 }else if(s1.getId() != sinistro.getId()) {
			     adicionaSinistros(s1);		// se registro for novo, ele e' adicionado
				 System.out.println("Sinistro adicionado!\n");
				 //System.out.println(listaSinistros + "\n");
				 return true;
			 } 
		 
		 }
		 
		return false;
	}

	
	// Visualiza o id registrado em um id
	 public boolean visualizarSinistro(int id){
	 	for(Sinistro sinistro: listaSinistros) {
	 		int idNovo = sinistro.getId();
	 		if(idNovo == id) {
	 			System.out.println(sinistro.toString()+ "\n");
	 			return true;
	 		} 
	 	}
	 	return false;
	 }
	 
	 
	 // Vai listar todas as ocorrencias de sinistros de um cliente
	 public List < Sinistro > listarSinistros(String nomeCliente){
	 List < Sinistro > listaSinistrosCliente = new ArrayList<Sinistro>();
	 	
	 	for(Sinistro sinistro : getListaSinistros()) {
	 		String nomeClienteSinistro = sinistro.getCliente().getNome();
	 		
	 		if(nomeClienteSinistro.equals(nomeCliente)) {
	 			listaSinistrosCliente.add(sinistro);  // adiciona todos os sinistros com o nome do cliente nessa lista nova
	 		}
	 		else if(listaSinistros.size() == 0) {  // se nao tiver nenhum sinistro registrado (lista vazia) ele adiciona	
	 			 System.out.println("Sem registro de sinistros para esse cliente!\n");
	 		 }
	 	}
	 	return listaSinistrosCliente; // retorna a lista nova
	 }
	
	 
	 
	 public double calcularPrecoSeguroCliente(Cliente cliente1) throws ParseException  {
		 double seguro = 0;
		 // calculo do valor do seguro
		 
		 	if(cliente1 instanceof ClientePF) {
				 seguro = ((ClientePF) cliente1).calculaScore();
				cliente1.valorSeguro = seguro;
				
			} else if(cliente1 instanceof ClientePJ) {
				 seguro = ((ClientePJ) cliente1).calculaScore();
				cliente1.valorSeguro = seguro;
			} else {
				seguro = 0;
			}
		
		 return seguro;
	 }
	 
	 public double calcularReceita() {
		 double receita = 0;
		 for(Cliente cliente : listaClientes)
			 receita += cliente.valorSeguro;
		 return receita;
	 }
	 
		public String toString () {
			String saida = "";
			saida += " \n  Seguradora:" + 
					  "\n    Nome: " + getNome() + 
					  "\n    Telefone: " + getTelefone() + 
					  "\n    Email: " + getEmail() + 
					  "\n    Endereço:  " + getEndereco()+ 
					  "\n    Sinistros: " + getListaSinistros() + 
					  "\n    Clientes: " + getListaClientes() + 
					  "\n";
			
			return saida;
			}
	
	}
