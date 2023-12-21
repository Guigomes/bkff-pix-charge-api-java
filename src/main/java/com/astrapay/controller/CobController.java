package com.astrapay.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.astrapay.delegate.CobDelegate;
import com.astrapay.dto.cob.CobGetAllResponseDTO;
import com.astrapay.dto.cob.CobPatchRequestDTO;
import com.astrapay.dto.cob.CobPostRequestDTO;
import com.astrapay.dto.cob.CobPutRequestDTO;
import com.astrapay.dto.cob.CobResponseDTO;
import com.astrapay.entity.AstraErrorMessage;
import com.astrapay.logger.AstraLogger;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("v1/cob")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class CobController {

	private final AstraLogger logger;

	private final CobDelegate cobDelegate;

	@PutMapping("/{txId}")
	@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AstraErrorMessage.class)))
	@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AstraErrorMessage.class)))
	public ResponseEntity<CobResponseDTO> createCob(
			
			@RequestHeader("x-transaction-id") @Parameter(name = "x-transaction-id", description = "UUID da transação", example = "328d5e1a-06dd-4263-8081-0a2ec31c1f9a") String xTransactionId,

			@RequestBody @Valid CobPutRequestDTO request, @PathVariable String txId) throws Exception {

		return cobDelegate.createCob(txId, request, xTransactionId, null);

	}

	@PatchMapping("/{txId}")
	@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AstraErrorMessage.class)))
	@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AstraErrorMessage.class)))
	public ResponseEntity<CobResponseDTO> alterCob(
			@RequestHeader("authorization") @Parameter(name = "authorization", description = "JWT Token") String authorization,
			@RequestHeader("x-transaction-id") @Parameter(name = "x-transaction-id", description = "UUID da transação", example = "328d5e1a-06dd-4263-8081-0a2ec31c1f9a") String xTransactionId,

			@RequestBody @Valid CobPatchRequestDTO request, @PathVariable String txId) throws Exception {

		logger.info("Atualizando  exemplo: %s", request);

		return new ResponseEntity<>(cobDelegate.alterCob(txId, request, xTransactionId, authorization), HttpStatus.OK);

	}

	@GetMapping("/{txid}")
	@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AstraErrorMessage.class)))
	@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AstraErrorMessage.class)))
	public ResponseEntity<CobResponseDTO> consultCob(
			@RequestHeader("authorization") @Parameter(name = "authorization", description = "JWT Token") String authorization,
			@RequestHeader("x-transaction-id") @Parameter(name = "x-transaction-id", description = "UUID da transação", example = "328d5e1a-06dd-4263-8081-0a2ec31c1f9a") String xTransactionId,

			@PathVariable String txid, @RequestParam(name = "revisao", required = false) Integer revisao)
			throws Exception {

		logger.info("buscando um exemplo por id: " + txid);

		return new ResponseEntity<>(cobDelegate.consultCob(txid, revisao, xTransactionId, authorization),
				HttpStatus.OK);

	}

	@PostMapping("/")
	@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AstraErrorMessage.class)))
	@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AstraErrorMessage.class)))
	public ResponseEntity<CobResponseDTO> createCob(
			@RequestHeader("authorization") @Parameter(name = "authorization", description = "JWT Token") String authorization,
			@RequestHeader("x-transaction-id") @Parameter(name = "x-transaction-id", description = "UUID da transação", example = "328d5e1a-06dd-4263-8081-0a2ec31c1f9a") String xTransactionId,

			@RequestBody @Valid CobPostRequestDTO request) throws Exception {

		logger.info("Criando novo exemplo: %s", request);

		return new ResponseEntity<>(cobDelegate.createCob(request, xTransactionId, authorization), HttpStatus.OK);

	}

	@GetMapping("/")
	@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AstraErrorMessage.class)))
	@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AstraErrorMessage.class)))
	public ResponseEntity<CobGetAllResponseDTO> listCobs(
			@RequestHeader("authorization") @Parameter(name = "authorization", description = "JWT Token") String authorization,
			@RequestHeader("x-transaction-id") @Parameter(name = "x-transaction-id", description = "UUID da transação", example = "328d5e1a-06dd-4263-8081-0a2ec31c1f9a") String xTransactionId,
			@RequestParam @NotNull LocalDateTime inicio, @RequestParam @NotNull LocalDateTime fim,
			@RequestParam(name = "cpf", required = false) String cpf,
			@RequestParam(name = "cnpj", required = false) String cnpj,
			@RequestParam(name = "locationPresente", required = false) Boolean locationPresente,
			@RequestParam(name = "status", required = false) String status,
			@RequestParam(name = "paginaAtual", required = false) Integer paginaAtual,
			@RequestParam(name = "itensPorPagina", required = false) Integer itensPorPagina)

			throws Exception {

		logger.info("Listando todos os exemplos");

		return ResponseEntity.ok(cobDelegate.listCobs(inicio, fim, cpf, cnpj, locationPresente, status, paginaAtual,
				itensPorPagina, xTransactionId, authorization));

	}

}