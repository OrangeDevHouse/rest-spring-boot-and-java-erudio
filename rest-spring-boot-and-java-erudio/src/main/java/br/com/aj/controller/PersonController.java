package br.com.aj.controller;

import br.com.aj.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    Logger logger = LoggerFactory.getLogger(PersonController.class);

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        logger.info("Endpoint /person/all is called");
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }
}
