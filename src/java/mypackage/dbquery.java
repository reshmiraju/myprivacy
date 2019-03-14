/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class dbquery {
    Statement st,st1;
    ResultSet rs,rs1;
    public dbquery() throws SQLException
    {
        try {
            dbconnection db=new dbconnection();
            Connection con=db.getc();
            st=con.createStatement();
            st1=con.createStatement();
      
        } catch (Exception e) {
        }
    }
    
    public int employee_add(String name,String place,String post,String pin,String district,String phone,String gender,String email,String password)
    {
        int i=0;
        try {
            st.executeUpdate("insert into login values(null,'"+email+"','"+password+"','employee')");
            String lid="";
            ResultSet rs=st1.executeQuery("select max(lid)from login");
            if(rs.next())
            {
                lid=rs.getString(1);
            }
           
            i=st.executeUpdate("insert into employee values(null,'"+name+"','"+place+"','"+post+"','"+pin+"','"+district+"','"+phone+"','"+gender+"','"+email+"','"+lid+"')");
            
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return i;
    }
    
     public ResultSet employee_view()
    {
        try {
            String str="select * from employee";
            rs=st.executeQuery(str);
        } catch (Exception e) {
        }
        return rs;
    }
      public int Delete(String emp_id)
    {
        int i=0;
        try {
            i=st.executeUpdate("delete from employee where emp_id='"+emp_id+"'");
        } catch (Exception e) {
        }
        return i;
    }

  
public ResultSet  employee_view_edit(String emp_id)
{
    try {
         rs=st.executeQuery("select * from employee where emp_id='"+emp_id+"'");   
        } catch (Exception e) {
        }
        return rs;
 }
 public int updt(String name,String place,String post,String pin,String district,String phone,String gender,String email,String id)
 {
     int i=0;
     try {
         String str="update employee set name='"+name+"',place='"+place+"',post='"+post+"',pin='"+pin+"',district='"+district+"',phone='"+phone+"',gender='"+gender+"',email='"+email+"' where emp_id='"+id+"'";
     i=st.executeUpdate(str);
     } catch (Exception e) {
        
     }
      return i;       
 }
 
 public ResultSet user_view()
    {
        try {
            String str="select * from user";
            rs=st.executeQuery(str);
        } catch (Exception e) {
        }
        return rs;
    }
     
     public ResultSet feedback_view()
    {
        try {
            String str="select feedback.*,user.name,user.email from feedback,user where feedback.user_id=user.user_id";
            rs=st.executeQuery(str);
        } catch (Exception e) {
        }
        return rs;
    }
   public ResultSet complaint_view()
    {
        try {
            String str="select complaints.*,user.name,user.email from complaints, user where complaints.user_id=user.user_id";
            rs=st.executeQuery(str);
        } catch (Exception e) {
        }
        return rs;
    }
    public ResultSet login(String username, String password)
       {
  
    try {
        String str="select * from login where username='"+username+"' and password='"+password+"'";
     rs=st.executeQuery(str);
    } catch (Exception e) {
    }
    return rs;
}
     public ResultSet profile_view(String emp_id)
    {
        try {
            String str="select * from employee where lid='"+emp_id+"'";
            rs=st.executeQuery(str);
        } catch (Exception e) {
        }
        return rs;
    }
      public int reply_add(String reply,String cid)
    {
        int i=0;
        try {
           
            String str="update complaints set reply='"+reply+"', date=curdate() where c_id='"+cid+"'";
            i=st.executeUpdate(str);
            
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return i;
    }
    public ResultSet block()
    {
        try {
            String str="select a.*,b.*,report.* from user as a,user as b,report where report.from_id=a.lid and report.to_id=b.lid";
            rs=st.executeQuery(str);
        } catch (Exception e) {
        }
        return rs;
    } 
    public int user_block(String re_id)
 {
     int i=0;
     try {
         i=st.executeUpdate("update report set status='blocked' where re_id='"+re_id+"'");
     } catch (Exception e) {
        
     }
      return i;       
 }
 
      public int user_unblock(String re_id)
 {
     int i=0;
     try {
         i=st.executeUpdate("update report set status='unblocked' where re_id='"+re_id+"'");
     } catch (Exception e) {
        
     }
      return i;       
 }
      public ResultSet login1(String uname,String pwd)
      {
          try {
              rs=st.executeQuery("select * from login where username='"+uname+"' and password='"+pwd+"' and type='user'");
          } catch (Exception e) {
          }
          return rs;
      }
      public int add2(String name,String gender,String dob,String place,String post,String pin,String district,String email,String phone,String pic, String password)
      {
         int i=0;
          try {
            st.executeUpdate("insert into login values(null,'"+email+"','"+password+"','user')");
            String lid="";
            ResultSet rs=st1.executeQuery("select max(lid)from login");
            if(rs.next())
            {
                lid=rs.getString(1);
            }
             i=st.executeUpdate("insert into user values(null,'"+name+"','"+gender+"','"+dob+"','"+place+"','"+post+"','"+pin+"','"+district+"','"+email+"','"+phone+"','"+pic+"','"+lid+"')");
          } catch (Exception e) {
              System.err.println(e.toString());
          }
          return i;
        }
      public int comment(String user_id,String post_id,String comment)
      {
          int i=0;
          try {
              st.executeUpdate("insert into comment values(null,'"+user_id+"','"+post_id+"','"+comment+"',curdate())");
          } catch (Exception e) {
              System.err.println(e.toString());
          }
          return i;
      }
     public int feedback(String fdbk,String uid)
     {
         int i=0;
         try {
            i=st.executeUpdate("insert into feedback values(null,'"+fdbk+"','"+uid+"',curdate())");
         } catch (Exception e) {
             System.err.println(e.toString());
         }
              return i;
     }
      public int post(String uid,String img,String cnt,String lcn,String sts)
      {
            int i=0;
            try {
                  st.executeUpdate("insert into post values(null,'"+uid+"','"+img+"','"+cnt+"','"+lcn+"','"+sts+"',curdate())");
          } catch (Exception e) {
                System.err.println(e.toString());
          }
             return i;
      }
      public int report(String fid,String tid,String rprt)
      {
          int i=0;
          try {
               i=st.executeUpdate("insert into report (from_id,to_id,report)values('"+fid+"','"+tid+"','"+rprt+"')");
              
          } catch (Exception e) {
               System.err.println(e.toString());
          }
           return i;
      }
      public int complaint(String uid,String cmplnt)
      {
          int i=0;
          try {
               i=st.executeUpdate("insert into complaints(user_id,complaint)values('"+uid+"','"+cmplnt+"')");
              
          } catch (Exception e) {
               System.err.println(e.toString());
          }
           return i;
      
      }
      public ResultSet frnd_request_view(String lid)
      {
          try {
              rs=st.executeQuery("select user.* from user,friends where friends.sender_id=user.lid and friends.receiver_id='"+lid+"'");
          } catch (Exception e) {
          }
          return rs;
      }
       public ResultSet pro1(String lid)
      {
          try{
              rs=st.executeQuery("select * from user where lid='"+lid+"'");
          } catch (Exception e) {
          }
          return rs;
      }
       public ResultSet search_frnd(String name,String uid)
      {
          
          try {
               rs=st.executeQuery("select * from user where name like '"+name+"%' and lid!='"+uid+"'");
              
          } catch (Exception e) {
               System.err.println(e.toString());
          }
           return rs;
      
      }
       public int update_profile(String uid,String name,String gender,String dob,String plc,String pst,String pin,String dstct,String email,String phone)
 {
     int i=0;
     try {
     String str="update user set name='"+name+"',gender='"+gender+"',dob='"+dob+"',place='"+plc+"',post='"+pst+"',pin='"+pin+"',district='"+dstct+"',email='"+email+"',phone='"+phone+"' where lid='"+uid+"'";
     i=st.executeUpdate(str);
     } catch (Exception e) {
        
     }
      return i;       
 }
       
     public int send_request(String fid,String tid)
      {
          int i=0;
          try {
               i=st.executeUpdate("insert into friends(sender_id,receiver_id)values('"+fid+"','"+tid+"')");
              
          } catch (Exception e) {
               System.err.println(e.toString());
          }
           return i;
      }  
       
}


