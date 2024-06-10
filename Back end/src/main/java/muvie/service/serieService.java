package muvie.service;

import muvie.dto.EpisodioDto;
import muvie.dto.serieDto;
import muvie.model.Categoria;
import muvie.model.Episodio;
import muvie.model.Serie;
import muvie.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class serieService {



    @Autowired
    private SerieRepository repository;

    public List<serieDto> obtenerSeries (){
        return convertirDatos(repository.findAll());
    }
    public List<serieDto> obtenerTop5(){
        return convertirDatos(repository.findTop5ByOrderByEvaluacionDesc());
    }
    public List<serieDto> obtenerLanzamientosRecientes(){
        return convertirDatos(repository.lanzamientosRecientes());
    }

    public List<serieDto> convertirDatos (List<Serie> series){
        return series.stream()
                .map(s -> new serieDto(s.getId(), s.getTitulo(),s.getTotalTemporadas(),s.getEvaluacion()
                        ,s.getPoster(),s.getGenero(),s.getActores(),s.getSinopsis())).collect(Collectors.toList());

    }

    public serieDto obtenerPorId(long id) {
        Optional<Serie> serie = repository.findById(id);

        if(serie.isPresent()){
            Serie s = serie.get();
            return new serieDto(s.getId(), s.getTitulo(),s.getTotalTemporadas(),s.getEvaluacion()
                    ,s.getPoster(),s.getGenero(),s.getActores(),s.getSinopsis());

        }
        return null;
    }

    public List<EpisodioDto> obtenerTemporadas(long id) {
        Optional<Serie> serie = repository.findById(id);
        if(serie.isPresent()){
            Serie s = serie.get();
            return s.getEpisodios().stream()
                    .map(e -> new EpisodioDto(e.getTemporada(),e.getTitulo(),e.getNumeroEpisodio()))
                    .collect(Collectors.toList());
        }
        return null;

    }

    public List<EpisodioDto> obtenerNumeroTemporadas(long id, long numeroTemporada) {
        return repository.obtenerNumeroTemporadas(id,numeroTemporada).stream()
                .map(e -> new EpisodioDto(e.getTemporada(),e.getTitulo(),e.getNumeroEpisodio()))
                .collect(Collectors.toList());
    }

    public List<serieDto> obtenerCategoriaSerie(String nombreGenero) {
        Categoria categoria = Categoria.fromEspanol(nombreGenero);
        return convertirDatos(repository.findByGenero(categoria));
    }

    public List<EpisodioDto> obtenerTop5Episodios(long id) {
        var serie = repository.findById(id).get();
        return repository.top5Episodios(serie).stream()
                .map((e -> new EpisodioDto(e.getNumeroEpisodio(),e.getTitulo(),e.getTemporada())))
                .collect(Collectors.toList());

        }

    }

