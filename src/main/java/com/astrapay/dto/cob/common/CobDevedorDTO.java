package com.astrapay.dto.cob.common;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CobDevedorDTO {
	
	@Schema(description = "CNPJ do usuário.")
	@Pattern(regexp = "/^\\d{14}$/")
	private String cnpj;
	
	@Schema(description = "CPF do usuário.", example = "1012805808")
	@Pattern(regexp = "/^\\d{11}$/")
	private String cpf;
	
	@Schema(description = "Nome do usuário.", example = "Fulano Gomes da Silva")
	private String nome;

}