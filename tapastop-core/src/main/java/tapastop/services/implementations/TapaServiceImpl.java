package tapastop.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tapastop.converters.TapaCoreConverter;
import tapastop.converters.TapaResponseConverter;
import tapastop.exceptions.types.BadRequestException;
import tapastop.model.Region;
import tapastop.model.Tapa;
import tapastop.model.Type;
import tapastop.model.User;
import tapastop.persistence.*;
import tapastop.reponses.TapaResponse;
import tapastop.requests.TapaCoreRequest;
import tapastop.services.TapaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TapaServiceImpl implements TapaService {

    @Autowired
    private UserPersistence userPersistence;
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
        if(!tapa.isPresent()){
            return null;
        }
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
    public List<TapaResponse> findByTaste(String taste) {
        TapaResponseConverter tapaResponseConverter = new TapaResponseConverter();
        List<Tapa> tapas = tapaPersistence.findByTaste(taste);
        return tapas.stream()
                .map(tapaResponseConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<TapaResponse> findByRegion(String region) {
        TapaResponseConverter tapaResponseConverter = new TapaResponseConverter();
        List<Tapa> tapas = tapaPersistence.findByRegion(region);
        return tapas.stream()
                .map(tapaResponseConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<TapaResponse> getTapasByUser(String username) {
        Optional<User> user = userPersistence.findByUsername(username);
        if(!user.isPresent()){
            throw new BadRequestException("400", "User with username " + username + " does not exist", HttpStatus.BAD_REQUEST);
        }
        Long id = user.get().getId();
        List<Tapa> tapaList = tapaPersistence.getTapasByUsers(id);
        List<TapaResponse> responseList = new ArrayList<>();
        TapaResponseConverter tapaResponseConverter = new TapaResponseConverter();
        for(Tapa tapa : tapaList){
            responseList.add(tapaResponseConverter.convert(tapa));
        }
        return responseList;
    }
}
