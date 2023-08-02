package br.com.projetoconest.api.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "comment")
    private List<Comment> replies = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

}
