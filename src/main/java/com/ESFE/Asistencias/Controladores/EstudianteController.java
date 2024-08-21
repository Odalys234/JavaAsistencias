package com.ESFE.Asistencias.Controladores;

import com.ESFE.Asistencias.Entidades.Estudiante;
import com.ESFE.Asistencias.Servicios.Interfaces.IEstudianteSevices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private IEstudianteSevices estudianteServices;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1) - 1;
        int pageSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage, pageSize);
        Page<Estudiante> estudiantes = estudianteServices.BuscarTodosPaginados(pageable);
        model.addAttribute("estudiantes", estudiantes);

        int totalPage = estudiantes.getTotalPages();
        if (totalPage > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
                    .boxed()
                    .collect(Collectors.toList());

            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "estudiante/index";
    }

    @GetMapping("/create")
    public String create(Estudiante estudiante) {
        return "estudiante/create";
    }

    @PostMapping("/save")
    public String save(Estudiante estudiante, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute(estudiante);
            attributes.addFlashAttribute("error", "No se pudo guardar el estudiante debido a un error");
            return "estudiante/create";
        }
        estudianteServices.CrearOeditar(estudiante);
        attributes.addFlashAttribute("msg", "Estudiante creado correctamente");
        return "redirect:/estudiantes";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model) {
        Estudiante estudiante = estudianteServices.BuscarPorId(id).get();
        model.addAttribute("estudiante", estudiante);
        return "estudiante/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Estudiante estudiante = estudianteServices.BuscarPorId(id).get();
        model.addAttribute("estudiante", estudiante);
        return "estudiante/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model) {
        Estudiante estudiante = estudianteServices.BuscarPorId(id).get();
        model.addAttribute("estudiante", estudiante);
        return "estudiante/delete";
    }

    @PostMapping("/delete")
    public String delete(Estudiante estudiante, RedirectAttributes attributes) {
        estudianteServices.EliminarPorId(estudiante.getId());
        attributes.addFlashAttribute("msg", "Estudiante eliminado correctamente");
        return "redirect:/estudiantes";
    }
}
