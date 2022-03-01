/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import javax.swing.*;
/**
 *
 * @author User
 */


public class Studentlogin2 {
     
    JFrame f; 
    Studentlogin2()
    {  
        f=new JFrame();  
        JOptionPane.showMessageDialog(f,"Incorrect Username Or Password","Alert",JOptionPane.WARNING_MESSAGE);     
    }
    
    private static Scanner x;
    
    public static void Studentlogin2(String tpno, String password, String filepath)
    {
        boolean found= false;
        String tempTpno = "" ;
        String tempPassword = "" ;


        try {
            
            x= new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");
            
            while (x.hasNext() && !found)
            {
                tempTpno=x.next();
                tempPassword=x.next();
                
                if((tempTpno.trim().equals(tpno.trim())) && tempPassword.trim().equals(password.trim()))
                {
                    
                    found=true;
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss a");
                    LocalDateTime now = LocalDateTime.now();
                    String dateTime = now.format(formatter);
                    
                    FileWriter Writer1 = new FileWriter("Login_Activity.txt", true);
                    Writer1.write(""+tpno+","+password+","+dateTime+","+"Student"+","+"Login-In");
                    Writer1.write(System.getProperty("line.separator"));
                    Writer1.close();
                    new StudentMenu(tpno).setVisible(true);
                }

            }
            x.close();
            if (found==false)
            {
                new Studentlogin2();
                new Studentlogin().setVisible(true);
            }
        }
        
        catch(Exception e)
        {
            System.out.println("Welcome");
            
        }     
    }
}
