// Glória a Deus nos mais altos céus e Paz no mundo aos homens por Ele amados!
package org.example.controller;

import org.example.models.Funcionario;
import org.example.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> findAll(){
        return funcionarioService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Funcionario> findById(@PathVariable int id){
        return funcionarioService.findById(id);
    }

    @PostMapping
    public Funcionario save(@RequestBody Funcionario funcionario){
        return  funcionarioService.save(funcionario);
    }

    @PutMapping("{id}")
    public Funcionario update(@PathVariable int id, @RequestBody Funcionario funcionario){
        return funcionarioService.update(id, funcionario);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        funcionarioService.delete(id);
    }
}
