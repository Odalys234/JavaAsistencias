package com.ESFE.Asistencias.Servicios.Implementaciones;

import com.ESFE.Asistencias.Entidades.estudianteGrupo;
import com.ESFE.Asistencias.Repositorios.IEstudianteGrupoRepository;
import com.ESFE.Asistencias.Servicios.Interfaces.IEstudianteGrupoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteGrupoServices implements IEstudianteGrupoServices {

    @Autowired
    private IEstudianteGrupoRepository estudianteGrupoRepository;

    @Override
    public Page<estudianteGrupo> BuscarTodosPaginados(Pageable pageable) {
        return estudianteGrupoRepository.findByOrderByEstudianteDesc(pageable);
    }

    @Override
    public List<estudianteGrupo> ObtenerTodos() {
        return estudianteGrupoRepository.findAll();
    }

    @Override
    public Optional<estudianteGrupo> BuscarPorId(Integer id) {
        return estudianteGrupoRepository.findById(id);
    }

    @Override
    public estudianteGrupo CrearOeditar(estudianteGrupo estudianteGrupo) {
        return estudianteGrupoRepository.save(estudianteGrupo);
    }

    @Override
    public void EliminarPorId(Integer id) {
        estudianteGrupoRepository.deleteById(id);
    }
}
