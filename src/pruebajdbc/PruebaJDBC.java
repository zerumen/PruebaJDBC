/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebajdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alumno
 */
public class PruebaJDBC {

    /**
     * 
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = null;
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco","root", "root");
        
        
       // System.out.println("Si esta linea sale es que ha funcionado");
        
        
        String selectSQL = "SELECT idEntidad, nombre FROM entidadBancaria WHERE idEntidad = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
        preparedStatement.setInt(1, 2);
        //preparedStatement.setString(2, "Valencia-Malilla");
        ResultSet resultset = preparedStatement.executeQuery();
        //while (resultset.next()) {
        if(resultset.next()==true){
          
	String userid = resultset.getString("idEntidad");
	String username = resultset.getString("nombre");
            System.out.println("IdEntidad: "+userid);
            System.out.println("Nombre: "+username);
             if(resultset.next()==false){
                 System.out.println("Existe mas de una unidad Bancaria");
             }
        }else{
            System.out.println("No existe entidad");
        }
       
        connection.close();
}
}
/* if(result.next()==true){
 * codigo=resultset.getString("codigo");
 *  if (resultset.next()==true){
 * throw new RuntimeException("·Existre mas de una entidadBancaria"+id entidad)
 * }
 * }
 * else
 */
