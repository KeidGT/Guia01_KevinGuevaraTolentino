/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.reportes;

import com.sv.udb.recursos.Conexion;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Kevin
 */
public class Reporte {
    public void reporteVisitas(int unidad){
        /*          SWING
        
        try {
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
/*      try{
            JasperReport reporte = (JasperReport) JRLoader.loadObject("reporte1.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parameters, cn);
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint); 
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE,new java.io.File("reportePDF.pdf"));
            exporter.exportReport();
        }catch(Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }*/
    }
}
