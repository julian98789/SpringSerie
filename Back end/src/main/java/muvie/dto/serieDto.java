package muvie.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import muvie.model.Categoria;

public record serieDto(
        long id,
        String titulo,
        Integer totalTemporadas,
        double evaluacion,
        String poster,
        Categoria genero,
        String actores,
        String sinopsis
) {

}
