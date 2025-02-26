package spring.sanignaciopocket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.sanignaciopocket.models.Estampitas;

@Repository
public interface IEstampitasRepository extends JpaRepository<Estampitas, Long> { }
