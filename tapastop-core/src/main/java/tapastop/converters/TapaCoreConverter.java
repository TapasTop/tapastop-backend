package tapastop.converters;

import org.springframework.core.convert.converter.Converter;
import tapastop.model.Tapa;
import tapastop.requests.TapaCoreRequest;

public class TapaCoreConverter implements Converter<TapaCoreRequest, Tapa> {
    @Override
    public Tapa convert(TapaCoreRequest source) {
        Tapa tapa = new Tapa(
                source.getName(),
                source.getRestaurant(),
                source.getPicture(),
                source.getTaste(),
                source.getType(),
                source.getRegion(),
                source.getDescription());
        return tapa;
    }
}
