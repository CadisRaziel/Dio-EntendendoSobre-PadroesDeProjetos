package com.dio.padroesprojetos.Service.impl;

import com.dio.padroesprojetos.Model.Cliente;
import com.dio.padroesprojetos.Model.Endereco;
import com.dio.padroesprojetos.Repository.ClienteRepository;
import com.dio.padroesprojetos.Repository.EnderecoRepository;
import com.dio.padroesprojetos.Service.ClienteService;
import com.dio.padroesprojetos.Service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    // TODO Singlton: Injetar os componentes do Spring com @Autowired
    // TODO Strategy: IMplementar os metodos definidos na interface
    // TODO Facade: Abstrair integrações com subsistemas, provendo uma interface simples

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public List<Cliente> buscarTodos() {
        //FIXME Buscar todos os clientes
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        //FIXME Buscar Cliente por ID
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        //Posso extrair tudo aqui dentro para um metodo pois o 'atualizar faz a mesma coisa'
        //clique com o botão direito 'refactor' > extract to method > de um nome e de enter

        //FIXME Verificar se o endereço do cliente ja existe (pelo cep)
        String cep = cliente.getEndereco().getCep();
        //orElseGet -> caso nao exista o cep (é uma callback tipo .then)
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            //FIXME Caso não exista, integrar com o ViaCep e persistir o retorno com um novo endereço
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        //FIXME Inserir Cliente, vinculando o Endereco (novo ou inexistente)
        clienteRepository.save(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        //FIXME Buscar cliente por ID, caso exista:
        Optional<Cliente> clienteUpdate = clienteRepository.findById(id);
        if (clienteUpdate.isPresent()) {
            //FIXME Verificar se o endereço do cliente ja existe (pelo cep)
            String cep = cliente.getEndereco().getCep();
            //orElseGet -> caso nao exista o cep (é uma callback tipo .then)
            Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
                //FIXME Caso não exista, integrar com o ViaCep e persistir o retorno com um novo endereço
                Endereco novoEndereco = viaCepService.consultarCep(cep);
                enderecoRepository.save(novoEndereco);
                return novoEndereco;
            });
            cliente.setEndereco(endereco);
            //FIXME Alterar Cliente, vinculando o Endereco (novo ou inexistente)
            clienteRepository.save(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        //FIXME Deletar Cliente por ID
        clienteRepository.deleteById(id);
    }
}
