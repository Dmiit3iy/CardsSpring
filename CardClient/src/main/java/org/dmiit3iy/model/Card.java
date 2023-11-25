package org.dmiit3iy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Card {
    private long id;
    @NonNull
    private String question;
    @NonNull
    private String answer;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate creationDate;
    @ToString.Exclude
    private Category category;

    public Card(long id, @NonNull String question, @NonNull String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }
}
