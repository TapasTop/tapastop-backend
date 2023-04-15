package tapastop.services;

import org.springframework.http.ResponseEntity;
import tapastop.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    public Restaurant findById(Long id);
    public Restaurant save(Restaurant restaurant);
    public List<Restaurant> findAll();
    public void deleteById(Long id);
}
