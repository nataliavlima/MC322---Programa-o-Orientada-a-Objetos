package lab05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



public class SeguroPF extends Seguro{

	private Veiculo veiculo;
	private ClientePF cliente;
	
	// Construtor
	public SeguroPF( Date dataInicio, Date dataFim,Seguradora seguradora, Veiculo veiculo, ClientePF cliente) {
		super( dataInicio,dataFim,seguradora); 
		super.setValorMensal(calcularValor());
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
	
	
	 public int calculaIdade(Date dataNascimento) {
	        LocalDate dataNasc = dataNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	        LocalDate hoje = LocalDate.now();
	        int idade = hoje.getYear() - dataNasc.getYear();

	        if (hoje.getMonthValue() < dataNasc.getMonthValue() || (hoje.getMonthValue() == dataNasc.getMonthValue() && hoje.getDayOfMonth() < dataNasc.getDayOfMonth())) {
	            idade--;
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

	@Override
	public double calcularValor() {
         //int idade = calculaIdade(getCliente().getDataNascimento());
		LocalDate dataNasc = cliente.getDataNascimento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
		 LocalDate dataAtual = LocalDate.now();
	     int idade = Period.between(dataNasc, dataAtual).getYears();
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
				" Veículo: \n" + this.veiculo.getPlaca() + 
				" Cliente: " + this.cliente.getNome()+ "\n";
	}
}
