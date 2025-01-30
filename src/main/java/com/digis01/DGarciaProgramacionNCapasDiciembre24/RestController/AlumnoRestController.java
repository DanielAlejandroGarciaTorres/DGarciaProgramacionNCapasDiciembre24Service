package com.digis01.DGarciaProgramacionNCapasDiciembre24.RestController;

import com.digis01.DGarciaProgramacionNCapasDiciembre24.DAO.AlumnoDAOImplementation;
import com.digis01.DGarciaProgramacionNCapasDiciembre24.JPA.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Alumnoapi")
public class AlumnoRestController {
    
    @Autowired
    private AlumnoDAOImplementation alumnoDAOImplementation;
    
    @GetMapping
    public ResponseEntity GetAll(){
        
        Result result = alumnoDAOImplementation.GetAllJPA();
        
        if (result.correct) {
            return ResponseEntity.ok().body(result);
        } else {
            // configurar una respuesta de no información
            return ResponseEntity.ok().body(result); 
        }
        
    }
    
}
