package tapastop.converters;

import org.springframework.core.convert.converter.Converter;
import tapastop.model.User;
import tapastop.requests.SaveTapaRequest;
import tapastop.requests.SaveUserRequest;
import tapastop.requests.TapaCoreRequest;
import tapastop.utils.ValidatorUtils;

import java.util.Locale;

public class TapaRequestConverter implements Converter<SaveTapaRequest, TapaCoreRequest> {

    @Override
    public TapaCoreRequest convert(SaveTapaRequest source) {
        TapaCoreRequest tapaCoreRequest = new TapaCoreRequest(
                source.getName(),
                source.getRestaurant_id(),
                source.getType_id(),
                source.getRegion_id(),
                source.getPicture(),
                source.getTaste(),
                source.getDescription());
        return tapaCoreRequest;
    }
}