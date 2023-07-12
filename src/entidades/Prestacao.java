package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Prestacao {

	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private LocalDate data;
	private Double valor;

	public Prestacao() {
	}

	public Prestacao(LocalDate data, Double valor) {
		this.data = data;
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setDate(LocalDate data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return data.format(fmt) + " - " + String.format("%.2f", valor);
	}

}
