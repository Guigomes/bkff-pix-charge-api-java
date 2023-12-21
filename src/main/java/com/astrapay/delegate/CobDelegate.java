package com.astrapay.delegate;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.astrapay.dto.cob.CobGetAllResponseDTO;
import com.astrapay.dto.cob.CobPatchRequestDTO;
import com.astrapay.dto.cob.CobPostRequestDTO;
import com.astrapay.dto.cob.CobPutRequestDTO;
import com.astrapay.dto.cob.CobResponseDTO;
import com.astrapay.rests.service.ReaderManagementService;
import com.astrapay.rests.service.WriterManagementService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CobDelegate {

	private final WriterManagementService oWriterManagementService;
	private final ReaderManagementService oChargeAPIRestService;

	public ResponseEntity<CobResponseDTO> createCob(String txId, CobPutRequestDTO request, String xTransactionId, String token) {

		return oWriterManagementService.createCharge(request, txId, xTransactionId, token);
	}

	public CobResponseDTO createCob(CobPostRequestDTO request, String xTransactionId, String token) {

		return null;
	}

	public CobResponseDTO alterCob(String txId, CobPatchRequestDTO request, String xTransactionId, String token) {

		return null;
	}

	public CobResponseDTO consultCob(String txid, int revisao,  String xTransactionId, String token) {

		return null;
	}
	
	public CobGetAllResponseDTO listCobs(LocalDateTime inicio, LocalDateTime fim, String cpf, String cnpj,
			Boolean locationPresente, String status, Integer paginaAtual, Integer itensPorPagina, String xTransactionId, String token) {

		return null;
	}
}
