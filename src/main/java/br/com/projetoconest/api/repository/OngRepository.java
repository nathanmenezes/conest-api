package br.com.projetoconest.api.repository;

import br.com.projetoconest.api.model.entities.Ong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OngRepository extends JpaRepository<Ong, Long>{
}
