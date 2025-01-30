package com.digis01.DGarciaProgramacionNCapasDiciembre24.DAO;

import com.digis01.DGarciaProgramacionNCapasDiciembre24.JPA.AlumnoDireccion;
import com.digis01.DGarciaProgramacionNCapasDiciembre24.JPA.Result;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository // logica de base de datos
public class AlumnoDAOImplementation implements IAlumnoDAO {

    @Autowired
    private EntityManager entityManager; // conexión jpa

    @Override
    public Result GetAllJPA() {
        Result result = new Result();
        try {
            // JPQL

            result.objects = new ArrayList<>();

            TypedQuery<com.digis01.DGarciaProgramacionNCapasDiciembre24.JPA.Alumno> queryAlumno = entityManager.createQuery("FROM Alumno", com.digis01.DGarciaProgramacionNCapasDiciembre24.JPA.Alumno.class);
            List<com.digis01.DGarciaProgramacionNCapasDiciembre24.JPA.Alumno> alumnosJPA = queryAlumno.getResultList();

            for (com.digis01.DGarciaProgramacionNCapasDiciembre24.JPA.Alumno alumno : alumnosJPA) {
                AlumnoDireccion alumnoDireccion = new AlumnoDireccion();
                alumnoDireccion.Alumno = alumno;
                
                TypedQuery<com.digis01.DGarciaProgramacionNCapasDiciembre24.JPA.Direccion> queryDireccion = entityManager.createQuery("FROM Direccion WHERE Alumno.IdAlumno = :pIdAlumno", com.digis01.DGarciaProgramacionNCapasDiciembre24.JPA.Direccion.class);
                queryDireccion.setParameter("pIdAlumno", alumno.getIdAlumno());
                List<com.digis01.DGarciaProgramacionNCapasDiciembre24.JPA.Direccion> direcciones = queryDireccion.getResultList();

                alumnoDireccion.Direcciones = direcciones;

                result.objects.add(alumnoDireccion);
            }

            result.correct = true;

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
            result.objects = null;
        }

        return result;
    }

    @Transactional // DML Insert/update/delete
    @Override
    public Result AddJPA(AlumnoDireccion alumnoDireccion) {

//        com.digis01.DGarciaProgramacionNCapasDiciembre24.JPA.Alumno alumnoJPA = new com.digis01.DGarciaProgramacionNCapasDiciembre24.JPA.Alumno();
//        alumnoJPA.setNombre("Ramón");
//        alumnoJPA.setApellidoPaterno("Valdez");
//        alumnoJPA.setApellidoMaterno("Valdez");
//        alumnoJPA.setUserName("Rorro");
//        alumnoJPA.setPassword("rorro123");
//        alumnoJPA.setTelefono("1234560089");
//        alumnoJPA.Semestre = new com.digis01.DGarciaProgramacionNCapasDiciembre24.JPA.Semestre();
//        alumnoJPA.Semestre.setIdSemestre(1);
//
//        entityManager.persist(alumnoJPA);

        return new Result();
    }

    @Override
    @Transactional
    public Result BajaLogicaJPA(int IdAlumno) {
        Result result = new Result();
//        try {
//            com.digis01.DGarciaProgramacionNCapasDiciembre24.JPA.Alumno alumnoJPA = entityManager.find(com.digis01.DGarciaProgramacionNCapasDiciembre24.JPA.Alumno.class, IdAlumno);
//
//            alumnoJPA.setStatus(alumnoJPA.getStatus().equals("Activo") ? "Inactivo" : "Activo");
//            entityManager.merge(alumnoJPA);
//            result.correct = true;
//        } catch(Exception ex){
//            
//        }

        return result;

    }

}
