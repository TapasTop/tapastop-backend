package tapastop.converters;

import org.springframework.core.convert.converter.Converter;
import tapastop.model.Rating;
import tapastop.requests.RatingCoreRequest;
import tapastop.requests.SaveRatingRequest;
import tapastop.requests.SaveTapaRequest;
import tapastop.requests.TapaCoreRequest;

public class RatingRequestConverter implements Converter<SaveRatingRequest, RatingCoreRequest> {

    @Override
    public RatingCoreRequest convert(SaveRatingRequest source) {
        RatingCoreRequest ratingCoreRequest = new RatingCoreRequest(
                source.getUsername(),
                source.getTapaId(),
                source.getRate());
        return ratingCoreRequest;
    }
}