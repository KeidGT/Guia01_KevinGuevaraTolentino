/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Proveedor;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevin
 */
public class ProveedorCtrl {
     public List<Proveedor> consTodo()
    {
       List<Proveedor> resp = new ArrayList();
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("select * from proveedores");
            ResultSet rs = cmd.executeQuery();
                
            while(rs.next())
            {   
                resp.add(new Proveedor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
               
            }
             
        }
        catch(SQLException err)
        {
            System.out.print(err);
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                System.out.print(err);
            }
        }
        return resp;
    }
     public Proveedor consProveedor(String id)
    {
       Proveedor resp = new Proveedor();
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("select * from proveedores where idProveedor = ?");
            cmd.setString(1, id);
            ResultSet rs = cmd.executeQuery();
                
            if(rs.next())
            {   
                resp = new Proveedor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
               
            }
             
        }
        catch(SQLException err)
        {
            System.out.print(err);
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                System.out.print(err);
            }
        }
        return resp;
    }
    public boolean guardar(Proveedor obj)
    {
        boolean resp= false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("INSERT INTO proveedores VALUES(NULL,?,?,?)");
            cmd.setString(1, obj.getNombreProveedor());
            cmd.setString(2, obj.getDireccionProveedor());
            cmd.setString(3, obj.getTelefonoProveedor());
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception err)
        {
            err.printStackTrace();
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    }
    public boolean modificar(Proveedor obj)
    {
        boolean resp= false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("UPDATE proveedores set nombreProveedor= ? , direccionProveedor = ?, telefonoProveedor = ?  where idProveedor = ?");
            cmd.setString(1, obj.getNombreProveedor());
            cmd.setString(2, obj.getDireccionProveedor());
            cmd.setString(3, obj.getTelefonoProveedor());
            cmd.setInt(4, obj.getIdProveedor());
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception err)
        {
            err.printStackTrace();
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    }
    public boolean eliminar(Proveedor obj)
    {
        boolean resp= false;
        Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("DELETE FROM proveedores  WHERE idProveedor = ?");
            cmd.setInt(1, obj.getIdProveedor());
            cmd.executeUpdate();
            resp=true;
        }
        catch(Exception err)
        {
            err.printStackTrace();
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    }
}
