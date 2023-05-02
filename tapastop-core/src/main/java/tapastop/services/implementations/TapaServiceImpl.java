package tapastop.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tapastop.converters.TapaCoreConverter;
import tapastop.converters.TapaResponseConverter;
import tapastop.dao.RegionDao;
import tapastop.dao.TypeDao;
import tapastop.model.Region;
import tapastop.model.Tapa;
import tapastop.model.Type;
import tapastop.model.User;
import tapastop.persistence.RegionPersistence;
import tapastop.persistence.RestaurantPersistence;
import tapastop.persistence.TapaPersistence;
import tapastop.persistence.TypePersistence;
import tapastop.reponses.TapaResponse;
import tapastop.requests.TapaCoreRequest;
import tapastop.services.TapaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TapaServiceImpl implements TapaService {

    @Autowired
    private TapaPersistence tapaPersistence;
    @Autowired
    private TypePersistence typePersistence;
    @Autowired
    private RegionPersistence regionPersistence;
    @Autowired
    private RestaurantPersistence restaurantPersistence;

    @Override
    public TapaResponse findById(Long id) {
        TapaResponseConverter tapaResponseConverter = new TapaResponseConverter();
        Optional<Tapa> tapa = tapaPersistence.findById(id);
        return tapaResponseConverter.convert(tapa.get());
    }

    @Override
    public TapaResponse save(TapaCoreRequest tapa) {
        List<Region> list_region = new ArrayList<>();
        List<Type> list_type = new ArrayList<>();
        for(Long id : tapa.getRegion_id()){
            list_region.add(regionPersistence.findById(id).get());
        }
        for(Long id : tapa.getType_id()){
            list_type.add(typePersistence.findById(id).get());
        }
        tapa.setRegion(list_region);
        tapa.setType(list_type);
        tapa.setRestaurant(restaurantPersistence.findById(tapa.getRestaurant_id()).get());
        TapaCoreConverter tapaCoreConverter = new TapaCoreConverter();
        Tapa response = tapaPersistence.save(tapaCoreConverter.convert(tapa));
        TapaResponseConverter tapaResponseConverter= new TapaResponseConverter();
        return tapaResponseConverter.convert(response);
    }

    @Override
    public List<TapaResponse> findAll() {
        List<Tapa> tapaList = tapaPersistence.findAll();
        List<TapaResponse> responseList = new ArrayList<>();
        TapaResponseConverter tapaResponseConverter = new TapaResponseConverter();
        for(Tapa tapa : tapaList){
            responseList.add(tapaResponseConverter.convert(tapa));
        }
        return responseList;
    }

    @Override
    public void deleteById(Long id) {
        tapaPersistence.deleteById(id);
    }

    @Override
    public List<TapaResponse> findAllByUser(User user) {
        List<Tapa> tapaList = tapaPersistence.findAllByUsers(user);
        List<TapaResponse> responseList = new ArrayList<>();
        TapaResponseConverter tapaResponseConverter = new TapaResponseConverter();
        for(Tapa tapa : tapaList){
            responseList.add(tapaResponseConverter.convert(tapa));
        }
        return responseList;
    }
}
