package org.dmit3iy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "userId"})})
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @NonNull
    private String name;

    @ManyToOne
    @NonNull
    @JsonIgnore
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Card> cards;

}
