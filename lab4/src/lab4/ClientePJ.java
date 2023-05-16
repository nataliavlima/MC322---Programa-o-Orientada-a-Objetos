package lab4;
import java.text.ParseException;
<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> working
import java.util.Date;
import java.util.List;


// define essa classe como uma subclasse de Cliente (extends)
public class ClientePJ extends Cliente {
 private final String  cnpj;
 private Date dataFundacao ;
 private int qtdFuncionarios;

<<<<<<< HEAD
 public ClientePJ ( String nome , String endereco , List < Veiculo > listaVeiculos , String cnpj , Date dataFundacao, int qtdFuncionarios ) {
=======
 public ClientePJ ( String nome , String endereco , ArrayList < Veiculo > listaVeiculos , String cnpj , Date dataFundacao, int qtdFuncionarios ) {
>>>>>>> working
	 
 // chama o construtor da superclasse
 
 super ( nome , endereco ,  listaVeiculos );
 this.cnpj = cnpj;
 this.dataFundacao = dataFundacao;
 this.qtdFuncionarios = qtdFuncionarios;
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
 public int getQtdFuncionarios(){
	 return qtdFuncionarios;
 	}

 public void setQtdFuncionarios(int qtdFuncionarios) {
	 this.qtdFuncionarios = qtdFuncionarios;
 	}
 
 
 public double calculaScore(){
	 double score;
	 int quantidadeCarros = listaVeiculos.size();
	
	score = (CalcSeguro.VALOR_BASE.fator)*(1 + (qtdFuncionarios/100))*quantidadeCarros;
	 
	return score; 
 }

 @Override
 public String toString () {
	
		String saida = "";
		saida += super.toString() + " Cnpj: " + this.cnpj + " \n Data de Fundação: " + this.dataFundacao + "\n Quantidade de Funcionários: " + this.qtdFuncionarios + "\n";
		return saida;
		}
 }
