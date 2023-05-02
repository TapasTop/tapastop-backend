package tapastop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import tapastop.model.Tapa;
import tapastop.model.User;

import java.util.List;

public interface TapaDao extends JpaRepository<Tapa, Long> {

    @Query(value = "SELECT t.tapa FROM Rating t WHERE t.user = :user")
    List<Tapa> findAllByUsers(@RequestBody User user);

}
