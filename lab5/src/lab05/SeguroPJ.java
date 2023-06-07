package lab05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* testar listaSinistroCondutor()*/

public class SeguroPJ extends Seguro{

	private Frota frota;
	private ClientePJ cliente;
	
	// Construtor
	public SeguroPJ(Date dataInicio, Date dataFim,Seguradora seguradora,  Frota frota, ClientePJ cliente) {
		super(dataInicio,dataFim,seguradora); 
			
		this.frota = frota;
		this.cliente = cliente;
	}
	
	public Frota getFrota() {
		return frota;
	}
	
	public void setFrota(Frota frota) {
		this.frota = frota;
	}
	
	public ClientePJ getCliente(){
		return cliente;
		}
	
	public void setCliente(ClientePJ cliente) {
		this.cliente = cliente;
	}
		
	public int calculaAno(Date dataFundacao)throws ParseException {
	 	
	 	// Define a data de hoje numa variavel
		Date date = new Date(); 
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		// Separa a data de fundacao em apenas Ano:
	 	SimpleDateFormat y = new SimpleDateFormat("yyyy"); 
		int nAno = Integer.parseInt( y.format(dataFundacao)); 
		
		// Define o ano atual:
		int ano = calendar.get(Calendar.YEAR);
		
		// Calcula a ano pos fundacao (ano atual - ano fundacao):
		int idadeAno =  ano - nAno;
		
		return idadeAno;
 }
  
	public int quantidadeSinistrosCondutor(){
		int quantidadeSinistrosCondutor = 0;
		for(Condutor condutor : getListaCondutores()) { // acessa a cada condutor da lista
			quantidadeSinistrosCondutor += condutor.getListaSinistro().size();	// ve a quantidade de sinistro que possui e adiciona aqui, e segue para ver o proximo condutor
			}
		return quantidadeSinistrosCondutor;
	}

	public double calcularValor() throws ParseException {
		  
		 int AnosPosFundacao = calculaAno(cliente.getDataFundacao());
		 
		 // calcula a quantidade de itens nas listas
		 int quantidadeVeiculos = cliente.getListaFrota().size();
		 int quantidadeFunc = getListaCondutores().size(); // considerando funcionarios = condutores
		 int quantidadeSinistrosCliente = seguradora.listarSinistros(cliente.getNome()).size();
		 int quantidadeSinistrosCondutor = quantidadeSinistrosCondutor();
		 
		 // define o valor mensal
		 double valor = (CalcSeguro.VALOR_BASE.fator)*(10 + (quantidadeFunc/10))*(1+1/(quantidadeVeiculos + 2))*(1 + 1/(AnosPosFundacao + 2))* (2 + quantidadeSinistrosCliente/10) * (5 + quantidadeSinistrosCondutor/10);

		 return valor;
		
	}
	
	@Override
	public String toString () {
		return  super.toString() + 
				" Frota: " + this.frota + 
				"\n Cliente: " + this.cliente.getNome()+ "\n";
	}
}
