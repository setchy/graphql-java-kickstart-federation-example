package com.example.demo.model;

import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Show {
    private String id;
    private List<Review> reviews;

    public static Show resolveReference(@NotNull Map<String, Object> reference) {
        String federatedKeyName = "id";

        if (!(reference.get(federatedKeyName) instanceof String)) {
            return null;
        }

        final String id = (String) reference.get(federatedKeyName);

        Show show = new Show();
        show.setId(id);
        return show;
    }
}
