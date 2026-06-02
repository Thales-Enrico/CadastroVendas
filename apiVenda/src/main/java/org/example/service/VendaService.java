// Glória a Deus nos mais altos céus e Paz no mundo aos homens por Ele amados!
package org.example.service;

import org.example.dto.FuncionarioDTO;
import org.example.dto.VendaRequestDTO;
import org.example.models.Venda;
import org.example.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {
    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<Venda> findAll(){
        return vendaRepository.findAll();
    }

    public Optional<Venda> findById(int id){
        return vendaRepository.findById(id);
    }

    public Venda save(VendaRequestDTO dto) {

        FuncionarioDTO funcionario =
                buscarFuncionario(dto.getFuncionarioId());

        if (funcionario == null) {
            throw new RuntimeException(
                    "Funcionário com ID " +
                            dto.getFuncionarioId() +
                            " não encontrado."
            );
        }

        Venda venda = new Venda();

        venda.setDescricao(dto.getDescricao());
        venda.setDataVenda(dto.getDataVenda());
        venda.setNomeProduto(dto.getNomeProduto());
        venda.setValorProduto(dto.getValorProduto());
        venda.setQtd(dto.getQtd());

        venda.setFuncionarioId(funcionario.getId());
        venda.setFuncionarioNome(funcionario.getNome());
        venda.setFuncionarioTelefone(funcionario.getTelefone());
        venda.setFuncionarioEmail(funcionario.getEmail());
        venda.setFuncionarioEndereco(funcionario.getEndereco());
        venda.setFuncionarioCidade(funcionario.getCidade());
        venda.setFuncionarioSalario(funcionario.getSalario());
        venda.setFuncionarioDataNasc(funcionario.getDataNasc());
        venda.setFuncionarioDataCadas(funcionario.getDataCadas());

        return vendaRepository.save(venda);
    }

    public Venda update(int id, Venda vendaAtualizada){
        Optional<Venda> vendaExistente = vendaRepository.findById(id);

        if(vendaExistente.isPresent()){
            Venda venda = vendaExistente.get();
            venda.setDescricao(vendaAtualizada.getDescricao());
            venda.setDataVenda(vendaAtualizada.getDataVenda());
            venda.setNomeProduto(vendaAtualizada.getNomeProduto());
            venda.setValorProduto(vendaAtualizada.getValorProduto());
            venda.setQtd(vendaAtualizada.getQtd());
            venda.setValorTotalVenda(vendaAtualizada.getValorTotalVenda());
            return vendaRepository.save(venda);
        }
        return null;
    }

    private FuncionarioDTO buscarFuncionario(int funcionarioId) {

        try {
            String url = "http://localhost:8080/funcionarios/" + funcionarioId;

            return restTemplate.getForObject(
                    url,
                    FuncionarioDTO.class
            );

        } catch (HttpClientErrorException.NotFound e) {
            throw new RuntimeException(
                    "Funcionário com ID " + funcionarioId + " não encontrado."
            );
        } catch (ResourceAccessException e) {
            throw new RuntimeException(
                    "API de Funcionários indisponível."
            );
        }
    }

    public void delete(int id){
        vendaRepository.deleteById(id);
    }
}
