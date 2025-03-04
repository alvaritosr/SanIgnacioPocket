package spring.sanignaciopocket.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.sanignaciopocket.dtos.EstampitasDTO;
import spring.sanignaciopocket.services.EstampitasService;

import java.util.List;

@RestController
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping("/estampitas")
public class EstampitasController
{
    @Autowired
    private EstampitasService estampitasService;

    @GetMapping("/")
    public List<EstampitasDTO> getAll() throws Exception
    {
        return estampitasService.getAll();
    }
}
