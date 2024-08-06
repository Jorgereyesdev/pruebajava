package app.persistence.crud;

public interface CreateModel<Entity> {
    Entity create(Entity request);
}
