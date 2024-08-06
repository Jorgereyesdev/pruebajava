package app.persistence.crud;

public interface UpdateModel<Entity> {
    Entity update(Entity request);
}
