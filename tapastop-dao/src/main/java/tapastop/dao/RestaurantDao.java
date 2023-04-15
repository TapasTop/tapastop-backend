package tapastop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tapastop.model.Restaurant;

public interface RestaurantDao extends JpaRepository<Restaurant, Long> {

}
