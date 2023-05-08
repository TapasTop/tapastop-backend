package tapastop.converters;

import org.springframework.core.convert.converter.Converter;
import tapastop.model.Rating;
import tapastop.model.Tapa;
import tapastop.requests.RatingCoreRequest;
import tapastop.requests.TapaCoreRequest;

public class RatingCoreConverter implements Converter<RatingCoreRequest, Rating> {

    @Override
    public Rating convert(RatingCoreRequest source) {
        Rating rating = new Rating(
                source.getUser(),
                source.getTapa(),
                source.getRate()
        );
        return rating;
    }
}
