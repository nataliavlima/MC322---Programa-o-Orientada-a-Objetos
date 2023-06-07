package lab05;

import java.util.ArrayList;


public class Frota {
	private String code;
	private ArrayList<Veiculo> listaVeiculos;
	
	// Construtor
	public Frota(String code) {
		this.code = code;
		this.listaVeiculos = new ArrayList<Veiculo>();
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
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
	
	public String toString () {
		return  " Code: " + this.code + 
				"\n Veiculos: " + this.listaVeiculos+ "\n";
	}
}
