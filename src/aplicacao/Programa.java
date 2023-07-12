package aplicacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entidades.Contrato;
import entidades.Prestacao;
import servicos.ContratoService;
import servicos.PaypalService;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre os dados do contrato:");
		System.out.print("Numero: ");
		int numero = scan.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate data = LocalDate.parse(scan.next(), fmt);
		System.out.print("Valor do contrato: ");
		double valorContrato = scan.nextDouble();
		
		Contrato contrato = new Contrato(numero, data, valorContrato);
		
		System.out.print("Entre com o numero de parcelas: ");
		int n = scan.nextInt();
		
		ContratoService contratoService = new ContratoService(new PaypalService());
		
		contratoService.processoContrato(contrato, n);
		
		System.out.println("Parcelas: ");
		for(Prestacao prestacao : contrato.getPrestacoes()) {
			System.out.println(prestacao);
		}
		
		scan.close();
	}

}


/*
 * Uma empresa deseja automatizar o processamento de seus contratos. O
 * processamento deum contrato consiste em gerar as parcelas a serem pagas para
 * aquele contrato, com base nonúmero de meses desejado. A empresa utiliza um
 * serviço de pagamento online para realizar o pagamento das parcelas.Os
 * serviços de pagamento online tipicamente cobram um juro mensal, bem como uma
 * taxapor pagamento. Por enquanto, o serviço contratado pela empresa é o do
 * Paypal, que aplicajuros simples de 1% a cada parcela, mais uma taxa de
 * pagamento de 2%. Fazer um programa para ler os dados de um contrato (número
 * do contrato, data do contrato,e valor total do contrato). Em seguida, o
 * programa deve ler o número de meses paraparcelamento do contrato, e daí gerar
 * os registros de parcelas a serem pagas (data e valor),sendo a primeira
 * parcela a ser paga um mês após a data do contrato, a segunda parcela
 * doismeses após o contrato e assim por diante. Mostrar os dados das parcelas
 * na tela.
 */
