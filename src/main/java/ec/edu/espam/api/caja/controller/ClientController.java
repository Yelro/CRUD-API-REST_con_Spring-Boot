package ec.edu.espam.api.caja.controller;

import ec.edu.espam.api.caja.domain.Account;
import ec.edu.espam.api.caja.domain.Client;
import ec.edu.espam.api.caja.domain.dto.ClientDto;
import ec.edu.espam.api.caja.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/clients")
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDto> create(@RequestBody @Valid ClientDto client) {
        return new ResponseEntity<>(clientService.create(client), HttpStatus.CREATED);
    }
}
