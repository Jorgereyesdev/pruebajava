package app.persistence.crud;

import java.util.List;

public interface ReadAllModel<Entity> {
    List<Entity> readAll(int size, int numberPage);
}
