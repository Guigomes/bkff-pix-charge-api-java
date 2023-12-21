package com.astrapay.dto.cob;

import java.util.List;

import com.astrapay.dto.InfoAdicional;
import com.astrapay.dto.LocResponseDTO;
import com.astrapay.dto.PixResponseDTO;
import com.astrapay.dto.cob.common.CobCalendarioResponseDTO;
import com.astrapay.dto.cob.common.CobDevedorDTO;
import com.astrapay.dto.cob.common.CobValorDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CobResponseDTO {
	@NotBlank
	@Size(min = 26)
	@Size(max = 35)
	private String txid;

	@NotNull
	private Integer revisao;

	@NotNull
	@Schema(description = "Os campos aninhados sob o identificador calendário organizam informações a respeito de controle de tempo da cobrança.")
	private CobCalendarioResponseDTO calendario;

	@Schema(description = "Os campos aninhados sob o objeto devedor são opcionais e identificam o devedor, ou seja, a pessoa ou a instituição a quem a cobrança está endereçada. Não identifica, necessariamente, quem irá efetivamente realizar o pagamento. Um CPF pode ser o devedor de uma cobrança, mas pode acontecer de outro CPF realizar, efetivamente, o pagamento do documento. Não é permitido que o campo devedor.cpf e campo devedor.cnpj estejam preenchidos ao mesmo tempo. Se o campo devedor.cnpj está preenchido, então o campo devedor.cpf não pode estar preenchido, e vice-versa. Se o campo devedor.nome está preenchido, então deve existir ou um devedor.cpf ou um campo devedor.cnpj preenchido.")
	private CobDevedorDTO devedor;

	@Schema(description = "Identificador da localização do payload.")
	private LocResponseDTO loc;

	@Schema(description = "valores monetários referentes à cobrança.")
	private CobValorDTO valor;

	@Schema(description = "Chave DICT do recebedor")
	private String chave;

	@Schema(description = "Localização do payload")
	private String location;

	@Schema(description = "Estado do registro da cobrança. Não se confunde com o estado da cobrança em si, ou seja, não guarda relação com o fato de a cobrança encontrar-se vencida ou expirada, por exemplo.\n"
			+ "\n" + "Os status são assim definidos:\n" + "\n"
			+ "ATIVA: indica que o registro se refere a uma cobrança que foi gerada mas ainda não foi paga nem removida;\n"
			+ "CONCLUIDA: indica que o registro se refere a uma cobrança que já foi paga e, por conseguinte, não pode acolher outro pagamento;\n"
			+ "REMOVIDO_PELO_USUARIO_RECEBEDOR: indica que o usuário recebedor solicitou a remoção do registro da cobrança; e\n"
			+ "REMOVIDO_PELO_PSP: indica que o PSP Recebedor solicitou a remoção do registro da cobrança.")
	private String status;

	@Schema(description = "Este campo retorna o valor do Pix Copia e Cola correspondente à cobrança. Trata-se da sequência de caracteres que representa o BR Code.")
	private String pixCopiaECola;

	@Size(max = 140)
	@Schema(description = "O campo solicitacaoPagador, opcional, determina um texto a ser apresentado ao pagador para que ele possa digitar uma informação correlata, em formato livre, a ser enviada ao recebedor. Esse texto será preenchido, na pacs.008, pelo PSP do pagador, no campo RemittanceInformation . O tamanho do campo na pacs.008 está limitado a 140 caracteres.")
	private String solicitacaoPagador;

	@Schema(description = "Informações adicionais: Cada respectiva informação adicional contida na lista (nome e valor) deve ser apresentada ao pagador.")
	private List<InfoAdicional> infoAdicionais;
	
	@Schema(description = "Pix recebidos")
	private List<PixResponseDTO> pix;

}
