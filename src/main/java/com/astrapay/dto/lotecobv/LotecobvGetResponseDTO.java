package com.astrapay.dto.lotecobv;

import java.time.LocalDateTime;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LotecobvGetResponseDTO {

	@Schema(description = "Identificador do lote em formato numérico")
	private Integer id;

	@Schema(description = "Descrição do lote")
	private String descricao;

	@Schema(description = "Data de criação do lote")
	private LocalDateTime criacao;

	@Schema(description = "Lista de cobranças no lote")
	private List<Cobranca> cobsv;

}

@Getter
@Setter
@ToString
class Cobranca {

	@Schema(description = "Id da Transação", pattern = "[a-zA-Z0-9]{26,35}")
	private String txid;

	@Schema(description = "Status da solicitação de criação/alteração da cobrança no contexto de criação via lote")
	private String status;

	@Schema(description = "Detalhes do problema, se houver")
	private Problema problema;

	@Schema(description = "Data de Criação")
	private LocalDateTime criacao;

}

@Getter
@Setter
@ToString
class Problema {

	@Schema(description = "URI de referência que identifica o tipo de problema", format = "uri")
	private String type;

	@Schema(description = "Descrição resumida do problema")
	private String title;

	@Schema(description = "Código HTTP do status retornado")
	private int status;

	@Schema(description = "Descrição completa do problema")
	private String detail;

	@Schema(description = "Identificador de correlação do problema para fins de suporte")
	private String correlationId;

	@Schema(description = "Lista de violações, se houver")
	private List<Violacao> violacoes;

}

@Getter
@Setter
@ToString
class Violacao {

	@Schema(description = "Descrição do erro")
	private String razao;

	@Schema(description = "Nome da propriedade")
	private String propriedade;

	@Schema(description = "Valor da propriedade")
	private String valor;

}