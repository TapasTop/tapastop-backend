package tapastop.persistence.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tapastop.dao.RestaurantDao;
import tapastop.dao.UserDao;
import tapastop.model.Restaurant;
import tapastop.persistence.RestaurantPersistence;

import java.util.List;
import java.util.Optional;

@Component
public class RestaurantPersistenceImpl implements RestaurantPersistence {

    @Autowired
    private RestaurantDao restaurantDao;

    @Override
    public Optional<Restaurant> findById(Long id) {
        Optional<Restaurant> persisted = restaurantDao.findById(id);
        return persisted;
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        Restaurant persisted = restaurantDao.save(restaurant);
        return persisted;
    }

    @Override
    public List<Restaurant> findAll() {
        List<Restaurant> persisted = restaurantDao.findAll();
        return persisted;
    }

    @Override
    public void deleteById(Long id) {
        restaurantDao.deleteById(id);
    }
}
