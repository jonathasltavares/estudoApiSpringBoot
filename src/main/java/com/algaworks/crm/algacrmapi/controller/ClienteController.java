package com.algaworks.crm.algacrmapi.controller;

import com.algaworks.crm.algacrmapi.model.Cliente;
import com.algaworks.crm.algacrmapi.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;
    @GetMapping
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }
    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        var clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return clienteOptional.get();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void excluirPorId(@PathVariable Long id) {
        var clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        clienteRepository.delete(clienteOptional.get());
    }
}
