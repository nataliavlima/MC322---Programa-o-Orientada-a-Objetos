package lab05;
import java.util.ArrayList;
import java.util.Date;




// define essa classe como uma subclasse de Cliente (extends)
public class ClientePJ extends Cliente {
 private final String  cnpj;
 private Date dataFundacao ;
 private ArrayList<Frota> listaFrota;

 public ClientePJ (String nome , String telefone, String endereco, String email  , String cnpj , Date dataFundacao) {
	 
 // chama o construtor da superclasse
 
 super ( nome , telefone, endereco, email  );
 this.cnpj = cnpj;
 this.dataFundacao = dataFundacao;
 this.listaFrota = new ArrayList<Frota>();
 }

 // get e set CPF e data de fundação
	public  String getCnpj() {
		 return cnpj;
	 	}
	
	public Date getDataFundacao() {
		 return dataFundacao;
	 	}
	
	public void setDataFundacao(Date dataFundacao) {
	 this.dataFundacao = dataFundacao;
 	}
	
	public ArrayList<Frota> getListaFrota(){
		return listaFrota;
		}
	
	public void setListaFrota(ArrayList<Frota> listaFrota) {
		this.listaFrota= listaFrota;
	}
	
	public void adicionaFrota(Frota frota) {
		this.listaFrota.add(frota);
	}
	
	public void tiraFrota(Frota frota) {
		this.listaFrota.remove(frota);
	}
	
	public boolean cadastrarFrota(Frota frota) {
		  
		 
		 if(listaFrota.size() == 0) {  
			 adicionaFrota(frota);	
			 System.out.println("Frota adicionada!\n");
		 }
		 for(Frota frotaComparacao  : listaFrota) { 
			 
			 if(frota.getCode() == frotaComparacao.getCode()) {	// 
				 System.out.println("Frota já registrada!\n");
				 return false;
			 }else if(frota.getCode() != frotaComparacao.getCode()) {
			     adicionaFrota(frota);		
				 System.out.println("Frota adicionada!\n");
				 return true;
			 } 
		 
		 }
		 
		return false;
	} public boolean removerFrota(Frota frota) {
		 
		 if(listaFrota.size() == 0) {  
			 System.out.println("Não foi possível remover frota, não há nenhuma frota cadastrada para esse cliente\n");
			 return false;
		 }
		 for(Frota frotaComparacao  : listaFrota) { 	
			 
			 if(frota.getCode() == frotaComparacao.getCode()) {	
				 tiraFrota(frota);
				 System.out.println("Frota retirada!\n");
				 return true;
			 }else if(frota.getCode() != frotaComparacao.getCode()) {
				 System.out.println("Não foi possível remover frota!\n");
				 return false;
			 } 
		 
		 }
		 
		return false;
		}
 
	 // Vai listar todos os veiculos por frota
	 public ArrayList < Veiculo> getVeiculosPorFrota(String code){
	 ArrayList <Veiculo> listaVeiculoFrota = new ArrayList<Veiculo>();
	 	
	 	for(Frota frota: listaFrota) {
	 		String codeFrota = frota.getCode();
	 		
	 		if(code.equals(codeFrota)) {
	 			listaVeiculoFrota = frota.getListaVeiculo();  
	 		}
	 		else if(frota.getListaVeiculo().size() == 0) {  	
	 			 System.out.println("Sem veículos registrados para essa Frota!\n");
	 		 }
	 	}
	 	return listaVeiculoFrota ; // retorna a lista nova
	 }
	 
	 // atualiaza frota trocando a Antiga pela Nova
	 public boolean atualizarFrota(Frota frotaAntiga, Frota frotaNova) {
		 for(Frota frota1 : listaFrota) {
			 if(frota1.getCode().equals(frotaAntiga.getCode())){
				 removerFrota(frotaAntiga); // tira a frota antiga
				 cadastrarFrota(frotaNova); // adiciona a frota nova na lista
				 return true;
			 }
			 else {
				 return false;
			 }
		 }
		 return false;
	 }
	 
	 
	//remove frota 
	public boolean atualizarFrota(Frota frota) {
		 for(Frota frota1 : listaFrota) {
			 if(frota1.getCode().equals(frota.getCode())){
				 removerFrota(frota);
				 return true;
			 }
			 else {
				 return false;
			 }
		 }
		 return false;
		 }
		
	
 @Override
 public String toString () {
	
		String saida = "";
		saida += super.toString() + " Cnpj: " + this.cnpj + " \n Data de Fundação: " + this.dataFundacao + "\n Lista de Frotas: " + this.listaFrota + "\n";
		return saida;
		}
 }
