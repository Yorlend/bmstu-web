package ru.bmstu.icsnetwork.data.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Entity
@Table(name = "posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String content;

    @NotNull
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @NotNull
    private UserEntity author;

    @OneToMany(mappedBy = "post")
    @Singular
    private List<VoteEntity> votes;
}
