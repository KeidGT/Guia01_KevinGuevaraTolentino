/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.reportes;

import com.sv.udb.recursos.Conexion;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Kevin
 */
public class Reporte {
    public void reporteVisitas(int unidad){
        /*try {
          JasperReport reporte = (JasperReport) JRLoader.loadObject("Visitas.jasper");
          Map parametro = new HashMap();
          parametro.put("codigoUnidadOrganizativa", unidad);
          Conexion con = new Conexion();
          JasperPrint j = JasperFillManager.fillReport(reporte, parametro, con.getConn());
          JasperViewer jv = new JasperViewer(j,false);
          jv.setTitle("ReporteVisitas");
          jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("ERROR REPORTE VISITAS: " +e);
        }*/
        
    }
}
