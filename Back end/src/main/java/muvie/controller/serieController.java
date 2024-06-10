package muvie.controller;

import muvie.dto.EpisodioDto;
import muvie.dto.serieDto;
import muvie.service.serieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/series")
public class serieController {

    @Autowired
    private serieService servicio;

    @GetMapping()
    public List<serieDto> obtenerSeries() {
        return servicio.obtenerSeries();

    }
    @GetMapping("/top5")
    public List<serieDto> obtenerSTop5() {
        return servicio.obtenerTop5();

    }

    @GetMapping("/lanzamientos")
    public List<serieDto>obtenerLanzamientosRecientes(){
        return servicio.obtenerLanzamientosRecientes();
    }

    @GetMapping("/{id}")
    public serieDto obtenerPorId(@PathVariable long id){
        return servicio.obtenerPorId(id);
    }
    @GetMapping("/{id}/temporadas/todas")
    public List<EpisodioDto> obtenerTemporadas(@PathVariable long id){
        return servicio.obtenerTemporadas(id);
    }
    @GetMapping("/{id}/temporadas/{numeroTemporada}")
    public List<EpisodioDto> obtenerNumeroTemporadas(@PathVariable long id, @PathVariable long numeroTemporada){
        return servicio.obtenerNumeroTemporadas(id,numeroTemporada);
    }
    @GetMapping("/categoria/{nombreGenero}")
    public List<serieDto> obtenerCategoriaSerie(@PathVariable String nombreGenero){
        return servicio.obtenerCategoriaSerie(nombreGenero);
    }

    @GetMapping("/{id}/temporadas/top")
    public List<EpisodioDto> obtenerTop5Episodios(@PathVariable long id){
        return servicio.obtenerTop5Episodios(id);
    }
}
