package tapastop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tapastop.model.Tapa;
import tapastop.model.User;

import java.util.List;

import java.util.List;

public interface TapaDao extends JpaRepository<Tapa, Long> {
    @Query(value = "SELECT * FROM tapa t WHERE t.taste = :taste", nativeQuery = true)
    List<Tapa> findByTaste(@Param("taste") String taste);

    //@Query(value = "SELECT * FROM tapa t WHERE t.region IN (SELECT unnest(t.region_names))", nativeQuery = true)
    @Query(value = "SELECT t.* FROM tapa t JOIN tapa_region tr ON t.id = tr.tapa_id JOIN region r ON tr.region_id = r.id WHERE r.name = :region", nativeQuery = true)
    List<Tapa> findByRegion(@Param("region") String region);

    @Query(value = "SELECT tapa.* FROM tapa INNER JOIN rating ON tapa.id = rating.tapa_id  WHERE rating.user_id = :user_id",  nativeQuery = true)
    List<Tapa> getTapasByUsers(@Param("user_id") Long id);
}
