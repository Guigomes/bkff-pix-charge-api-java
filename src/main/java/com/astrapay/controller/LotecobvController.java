package com.astrapay.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.astrapay.delegate.LotecobvDelegate;
import com.astrapay.dto.cobv.CobvGetAllResponseDTO;
import com.astrapay.dto.lotecobv.LotecobvGetAllResponseDTO;
import com.astrapay.dto.lotecobv.LotecobvGetResponseDTO;
import com.astrapay.dto.lotecobv.LotecobvPatchRequestDTO;
import com.astrapay.dto.lotecobv.LotecobvPutRequestDTO;
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
@RequestMapping("v1/lotecobv")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class LotecobvController {

	private final AstraLogger logger;

	private final LotecobvDelegate lotecobvDelegate;

	@PutMapping("/{id}")
	@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AstraErrorMessage.class)))
	@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AstraErrorMessage.class)))
	public ResponseEntity<Void> put(
			@RequestHeader("authorization") @Parameter(name = "authorization", description = "JWT Token") String authorization,
			@RequestHeader("x-transaction-id") @Parameter(name = "x-transaction-id", description = "UUID da transação", example = "328d5e1a-06dd-4263-8081-0a2ec31c1f9a") String xTransactionId,

			@RequestBody @Valid LotecobvPutRequestDTO request, @PathVariable String id) throws Exception {

		logger.info("criando  lote de cobrança: %s - %s", request, xTransactionId);

		lotecobvDelegate.createLotecobv(id, request, xTransactionId, authorization);

		return ResponseEntity.status(HttpStatus.ACCEPTED).build();

	}

	@PatchMapping("/{id}")
	@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AstraErrorMessage.class)))
	@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AstraErrorMessage.class)))
	public ResponseEntity<Void> patch(
			@RequestHeader("authorization") @Parameter(name = "authorization", description = "JWT Token") String authorization,
			@RequestHeader("x-transaction-id") @Parameter(name = "x-transaction-id", description = "UUID da transação", example = "328d5e1a-06dd-4263-8081-0a2ec31c1f9a") String xTransactionId,

			@RequestBody @Valid LotecobvPatchRequestDTO request, @PathVariable String id) throws Exception {

		logger.info("Atualizando  exemplo: %s - %s", request, xTransactionId);

		lotecobvDelegate.alterLotrCobv(id, request, xTransactionId, authorization);

		return ResponseEntity.status(HttpStatus.ACCEPTED).build();

	}

	@GetMapping("/{id}")
	@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AstraErrorMessage.class)))
	@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AstraErrorMessage.class)))
	public ResponseEntity<LotecobvGetResponseDTO> findOne(
			@RequestHeader("authorization") @Parameter(name = "authorization", description = "JWT Token") String authorization,
			@RequestHeader("x-transaction-id") @Parameter(name = "x-transaction-id", description = "UUID da transação", example = "328d5e1a-06dd-4263-8081-0a2ec31c1f9a") String xTransactionId,

			@PathVariable Integer id, @RequestParam(name = "revisao", required = false) Integer revisao)
			throws Exception {

		logger.info("buscando um lote de cobrança por id: " + id);

		return new ResponseEntity<>(lotecobvDelegate.consultCobv(id, xTransactionId, authorization), HttpStatus.OK);

	}

	@GetMapping("/")
	@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AstraErrorMessage.class)))
	@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AstraErrorMessage.class)))
	public ResponseEntity<LotecobvGetAllResponseDTO> listAll(
			@RequestHeader("authorization") @Parameter(name = "authorization", description = "JWT Token") String authorization,
			@RequestHeader("x-transaction-id") @Parameter(name = "x-transaction-id", description = "UUID da transação", example = "328d5e1a-06dd-4263-8081-0a2ec31c1f9a") String xTransactionId,
			@RequestParam @NotNull LocalDateTime inicio, @RequestParam @NotNull LocalDateTime fim,

			@RequestParam(name = "paginaAtual", required = false) Integer paginaAtual,
			@RequestParam(name = "itensPorPagina", required = false) Integer itensPorPagina)

			throws Exception {

		logger.info("Listando todos os exemplos");

		return ResponseEntity.ok(
				lotecobvDelegate.listCobvs(inicio, fim, paginaAtual, itensPorPagina, xTransactionId, authorization));

	}

}