
package lab05;
	import java.util.ArrayList;
	import java.util.Date;
	
	/*
	 * - ver a declaracao do cpf como final
	 */
public class Condutor {
			private final String cpf;
			
			private String nome;
			private String telefone;
			private String endereco;
			private String email;
			private Date dataNasc;
			private ArrayList < Sinistro > listaSinistros = new ArrayList<Sinistro>();
			

			// Construtor
			 	public Condutor (String cpf, String nome , String telefone, String endereco, String email, Date dataNasc, ArrayList listaSinistro ) {
				 this.nome = nome;
				 this.endereco = endereco;
				 this.telefone = telefone;
				 this.email = email;
				 this.cpf = cpf;
				 this.dataNasc = dataNasc;
				 this.listaSinistros = new ArrayList<Sinistro>();
			 }
				
				 
			// Getters e setters
			 public String getNome() {
				 return nome;
			 	}

			 public void setNome(String nome) {
				 this.nome = nome;
			 	}
			 
			 public String getTelefone() {
				 return telefone;
			 	}

			 public void setTelefone( String telefone) {
				 this.telefone = telefone;
			 	}
			 public String getEmail() {
				 return email;
			 	}

			 public void setEmail( String email) {
				 this.email = email;
			 	}
			 public String getEndereco() {
				 return endereco;
			 	}

			 public void setEndereco( String endereco ) {
				 this.endereco = endereco;
			 	}
			 
			 public ArrayList<Sinistro> getListaSinistro(){
				return listaSinistros;
				}
			 
			public void setListaSinistro(ArrayList<Sinistro> listaSinistros) {
				this.listaSinistros = listaSinistros;
				}
				
			public void adicionaSinistro(Sinistro sinistro) {
				this.listaSinistros.add(sinistro);
			}
			public  String getCpf() {
				 return cpf;
			 	}

			 public Date getDataNasc() {
				 return dataNasc;
			 	}

			 public void setDataNasc(Date dataNasc) {
				 this.dataNasc = dataNasc;
			 	}
			
			@Override
			public String toString () {
				return  " Nome: " + this.nome + 
						"\n Telefon: " + this.telefone+ 
						"\n Endereço: " + this.endereco +
						"\n Email: " + this.email + 
						"\n Data de Nascimento: " + this.dataNasc +
						"\n Lista de Sinistros: " + this.listaSinistros + 
						"\n";
				
				}
			
		  
		}