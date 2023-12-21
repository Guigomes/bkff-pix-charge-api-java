package com.astrapay.rests.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.astrapay.dto.cob.CobPutRequestDTO;
import com.astrapay.dto.cob.CobResponseDTO;
import com.astrapay.logger.AstraLogger;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WriterManagementService {

	private final RestTemplate restTemplate;

	private final AstraLogger logger;

	@Value("${chge-writer-management-java.url}")
	private String baseUrl;

	private static final String ENDPOINT = "/cob";

	public ResponseEntity<CobResponseDTO> createCharge(CobPutRequestDTO request, String txId, String xTransactionId,
			String token) {

		logger.info("Chamando servico de criação de cobrança - chge-writer-management-java: %s - %s - %s", request,
				txId, xTransactionId);

		var url = baseUrl + ENDPOINT + "/" + txId;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", token);
		headers.add("x-transaction-id", xTransactionId);

		HttpEntity<CobPutRequestDTO> requestEntity = new HttpEntity<>(request, headers);

		return restTemplate.exchange(url, HttpMethod.PUT, requestEntity, CobResponseDTO.class);

	}

}
