/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author aliza
 */

// Class Modify_File containg the method modify_file_admin, which modifies the User_Details.txt file with text which has been changed by the user

public class Modify_Record 
{
    public int modify_file_admin(String name,String tpno, String unq,String id, String ct, String app, String date, String IC, int found)
    { 
        try
        {
            Path p = Paths.get(".", "Appointments.txt");
            Path tempFile = Files.createTempFile(p.getParent(), "PendingTemp", ".txt");
            try (BufferedReader reader = Files.newBufferedReader(p);
                BufferedWriter writer = Files.newBufferedWriter(tempFile))
            {
                String line123;
                // copy everything until the id is found
                while ((line123 = reader.readLine()) != null)
                {
                    String[] fields = line123.split("[,]");
                    System.out.println(fields[0]);
                    if (unq.equals(fields[2]))
                    {
                        found = 1;
                        for (int i = 0; i < fields.length; ++i)
                        {
                            System.out.println(i + ": " + fields[i]);
                        }
                        fields[0] = tpno;
                        fields[1] = name;
                        fields[2] = id;
                        fields[3] = ct;
                        fields[4] = app;
                        fields[5]= date;
                        fields[6] = "Completed";
                    }
                    writer.write(String.join(",", fields));
                    writer.newLine();
                }             
            }
            // copy new file & delete temporary file
            Files.copy(tempFile, p, StandardCopyOption.REPLACE_EXISTING);
            Files.delete(tempFile);
           
        }catch (IOException ex){} 
        return found;
    }   
}
