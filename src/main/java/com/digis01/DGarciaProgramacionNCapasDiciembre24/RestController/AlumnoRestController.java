package com.digis01.DGarciaProgramacionNCapasDiciembre24.RestController;

import com.digis01.DGarciaProgramacionNCapasDiciembre24.DAO.AlumnoDAOImplementation;
import com.digis01.DGarciaProgramacionNCapasDiciembre24.JPA.Alumno;
import com.digis01.DGarciaProgramacionNCapasDiciembre24.JPA.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    
    
    /* cadena de bytes
       headers - tipo de dato a enviar    
    */
    
    
    @PostMapping("/CargaMasiva")
    public ResponseEntity CargaMasiva(@RequestParam("archivo") MultipartFile archivo){
        
        //almacenamiento del archivo - absolutePath
        //lectura
        // valido
        
        //Si todo OK
        Result result = new Result();
        /*Todo bien, se retorna informacion de archivo correcto */
        result.correct = true;
        result.object = "Ruta";
        return ResponseEntity.ok().body(result);
        
        /*todo mal, se retorna lista de errores*/
//        result.correct = false;
//        result.object = null ; // lista errores (Result excel)
        
//        return ResponseEntity.badRequest().body(result);
    }
    
    
}
