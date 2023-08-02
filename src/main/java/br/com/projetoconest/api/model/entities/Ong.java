package br.com.projetoconest.api.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Ong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String tourLink;

    @OneToOne
    @JoinColumn(name = "profile_image_id")
    private Image profilePicture;

    @OneToOne
    @JoinColumn(name = "banner_image_id")
    private Image bannerPicture;

    @Column(nullable = false)
    private String category;

    @ToString.Exclude
    @OneToMany(mappedBy = "ong", orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();
}
