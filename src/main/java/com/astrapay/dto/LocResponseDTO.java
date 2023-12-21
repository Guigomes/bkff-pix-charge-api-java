package com.astrapay.dto;

import java.time.LocalDateTime;

import com.astrapay.enums.TipoCobEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class LocResponseDTO {
	@NotNull
	@Positive
	@Schema(description = "Identificador da location a ser informada na criação da cobrança .", example = "1")
	private Integer id;

	@NotNull
	@Size(max = 77)
	@Schema(description = "Identificador da location a ser informada na criação da cobrança", example = "pix.example.com/qr/v2/2353c790eefb11eaadc10242ac120002")
	private String location;

	@Schema(description = "Tipo da cobrança",  defaultValue = "cob")
	private String tipoCob;

	@Schema(description = "Data e hora em que a location foi criada. Respeita RFC 3339")
	private LocalDateTime criacao;
}
