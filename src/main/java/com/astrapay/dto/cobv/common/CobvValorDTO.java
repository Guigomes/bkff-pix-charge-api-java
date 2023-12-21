package com.astrapay.dto.cobv.common;

import java.time.LocalDate;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class CobvValorDTO {
	
	@Schema(description = "Multa aplicada à cobrança.")
	private @Valid Multa multa;
	
	@Schema(description = "Juro aplicada à cobrança.")
	private @Valid Juros juros;
	
	@Schema(description = "Abatimento aplicada à cobrança.")
	private @Valid Abatimento abatimento;
	
	@Schema(description = "Descontos aplicada à cobrança.")
	private @Valid Desconto desconto;

	@Getter
	@Setter
	@ToString
	public static class Multa {
		@Schema(description = "Modalidade da multa, conforme tabela de domínios", example = "1", $comment = "Valor Fixo: 1, Percentual	2")
		@NotNull
		@Min(1)
		@Max(2)
		private Integer modalidade;

		@NotBlank
		@Schema(description = "Multa do documento em valor absoluto ou percentual, conforme \"valor.multa.modalidade\".", example = "400.00")
		@Pattern(regexp = "\\d{1,10}\\.\\d{1,2}")
		private String valorPerc;

	}

	@Getter
	@Setter
	@ToString
	public static class Abatimento {
		@Schema(description = "Modalidade de abatimentos, conforme tabela de domínios.", example = "1", $comment = "Valor Fixo: 1, Percentual	2")
		@NotNull
		@Min(1)
		@Max(2)
		private Integer modalidade;

		@NotBlank
		@Schema(description = "Abatimento do documento em valor absoluto ou percentual, conforme \"valor.abatimento.modalidade\".", example = "400.00")
		@Pattern(regexp = "\\d{1,10}\\.\\d{1,2}")
		private String valorPerc;

	}

	@Getter
	@Setter
	@ToString
	public static class Juros {

		@Schema(description = "Modalidade de juros, conforme tabela de domínios.", example = "1", $comment = "Valor (dias corridos): 	1\n"
				+ "Percentual ao dia (dias corridos): 2\n" + "Percentual ao mês (dias corridos): 3\n"
				+ "Percentual ao ano (dias corridos): 4\n" + "Valor (dias úteis): 5\n"
				+ "Percentual ao dia (dias úteis):	6\n" + "Percentual ao mês (dias úteis):	7\n"
				+ "Percentual ao ano (dias úteis): 8")
		@NotNull
		@Min(1)
		@Max(8)
		private String modalidade;

		@NotBlank
		@Schema(description = "juros do documento em valor absoluto ou percentual, conforme \"valor.juros.modalidade\".", example = "400.00")
		@Pattern(regexp = "\\d{1,10}\\.\\d{1,2}")
		private String valorPerc;

	}

	@Getter
	@Setter
	@ToString
	public static class Desconto {

		@Schema(description = "Modalidade de desconto, conforme tabela de domínios.", example = "1", $comment = "Valor Fixo até a[s] data[s] informada[s]	1\n"
				+ "Percentual até a data informada	2\n" + "Valor por antecipação dia corrido	3\n"
				+ "Valor por antecipação dia útil	4\n" + "Percentual por antecipação dia corrido	5\n"
				+ "Percentual por antecipação dia útil	6")
		@NotNull
		@Min(1)
		@Max(6)
		private String modalidade;

		@Schema(description = "Descontos absolutos aplicados à cobrança.")
		private @Valid List<DescontoDataFixa> descontoDataFixa;

		@Pattern(regexp = "\\d{1,10}\\.\\d{1,2}")
		@Schema(description = "Abatimentos ou outras deduções aplicadas ao documento, em valor absoluto ou percentual do valor original do documento.", example = "400.00")
		private String valorPerc;

	}

	@Getter
	@Setter
	@ToString
	public static class DescontoDataFixa {

		@NotNull
		@Schema(description = "Descontos por pagamento antecipado, com data fixa. Matriz com até três elementos, sendo que cada elemento é composto por um par \"data e valorPerc\", para estabelecer descontos percentuais ou absolutos, até aquela data de pagamento. Trata-se de uma data, no formato YYYY-MM-DD, segundo ISO 8601. A data de desconto obrigatoriamente deverá ser menor ou igual à data de vencimento da cobrança.")
		private LocalDate data;

		@NotBlank
		@Schema(description = "Desconto em valor absoluto ou percentual por dia, útil ou corrido, conforme valor.desconto.modalidade.", example = "400.00")
		@Pattern(regexp = "\\d{1,10}\\.\\d{1,2}")
		private String valorPerc;

	}

}
