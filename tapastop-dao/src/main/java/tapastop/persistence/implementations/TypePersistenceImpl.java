package tapastop.persistence.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tapastop.dao.TypeDao;
import tapastop.model.Type;
import tapastop.persistence.TypePersistence;

import java.util.Optional;

@Component
public class TypePersistenceImpl implements TypePersistence {

    @Autowired
    private TypeDao typeDao;

    @Override
    public Optional<Type> findById(Long id) {
        return typeDao.findById(id);
    }
}
