package tapastop.dao;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import tapastop.model.Region;

public interface RegionDao extends JpaRepository<Region, Long> {
}
