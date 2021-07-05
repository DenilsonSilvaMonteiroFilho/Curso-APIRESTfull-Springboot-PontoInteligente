package com.dnsn.pontoInteligente.Api.services;

import java.util.Optional;

import com.dnsn.pontoInteligente.Api.Entities.Empresa;


public interface EmpresaService {
    

    /**
     * Retiena uma empresa dado um CNPJ
     * 
     * @param cnpj
     * @return Optional<Empresa> 
     */

    Optional<Empresa> buscarPorCnpj(String cnpj);

    /**
     * Cadastra uma nova empresa na base de dados.
     * 
     * @param empresa
     * @return Empresa
     */

    Empresa persistir(Empresa empresa);
}
