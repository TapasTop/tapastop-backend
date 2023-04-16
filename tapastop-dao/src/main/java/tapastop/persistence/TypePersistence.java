package tapastop.persistence;

import tapastop.model.Type;

import java.util.Optional;

public interface TypePersistence {
    public Optional<Type> findById(Long id);
}
