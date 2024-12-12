package com.example.ef_listar.Controllers;

import com.example.ef_listar.Entities.Empleado;
import com.example.ef_listar.Repositories.EmpleadoRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ListarController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping("/rh/saludo/{order}")
    public ResponseEntity<String> holi(@PathVariable String order){
        return  ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Saludos mi estimado: "+order);
    }


    @GetMapping("/rh/empleado/orderby/{order}")
    public ResponseEntity<String> listarEmpleados(@PathVariable String order){

        List<Empleado> listaEmpleados = new ArrayList<>();

        switch (order.trim().toLowerCase()) {
            case "firstname" -> {
                listaEmpleados = empleadoRepository.findAll(Sort.by(Sort.Direction.ASC,"firstName"));
            }

            case "lastname" -> {
                listaEmpleados = empleadoRepository.findAll(Sort.by(Sort.Direction.ASC, "lastName"));
            }

            case "email" -> {
                listaEmpleados = empleadoRepository.findAll(Sort.by(Sort.Direction.ASC, "email"));
            }

            default -> {
                return ResponseEntity.badRequest().body("El valor de 'order' no es válido.");
            }
        }

        Gson gson = new Gson();
        return  ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(gson.toJson(listaEmpleados));

    }
}
