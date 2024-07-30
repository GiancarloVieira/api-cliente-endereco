package me.dio.controller;

import me.dio.controller.dto.EnderecoDto;
import me.dio.domain.model.Endereco;
import me.dio.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin
@RestController
@RequestMapping("/enderecos")
@Tag(name = "Endereço Controller", description = "RESTful API for managing users address.")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public ResponseEntity<List<EnderecoDto>> findAll() {
        List<Endereco> enderecos = enderecoService.findAll();
        List<EnderecoDto> enderecosDto = enderecos.stream()
                .map(EnderecoDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(enderecosDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDto> findById(@PathVariable Long id) {
        Endereco endereco = enderecoService.findById(id);
        return ResponseEntity.ok(new EnderecoDto(endereco));
    }

    @PostMapping
    public ResponseEntity<EnderecoDto> create(@RequestBody EnderecoDto enderecoDto) {
        Endereco endereco = enderecoService.create(enderecoDto.toModel());
        return ResponseEntity.created(null).body(new EnderecoDto(endereco));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDto> update(@PathVariable Long id, @RequestBody EnderecoDto enderecoDto) {
        Endereco endereco = enderecoService.update(id, enderecoDto.toModel());
        return ResponseEntity.ok(new EnderecoDto(endereco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        enderecoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
