package com.astrapay.dto.cob.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CobCalendarioRequestDTO {

	@Schema(description = "Tempo de vida da cobrança, especificado em segundos. default: 86400", example = "3600")
	private Integer expiracao;
}
