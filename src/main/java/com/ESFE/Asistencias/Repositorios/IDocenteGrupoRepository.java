package com.ESFE.Asistencias.Repositorios;

import com.ESFE.Asistencias.Entidades.docenteGrupo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocenteGrupoRepository extends JpaRepository<docenteGrupo, Integer> {

    Page<docenteGrupo> findByOrderByDocenteDesc(Pageable pageable);
}
