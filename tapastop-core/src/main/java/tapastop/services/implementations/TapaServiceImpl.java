package tapastop.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tapastop.model.Tapa;
import tapastop.persistence.TapaPersistence;
import tapastop.services.TapaService;

import java.util.List;
import java.util.Optional;

@Service
public class TapaServiceImpl implements TapaService {

    @Autowired
    private TapaPersistence tapaPersistence;

    @Override
    public Tapa findById(Long id) {
        Optional<Tapa> tapa = tapaPersistence.findById(id);
        return tapa.get();
    }

    @Override
    public Tapa save(Tapa tapa) {
        Tapa rest = tapaPersistence.save(tapa);
        return rest;
    }

    @Override
    public List<Tapa> findAll() {
        List<Tapa> tapaList = tapaPersistence.findAll();
        return tapaList;
    }

    @Override
    public void deleteById(Long id) {
        tapaPersistence.deleteById(id);
    }
}
