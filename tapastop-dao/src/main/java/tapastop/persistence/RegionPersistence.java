package tapastop.persistence;

import tapastop.model.Region;
import tapastop.model.Type;

import java.util.Optional;

public interface RegionPersistence {
    public Optional<Region> findById(Long id);
}
