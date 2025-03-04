package spring.sanignaciopocket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.sanignaciopocket.models.Puntuaciones;

import java.util.List;

@Repository
public interface IPuntuacionesRepository extends JpaRepository<Puntuaciones, Long>
{
    @Query("SELECT p FROM Puntuaciones p ORDER BY p.pts DESC")
    List<Puntuaciones> findTop10ByQuery();
}
