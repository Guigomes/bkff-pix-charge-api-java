package com.astrapay.dto.cobv;

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
public class CobvGetAllResponseDTO {

	private Parametros parametros;
	private List<CobvGetResponseDTO> cobvs;

	@Getter
	@Setter
	@ToString
	public static class Parametros {
		
		@Schema(description = "Data inicial utilizada na consulta. Respeita RFC 3339.")
		private LocalDateTime inicio;

		@Schema(description = "Data de fim utilizada na consulta. Respeita RFC 3339.")
		private LocalDateTime fim;
		
		@Schema(description = "Filtro pelo CPF do devedor. Não pode ser utilizado ao mesmo tempo que o CNPJ.")
		private String cpf;

		@Schema(description = "Filtro pelo CNPJ do devedor. Não pode ser utilizado ao mesmo tempo que o CPF")
		private String cnpj;
		
		@Schema(description = "Filtro pela existência de location vinculada.")
		private Boolean locationPresente;
		
		@Schema(description = "Filtro pelo status das cobranças.")
		private String status; 
		
		private PaginacaoResponseDTO paginacao;

	}


}
