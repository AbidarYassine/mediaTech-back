package com.fstg.mediatech.controllers;

import com.fstg.mediatech.dto.ProduitDto;
import com.fstg.mediatech.service.facade.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/produits")
@RequiredArgsConstructor
public class ProduitController {

    private final ProduitService produitService;

    @PostMapping("/")
    public ProduitDto save(@Valid @RequestBody ProduitDto produitDto) {
        return produitService.save(produitDto);
    }

    @GetMapping("/ref/{ref}")
    public ProduitDto findByRef(@PathVariable String ref) {
        return produitService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int delete(@PathVariable String ref) {
        return produitService.delete(ref);
    }

    @PutMapping("/")
    public ProduitDto update(@Valid @RequestBody ProduitDto produitDto) {
        return produitService.update(produitDto);
    }

    @GetMapping("/")
    public List<ProduitDto> findAll() {
        return produitService.findAll();
    }
}
