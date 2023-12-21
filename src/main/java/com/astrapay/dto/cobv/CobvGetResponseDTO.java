package com.astrapay.dto.cobv;

import java.util.List;

import com.astrapay.dto.InfoAdicional;
import com.astrapay.dto.LocResponseDTO;
import com.astrapay.dto.PixResponseDTO;
import com.astrapay.dto.cobv.common.CobvCalendarioDTO;
import com.astrapay.dto.cobv.common.CobvDevedorDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CobvGetResponseDTO {

	@Schema(description = "Os campos aninhados sob o identificador calendário organizam informações a respeito de controle de tempo da cobrança.")
	private @Valid CobvCalendarioDTO calendario;

	@NotBlank
	@Schema(description = "Id da Transação")
	private String txId;

	@Schema(description = "O campo revisao\n"
			+ "Denota a revisão da cobrança. Sempre começa em zero. Sempre varia em acréscimos de 1.\n" + "\n"
			+ "O incremento em uma cobrança deve ocorrer sempre que um objeto da cobrança em questão for alterado. O campo loc é uma exceção a esta regra.\n"
			+ "\n"
			+ "Se em uma determinada alteração em uma cobrança, o único campo alterado for o campo loc, então esta operação não incrementa a revisão da cobrança.\n"
			+ "\n"
			+ "O campo loc não ocasiona uma alteração na cobrança em si. Não é necessário armazenar histórico das alterações do campo loc para uma determinada cobrança. Para os outros campos da cobrança, registra-se histórico.")
	private Integer revisao;

	@Schema(description = "O objeto devedor organiza as informações sobre o devedor da cobrança.")
	private CobvDevedorDTO devedor;

	@Schema(description = "O objeto recebedor organiza as informações sobre o credor da cobrança.")
	private CobvRecebedor recebedor;

	@Schema(description = "Identificador da localização do payload.")
	private @Valid LocResponseDTO loc;

	@Schema(description = "Estado do registro da cobrança. Não se confunde com o estado da cobrança em si, ou seja, não guarda relação com o fato de a cobrança encontrar-se vencida ou expirada, por exemplo.\n"
			+ "\n" + "Os status são assim definidos:\n" + "\n"
			+ "ATIVA: indica que o registro se refere a uma cobrança que foi gerada mas ainda não foi paga nem removida;\n"
			+ "CONCLUIDA: indica que o registro se refere a uma cobrança que já foi paga e, por conseguinte, não pode acolher outro pagamento;\n"
			+ "REMOVIDO_PELO_USUARIO_RECEBEDOR: indica que o usuário recebedor solicitou a remoção do registro da cobrança; e\n"
			+ "REMOVIDO_PELO_PSP: indica que o PSP Recebedor solicitou a remoção do registro da cobrança.")
	private String status;

	@Schema(description = "valores monetários referentes à cobrança.")
	private CobvResponseValorDTO valor;

	@Schema(description = "Este campo retorna o valor do Pix Copia e Cola correspondente à cobrança. Trata-se da sequência de caracteres que representa o BR Code.")
	private String pixCopiaECola;

	@Size(max = 140)
	@Schema(description = "O campo solicitacaoPagador, opcional, determina um texto a ser apresentado ao pagador para que ele possa digitar uma informação correlata, em formato livre, a ser enviada ao recebedor. Esse texto será preenchido, na pacs.008, pelo PSP do pagador, no campo RemittanceInformation . O tamanho do campo na pacs.008 está limitado a 140 caracteres.")
	private String solicitacaoPagador;

	@Schema(description = "Informações adicionais: Cada respectiva informação adicional contida na lista (nome e valor) deve ser apresentada ao pagador.")
	private List<InfoAdicional> infoAdicionais;

	@NotBlank
	@Schema(description = "Chave DICT do recebedor")
	@Size(max = 77)
	private String chave;

	@Schema(description = "Pix recebidos")
	private List<PixResponseDTO> pix;

	@Getter
	@Setter
	@ToString
	public static class CobvRecebedor extends CobvDevedorDTO {

	}

	public static class CobvResponseValorDTO extends CobvPutValorDTO {
	}

	
}
