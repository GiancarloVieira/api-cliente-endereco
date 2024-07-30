package me.dio.controller.dto;

import me.dio.domain.model.Endereco;

public record EnderecoDto(
        Long id,
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep
) {

    public EnderecoDto(Endereco model) {
        this(model.getId(), model.getLogradouro(), model.getNumero(), model.getComplemento(),
             model.getBairro(), model.getCidade(), model.getEstado(), model.getCep());
    }

    public Endereco toModel() {
        Endereco model = new Endereco();
        model.setId(this.id);
        model.setLogradouro(this.logradouro);
        // Set other properties
        return model;
    }
}
