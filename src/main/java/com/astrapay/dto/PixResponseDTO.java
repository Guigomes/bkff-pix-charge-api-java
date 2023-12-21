package com.astrapay.dto;

import java.time.LocalDateTime;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class PixResponseDTO {
	@Getter
	@Setter
	@ToString
	public static class Pix {

		@Schema(description = "Id fim a fim da transação")
		private String endToEndId;

		@Schema(description = "Id da Transação")
		private String txid;

		@Schema(description = "Valor do Pix.")
		private String valor;

		@Schema(description = "O objetivo dessa estrutura é explicar os elementos de composição do valor do Pix, incluindo informações sobre as multas, juros, descontos e abatimentos quando o Pix for relativo a cobranças com vencimento.")
		private InformacoesValor componentesValor;

		@Schema(description = "Chave DICT do recebedor")
		private String chave;

		@Schema(description = "Horário em que o Pix foi processado no PSP.")
		private LocalDateTime horario;

		@Schema(description = "Informação livre do pagador")
		private String infoPagador;

		@Schema(description = "Devoluções")
		private List<Devolucao> devolucoes;

	}

	@ToString
	@Getter
	@Setter
	public static class InformacoesValor {

		private Original original;
		private Multa multa;
		private Desconto desconto;
		private Abatimento abatimento;
	}

	@ToString
	@Getter
	@Setter
	public static class Original {

		@Schema(description = "Valor original do Pix.")
		private String valor;
	}

	@ToString
	@Getter
	@Setter
	public static class Multa {

		@Schema(description = "Valor da multa.")
		private String valor;
	}

	@ToString
	@Getter
	@Setter
	public static class Abatimento {

		@Schema(description = "Valor do abatimento.")
		private String valor;
	}

	@ToString
	@Getter
	@Setter
	public static class Desconto {

		@Schema(description = "Valor do desconto.")
		private String valor;
	}

	@Getter
	@Setter
	@ToString
	public static class Devolucao {

		@Schema(description = "Id da Devolução")
		private String id;

		@Schema(description = "ReturnIdentification que transita na PACS004.")
		private String rtrId;

		@Schema(description = "Valor a devolver.")
		private String valor;

		@Schema(description = "	Natureza da Devoluçãostring\n" + "title: Natureza da Devolução\n"
				+ "Indica qual é a natureza da devolução. Uma devolução pode ser relacionada a um Pix comum (com códigos possíveis: MD06, BE08 e FR01 da pacs.004), ou a um Pix de Saque ou Troco (com códigos possíveis: MD06 e SL02 da pacs.004). Na ausência deste campo a natureza deve ser interpretada como sendo de um Pix comum (ORIGINAL).\n"
				+ "\n" + "As naturezas são assim definidas:\n" + "\n"
				+ "ORIGINAL: quando a devolução é solicitada pelo usuário recebedor e se refere a um Pix comum ou ao valor da compra em um Pix Troco (MD06);\n"
				+ "RETIRADA: quando a devolução é solicitada pelo usuário recebedor e se refere a um Pix Saque ou ao valor do troco em um Pix Troco (SL02);\n"
				+ "MED_OPERACIONAL: quando a devolução ocorre no âmbito do MED por motivo de falha operacional e se refere a um Pix comum (BE08);\n"
				+ "MED_FRAUDE: quando a devolução ocorre no âmbito do MED por fundada suspeita de fraude e se refere a um Pix comum (FR01).\n"
				+ "Os valores de devoluções são sempre limitados aos valores máximos a seguir:\n" + "\n"
				+ "Pix comum: o valor da devolução é limitado ao valor do próprio Pix (a natureza nesse caso pode ser: ORIGINAL, MED_OPERACIONAL ou MED_FRAUDE);\n"
				+ "Pix Saque: o valor da devolução é limitado ao valor da retirada (a natureza nesse caso deve ser: RETIRADA); e\n"
				+ "Pix Troco: o valor da devolução é limitado ao valor relativo à compra ou ao troco:\n"
				+ "Quando a devolução for referente à compra, o valor limita-se ao valor da compra (a natureza nesse caso deve ser ORIGINAL); e\n"
				+ "Quando a devolução for referente ao troco, o valor limita-se ao valor do troco (a natureza nesse caso deve ser RETIRADA).")
		private String natureza;

		@Schema(description = "Mensagem ao pagador relativa à devolução.")
		private String descricao;

		private Horario horario;

		@Schema(description = "Status da devolução.")
		private String status;

		@Schema(description = "Campo opcional que pode ser utilizado pelo PSP recebedor para detalhar os motivos de a devolução ter atingido o status em questão. Pode ser utilizado, por exemplo, para detalhar o motivo de a devolução não ter sido realizada.")
		private String motivo;

	}

	@Getter
	@Setter
	@ToString
	public static class Horario {

		@Schema(description = "Horário no qual a devolução foi solicitada no PSP.")
		private LocalDateTime solicitacao;

		@Schema(description = "Horário no qual a devolução foi liquidada no PSP.")
		private LocalDateTime liquidacao;
	}

}
