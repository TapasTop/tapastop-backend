package tapastop.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tapastop.model.Restaurant;
import tapastop.model.User;
import tapastop.persistence.RestaurantPersistence;
import tapastop.services.RestaurantService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantPersistence restaurantPersistence;

    @Override
    public Restaurant findById(Long id) {
        Optional<Restaurant> restaurant = restaurantPersistence.findById(id);
        return restaurant.get();
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        restaurant.setAddedDate(new Date(System.currentTimeMillis()));
        Restaurant rest = restaurantPersistence.save(restaurant);
        return rest;
    }

    @Override
    public List<Restaurant> findAll() {
        List<Restaurant> restaurantList = restaurantPersistence.findAll();
        return restaurantList;
    }

    @Override
    public void deleteById(Long id) {
        restaurantPersistence.deleteById(id);
    }
}
