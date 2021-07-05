package com.dnsn.pontoInteligenre.Api.service;

import java.util.Optional;

import com.dnsn.pontoInteligente.Api.Entities.Empresa;
import com.dnsn.pontoInteligente.Api.repositories.EmpresaRepository;
import com.dnsn.pontoInteligente.Api.services.EmpresaService;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class EmpresaServiceTest {
    
    @MockBean
    private EmpresaRepository empresaRepository;
    
    @Autowired
    private EmpresaService empresaService;

    private static final String CNPJ = "51463645000100";

    @Before
    public void setUp() throws Exception{
        BDDMockito.given(this.empresaRepository.findByCnpj(Mockito.anyString())).willReturn(new Empresa());
        BDDMockito.given(this.empresaRepository.save(Mockito.any(Empresa.class))).willReturn(new Empresa());
    }

    @Test
    public void testBuscarPorCnpj(){
        Optional<Empresa> empresa = this.empresaService.buscarPorCnpj(CNPJ);
        assertTrue(empresa.isPresent());
    }

    @Test
    public void testBuscarEmpresaPorCnpj(){
        Optional<Empresa> empresa = this.empresaService.buscarPorCnpj(CNPJ);
        assetTrue(empresa.isPresent());
    }

    @Test
    public void testPersistirEmpresa(){
        Empresa empresa = this.empresaService.persistir(new Empresa());
        assertNotNull(empresa);
    }
}
