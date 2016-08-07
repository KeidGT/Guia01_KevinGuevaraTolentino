/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.PERS;
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
public class PERSCtrl {
    public List<PERS> consTodo()
    {
       List<PERS> resp = new ArrayList();
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("select * from PERS");
            ResultSet rs = cmd.executeQuery();
                
            while(rs.next())
            {   
                resp.add(new PERS(rs.getInt(1), rs.getString(2)+" "+rs.getString(3)));
               
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
