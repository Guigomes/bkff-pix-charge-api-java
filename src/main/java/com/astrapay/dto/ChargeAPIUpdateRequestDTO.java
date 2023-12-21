package com.astrapay.dto;

import com.astrapay.dto.cob.CobResponseDTO;

import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChargeAPIUpdateRequestDTO extends CobResponseDTO {

	@Positive
	private long id;

}
