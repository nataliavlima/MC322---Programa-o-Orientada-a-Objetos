package lab05;

import java.util.ArrayList;
import java.util.Date;


// define essa classe como uma subclasse de Cliente (extends)
public class ClientePF extends Cliente {
 private final String cpf ;
 private Date dataNascimento ;
 private String educacao;
 private String genero;
 private ArrayList<Veiculo> listaVeiculos;

 public ClientePF ( String nome , String telefone, String endereco, String email ,  String cpf , Date dataNascimento , String educacao , String genero   ) {
	 
 // chama o construtor da superclasse
 super ( nome , telefone, endereco, email );
 this.cpf = cpf ;
 this.dataNascimento = dataNascimento ;
 this.educacao = educacao;
 this.genero = genero;
 this.listaVeiculos = new ArrayList<Veiculo>();
 }

 // get e set CPF e data de nascimento
 public  String getCpf() {
	 return cpf;
 	}

 public Date getDataNascimento() {
	 return dataNascimento;
 	}

 public void setDataNascimento(Date dataNascimento) {
	 this.dataNascimento = dataNascimento;
 	}
 
 public String getEducacao(){
	 return educacao;
 	}

 public void setEducacao(String educacao) {
	 this.educacao = educacao;
 	}

 public String getGenero(){
	 return genero;
 	}

 public void setGenero(String genero) {
	 this.genero = genero;
 	}
	
	public ArrayList<Veiculo> getListaVeiculo(){
		return listaVeiculos;
		}
	public void setListaVeiculo(ArrayList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	
	
	public void adicionaVeiculo(Veiculo veiculo) {
		this.listaVeiculos.add(veiculo);
	}
	
	public void tiraVeiculo(Veiculo veiculo) {
		this.listaVeiculos.remove(veiculo);
	}
	
	public boolean cadastrarVeiculo(Veiculo veiculo) {
		  
		 
		 if(listaVeiculos.size() == 0) {  // se nao tiver nenhum veiculo registrado (lista vazia) ele adiciona
			 adicionaVeiculo(veiculo);	
			 System.out.println("Veiculo adicionado!\n");
		 }
		 for(Veiculo veiculoComparacao  : listaVeiculos) { 	// percorre a lista de sinistro inteira
			 
			 if(veiculo.getPlaca() == veiculoComparacao.getPlaca()) {	// ve se esse veiculo ja foi registrado antes
				 System.out.println("Veiculo já registrado!\n");
				 return false;
			 }else if(veiculo.getPlaca() != veiculoComparacao.getPlaca()) {
			     adicionaVeiculo(veiculo);		// se registro for novo, ele e' adicionado
				 System.out.println("Veiculo adicionado!\n");
				 return true;
			 } 
		 
		 }
		 
		return false;
	} public boolean removerVeiculo(Veiculo veiculo) {
		 
		 if(listaVeiculos.size() == 0) {  // se nao tiver nenhum veiculo registrado (lista vazia) ele nao remove
			 System.out.println("Não foi possível remover veículo, não há nenhum veiculo cadastro para esse cliente\n");
			 return false;
		 }
		 for(Veiculo veiculoComparacao  : listaVeiculos) { 	// percorre a lista de sinistro inteira
			 
			 if(veiculo.getPlaca() == veiculoComparacao.getPlaca()) {	// ve se esse veiculo ta na lista, se tiver ele tira
				 tiraVeiculo(veiculo);
				 System.out.println("Veiculo retirado!\n");
				 return true;
			 }else if(veiculo.getPlaca() != veiculoComparacao.getPlaca()) {
				 System.out.println("Não foi possível remover veículo!\n");
				 return false;
			 } 
		 
		 }
		 
		return false;
		}
 
 @Override
 public String toString () {
		String saida = "";
		saida += super.toString() 
			+ " Cpf: " + this.cpf +
			"\n Data de Nascimento: " + this.dataNascimento + 
			"\n Educação: " + this.educacao +  
			"\n Gênero:  " + this.genero+ 
			"\n Lista de Veículos:  " + this.listaVeiculos+
			"\n\n";
		
		
		return saida;
		}
 }
