package tapastop.services;

import tapastop.model.Rating;
import tapastop.model.Restaurant;
import tapastop.reponses.RatingResponse;
import tapastop.requests.RatingCoreRequest;

import java.util.List;

public interface RatingService {

    public RatingResponse findById(Long id);
    public RatingResponse save(RatingCoreRequest rating);
    public List<RatingResponse> findAll();
    public void deleteById(Long id);
}
