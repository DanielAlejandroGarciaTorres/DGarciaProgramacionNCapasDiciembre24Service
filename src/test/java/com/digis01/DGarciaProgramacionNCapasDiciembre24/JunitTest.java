package com.digis01.DGarciaProgramacionNCapasDiciembre24;

import com.digis01.DGarciaProgramacionNCapasDiciembre24.DAO.AlumnoDAOImplementation;
import com.digis01.DGarciaProgramacionNCapasDiciembre24.JPA.Alumno;
import com.digis01.DGarciaProgramacionNCapasDiciembre24.JPA.Result;
import com.digis01.DGarciaProgramacionNCapasDiciembre24.JPA.Semestre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JunitTest {
    
    @Autowired
    private AlumnoDAOImplementation alumnoDAOImplementation;
    
    @Test
    public void AddJunit(){
        
        Alumno alumno = new Alumno();
        alumno.setNombre("Johnny");
        alumno.setApellidoPaterno("Deep2");
        alumno.setApellidoMaterno("Deep2");
        alumno.setUserName("jdeep2");
        alumno.setPassword("jdeep1234");
        alumno.setTelefono("7418520964");
        alumno.Semestre = new Semestre();
        alumno.Semestre.setIdSemestre(2);
        
        
        Result result = alumnoDAOImplementation.AddJPA(alumno, 0);
    
        
        Assertions.assertTrue(result.correct);
    }
    
    
}
