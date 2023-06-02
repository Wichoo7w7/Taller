package sql;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
public class Conexionsql {
    Connection conn=null;
    String url="jdbc:postgresql://localhost:5432/taller";
    String usuario="postgres"; 
    String clave="root";
    
    public Connection conectar(){
    
        try{
            Class.forName("org.postgresql.Driver");
            conn=DriverManager.getConnection(url,usuario,clave);
            JOptionPane.showMessageDialog(null, "Coneccion exitosa");
        }
        catch(Exception e){
        
        JOptionPane.showMessageDialog(null, "Coneccion fallida"+e, "Error",JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }
    
    public void cerrar(){
        try{
            conn.close();
            JOptionPane.showMessageDialog(null, "CONECCION FINALIZADA");
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Desconeccion fallida");
        
        
        }
  
    
    }

}
