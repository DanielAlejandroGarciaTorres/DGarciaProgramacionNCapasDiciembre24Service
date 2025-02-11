package com.digis01.DGarciaProgramacionNCapasDiciembre24;

import com.digis01.DGarciaProgramacionNCapasDiciembre24.DAO.AlumnoDAOImplementation;
import com.digis01.DGarciaProgramacionNCapasDiciembre24.JPA.Alumno;
import com.digis01.DGarciaProgramacionNCapasDiciembre24.JPA.Result;
import com.digis01.DGarciaProgramacionNCapasDiciembre24.JPA.Semestre;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MockitoTest {
    
    @Mock
    private EntityManager entityManager;
    
    @InjectMocks
    private AlumnoDAOImplementation alumnoDAOImplementation;
    
    /*addMOckitoCorrecto
      addMOckitoIncorrecto*/
    
    @Test
    public void AddMockito(){
        Alumno alumno = new Alumno();
        alumno.setNombre("Johnny");
        alumno.setApellidoPaterno("Bravo");
        alumno.setApellidoMaterno("Bravo");
        alumno.setUserName("jbravo");
        alumno.setPassword("jbravo1234");
        alumno.setTelefono("7418520964");
        alumno.Semestre = new Semestre();
        alumno.Semestre.setIdSemestre(2);
        
        
        Mockito.doNothing().when(entityManager).persist(any(Alumno.class));
        
        Result result = alumnoDAOImplementation.AddJPA(alumno, 0);
    
        
        Mockito.verify(entityManager,Mockito.times(1)).persist(any(Alumno.class));
        
        Assertions.assertTrue(result.correct);
    }
    
    
}
