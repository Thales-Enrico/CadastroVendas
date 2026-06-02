//Glória a Deus nos mais altos céus e Paz no mundo aos homens por Ele amados!
package org.example.repository;

import org.example.models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {
}
