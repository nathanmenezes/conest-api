package br.com.projetoconest.api.repository;

import br.com.projetoconest.api.model.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
