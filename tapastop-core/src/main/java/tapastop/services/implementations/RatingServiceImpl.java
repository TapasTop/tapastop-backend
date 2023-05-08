package tapastop.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tapastop.converters.RatingCoreConverter;
import tapastop.converters.RatingResponseConverter;
import tapastop.converters.TapaResponseConverter;
import tapastop.exceptions.types.BadRequestException;
import tapastop.model.Rating;
import tapastop.model.Restaurant;
import tapastop.model.Tapa;
import tapastop.model.User;
import tapastop.persistence.RatingPersistence;
import tapastop.persistence.RestaurantPersistence;
import tapastop.persistence.TapaPersistence;
import tapastop.persistence.UserPersistence;
import tapastop.reponses.RatingResponse;
import tapastop.requests.RatingCoreRequest;
import tapastop.services.RatingService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingPersistence ratingPersistence;
    @Autowired
    private UserPersistence userPersistence;
    @Autowired
    private TapaPersistence tapaPersistence;

    @Override
    public RatingResponse findById(Long id) {
        Optional<Rating> rating = ratingPersistence.findById(id);
        RatingResponseConverter ratingResponseConverter = new RatingResponseConverter();
        if(!rating.isPresent()){
            return null;
        }
        return ratingResponseConverter.convert(rating.get());
    }

    @Override
    public RatingResponse save(RatingCoreRequest rating) {
        RatingCoreConverter ratingCoreConverter = new RatingCoreConverter();
        RatingResponseConverter ratingResponseConverter = new RatingResponseConverter();
        Optional<User> user = userPersistence.findByUsername(rating.getUsername());
        Optional<Tapa> tapa = tapaPersistence.findById(rating.getTapaId());
        if(!user.isPresent()){
            throw new BadRequestException("400", "Username " + rating.getUsername() + " doesn't exist", HttpStatus.BAD_REQUEST);
        }
        if(!tapa.isPresent()){
            throw new BadRequestException("400", "Tapa with " + rating.getTapaId() + " id doesn't exist", HttpStatus.BAD_REQUEST);
        }
        rating.setTapa(tapa.get());
        rating.setUser(user.get());
        RatingResponse rat = ratingResponseConverter.convert(ratingPersistence.save(ratingCoreConverter.convert(rating)));
        return rat;
    }

    @Override
    public List<RatingResponse> findAll() {
        RatingResponseConverter ratingResponseConverter = new RatingResponseConverter();
        List<Rating> ratings = ratingPersistence.findAll();
        return ratings.stream()
                .map(ratingResponseConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        ratingPersistence.deleteById(id);
    }
}
