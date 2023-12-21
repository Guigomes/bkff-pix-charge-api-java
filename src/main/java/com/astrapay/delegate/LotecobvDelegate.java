package com.astrapay.delegate;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.astrapay.dto.lotecobv.LotecobvGetAllResponseDTO;
import com.astrapay.dto.lotecobv.LotecobvGetResponseDTO;
import com.astrapay.dto.lotecobv.LotecobvPatchRequestDTO;
import com.astrapay.dto.lotecobv.LotecobvPutRequestDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LotecobvDelegate {

	public void createLotecobv(String idLote, LotecobvPutRequestDTO request, String xTransactionId, String token) {

	}

	public void alterLotrCobv(String idLote, LotecobvPatchRequestDTO request, String xTransactionId, String token) {

	}

	public LotecobvGetResponseDTO consultCobv(Integer idLote, String xTransactionId, String token) {

		return null;
	}

	public LotecobvGetAllResponseDTO listCobvs(LocalDateTime inicio, LocalDateTime fim, Integer paginaAtual,
			Integer itensPorPagina, String xTransactionId, String token) {

		return null;
	}
}
