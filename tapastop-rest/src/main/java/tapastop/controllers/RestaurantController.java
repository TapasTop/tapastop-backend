package tapastop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tapastop.model.Restaurant;
import tapastop.model.Restaurant;
import tapastop.services.RestaurantService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestaurantController {
    
    @Autowired
    private RestaurantService restaurantService;
    
    @GetMapping("/restaurant")
    public ResponseEntity<List<Restaurant>> getAllRestaurants(){
        ResponseEntity<List<Restaurant>> responseEntity = new ResponseEntity<>(restaurantService.findAll(), HttpStatus.OK);
        return responseEntity;
    }
    
    @GetMapping("/restaurant/{id}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable Long id){
        ResponseEntity<Restaurant> responseEntity = new ResponseEntity<>(restaurantService.findById(id), HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/restaurant")
    public ResponseEntity<Restaurant> saveRestaurant(@RequestBody Restaurant restaurant){
        ResponseEntity<Restaurant> responseEntity = new ResponseEntity<>(restaurantService.save(restaurant), HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/restaurant/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable Long id){
        restaurantService.deleteById(id);
        ResponseEntity<String> responseEntity = new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
        return responseEntity;
    }
}
