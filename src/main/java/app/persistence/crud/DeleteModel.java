package app.persistence.crud;

public interface DeleteModel<Id> {
    void delete(Id id);
}
