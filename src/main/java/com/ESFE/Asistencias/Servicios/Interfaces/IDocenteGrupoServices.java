package com.ESFE.Asistencias.Servicios.Interfaces;

import com.ESFE.Asistencias.Entidades.docenteGrupo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IDocenteGrupoServices {
    Page<docenteGrupo> BuscarTodosPaginados(Pageable pageable);
    List<docenteGrupo> ObtenerTodos();
    Optional<docenteGrupo> BuscarPorId(Integer id);
    docenteGrupo CrearOeditar(docenteGrupo docenteGrupo);
    void EliminarPorId(Integer id);
}
