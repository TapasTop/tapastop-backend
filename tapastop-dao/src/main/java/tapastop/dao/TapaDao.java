package tapastop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tapastop.model.Tapa;

public interface TapaDao extends JpaRepository<Tapa, Long> {
}
