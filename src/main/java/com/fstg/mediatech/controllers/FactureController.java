package com.fstg.mediatech.controllers;

import com.fstg.mediatech.dto.FactureDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yassineabidar on 26/1/2023
 */
@RestController
@RequestMapping("factures")
public class FactureController {


    @PostMapping
    public String create(@RequestBody FactureDto factureDto) {
        return "";
    }
}
