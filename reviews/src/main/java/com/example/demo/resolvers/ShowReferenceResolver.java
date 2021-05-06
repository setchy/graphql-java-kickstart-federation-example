package com.example.demo.resolvers;

import com.example.demo.model.Show;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class ShowReferenceResolver {

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
