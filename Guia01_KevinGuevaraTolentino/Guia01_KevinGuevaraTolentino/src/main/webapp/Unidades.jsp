<%-- 
    Document   : index
    Created on : 26-abr-2016, 15:43:28
    Author     : Kevin
--%>
<%@page import="com.sv.udb.controlador.PERSCtrl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://displaytag.sf.net/el" prefix="display" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
	<link rel="stylesheet" type="text/css" href="css/materialize.min.css">
        <link rel="stylesheet" type="text/css" href="css/icon.css">
        <link rel="stylesheet" href="iconos/style.css">
        <title>Reporte de Visitas</title>
    </head>
    <body>
        <div id="contenedor">
            <div id="manEquipos">
                <div id="mensajes">
                    <h1 class="center tituloMan">Reporte de Visitas</h1>
                </div>
            </div>
            <div id="menu">
                <div class="menu-item">
                    <a href="index.jsp" class="menu-link">Visitas a una Unidad</a>
                </div>
                <div class="menu-item">
                    <a href="Personas.jsp" class="menu-link">Visitas de una persona</a>
                </div>
                <div class="menu-item">
                    <a href="Unidades.jsp" class="menu-link">Visitas en lapso tiempo</a>
                </div>
                <div class="menu-item">
                    <a href="#" class="menu-link">Item Menu</a>
                </div>
                
                
            </div>
            <div id="registros">
                <form method="POST" action = "Reporte3.jsp" target="_blank">
                <div class="row">
                    <div class="input-field col s12"  >
                        <select name="cmbUnidad" id="cmbUnidad" onchange="probar()">
                            <option name="idUnidad" value="" disabled selected>Seleccione una Unidad</option>
                            <jsp:useBean id="frijolito" class="com.sv.udb.controlador.UNID_ORGACtrl" scope="page"/>
                            <c:forEach items="${frijolito.consTodo()}" var="fila">
                                <option value="<c:out value="${fila.codigo}"></c:out>" ${fila.codigo == selectedPieza  ? 'selected' : ' '}><c:out value="${fila.nombre}" ></c:out></option>
                            </c:forEach>
                        </select>
                        <label>Unidades</label>
                  </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <label>Fecha Inicial</label><br><br>
                        <input type="date" class="" id="dt1" name="dt1" onchange="probar()"/>
                        
                    </div>
                    <div class="input-field col s6" >
                        <label>Fecha Final</label><br><br>
                        <input type="date" class="" id="dt2" name="dt2" onchange="probar()"/>
                        
                    </div>
                </div>
                            
                <div class="row">
                    <div class="input-field col s4">
                        <input class="btn waves-effect waves-light disabled" disabled id="btnReporte" style="width: 100%; padding: 0px;" type="submit" name="cursBoton" value="Generar Reporte"/>
                    </div>
                    <div class="input-field col s2">
                        <a class="waves-effect waves-light btn modal-trigger" href="#modal1"><span class="icon-lifebuoy"></span></a>
                    </div>
                </div>    

                                
                    <input class="btn waves-effect waves-light left" style="margin-top: 14px; display: none;" type="Submit" name="cursBoton" value="Consultar" id="btnConsultar" />
            </form>
            
            </div>
        </div>
    </body>
    <div id="modal1" class="modal">
        <div class="modal-content">
          <h4>Instrucciones:</h4>
          <p>Para generar un reporte, clickear una fila de la tabla, y luego se habilitará el boton de generar reporte.</p>
        </div>
        <div class="modal-footer">
          <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Aceptar</a>
        </div>
      </div>
    <script src="js/jquery-2.1.3.js" charset="utf-8"></script>
    <script src="js/materialize.min.js" charset="utf-8"></script>
    <script src="js/dinamico.js" charset="utf-8"></script>

    <script>
        
        $('select').material_select();
        $('.datepicker').pickadate({
            selectMonths: true, // Creates a dropdown to control month
            selectYears: 15 // Creates a dropdown of 15 years to control year
          });
        $(document).ready(function(){
            // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
            $('.modal-trigger').leanModal();
            
          });
        var btn =document.getElementById("btnReporte");
        function resetForm(){
            $("#disabled").val(null);
            $("#nombre").val(null);
            $("#tipo").val(null);
            $("#direccion").val(null);
            $("#telefono").html(null);
            $("#disabled").attr("disabled", true);
        }
        function ocultar(){
            $("#tbData th:last-child").attr("style", "display: none;");
            $("#tbData td:last-child").attr("style", "display: none;");
            $("#tbData thead").attr("style", "display: none;");
        }
        function seleccionarElemento(){
            $("#tbData tr").click(function(event) {
                var n = $(this).find("input.radioButton").val();
                var id = "test"+n;
                //$("#test"+n).attr("checked", true); // A VECES FALLA :|
                document.getElementById(id).checked = true;
                btn.parentNode.classList.remove("disabled");
                btn.removeAttribute("disabled");
                event.preventDefault();
            });
        }
        function probar(){
            var dt1 = document.getElementById("dt1").value;
            var dt2 = document.getElementById("dt2").value;
            var cmbUnidad = document.getElementById("cmbUnidad").value;
            if((dt1 == null || dt1.trim() =="") || (dt2 == null || dt2.trim() =="") || (cmbUnidad == null || cmbUnidad.trim() =="")){
                btn.parentNode.classList.add("disabled");
                btn.setAttribute("disabled", "true");
               
            }else{
                btn.parentNode.classList.remove("disabled");
                btn.removeAttribute("disabled");
            }
           // alert("dt1: "+dt1+", dt2: "+dt2+", cmb: "+cmbUnidad);
        }
        $(document).ready(function() {
            //OCULTAMOS LA ULTIMA COLUMNA DE LA TABLA DONDE SE MANTIENE EL RADIO BUTTON
            ocultar();
            //LE DECIMOS QUE AL DAR CLICK EN UNA FILA, ESTE SELECCIONE EL RADIO BUTTON CORRESPONDIENTE Y CLICKEE EL BOTON CONSULTAR
            seleccionarElemento();
            resetForm();
            //CURS BOTON
            /*
            $("input[name='cursBoton']").click(function(event) {
                var cursBoton = $(this).val();
                var form = $(this).closest("form");
                if(cursBoton == "Generar Reporte"){
                    btn.parentNode.classList.add("disabled");
                    btn.setAttribute("disabled", "true");
                    $.ajax( {
                        type: "POST",
                        url: form.attr('action'),
                        data: form.serialize() + "&cursBoton=" + cursBoton,
                        success: function(response) {
                            $("#estado").html($(response).find("#estado").html());
                            var win = window.open("reporte.jsp", "_blank");
                            win.focus();
                            alert("HOLA");
                        }
                      });
            
                }else{
                    location.reload();
                }
                event.preventDefault();
            });*/
        });
    </script>
</html>
