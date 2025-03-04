package spring.sanignaciopocket.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.sanignaciopocket.dtos.EstampitasDTO;
import spring.sanignaciopocket.dtos.PuntuacionesDTO;
import spring.sanignaciopocket.models.Puntuaciones;
import spring.sanignaciopocket.services.EstampitasService;
import spring.sanignaciopocket.services.PuntuacionesService;

import java.util.List;

@Controller
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping("/puntuaciones")
public class PuntuacionesController
{
    @Autowired
    private PuntuacionesService puntuacionesService;

    @GetMapping("/")
    public List<PuntuacionesDTO> getAll() throws Exception
    {
        return puntuacionesService.getAll();
    }

    @PostMapping("/guardar")
    public PuntuacionesDTO guardar(@RequestBody PuntuacionesDTO puntuacionesDTO)
    {
        return puntuacionesService.guardar(puntuacionesDTO);
    }
}
