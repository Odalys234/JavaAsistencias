package com.ESFE.Asistencias.Repositorios;

import com.ESFE.Asistencias.Entidades.estudianteGrupo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IEstudianteGrupoRepository extends JpaRepository<estudianteGrupo, Integer> {
    Page<estudianteGrupo> findByOrderByEstudianteDesc(Pageable pageable);
}
