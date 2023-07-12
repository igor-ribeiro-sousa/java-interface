package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contrato {

	private Integer numero;
	private LocalDate data;
	private Double valorTotal;

	private List<Prestacao> prestacoes = new ArrayList<>();

	public Contrato() {
	}

	public Contrato(Integer numero, LocalDate data, Double valorTotal) {
		this.numero = numero;
		this.data = data;
		this.valorTotal = valorTotal;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Prestacao> getPrestacoes() {
		return prestacoes;
	}
}
