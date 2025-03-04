package spring.sanignaciopocket.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.sanignaciopocket.dtos.EstampitasDTO;
import spring.sanignaciopocket.models.Estampitas;
import spring.sanignaciopocket.repositories.IEstampitasRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class EstampitasService
{
    @Autowired
    private IEstampitasRepository estampitasRepository;

    public List<EstampitasDTO> getAll() throws Exception
    {
        List<Estampitas> estampitas = estampitasRepository.findAll();

        if (estampitas.isEmpty())
        {
            throw new Exception("No se encontraron estampitas");
        }

        return estampitas.stream().map(this::returnDTO).collect(Collectors.toList());
    }

    public EstampitasDTO returnDTO(Estampitas estampitas)
    {
        EstampitasDTO dto = new EstampitasDTO();
        dto.setId(estampitas.getId());
        dto.setNombre(estampitas.getNombre());
        dto.setImagen(estampitas.getImagen());
        return dto;
    }
}
