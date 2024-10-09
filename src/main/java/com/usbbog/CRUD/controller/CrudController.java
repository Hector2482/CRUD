package com.usbbog.CRUD.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CrudController {

    private List<String> paises = new ArrayList<>();

    public CrudController() {
        paises.add("Colombia");
        paises.add("Canadá");
        paises.add("Ecuador");
        paises.add("Peru");
        paises.add("Rusia");
        paises.add("Australia");
        paises.add("Alemania");
        paises.add("Suiza");
        paises.add("Noruega");
        paises.add("Suecia");
        paises.add("Estados Unidos");
        paises.add("Francia");
        paises.add("Italia");
        paises.add("Brasil");
        paises.add("Argentina");
        paises.add("Chile");
        paises.add("México");
        paises.add("Japón");
        paises.add("China");
        paises.add("India");
        paises.add("Sudáfrica");
        paises.add("Nueva Zelanda");
        paises.add("Egipto");
        paises.add("Grecia");
        paises.add("Portugal");
        paises.add("España");
        paises.add("Reino Unido");
        paises.add("Finlandia");
        paises.add("Dinamarca");
        paises.add("Corea del Sur");
    }

    // Método GET para leer todos los países
    @GetMapping("/paises")
    public List<String> getAllCountries() {
        return paises;
    }

    // Método GET para leer un país por ID
    @GetMapping("/paises/{idPais}")
    public String getCountryById(@PathVariable int idPais) {
        if (idPais >= 0 && idPais < paises.size()) {
            return paises.get(idPais);
        } else {
            return "Pais no encontrado";
        }
    }

    // Método POST para agregar un nuevo país (CREATE)
    @PostMapping("/paises")
    public String addCountry(@RequestBody String nuevoPais) {
        paises.add(nuevoPais);
        return "Pais agregado: " + nuevoPais;
    }

    // Método PUT para actualizar un país existente (UPDATE)
    @PutMapping("/paises/{idPais}")
    public String updateCountry(@PathVariable int idPais, @RequestBody String paisActualizado) {
        if (idPais >= 0 && idPais < paises.size()) {
            paises.set(idPais, paisActualizado);
            return "Pais actualizado a: " + paisActualizado;
        } else {
            return "Pais no encontrado";
        }
    }

    // Método DELETE para eliminar un país por ID (DELETE)
    @DeleteMapping("/paises/{idPais}")
    public String deleteCountry(@PathVariable int idPais) {
        if (idPais >= 0 && idPais < paises.size()) {
            String paisEliminado = paises.remove(idPais);
            return "Pais eliminado: " + paisEliminado;
        } else {
            return "Pais no encontrado";
        }
    }
}
