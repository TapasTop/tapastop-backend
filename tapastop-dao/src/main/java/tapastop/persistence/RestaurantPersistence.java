package tapastop.persistence;

import tapastop.model.Restaurant;
import tapastop.model.User;

import java.util.List;
import java.util.Optional;

public interface RestaurantPersistence {
    public Optional<Restaurant> findById(Long id);
    public Restaurant save(Restaurant restaurant);
    public List<Restaurant> findAll();
    public void deleteById(Long id);
}
