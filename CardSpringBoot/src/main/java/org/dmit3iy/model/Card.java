package org.dmit3iy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (uniqueConstraints =
        {@UniqueConstraint(columnNames = {"question", "answer","categoryId"})})
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    @NonNull
    private String question;
    @Column(nullable = false)
    @NonNull
    private String answer;
    @JsonIgnore
    @NonNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate creationDate=LocalDate.now();
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "categoryId")
    private Category category;

}
