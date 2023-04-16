package tapastop.persistence.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tapastop.dao.RegionDao;
import tapastop.model.Region;
import tapastop.persistence.RegionPersistence;

import java.util.Optional;

@Component
public class RegionPersistenceImpl implements RegionPersistence {

    @Autowired
    private RegionDao regionDao;

    @Override
    public Optional<Region> findById(Long id) {
        return regionDao.findById(id);
    }
}
