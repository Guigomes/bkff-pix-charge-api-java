package com.astrapay.dto.cob.common;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CobCalendarioResponseDTO {
	
	@NotNull
	@Schema(description = "Timestamp que indica o momento em que foi criada a cobrança. Respeita o formato definido na RFC 3339.")
	private LocalDateTime criacao;

	@NotNull
	@Positive
	@Schema(description = "Tempo de vida da cobrança, especificado em segundos. default: 86400", example = "3600")
	private Integer expiracao;
}
