package com.astrapay.repository.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.astrapay.astrautils.exception.AstraNotFoundException;
import com.astrapay.dto.ChargeAPIResponseDTO;
import com.astrapay.dto.ChargeAPIUpdateRequestDTO;
import com.astrapay.dto.cob.CobResponseDTO;
import com.astrapay.model.ChargeAPI;
import com.astrapay.repository.ChargeAPIRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChargeAPIRepositoryService {
	private final ChargeAPIRepository repository;

	private final ModelMapper modelMapper;

	public ChargeAPIResponseDTO save(CobResponseDTO oChargeAPIRequestDTO) {

		ChargeAPI oChargeAPI = modelMapper.map(oChargeAPIRequestDTO, ChargeAPI.class);

		var newChargeAPI = repository.saveAndFlush(oChargeAPI);

		return modelMapper.map(newChargeAPI, ChargeAPIResponseDTO.class);

	}

	public ChargeAPIResponseDTO update(ChargeAPIUpdateRequestDTO oChargeAPIUpdateRequestDTO) {

		ChargeAPI oChargeAPI = modelMapper.map(oChargeAPIUpdateRequestDTO, ChargeAPI.class);

		repository.findById(oChargeAPI.getId()).orElseThrow(
				() -> new AstraNotFoundException(String.format("Resource with id % not found", oChargeAPI.getId())));

		repository.saveAndFlush(oChargeAPI);

		return modelMapper.map(oChargeAPI, ChargeAPIResponseDTO.class);

	}

	@Transactional(readOnly = true)
	public ChargeAPIResponseDTO findOne(Integer id) {

		var result = repository.findById(id)
				.orElseThrow(() -> new AstraNotFoundException(String.format("Resource with id % not found", id)));

		return modelMapper.map(result, ChargeAPIResponseDTO.class);

	}

	@Transactional(readOnly = true)
	public List<ChargeAPIResponseDTO> listAll() {

		var result = repository.findAll();

		return result.stream().map(source -> modelMapper.map(source, ChargeAPIResponseDTO.class))
				.collect(Collectors.toList());

	}

	@Transactional
	public void delete(Integer id) {
		ChargeAPI oChargeAPI = repository.findById(id)
				.orElseThrow(() -> new AstraNotFoundException(String.format("Resource with id % not found", id)));
		repository.delete(oChargeAPI);
	}
}
