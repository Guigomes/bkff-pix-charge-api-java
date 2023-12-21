package com.astrapay.dto.cob;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CobGetAllResponseDTO {

	private Parametros parametros;
	private List<CobResponseDTO> cobs;

	// getters e setters
	@Getter
	@Setter
	@ToString
	public static class Parametros {
		private LocalDateTime inicio;
		private LocalDateTime fim;
		private Paginacao paginacao;

	}

	@Getter
	@Setter
	@ToString
	public static class Paginacao {
		private int paginaAtual;
		private int itensPorPagina;
		private int quantidadeDePaginas;
		private int quantidadeTotalDeItens;

	}

}
