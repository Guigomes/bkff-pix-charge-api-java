package com.astrapay.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReaderManagementResponseDTO {

	private int id;

	private String nome;

	private Double valor;

	private LocalDateTime dataCriacao;

	private Integer quantidade;

	private String email;

	private Integer limiteErros;

}
