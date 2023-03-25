package com.dio.padroesprojetos.Service;

import com.dio.padroesprojetos.Model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
    //Client HTTP, criado via OpenFeing para consumo da api do ViaCep

    //vamos consumir a api do via cep
    @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")
    //ao invez do request mapping eu posso usar o getMapping
    //porem vamos deixar o requestmapping
    //@GetMapping("/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);
}
