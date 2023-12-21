package com.astrapay.dto.cob.common;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CobValorDTO {

	@NotBlank
	@Schema(description = "Valor original da cobrança.", example = "400.00")
	@Pattern(regexp = "\\d{1,10}\\.\\d{1,2}")
	private String original;

	@Min(0)
	@Max(1)
	@Schema(description = "Trata-se de um campo que determina se o valor final do documento pode ser alterado pelo pagador. Na ausência desse campo, assume-se que não se pode alterar o valor do documento de cobrança, ou seja, assume-se o valor 0. Se o campo estiver presente e com valor 1, então está determinado que o valor final da cobrança pode ter seu valor alterado pelo pagador.", example = "0")
	private Integer modalidadeAlteracao;

}
