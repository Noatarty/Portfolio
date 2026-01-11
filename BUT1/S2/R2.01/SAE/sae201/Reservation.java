package sae201;

import java.util.Date;
import java.util.Objects;

public class Reservation {
	
	private String numero;
	private Date date;
	private Date dateEnvoieConf;
	
	public Reservation(String numero, Date date, Date dateEnvoieConf) {
		super();
		this.numero = numero;
		this.date = date;
		this.dateEnvoieConf = dateEnvoieConf;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDateEnvoieConf() {
		return dateEnvoieConf;
	}
	public void setDateEnvoieConf(Date dateEnvoieConf) {
		this.dateEnvoieConf = dateEnvoieConf;
	}
	@Override
	public String toString() {
		return "Reservation [numero=" + numero + ", date=" + date + ", dateEnvoieConf=" + dateEnvoieConf + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(date, dateEnvoieConf, numero);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(date, other.date) && Objects.equals(dateEnvoieConf, other.dateEnvoieConf)
				&& Objects.equals(numero, other.numero);
	}
	
	
}
