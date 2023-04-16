package lab3;

import java.util.ArrayList;
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
	public void adiciona(Sinistro sinistro) {
		this.listaSinistros.add(sinistro);
	}
	public List < Cliente> getListaClientes(){
		return listaClientes;
		}
	/*
	public void adiciona(Cliente cliente) {
		this.listaClientes.add(cliente);
	}
	*/
	
	
	// Verifica se o cliente ja foi cadastrado antes, se nao foi ele adiciona novo
	public boolean cadastrarCliente(Cliente cliente) {
		//String nome = Cliente.getNome();
		
		if(listaClientes.contains(cliente)) {
			System.out.println(cliente.getNome());
			return false;	
		} else {
			listaClientes.add(cliente);
			System.out.println(cliente.getNome());
			return true;
		}
	}
	 
	// ele vai verificar a partir do CPF ou CNPJ pois sao os unicos itens unicos de cada cliente
	public boolean removerCliente(String Documento) {
				
		// retirar todos os caracteres nao numeros
		Documento = Documento.replaceAll("[^0-9]+", "");
		
		// transforma em um vetor de int
		char[] arrayDocumento = Documento.toCharArray();        // pega a string e escreve como array
		int[] DocumentoInt = new int[arrayDocumento.length];    // declara um vetor de int 
		
		for (int i = 0; i < arrayDocumento.length; i++) {
			DocumentoInt[i] = Integer.parseInt(Documento.substring(i, i+1));  // adiciona numero por numero convertido no vetor de int
		}

		
		for(Cliente cliente : listaClientes) {  // percorre toda a lista de clientes 
			
			// Documento com 11 digitos =  cpf (Pessoa fisica)
			if(DocumentoInt.length == 11) { 
				if(cliente instanceof ClientePF) {  // acessa a classe filha Cliente PF
					listaClientes.remove(cliente);  // remove
					return true;
				}
			}
			
			// Documento com 11 digitos =  cnpj (Pessoa juridica)
			if(DocumentoInt.length == 14){
				if(cliente instanceof ClientePJ) {
					listaClientes.remove(cliente);
					return true;
				}
			}
			else { // se nao tem nem 11 nem 14 numeros = documento invalido
				return false;
			}
		
		}
		return false;
		
	}
	
	//public List<Cliente> listarClientes(String )
	
	// cadastrar cliente
	// remover cliente
	// listar clientes
	// gerar sinistros
	// visualizar sinistro
	// listar sinistro
	
	
	
	 // toString()
	// Colocar para printar a lista sinsitro e clientes  1
		public String toString () {
			String saida = "";
			saida += " Nome: " + getNome() + "\n Telefone: " + getTelefone() + " \n Email: " + getEmail() + "\n Endereço:  " + getEndereco()+ "\n";
			return saida;
			}
	
	}
