package com.ESFE.Asistencias.Entidades;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Estudiantes")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Nullable
    private String nombre;

    @Email(message = "Ingrese un email válido")
    @NotBlank(message = "El email es obligatorio")
    private String email;

    @NotNull(message = "El pin es obligatorio")
    private String pin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Nullable
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@Nullable String nombre) {
        this.nombre = nombre;
    }

    public @Email(message = "Ingrese un email válido") @NotBlank(message = "El email es obligatorio") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Ingrese un email válido") @NotBlank(message = "El email es obligatorio") String email) {
        this.email = email;
    }

    public @NotNull(message = "El pin es obligatorio") String getPin() {
        return pin;
    }

    public void setPin(@NotNull(message = "El pin es obligatorio") String pin) {
        this.pin = pin;
    }
}
