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
        
        String userid;
        String selectSQL = "SELECT idEntidad, nombre FROM entidadBancaria WHERE idEntidad = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
        preparedStatement.setInt(1, 1);
        //preparedStatement.setString(2, "Valencia-Malilla");
        ResultSet resultset = preparedStatement.executeQuery();
        //while (resultset.next()) {
        if(resultset.next()==true){
          
	userid = resultset.getString("idEntidad");
	String username = resultset.getString("nombre");
            System.out.println("IdEntidad: "+userid);
            System.out.println("Nombre: "+username);
             if(resultset.next()==true){
                 System.out.println("Existe mas de una unidad Bancaria");
             }
        }else{
            System.out.println("No existe entidad");
        }
        
       /* String insertTableSQL = "INSERT INTO entidadBancaria"
		+ "(idEntidad, codigoEntidad, nombre, cif,tipoEntidadBancaria) VALUES"
		+ "(?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(insertTableSQL);
        preparedStatement.setInt(1, 11);
        preparedStatement.setInt(2, 55);
        preparedStatement.setString(3, "Quart-Manises");
        preparedStatement.setString(4, "B541202");
        preparedStatement.setString(5, "SUCURSAL");
// execute insert SQL stetement
        preparedStatement .executeUpdate();
        System.out.println("Insertado registro!");*/
        
      /*  String updateTableSQL = "UPDATE entidadBancaria SET nombre = ? WHERE idEntidad = ?";
         preparedStatement = connection.prepareStatement(updateTableSQL);
        preparedStatement.setString(1, "Quart-Bonaire");
        preparedStatement.setInt(2, 11);
// execute insert SQL stetement
        preparedStatement .executeUpdate();
        System.out.println("modificado registro!");*/
        
        
        String deleteSQL = "DELETE from entidadbancaria WHERE idEntidad = ?";
         preparedStatement = connection.prepareStatement(deleteSQL);
        preparedStatement.setInt(1, 11);
// execute delete SQL stetement
        preparedStatement.executeUpdate();
        
        System.out.println("Eliminado registro");
        connection.close();
}
    
}
/* if(result.next()==true){
 * codigo=resultset.getString("codigo");
 *  if (resultset.next()==true){
 * throw new RuntimeException("·Existre mas de una entidadBancaria"+id entidad)
 * }
 * }
 * else*/


 /* if(resultset.next()==true){
  userid=resultset.getString("idEntidad");
  if(resultset.next()==true){
  throw new RuntimeException("Existe mas de una entidadBancaria:"+userid);
  }
  }else{
  RuntimeException runtimeException=new RuntimeException("No existe la entidad Bancaria:");
  throw runtimeException;
  }
  resultset.next();
  userid=resultset.getString("idEntidad");
  connection.close();
  System.out.println("Se ha conectado");
    }
}
* */