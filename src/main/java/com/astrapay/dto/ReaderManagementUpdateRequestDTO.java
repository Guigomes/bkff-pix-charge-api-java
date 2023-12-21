package com.astrapay.dto;

import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReaderManagementUpdateRequestDTO extends ReaderManagementRequestDTO {

	@Positive
	private long id;

}
