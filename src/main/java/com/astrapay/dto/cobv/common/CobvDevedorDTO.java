package com.astrapay.dto.cobv.common;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CobvDevedorDTO {
	@Email
	private String email;
	@Max(200)
	private String logradouro;
	@Max(200)
	private String cidade;
	@Max(2)
	private String uf;
	@Max(8)
	private String cep;

	@Pattern(regexp = "/^\\d{14}$/")
	private String cnpj;

	@Pattern(regexp = "/^\\d{11}$/")
	private String cpf;
	@Max(200)
	private String nome;
}
