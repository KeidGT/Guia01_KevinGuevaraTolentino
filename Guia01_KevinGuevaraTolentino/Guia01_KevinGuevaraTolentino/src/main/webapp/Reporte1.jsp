<%@page import="com.sv.udb.recursos.Conexion"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="net.sf.jasperreports.engine.*" %> 
<%@ page import="java.util.*" %> 
<%@ page import="java.io.*" %>
<%@ page import="net.sf.jasperreports.engine.JasperFillManager"%>
<%@ page import="net.sf.jasperreports.engine.JasperReport" %> 
<%@ page import="net.sf.jasperreports.engine.util.JRLoader" %> 
<%@ page import="net.sf.jasperreports.engine.*" %>
<%@ page import="net.sf.jasperreports.engine.export.JRPdfExporter" %>
<%@ page import="net.sf.jasperreports.engine.JRExporter" %> 
<%
	try{
            //radioButton
            //recolectando posibles parámetros
            
            int id = Integer.parseInt(request.getParameter("radioButton"));
            Connection con = new Conexion().getConn(); 
            
            File reportFile = new File(application.getRealPath("reports/Reporte1.jasper"));
            Map parameters = new HashMap();
            parameters.put("idUnidad",id);
            byte[] bytes=JasperRunManager.runReportToPdf(reportFile.getPath(),parameters,con);
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(bytes,0,bytes.length);
            outputStream.flush();
            outputStream.close();
            
            // PDF
            
            /*
            File reportFile = new File(application.getRealPath("reports/Reporte1.jasper"));
            JasperReport reporte = (JasperReport) JRLoader.loadObject(reportFile);
            Map parameters = new HashMap();
            parameters.put("idUnidad",id);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parameters, con);
            //empezando a exportar
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint); 
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new File("chanchullo.pdf"));
            exporter.exportReport();
            System.out.println("Proceso terminado sin errores");
            */
        }catch(Exception e){
            System.out.println("ERROR REPORTE: "+e.getMessage());
        }
%>