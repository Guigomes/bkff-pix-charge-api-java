package com.astrapay.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LocRequestDTO {
	
	@Positive
	@Schema(description = "Identificador da location a ser informada na criação da cobrança .", example = "1")
	private Integer id;
}
