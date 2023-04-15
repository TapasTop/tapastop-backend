package tapastop.persistence.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import tapastop.dao.TapaDao;
import tapastop.model.Tapa;
import tapastop.model.Tapa;
import tapastop.persistence.TapaPersistence;

import java.util.List;
import java.util.Optional;

@Component
public class TapaPersistenceImpl implements TapaPersistence {
    @Autowired
    private TapaDao tapaDao;

    @Override
    public Optional<Tapa> findById(Long id) {
        Optional<Tapa> persisted = tapaDao.findById(id);
        return persisted;
    }

    @Override
    public Tapa save(Tapa tapa) {
        Tapa persisted = tapaDao.save(tapa);
        return persisted;
    }

    @Override
    public List<Tapa> findAll() {
        List<Tapa> persisted = tapaDao.findAll();
        return persisted;
    }

    @Override
    public void deleteById(Long id) {
        tapaDao.deleteById(id);
    }
}