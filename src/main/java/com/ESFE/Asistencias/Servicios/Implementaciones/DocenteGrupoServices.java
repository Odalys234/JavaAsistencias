package com.ESFE.Asistencias.Servicios.Implementaciones;

import com.ESFE.Asistencias.Entidades.docenteGrupo;
import com.ESFE.Asistencias.Repositorios.IDocenteGrupoRepository;
import com.ESFE.Asistencias.Servicios.Interfaces.IDocenteGrupoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DocenteGrupoServices implements IDocenteGrupoServices {
    @Autowired
    private IDocenteGrupoRepository docenteGrupoRepository;
    @Override
    public Page<docenteGrupo> BuscarTodosPaginados(Pageable pageable) {
        return docenteGrupoRepository.findByOrderByDocenteDesc(pageable);
    }

    @Override
    public List<docenteGrupo> ObtenerTodos() {
        return docenteGrupoRepository.findAll();
    }

    @Override
    public Optional<docenteGrupo> BuscarPorId(Integer id) {
        return docenteGrupoRepository.findById(id);
    }

    @Override
    public docenteGrupo CrearOeditar(docenteGrupo docenteGrupo) {
        return docenteGrupoRepository.save(docenteGrupo);
    }

    @Override
    public void EliminarPorId(Integer id) {
        docenteGrupoRepository.deleteById(id);
    }
}
