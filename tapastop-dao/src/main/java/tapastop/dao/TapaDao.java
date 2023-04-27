package tapastop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tapastop.model.Tapa;

import java.util.List;

public interface TapaDao extends JpaRepository<Tapa, Long> {
    @Query("SELECT t FROM Tapa t WHERE t.taste = :taste")
    List<Tapa> findByTaste(@Param("taste") String taste);
}
