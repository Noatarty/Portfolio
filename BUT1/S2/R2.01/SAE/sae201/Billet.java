package sae201;

import java.util.Objects;

public class Billet {
	
	private String numero;
	private Tarification maTarif;

	public Billet(String numero,Tarification maTarif) {
		super();
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Billet [numero=" + numero + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Billet other = (Billet) obj;
		return Objects.equals(numero, other.numero);
	}
	
	public void creerTarif(double pleinTarif) {
		this.maTarif = new Tarification(); 
	}
	
}
