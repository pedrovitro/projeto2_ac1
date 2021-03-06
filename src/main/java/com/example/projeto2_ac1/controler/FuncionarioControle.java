package com.example.projeto2_ac1.controler;

import com.example.projeto2_ac1.entidade.Funcionario;
import com.example.projeto2_ac1.servico.FuncionarioServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FuncionarioControle {

    @Autowired
    private FuncionarioServico servico;

    @GetMapping("/funcionarios")
    public ModelAndView getFuncionarios()
    {
        ModelAndView mv = new ModelAndView("funcionariosTemplate");
        mv.addObject("funcionarios",servico.getFuncionarios());

        return mv;
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Funcionario funcionario)
    {
        if(validar(funcionario))
             servico.salvar(funcionario);
             
        return "redirect:/funcionarios";
    }

    public boolean validar (Funcionario func)
    {
        if(func.getNome() == null || func.getSalario() < 0 || func.getCargo() == null )
            return false;
        else if(func.getNome().trim().length() == 0 ||func.getCargo().trim().length() == 0 )
            return false;
        else 
        return true;
    }
    
}