package tapastop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tapastop.model.Type;

public interface TypeDao extends JpaRepository<Type, Long> {
}
