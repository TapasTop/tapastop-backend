package tapastop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tapastop.model.Tapa;

import java.util.List;

public interface TapaDao extends JpaRepository<Tapa, Long> {
    @Query(value = "SELECT * FROM tapa t WHERE t.taste = :taste", nativeQuery = true)
    List<Tapa> findByTaste(@Param("taste") String taste);
}
