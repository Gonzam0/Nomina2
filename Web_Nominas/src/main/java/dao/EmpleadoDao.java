package dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import laboral.DatosNoCorrectosException;
import model.Nomina;
import model.Empleado;

 
/**
 * La clase EmpleadoDao se encarga de gestionar las operaciones relacionadas con los empleados y las nóminas en la base de datos.
 */
public class EmpleadoDao {
    private Connection connection;
    private PreparedStatement statement;
    private static boolean estadoOperacion;

    /**
     * Guarda un empleado en la base de datos.
     *
     * @param empleado El empleado que se va a guardar.
     * @return `true` si la operación fue exitosa, `false` en caso contrario.
     * @throws SQLException Si ocurre un error de SQL durante la operación.
     */
    public boolean guardar(Empleado empleado) throws SQLException {
        String sql = null;
        estadoOperacion = false;
        connection = obtenerConexion();
        Nomina nomina = new Nomina();

        try {
            connection.setAutoCommit(false);
            sql = "INSERT INTO empleados (nombre, dni, sexo, categoria, anyos) VALUES(?,?,?,?,?)";
            statement = connection.prepareStatement(sql);

            statement.setString(1, empleado.getNombre());
            statement.setString(2, empleado.getDni());
            statement.setString(3, empleado.getSexo());
            statement.setInt(4, empleado.getCategoria());
            statement.setInt(5, empleado.getAnyos());

            estadoOperacion = statement.executeUpdate() > 0;
            connection.commit();
            
            sql = "INSERT INTO nominas (dni, sueldo) VALUES(?,?)";
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, empleado.getDni());
            statement.setDouble(2, nomina.sueldo(empleado));
            
            estadoOperacion = statement.executeUpdate() > 0;
            connection.commit();
            
            statement.close();
            connection.close();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }

        return estadoOperacion;
    }

    /**
     * Edita un empleado en la base de datos.
     *
     * @param empleado El empleado que se va a editar.
     * @return `true` si la operación fue exitosa, `false` en caso contrario.
     * @throws SQLException Si ocurre un error de SQL durante la operación.
     */
    public boolean editar(Empleado empleado) throws SQLException {
        String sql = null;
        estadoOperacion = false;
        connection = obtenerConexion();
        try {
            connection.setAutoCommit(false);
            sql = "UPDATE empleados SET nombre=?, sexo=?, categoria=?, anyos=? WHERE dni = ?";
            statement = connection.prepareStatement(sql);

            statement.setString(1, empleado.getNombre());
            statement.setString(2, empleado.getSexo());
            statement.setDouble(3, empleado.getCategoria());
            statement.setInt(4, empleado.getAnyos());
            statement.setString(5, empleado.getDni());

            estadoOperacion = statement.executeUpdate() > 0;
            connection.commit();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }

        return estadoOperacion;
    }

    public List<Empleado> filtrarDni(String dni) throws SQLException, DatosNoCorrectosException {
        ResultSet resultSet = null;
        List<Empleado> empleados = new ArrayList<>();

        String sql = "SELECT * FROM empleados WHERE dni = ?";
        
        try (
            Connection connection = obtenerConexion();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, dni);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Empleado empleado = new Empleado();
                empleado.setNombre(resultSet.getString("nombre"));
                empleado.setDni(resultSet.getString("dni"));
                empleado.setSexo(resultSet.getString("sexo"));
                empleado.setCategoria(resultSet.getInt("categoria"));
                empleado.setAnyos(resultSet.getInt("anyos"));
                empleados.add(empleado);
            }

        } catch (SQLException e) {
            e.printStackTrace();  // Trata de manejar o relanzar la excepción de manera más específica
            throw new DatosNoCorrectosException("Error al filtrar por DNI", e);
        }

        return empleados;
    }


    /**
     * Obtiene una lista de empleados desde la base de datos.
     *
     * @return Una lista de empleados.
     * @throws SQLException Si ocurre un error de SQL durante la operación.
     * @throws DatosNoCorrectosException Si los datos obtenidos no son correctos.
     */
    public List<Empleado> obtenerEmpleados() throws SQLException, DatosNoCorrectosException {
        ResultSet resultSet = null;
        List<Empleado> listaEmpleados = new ArrayList<>();

        String sql = null;
        estadoOperacion = false;
        connection = obtenerConexion();

        try {
            sql = "SELECT * FROM empleados";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Empleado p = new Empleado();
                p.setNombre(resultSet.getString(1));
                p.setDni(resultSet.getString(2));
                p.setSexo(resultSet.getString(3));
                p.setCategoria(resultSet.getInt(4));
                p.setAnyos(resultSet.getInt(5));
                listaEmpleados.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaEmpleados;
    }

    /**
     * Obtiene la nómina de un empleado en base a su DNI.
     *
     * @param dni El DNI del empleado.
     * @return Un objeto de tipo Nomina que contiene la información salarial del empleado.
     * @throws SQLException Si ocurre un error de SQL durante la operación.
     */
    public Nomina obtenerSueldo(String dni) throws SQLException {
        ResultSet resultSet = null;
        Nomina nomina = new Nomina();

        String sql = null;
        estadoOperacion = false;
        connection = obtenerConexion();

        try {
            sql = "SELECT dni, sueldo FROM nominas WHERE dni = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, dni);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                nomina.setDni(resultSet.getString("dni"));
                nomina.setSueldo(resultSet.getDouble("sueldo"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return nomina;
    }

    /**
     * Obtiene una conexión desde el pool de conexiones.
     *
     * @return Una conexión a la base de datos.
     * @throws SQLException Si ocurre un error de SQL durante la operación.
     */
    private static Connection obtenerConexion() throws SQLException {
        return Conexion.getConnection();
    }
}