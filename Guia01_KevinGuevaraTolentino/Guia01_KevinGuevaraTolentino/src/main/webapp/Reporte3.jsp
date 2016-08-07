<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sv.udb.recursos.Conexion"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="net.sf.jasperreports.engine.*" %> 
<%@ page import="java.util.*" %> 
<%@ page import="java.io.*" %> 
<%
        int id = Integer.parseInt(request.getParameter("cmbUnidad"));
       /* Date dt1 = new SimpleDateFormat("dd-MM-yyyy", Locale.US).parse(request.getParameter("dt1"));
        Date dt2 = new SimpleDateFormat("dd-MM-yyyy", Locale.US).parse(request.getParameter("dt2"));
        System.out.println("id: "+id+", dt1: "+dt1+", dt2: "+dt2);
        parameters.put("fechaInicio",new java.sql.Date(dt1.getTime()));
        parameters.put("fechaFin",new java.sql.Date(dt2.getTime()));
        */
	try{
            //radioButton
            //recolectando posibles parámetros
            
            Connection cn = new Conexion().getConn(); 
            File reportFile = new File(application.getRealPath("reports/Reporte3.jasper"));
            System.out.println(reportFile.getPath());
            Map parameters = new HashMap();
            parameters.put("idUnidad",id);
            parameters.put("fechaInicio",request.getParameter("dt1"));
            parameters.put("fechaFin",request.getParameter("dt2"));
            byte[] bytes=JasperRunManager.runReportToPdf(reportFile.getPath(),parameters,cn);
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(bytes,0,bytes.length);
            outputStream.flush();
            outputStream.close();
        }catch(Exception e){
            System.out.println("ERROR REPORTE3: "+e.getMessage());
        }
        
%>