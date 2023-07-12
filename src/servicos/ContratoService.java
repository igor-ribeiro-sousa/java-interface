package servicos;

import java.time.LocalDate;

import entidades.Contrato;
import entidades.Prestacao;

public class ContratoService {

	private PagamentoOnlineService pagamentoOnlineService;

	public ContratoService(PagamentoOnlineService pagamentoOnlineService) {
		this.pagamentoOnlineService = pagamentoOnlineService;
	}
	
	public void processoContrato(Contrato contrato, int meses) {
		
		double parcelaBasica = contrato.getValorTotal() / meses;
		
		for(int i = 1; i <= meses; i++) {
			LocalDate vencimentoParcela = contrato.getData().plusMonths(i);
			
			double juros = pagamentoOnlineService.juros(parcelaBasica, i);
			double taxa  = pagamentoOnlineService.taxaPagamento(parcelaBasica + juros);
			double parcela = parcelaBasica + juros + taxa;
			
			contrato.getPrestacoes().add(new Prestacao(vencimentoParcela, parcela));
		}

	}
}
