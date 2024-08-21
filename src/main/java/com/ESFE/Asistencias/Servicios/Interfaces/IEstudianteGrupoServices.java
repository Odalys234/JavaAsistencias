package com.ESFE.Asistencias.Servicios.Interfaces;

import com.ESFE.Asistencias.Entidades.estudianteGrupo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEstudianteGrupoServices {
    Page<estudianteGrupo> BuscarTodosPaginados(Pageable pageable);
    List<estudianteGrupo> ObtenerTodos();
    Optional<estudianteGrupo> BuscarPorId(Integer id);
    estudianteGrupo CrearOeditar(estudianteGrupo estudianteGrupo);
    void EliminarPorId(Integer id);

}
