package br.com.aj.controller;

import br.com.aj.model.Person;
import br.com.aj.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "People", description = "Endpoints para gerenciamento de pessoas")
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Operation(
            summary = "Listar todas as pessoas",
            description = "Retorna uma lista com todas as pessoas cadastradas"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao processar a requisição")
    })
    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        logger.info("Endpoint /person/all is called");
        return new ResponseEntity<List<?>>(List.of(new Person()), HttpStatus.OK);
    }
}
