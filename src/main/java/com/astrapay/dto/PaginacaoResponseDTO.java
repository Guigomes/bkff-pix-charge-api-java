package com.astrapay.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaginacaoResponseDTO {

	@Schema(description = "Número da página recuperada.")
	private int paginaAtual;
	
	@Schema(description = "Quantidade de registros retornado na página.")
	private int itensPorPagina;
	
	@Schema(description = "Quantidade de páginas disponíveis para consulta.")
	private int quantidadeDePaginas;
	
	@Schema(description = "Quantidade total de itens disponíveis de acordo com os parâmetros informados.")
	private int quantidadeTotalDeItens;

}
