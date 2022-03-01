/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author rashi
 */
abstract class JFrame1
{
    JFrame f;
}
class JFrame2 extends JFrame1{}


public class adminlogin {
    
    JFrame2 jf=new JFrame2();
    adminlogin()
    {  
        jf.f=new JFrame();  
        JOptionPane.showMessageDialog(jf.f,"Incorrect Username Or Password","Alert",JOptionPane.WARNING_MESSAGE);     
    }
    
    private static Scanner x;
   
    public static void adminlogin(String username, String password, String filepath)
    {
        boolean found= false;
        String tempUsername = "" ;
        String tempPassword = "" ;


        try {
            
            x= new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");
            
            while (x.hasNext() && !found)
            {
                tempUsername=x.next();
                tempPassword=x.next();
                
                if((tempUsername.trim().equals(username.trim())) && tempPassword.trim().equals(password.trim()))
                {
                    found=true;
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss a");
                    LocalDateTime now = LocalDateTime.now();
                    String dateTime = now.format(formatter);
                    
                    FileWriter Writer1 = new FileWriter("Login_Activity.txt", true);
                    Writer1.write(""+username+","+password+","+dateTime+","+"Admin"+","+"Login-In");
                    Writer1.write(System.getProperty("line.separator"));
                    Writer1.close();
                    
                    new AdminInterface2().setVisible(true);
                }

            }
            x.close();
            if (found==false)
            {
                new adminlogin();
                new AdminInterface().setVisible(true);
            }
        }
        
        catch(Exception e)
        {
            System.out.println("Welcome");
            
        }
        
    }
}
