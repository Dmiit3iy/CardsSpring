package org.dmiit3iy.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Category {
    public Category(long id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }

    private long id;
    @NonNull
    private String name;

    private User user;
    @JsonIgnore
    @ToString.Exclude
    private List<Card> cards;
}
