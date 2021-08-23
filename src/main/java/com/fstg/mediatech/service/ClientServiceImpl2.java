package com.fstg.mediatech.service;

import com.fstg.mediatech.dto.ClientRequestDto;
import com.fstg.mediatech.dto.ClientResponseDto;
import org.springframework.stereotype.Service;

@Service("impl2")
public class ClientServiceImpl2 implements ClientService {
    @Override
    public ClientResponseDto save(ClientRequestDto clientRequestDto) {
        return null;
    }

    @Override
    public ClientResponseDto findById(Integer id) {
        return null;
    }

    @Override
    public ClientResponseDto findByNom(String nom) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id) {
        return null;
    }
}
