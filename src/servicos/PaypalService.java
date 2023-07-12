package servicos;

public class PaypalService implements PagamentoOnlineService{

	@Override
	public double taxaPagamento(double valor) {
		return valor * 0.02;
	}

	@Override
	public double juros(double valor, int meses) {
		return valor * 0.01 * meses;
	}

}
