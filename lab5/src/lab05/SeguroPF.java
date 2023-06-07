package lab05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



public class SeguroPF extends Seguro{

	private Veiculo veiculo;
	private ClientePF cliente;
	
	// Construtor
	public SeguroPF(Date dataInicio, Date dataFim,Seguradora seguradora, Veiculo veiculo, ClientePF cliente) {
		super(dataInicio,dataFim,seguradora); 
			
		this.veiculo = veiculo;
		this.cliente = cliente;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public ClientePF getCliente(){
		return cliente;
		}
	public void setCliente(ClientePF cliente) {
		this.cliente = cliente;
	}
	
	
	public int calculaIdade(Date dataNascimento)throws ParseException {
	 	
	 	// Define a data de hoje numa variavel
		Date date = new Date(); 
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		// Separa a data de nascimento em Dia, Mes e Ano:
	 	SimpleDateFormat y = new SimpleDateFormat("yyyy"); 
		SimpleDateFormat m = new SimpleDateFormat("MM"); 
		SimpleDateFormat d = new SimpleDateFormat("dd"); 	
		int nAno = Integer.parseInt( y.format(dataNascimento)); 
		int nMes = Integer.parseInt( m.format(dataNascimento)); 
		int nDia = Integer.parseInt( d.format(dataNascimento)); 
		
		// Define a data do dia de hoje separada em Dia, Mes e Ano:
		int ano = calendar.get(Calendar.YEAR);
		int mes = calendar.get(Calendar.MONTH);
		int dia = calendar.get(Calendar.DAY_OF_MONTH);
		
		
		// Calcula a idade:
		int idade = 0;
		
		int idadeAno =  ano - nAno;
		int idadeDia = dia - nDia;
		int idadeMes = mes - nMes;
		
		/* Se o mes/dia do aniversario for maior que o data de hoje (subtração deu negativa) 
		*  entao a pessoa ainda nao fez aniversario
		*  logo a idade e' a diferenca de anos -1
		*/
		
		if ((idadeMes <= 0) || (idadeDia < 0)) { 
				idade = idadeAno - 1;
				
		}else {
			idade = idadeAno;
		}
		return idade;
 }
	public int quantidadeSinistrosCondutor(){
		int quantidadeSinistrosCondutor = 0;
		for(Condutor condutor : getListaCondutores()) { // acessa a cada condutor da lista
			quantidadeSinistrosCondutor += condutor.getListaSinistro().size();	// ve a quantidade de sinistro que possui e adiciona aqui, e segue para ver o proximo condutor
			}
		return quantidadeSinistrosCondutor;
	}


	public double calcularValor() throws ParseException {
		  
		 int idade = calculaIdade(cliente.getDataNascimento());
		 double fator_idade = 0;
		 
		 // define o Fator idade conforme as faixas etarias
		 if ((idade >= 18) && (idade <= 30)){
			 fator_idade = CalcSeguro.FATOR_18_30.fator;
		 } else if((idade > 30) && (idade <= 60)) {
			 fator_idade = CalcSeguro.FATOR_30_60.fator;
		 } else if((idade > 60) && (idade <= 90)) {
			 fator_idade = CalcSeguro.FATOR_60_90.fator;
		 } else {
			 System.out.println("ERRO: Idade do cliente inválida\n");
		 }
		 
		 // calcula a quantidade de itens nas listas
		 int quantidadeVeiculos = cliente.getListaVeiculo().size();
		 int quantidadeSinistrosCliente = seguradora.listarSinistros(cliente.getNome()).size();
		 int quantidadeSinistrosCondutor = quantidadeSinistrosCondutor();
		 
		 // define o valor mensal
		 double valor = (CalcSeguro.VALOR_BASE.fator)*fator_idade*(1 + 1/(quantidadeVeiculos + 2))*(2 + quantidadeSinistrosCliente/10) * (5 + quantidadeSinistrosCondutor/10);
		 return valor;
		
	}
	 @Override
	public String toString () {
		return  super.toString() +  
				" Veículo: " + this.veiculo + 
				"\n Cliente: " + this.cliente.getNome()+ "\n";
	}
}
