package sql;
import getset.variables;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class CRUD extends Conexionsql{
    
    java.sql.Statement st;
    ResultSet rs;   
    variables var = new variables();
    public void insertar (String placa, String marca, String nombre, String contacto, String dpi, String fecha, String servicio, String pago){

        try{
            Connection conexion = conectar();
            st= conexion.createStatement();
            String sql="insert into Servicios(placa_vehiculo,marca_modelo_vehiculo,nombre_apellido_cliente,contacto_cliente,dpi_cliente,fecha_servicio,servicio_elegido,tipo_de_pago) values('"+placa+"','"+marca+"','"+nombre+"','"+contacto+"','"+dpi+"','"+fecha+"','"+servicio+"','"+pago+"')";
               st.execute(sql);
               st.close();
               conexion.close();
               JOptionPane.showMessageDialog(null, "registro exitoso","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "registro fallido"+e,"Mensaje",JOptionPane.ERROR_MESSAGE);
        
        }
    }
    
    public void mostrar(String placa_vehiculo){
        try {
            Connection conexion=conectar();
            st=conexion.createStatement();
            String sql="select * from Servicios where placa_vehiculo='"+placa_vehiculo+"';";
            rs=st.executeQuery(sql);
            if(rs.next()){
            var.setPlaca_vehiculo(rs.getString("placa_vehiculo"));
            var.setNumero_servicio(rs.getString("numero_servicio"));
            var.setMarca_modelo_vehiculo(rs.getString("marca_modelo_vehiculo"));
            var.setNombre_apellido_cliente(rs.getString("nombre_apellido_cliente"));
            var.setContacto_cliente(rs.getString("contacto_cliente"));
            var.setDpi_cliente(rs.getString("dpi_cliente"));
            var.setFecha_servicio(rs.getString("fecha_servicio"));
            var.setServicio_elegido(rs.getString("servicio_elegido"));
            var.setTipo_de_pago(rs.getString("tipo_de_pago"));
            }else{
            var.setPlaca_vehiculo("");
            var.setNumero_servicio("");
            var.setMarca_modelo_vehiculo("");
            var.setContacto_cliente("");
            var.setDpi_cliente("");
            var.setFecha_servicio("");
            var.setServicio_elegido("");
            var.setTipo_de_pago("");
            JOptionPane.showMessageDialog(null,"No se encontro registro","Sin registro",JOptionPane.INFORMATION_MESSAGE);
            st.close();
            conexion.close();
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error en el sistema de busqueda","Error busqueda",JOptionPane.ERROR_MESSAGE);      
        }
    }
    
    public void actualizar(String contacto, String servicio,String pago, String fecha,String placa){
        try {
            Connection conexion=conectar();
            st=conexion.createStatement();
            String sql="update Servicios set contacto_cliente='"+contacto+"',servicio_elegido='"+servicio+"',tipo_de_pago='"+pago+"', fecha_servicio='"+fecha+"' where placa_vehiculo='"+placa+"';";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se actualizo", "Exitoso",JOptionPane.INFORMATION_MESSAGE);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Actualizacion Fallida"+e, "Algo Fallo",JOptionPane.ERROR_MESSAGE);
        }
        }
    
    public void eliminar(String placa){
        try{
            Connection conexion=conectar();
            st=conexion.createStatement();
            String sql="delete from Servicios where placa_vehiculo='"+placa+"'; ";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente", "Eliminado",JOptionPane.INFORMATION_MESSAGE);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar registro"+e, "Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
