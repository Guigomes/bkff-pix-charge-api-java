package com.astrapay.delegate;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.astrapay.dto.cob.CobResponseDTO;
import com.astrapay.dto.cobv.CobvGetAllResponseDTO;
import com.astrapay.dto.cobv.CobvGetResponseDTO;
import com.astrapay.dto.cobv.CobvPatchRequestDTO;
import com.astrapay.dto.cobv.CobvPutPatchResponseDTO;
import com.astrapay.dto.cobv.CobvPutRequestDTO;
import com.astrapay.repository.service.ChargeAPIRepositoryService;
import com.astrapay.rests.service.ReaderManagementService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CobvDelegate {

	private final ChargeAPIRepositoryService oChargeAPIRepositoryService;
	private final ReaderManagementService oChargeAPIRestService;

	public CobvPutPatchResponseDTO createCobv(String txId, CobvPutRequestDTO request, String xTransactionId,
			String token) {

		return null;
	}

	public CobvPutPatchResponseDTO alterCobv(String txId, CobvPatchRequestDTO request, String xTransactionId,
			String token) {

		return null;
	}

	public CobvGetResponseDTO consultCobv(String txid, int revisao, String xTransactionId, String token) {

		return null;
	}

	public CobvGetAllResponseDTO listCobvs(LocalDateTime inicio, LocalDateTime fim, String cpf, String cnpj,
			Boolean locationPresente, String status, Integer paginaAtual, Integer itensPorPagina, String xTransactionId,
			String token) {

		return null;
	}
}
