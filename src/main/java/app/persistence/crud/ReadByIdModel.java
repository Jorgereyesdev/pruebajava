package app.persistence.crud;

public interface ReadByIdModel<Id, Entity> {
    Entity readByID(Id id);
}
