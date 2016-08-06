/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;
import com.sv.udb.modelo.Proveedor;
import com.sv.udb.modelo.UNID_ORGA;
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
public class UNID_ORGACtrl {
    public List<UNID_ORGA> consTodo()
    {
       List<UNID_ORGA> resp = new ArrayList();
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("select * from UNID_ORGA");
            ResultSet rs = cmd.executeQuery();
                
            while(rs.next())
            {   
                resp.add(new UNID_ORGA(rs.getInt(1), rs.getString(2)));
               
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
}
