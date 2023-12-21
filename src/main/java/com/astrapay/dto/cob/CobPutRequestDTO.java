package com.astrapay.dto.cob;

import java.util.List;

import com.astrapay.dto.InfoAdicional;
import com.astrapay.dto.LocRequestDTO;
import com.astrapay.dto.cob.common.CobCalendarioRequestDTO;
import com.astrapay.dto.cob.common.CobDevedorDTO;
import com.astrapay.dto.cob.common.CobValorDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CobPutRequestDTO {

	@Schema(description = "Os campos aninhados sob o identificador calendário organizam informações a respeito de controle de tempo da cobrança.")
	@NotNull
	private CobCalendarioRequestDTO calendario;

	@Schema(description = "Os campos aninhados sob o objeto devedor são opcionais e identificam o devedor, ou seja, a pessoa ou a instituição a quem a cobrança está endereçada. Não identifica, necessariamente, quem irá efetivamente realizar o pagamento. Um CPF pode ser o devedor de uma cobrança, mas pode acontecer de outro CPF realizar, efetivamente, o pagamento do documento. Não é permitido que o campo devedor.cpf e campo devedor.cnpj estejam preenchidos ao mesmo tempo. Se o campo devedor.cnpj está preenchido, então o campo devedor.cpf não pode estar preenchido, e vice-versa. Se o campo devedor.nome está preenchido, então deve existir ou um devedor.cpf ou um campo devedor.cnpj preenchido.")
	private CobDevedorDTO devedor;

	@Schema(description = "Identificador da localização do payload.")
	private @Valid LocRequestDTO loc;

	@NotNull
	@Schema(description = "valores monetários referentes à cobrança.")
	private @Valid CobValorDTO valor;

	@NotBlank
	@Schema(description = "Chave DICT do recebedor", example = "302a6b0c-bd3d-429c-bbff-a4f933260eca")
	@Size(max = 77)
	private String chave;

	@Size(max = 140)
	@Schema(description = "O campo solicitacaoPagador, opcional, determina um texto a ser apresentado ao pagador para que ele possa digitar uma informação correlata, em formato livre, a ser enviada ao recebedor. Esse texto será preenchido, na pacs.008, pelo PSP do pagador, no campo RemittanceInformation . O tamanho do campo na pacs.008 está limitado a 140 caracteres.")
	private String solicitacaoPagador;

	@Schema(description = "Informações adicionais: Cada respectiva informação adicional contida na lista (nome e valor) deve ser apresentada ao pagador.")
	private @Valid List<InfoAdicional> infoAdicionais;

}
