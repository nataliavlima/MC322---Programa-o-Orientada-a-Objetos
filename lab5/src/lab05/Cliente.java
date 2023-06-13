package lab05;
import java.util.List;
import java.text.ParseException;
import java.util.ArrayList;
	
public abstract class Cliente {

		protected String nome;
		protected String telefone;
		protected String endereco;
		protected String email;

		// Construtor
		 	public Cliente (String nome , String telefone, String endereco, String email ) {
			 this.nome = nome;
			 this.endereco = endereco;
			 this.telefone = telefone;
			 this.email = email;
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
		 
		
		@Override
		public String toString () {
			return  " Nome: " + this.nome + 
					"\n Telefone: " + this.telefone+ 
					"\n Endereço: " + this.endereco +
					"\n Email: " + this.email + 
					"\n";
			
			}
		
	  
	}