package lab02;

public class Cliente {
	private String nome;
	private String cpf;
	private String dataNascimento;
	private int idade;
	private String endereco;

	// Construtor
	 public Cliente ( String nome , String cpf, String dataNascimento , int idade,  String endereco ) {
		 this.nome = nome ;
		 this.cpf = cpf;
		 this.dataNascimento = dataNascimento;
		 this.idade = idade;
		 this.endereco = endereco ;
	 }
	
	// Getters e setters
	 public String getNome() {
		 return nome;
	 	}

	 public void setNome(String nome) {
		 this.nome = nome;
	 	}
	 
	 public String getCpf() {
		 return cpf;
	 	}

	 public void setCpf(String cpf) {
		 this.cpf = cpf;
	 	}
	 
	 public String getDataNascimento() {
		 return dataNascimento;
	 	}

	 public void setDataNascimento(String dataNascimento) {
		 this.dataNascimento = dataNascimento;
	 	}

	 public int getIdade() {
		 return idade;
	 	}

	 public void setEmail( int idade ) {
		 this.idade = idade;
	 	}

	 public String getEndereco() {
		 return endereco;
	 	}

	 public void setEndereco( String endereco ) {
		 this.endereco = endereco;
	 	}
 
	 // toString()
	 
	 // validarCPF(cpf; string): boolean
}