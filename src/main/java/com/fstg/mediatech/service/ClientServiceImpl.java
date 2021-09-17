package com.fstg.mediatech.service;

import com.fstg.mediatech.dao.ClientDao;
import com.fstg.mediatech.dto.ClientRequestDto;
import com.fstg.mediatech.dto.ClientResponseDto;
import com.fstg.mediatech.exception.EntityNotFoundException;
import com.fstg.mediatech.models.ClientEntity;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service()
public class ClientServiceImpl implements ClientService {
    private ClientDao clientDao;
    private ModelMapper modelMapper;

    public ClientServiceImpl(ClientDao clientDao, ModelMapper modelMapper) {
        this.clientDao = clientDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public ClientResponseDto save(ClientRequestDto clientRequestDto) {
        ClientEntity clientEntity = modelMapper.map(clientRequestDto, ClientEntity.class);
        ClientEntity saved = clientDao.save(clientEntity);
        return modelMapper.map(saved, ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findById(Integer id) {
        ClientEntity clientEntity = clientDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Client not found"));
        return modelMapper.map(clientEntity, ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findByNom(String nom) {
        ClientEntity clientEntity = clientDao.findByNom(nom);
        return modelMapper.map(clientEntity, ClientResponseDto.class);
    }

    @Override
    public void delete(Integer id) {
        clientDao.deleteById(id);
    }

    @Override
    public ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id) throws NotFoundException {
        Optional<ClientEntity> clientEntityOptional = clientDao.findById(id);
        if (clientEntityOptional.isPresent()) {
            ClientEntity clientEntity = modelMapper.map(clientRequestDto, ClientEntity.class);
            clientEntity.setId(id);
            ClientEntity updated = clientDao.save(clientEntity);
            return modelMapper.map(updated, ClientResponseDto.class);
        } else {
            throw new EntityNotFoundException("Client Not Found");
        }
    }

    @Override
    public List<ClientResponseDto> findAll() {
        return clientDao.findAll()
                .stream().map(el -> modelMapper.map(el, ClientResponseDto.class))
                .collect(Collectors.toList());
    }
}
