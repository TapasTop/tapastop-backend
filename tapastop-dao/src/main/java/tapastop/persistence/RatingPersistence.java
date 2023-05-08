package tapastop.persistence;

import tapastop.model.Rating;

import java.util.List;
import java.util.Optional;

public interface RatingPersistence {
    public Optional<Rating> findById(Long id);
    public Rating save(Rating rating);
    public List<Rating> findAll();
    public void deleteById(Long id);
}

