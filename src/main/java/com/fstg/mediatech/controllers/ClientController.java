package com.fstg.mediatech.controllers;
import com.fstg.mediatech.dto.ClientRequestDto;
import com.fstg.mediatech.dto.ClientResponseDto;
import com.fstg.mediatech.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("")
    public List<ClientResponseDto> getClient() {
        return clientService.findAll();
    }

    @PostMapping("")
    public ClientResponseDto save(@RequestBody() ClientRequestDto clientRequestDto) {
        return clientService.save(clientRequestDto);
    }

}
