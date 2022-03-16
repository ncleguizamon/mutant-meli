package com.meli.mutant.app.models.controllers;


import com.meli.mutant.app.models.entity.Dna;
import com.meli.mutant.app.models.service.IMutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MutantController {


    @Autowired
    private IMutantService mutantServiceService;

    public MutantController(IMutantService mutantServiceService) {
        this.mutantServiceService = mutantServiceService;
    }


    @PostMapping("/mutant")
    public ResponseEntity<String> isMutant(@RequestBody Dna dna) {
     System.out.println(dna.getDna());
       boolean isMutant= mutantServiceService.isMutantservice( dna.getDna());
      return ResponseEntity.status(isMutant?HttpStatus.FORBIDDEN : HttpStatus.OK).body(null);

    }

}
