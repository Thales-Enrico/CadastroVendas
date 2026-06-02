// Glória a Deus nos mais altos céus e Paz no mundo aos homens por Ele amados!
package org.example.service;

import org.example.models.Funcionario;
import org.example.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> findAll(){
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> findById(int id){
        return funcionarioRepository.findById(id);
    }

    public Funcionario save(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario update(int id, Funcionario funcionarioAtualizado){
        Optional<Funcionario> funcionarioExistente = funcionarioRepository.findById(id);

        if(funcionarioExistente.isPresent()){
            Funcionario funcionario = funcionarioExistente.get();
            funcionario.setNome(funcionarioAtualizado.getNome());
            funcionario.setTelefone(funcionarioAtualizado.getTelefone());
            funcionario.setEmail(funcionarioAtualizado.getEmail());
            funcionario.setEndereco(funcionarioAtualizado.getEndereco());
            funcionario.setCidade(funcionarioAtualizado.getCidade());
            funcionario.setSalario(funcionarioAtualizado.getSalario());
            funcionario.setDataNasc(funcionarioAtualizado.getDataNasc());
            funcionario.setDataCadas(funcionarioAtualizado.getDataCadas());
            return funcionarioRepository.save(funcionario);
        }
        return null;
    }

    public void delete(int id){
        funcionarioRepository.deleteById(id);
    }
}
