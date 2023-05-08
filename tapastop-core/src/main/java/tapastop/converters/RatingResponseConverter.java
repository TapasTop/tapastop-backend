package tapastop.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import tapastop.model.Rating;
import tapastop.model.Tapa;
import tapastop.persistence.TapaPersistence;
import tapastop.reponses.RatingResponse;

public class RatingResponseConverter implements Converter<Rating, RatingResponse> {
    @Override
    public RatingResponse convert(Rating source) {
        RatingResponse ratingResponse = new RatingResponse(
                source.getId(),
                source.getUser().getUsername(),
                source.getTapa().getId(),
                source.getTapa().getName(),
                source.getRate()
        );
        return ratingResponse;
    }
}
