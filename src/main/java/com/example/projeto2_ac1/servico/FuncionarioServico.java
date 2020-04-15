package com.example.projeto2_ac1.servico;

import java.util.List;

import com.example.projeto2_ac1.entidade.Funcionario;
import com.example.projeto2_ac1.repository.FuncionarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioServico {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> getFuncionarios()
    {
        return repository.findAll();
    }

    public void salvar(Funcionario funcionario)
    {
            repository.save(funcionario);
    }

}