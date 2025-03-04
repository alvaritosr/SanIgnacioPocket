package spring.sanignaciopocket.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.sanignaciopocket.dtos.PuntuacionesDTO;
import spring.sanignaciopocket.models.Puntuaciones;
import spring.sanignaciopocket.repositories.IPuntuacionesRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class PuntuacionesService 
{
    @Autowired
    private IPuntuacionesRepository puntuacionesRepository;

    public List<PuntuacionesDTO> getAll() throws Exception
    {
        List<Puntuaciones> puntuaciones = puntuacionesRepository.findTop10ByQuery();

        if (puntuaciones.isEmpty())
        {
            throw new Exception("No se encontraron Puntuaciones");
        }

        return puntuaciones.stream().map(this::returnDTO).collect(Collectors.toList());
    }

    public PuntuacionesDTO guardar(PuntuacionesDTO PuntuacionesDTO)
    {
        Puntuaciones puntuaciones = new Puntuaciones();
        puntuaciones.setId(PuntuacionesDTO.getId());
        puntuaciones.setNombre(PuntuacionesDTO.getNombre());
        puntuaciones.setPts(PuntuacionesDTO.getPts());

        Puntuaciones puntuacionesGuardado = puntuacionesRepository.save(puntuaciones);

        PuntuacionesDTO dto = new PuntuacionesDTO();
        dto.setId(puntuacionesGuardado.getId());
        dto.setNombre(puntuacionesGuardado.getNombre());
        dto.setPts(puntuacionesGuardado.getPts());

        return dto;
    }

    public PuntuacionesDTO returnDTO(Puntuaciones Puntuaciones)
    {
        PuntuacionesDTO dto = new PuntuacionesDTO();
        dto.setId(Puntuaciones.getId());
        dto.setNombre(Puntuaciones.getNombre());
        dto.setPts(Puntuaciones.getPts());
        return dto;
    }
}
