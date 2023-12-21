package com.astrapay.dto.lotecobv;

import java.util.List;

import com.astrapay.dto.cobv.CobvPutRequestDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LotecobvPutRequestDTO {

	@Schema(description = "Descrição do lote", example = "Cobranças dos alunos do turno vespertino")
	private @NotNull String descricao;

	private @NotNull @NotEmpty List<LoteCobsv> cobsv;

	public static class LoteCobsv extends CobvPutRequestDTO

	{
		@Pattern(regexp = "[a-zA-Z0-9]{26,35}")
		private @NotBlank String txid;

	}

}
