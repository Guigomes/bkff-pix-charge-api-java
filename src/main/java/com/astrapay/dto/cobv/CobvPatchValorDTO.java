package com.astrapay.dto.cobv;

import com.astrapay.dto.cobv.common.CobvValorDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CobvPatchValorDTO extends CobvValorDTO {

	@Schema(description = "Valor original da cobrança.", example = "400.00")
	@Pattern(regexp = "\\d{1,10}\\.\\d{1,2}")
	private String original;

}
