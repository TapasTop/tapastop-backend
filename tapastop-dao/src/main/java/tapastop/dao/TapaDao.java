package tapastop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import tapastop.model.Tapa;
import tapastop.model.User;

import java.util.List;

public interface TapaDao extends JpaRepository<Tapa, Long> {

    @Query(value = "SELECT t.tapa FROM Rating t INNER JOIN User u ON t.user = u.id WHERE U.id = ?1",  nativeQuery = true)
    List<Tapa> getTapasByUsers(@RequestParam Long id);

}
