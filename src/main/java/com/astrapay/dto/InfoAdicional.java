package com.astrapay.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InfoAdicional {

	@NotBlank
	@Size(max = 50)
	@Schema(description = "Nome do campo.")

	private String nome;

	@NotBlank
	@Size(max = 200)
	@Schema(description = "Dados do campo.")
	private String valor;

}