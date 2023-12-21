package com.astrapay.dto.lotecobv;

import java.time.LocalDateTime;
import java.util.List;

import com.astrapay.dto.PaginacaoResponseDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LotecobvGetAllResponseDTO {

	@Schema(description = "Parâmetros utilizados para a realização de uma consulta de lote de cobranças com vencimento.")
	private Parametros parametros;

	@Schema(description = "Lotes de solicitações de criação/alteração de cobranças com vencimento")
	private List<LotecobvGetResponseDTO> lotes;

	@Getter
	@Setter
	@ToString
	public static class Parametros {

		@Schema(description = "Data inicial utilizada na consulta. Respeita RFC 3339.")
		private LocalDateTime inicio;

		@Schema(description = "Data de fim utilizada na consulta. Respeita RFC 3339.")
		private LocalDateTime fim;

		private PaginacaoResponseDTO paginacao;

	}

}
