package com.example.projeto2_ac1.controler;

import com.example.projeto2_ac1.servico.FuncionarioServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FuncionarioControle {

    @Autowired
    private FuncionarioServico servico;

    @GetMapping("/funcionarios")
    public ModelAndView getFuncionarios()
    {
        ModelAndView mv = new ModelAndView("funcionarios");
        mv.addObject("funcionarios",servico.getFuncionarios());

        return mv;
    }
    
}