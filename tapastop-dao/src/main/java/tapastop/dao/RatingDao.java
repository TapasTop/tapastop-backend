package tapastop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tapastop.model.Rating;

public interface RatingDao extends JpaRepository<Rating, Long> {
}
