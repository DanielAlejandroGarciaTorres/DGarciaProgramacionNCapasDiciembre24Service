/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.DGarciaProgramacionNCapasDiciembre24.DAO;

import com.digis01.DGarciaProgramacionNCapasDiciembre24.JPA.AlumnoDireccion;
import com.digis01.DGarciaProgramacionNCapasDiciembre24.JPA.Result;

/**
 *
 * @author digis
 */
public interface IAlumnoDAO {
    Result BajaLogicaJPA(int IdAlumno);
    
    Result GetAllJPA();
    
    Result AddJPA(AlumnoDireccion alumnoDireccion);
}
