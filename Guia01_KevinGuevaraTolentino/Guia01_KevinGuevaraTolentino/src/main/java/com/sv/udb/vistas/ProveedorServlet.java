/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vistas;

import com.sv.udb.controlador.ProveedorCtrl;
import com.sv.udb.modelo.Proveedor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kevin
 */
@WebServlet(name = "ProveedorServlet", urlPatterns = {"/ProveedorServlet"})
public class ProveedorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        boolean esValido=request.getMethod().equals("POST");
        String mensaje="En Espera";
        if(esValido)
        {
            String CRUD = request.getParameter("cursBoton");
            if(CRUD.equals("Guardar"))
            {
                Proveedor obj = new Proveedor();
                obj.setNombreProveedor(request.getParameter("txtNombre"));
                obj.setDireccionProveedor(request.getParameter("txtDireccion"));
                obj.setTelefonoProveedor(request.getParameter("txtTelefono"));
                mensaje = new ProveedorCtrl().guardar(obj)? "Datos guardados" : "Datos NO guardados";
            }
            else if(CRUD.equals("Consultar"))
            {
                String id = request.getParameter("radioButton")==null?"0":request.getParameter("radioButton");
                Proveedor obj = new ProveedorCtrl().consProveedor(id);
                if(obj!=null)
                {
                    request.setAttribute("txtID", obj.getIdProveedor());
                    request.setAttribute("txtNombre", obj.getNombreProveedor());
                    request.setAttribute("txtDireccion", obj.getDireccionProveedor());
                    request.setAttribute("txtTelefono", obj.getTelefonoProveedor());
                }
                
            }else if(CRUD.equals("Eliminar")){
                int id = Integer.parseInt(request.getParameter("txtID")==null?"0":request.getParameter("txtID"));
                
                if(id > 0){
                    mensaje = new ProveedorCtrl().eliminar(new Proveedor(id,null,null,null))? "Datos eliminados" : "Datos NO eliminados";
                }else{
                    mensaje = "Registro no válido";
                }
            }else if(CRUD.equals("Modificar")){
                int id = Integer.parseInt(request.getParameter("txtID")==null?"0":request.getParameter("txtID"));
                if(id > 0){
                    Proveedor obj = new Proveedor();
                    obj.setIdProveedor(id);
                    obj.setNombreProveedor(request.getParameter("txtNombre"));
                    obj.setDireccionProveedor(request.getParameter("txtDireccion"));
                    obj.setTelefonoProveedor(request.getParameter("txtTelefono"));
                    mensaje = new ProveedorCtrl().modificar(obj)? "Datos modificados" : "Datos NO modificados";
                }else{
                    mensaje = "Registro no válido";
                }
            }
        } 
        else
        {
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
        request.setAttribute("mensAler", mensaje);    
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
