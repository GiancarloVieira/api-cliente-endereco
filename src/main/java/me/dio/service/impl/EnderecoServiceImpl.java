package me.dio.service.impl;

import me.dio.domain.model.Endereco;
import me.dio.domain.repository.EnderecoRepository;
import me.dio.service.EnderecoService;
import me.dio.service.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Endereco findById(Long id) {
        return enderecoRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    @Transactional
    public Endereco create(Endereco endereco) {
        // Add any necessary validation
        return enderecoRepository.save(endereco);
    }

    @Override
    public Endereco update(Long id, Endereco entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Método Update aina não implementado");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    // Implement other CRUD methods: update, delete
}
