package spring.sanignaciopocket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.sanignaciopocket.models.Puntuaciones;

@Repository
public interface IPuntuacionesRepository extends JpaRepository<Puntuaciones, Long> { }
