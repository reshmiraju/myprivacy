/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author User
 */
public class dbconnection {
     Connection con=null;
      public Connection getc()
      {
          try {
              Class.forName("com.mysql.jdbc.Driver");
               con=DriverManager.getConnection("jdbc:mysql://localhost:3306/privacy","root","");
              
          } catch (Exception e) {
          }
      return con;
              }
}
