package br.com.projetoconest.api.repository;

import br.com.projetoconest.api.model.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
