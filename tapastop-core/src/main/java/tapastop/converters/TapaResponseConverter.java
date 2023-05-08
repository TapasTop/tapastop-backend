package tapastop.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import tapastop.model.Region;
import tapastop.model.Tapa;
import tapastop.model.Type;
import tapastop.persistence.RegionPersistence;
import tapastop.persistence.TypePersistence;
import tapastop.reponses.TapaResponse;

import java.util.ArrayList;
import java.util.List;

public class TapaResponseConverter implements Converter<Tapa, TapaResponse> {

    @Autowired
    private TypePersistence typePersistence;
    @Autowired
    RegionPersistence regionPersistence;

    @Override
    public TapaResponse convert(Tapa source) {
        List<String> regions_list = new ArrayList<>();
        List<String> type_list = new ArrayList<>();
        for(Region region : source.getRegions()){
            regions_list.add(region.getName());
        }
        for(Type type : source.getTypes()){
            type_list.add(type.getName());
        }
        TapaResponse tapaResponse = new TapaResponse(
                source.getId(),
                source.getName(),
                source.getRestaurant().getName(),
                source.getRestaurant().getId(),
                type_list,
                regions_list,
                source.getPicture(),
                source.getTaste());
        return tapaResponse;
    }
}
