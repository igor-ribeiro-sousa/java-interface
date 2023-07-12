package servicos;

public interface PagamentoOnlineService {
	
	double taxaPagamento(double valor);
	
	double juros(double valor, int meses);

}
