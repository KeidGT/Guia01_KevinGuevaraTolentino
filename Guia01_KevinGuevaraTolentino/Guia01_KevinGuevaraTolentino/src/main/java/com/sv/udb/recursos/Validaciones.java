
package com.sv.udb.recursos;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Validaciones {
    
     public boolean Vacio(JPanel form, JTextField caja/*, JDateChooser Calendario*/)
    {
        boolean vacio = false;
        if(!"".equals(caja.getText().trim())){
         vacio = true;   
        }
        return vacio;
    }
    
    public void SoloLetras(java.awt.event.KeyEvent evt)
    {
       char car = evt.getKeyChar();
       
        if(!Character.isLetter(car) && car != KeyEvent.VK_SPACE){
            evt.consume();
        }

    }
     public void LetrasNumeros(java.awt.event.KeyEvent evt)
    {
       char car = evt.getKeyChar();
       
        if(!Character.isLetter(car) && car != KeyEvent.VK_SPACE && (car<'0' || car> '9')){
            evt.consume();
        }

    }
    public void LetrasGuiones(java.awt.event.KeyEvent evt)
    {
       char car = evt.getKeyChar();
       
        if(!Character.isLetter(car) && car != KeyEvent.VK_SPACE && car != KeyEvent.VK_MINUS && car != KeyEvent.VK_UNDERSCORE){
            evt.consume();
        }

    }
    public void SoloNumeros(java.awt.event.KeyEvent evt,JTextField a)
    {
       char car = evt.getKeyChar();
        if((car<'0' || car> '9') && a.getText().contains(".")){
            evt.consume();
        }
        else if((car<'0' || car>'9') && (car!='.')){
            evt.consume();
        }

        
    }
    public void LongitudTelefono(java.awt.event.KeyEvent evt,JTextField a)
    {       
      if(a.getText().length()==4)
       {
           String hola = a.getText();
           a.setText(hola+"-");
       }
       if(a.getText().length()>=9) evt.consume();       
    }
    public void LongitudDUI(java.awt.event.KeyEvent evt,JTextField a)
    {
       if(a.getText().length()==8)
       {
           String hola = a.getText();
           a.setText(hola+"-");
       }
       if(a.getText().length()>=10) evt.consume();
    }
     public static boolean Correo(String email) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public static boolean NumeroTelefono(String telefono) {
        Pattern Patron = Pattern.compile("^[2^6-7]{1}[0-9]{3}-[0-9]{4}$");
        Matcher Comparar = Patron.matcher(telefono); 
        return Comparar.find();
    }
    
    public static boolean NumeroDui(String dui) {
        try {
            int[] Numeros = new int[8];
            for (int i = 0; i < 8; i++) {
                Numeros[i] = Integer.parseInt(String.valueOf(dui.charAt(i)));
            }
            int suma = 0;
            int a = 9;
            for (int i : Numeros) {
                suma+= (i*a);
                a--;
            }
            int modulo = suma%10;
            int verificador = Integer.parseInt(String.valueOf(dui.charAt(9)));
            int resultado = 10 - modulo;
            return resultado == verificador || resultado == 0;
        }
        catch (Exception e ) {
            System.out.println("Error:" + e.getMessage());
            return false;
        }
    }
}
