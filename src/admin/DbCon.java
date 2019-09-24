
package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.*;

public class DbCon 
{
    public int dml(String query)
    {
        int re = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ams","test","test");
            Statement st = cn.createStatement();
            re = st.executeUpdate(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"DB Error : "+e);
        }
        return re;
    }
    
    public ResultSet dql(String query)
    {
        ResultSet rs = null;
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ams","test","test");
            Statement st = cn.createStatement();
            rs = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"DB Error : "+e);
        }
        return rs;
    }
}
