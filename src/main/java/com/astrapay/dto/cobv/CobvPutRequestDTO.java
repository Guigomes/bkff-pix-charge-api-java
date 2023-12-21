package com.astrapay.dto.cobv;

import java.util.List;

import com.astrapay.dto.InfoAdicional;
import com.astrapay.dto.LocRequestDTO;
import com.astrapay.dto.cobv.common.CobvCalendarioDTO;
import com.astrapay.dto.cobv.common.CobvDevedorDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CobvPutRequestDTO {

	@Schema(description = "Os campos aninhados sob o identificador calendário organizam informações a respeito de controle de tempo da cobrança.")
	private @Valid @NotNull CobvCalendarioDTO calendario;

	@NotNull
	@Schema(description = "O objeto devedor organiza as informações sobre o devedor da cobrança.")
	private CobvDevedorDTO devedor;

	@Schema(description = "Identificador da localização do payload.")
	private @Valid LocRequestDTO loc;

	@NotNull
	@Schema(description = "valores monetários referentes à cobrança.")
	private @Valid CobvPutValorDTO valor;

	@NotBlank
	@Schema(description = "Chave DICT do recebedor")
	@Size(max = 77)
	private String chave;

	@Size(max = 140)
	@Schema(description = "O campo solicitacaoPagador, opcional, determina um texto a ser apresentado ao pagador para que ele possa digitar uma informação correlata, em formato livre, a ser enviada ao recebedor. Esse texto será preenchido, na pacs.008, pelo PSP do pagador, no campo RemittanceInformation . O tamanho do campo na pacs.008 está limitado a 140 caracteres.")
	private String solicitacaoPagador;

	@Schema(description = "Informações adicionais: Cada respectiva informação adicional contida na lista (nome e valor) deve ser apresentada ao pagador.")
	private @Valid List<InfoAdicional> infoAdicionais;

	
}
