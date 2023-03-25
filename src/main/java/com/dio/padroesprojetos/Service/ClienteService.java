package com.dio.padroesprojetos.Service;

import com.dio.padroesprojetos.Model.Cliente;

import java.util.List;

//strategy
public interface ClienteService {
    List<Cliente> buscarTodos();
    Cliente buscarPorId(Long id);
    void inserir(Cliente cliente);
    void atualizar(Long id, Cliente cliente);
    void deletar(Long id);
}
