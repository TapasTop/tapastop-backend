package tapastop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tapastop.converters.RatingRequestConverter;
import tapastop.model.Rating;
import tapastop.model.Restaurant;
import tapastop.reponses.RatingResponse;
import tapastop.requests.RatingCoreRequest;
import tapastop.requests.SaveRatingRequest;
import tapastop.services.RatingService;
import tapastop.services.RestaurantService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping("/rating")
    public ResponseEntity<List<RatingResponse>> getAllRatings(){
        ResponseEntity<List<RatingResponse>> responseEntity = new ResponseEntity<>(ratingService.findAll(), HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/rating/{id}")
    public ResponseEntity<RatingResponse> getRating(@PathVariable Long id){
        ResponseEntity<RatingResponse> responseEntity = new ResponseEntity<>(ratingService.findById(id), HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/rating")
    public ResponseEntity<RatingResponse> saveRating(@RequestBody SaveRatingRequest rating){
        RatingRequestConverter ratingRequestConverter = new RatingRequestConverter();
        RatingCoreRequest ratingCoreRequest = ratingRequestConverter.convert(rating);
        ResponseEntity<RatingResponse> responseEntity = new ResponseEntity<>(ratingService.save(ratingCoreRequest), HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/rating/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable Long id){
        ratingService.deleteById(id);
        ResponseEntity<String> responseEntity = new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
        return responseEntity;
    }
}
