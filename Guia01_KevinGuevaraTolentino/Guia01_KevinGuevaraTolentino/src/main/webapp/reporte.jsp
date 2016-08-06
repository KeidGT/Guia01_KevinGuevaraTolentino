<%@page import="com.sv.udb.recursos.Conexion"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="net.sf.jasperreports.engine.*" %> 
<%@ page import="java.util.*" %> 
<%@ page import="java.io.*" %> 
<%
	try{
            Connection cn = new Conexion().getConn(); 
            File reportFile = new File(application.getRealPath("reports/Reporte1.jasper"));
            System.out.println(reportFile.getPath());
            Map parameters = new HashMap();
            parameters.put("idUnidad",1);
            byte[] bytes=JasperRunManager.runReportToPdf(reportFile.getPath(),parameters,cn);
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(bytes,0,bytes.length);
            outputStream.flush();
            outputStream.close();
        }catch(Exception e){
            System.out.println("ERROR REPORTE: "+e.getMessage());
        }
%>