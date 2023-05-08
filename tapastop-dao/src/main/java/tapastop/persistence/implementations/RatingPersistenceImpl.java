package tapastop.persistence.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tapastop.dao.RatingDao;
import tapastop.model.Rating;
import tapastop.persistence.RatingPersistence;

import java.util.List;
import java.util.Optional;

@Component
public class RatingPersistenceImpl implements RatingPersistence {

    @Autowired
    private RatingDao ratingDao;

    @Override
    public Optional<Rating> findById(Long id) {
        return ratingDao.findById(id);
    }

    @Override
    public Rating save(Rating rating) {
        return ratingDao.save(rating);
    }

    @Override
    public List<Rating> findAll() {
        return ratingDao.findAll();
    }

    @Override
    public void deleteById(Long id) {
        ratingDao.deleteById(id);
    }
}
