package com.astrapay.dto.cobv.common;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CobvCalendarioDTO {
	@Schema(description = "Trata-se de uma data, no formato YYYY-MM-DD, segundo ISO 8601. É a data de vencimento da cobrança. A cobrança pode ser honrada até esse dia, inclusive, em qualquer horário do dia.", example = "2023-02-02")
	@NotNull
	private LocalDate dataDeVencimento;

	@Schema(description = "Trata-se da quantidade de dias corridos após calendario.dataDeVencimento, em que a cobrança poderá ser paga.")
	private Integer validadeAposVencimento;
}
