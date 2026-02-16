package br.com.quantusoft.quantum_api.service;


import br.com.quantusoft.quantum_api.dto.ClientDTO;
import br.com.quantusoft.quantum_api.entity.Client;
import br.com.quantusoft.quantum_api.repository.ClientRepository;
import br.com.quantusoft.quantum_api.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public List<ClientDTO> findAll() {
        return repository.findAll()
                .stream().map(ClientDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public ClientDTO finDyId(Long id) {
        Client entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado. ID: " +id)

        );
        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO create(ClientDTO dto) {
        Client entity = new Client();
        toEntity(dto, entity);
        entity = repository.save(entity);
        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        try {
            Client entity = repository.getReferenceById(id);
            toEntity(dto, entity);
            entity = repository.save(entity);
            return new ClientDTO(entity);
        } catch (EntityNotFoundException ex) {
            throw new ResourceNotFoundException("Recurso não encontrado. ID: " +id);
        }
    }

    @Transactional
    public void delete(Long id) {
        if(!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado. ID: " + id);
        }
        repository.deleteById(id);
    }

    private void toEntity(ClientDTO dto,
                          Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setCnpj(dto.getCnpj());
        entity.setCellphone(dto.getCellphone());
        entity.setEmail(dto.getEmail());
    }
}
