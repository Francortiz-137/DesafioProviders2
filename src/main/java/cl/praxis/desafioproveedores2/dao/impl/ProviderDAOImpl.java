package cl.praxis.desafioproveedores2.dao.impl;

import cl.praxis.desafioproveedores2.connection.MySQLConnection;
import cl.praxis.desafioproveedores2.dao.ProviderDAO;
import cl.praxis.desafioproveedores2.models.ProviderDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProviderDAOImpl implements ProviderDAO {

    private static final String SELECT_ALL_USERS = "SELECT id, nombre, rut, direccion, correo, telefono, contacto, telefono_contacto FROM proveedores";
    private static final String SELECT_USER_BY_ID = "SELECT id, nombre, rut, direccion, correo, telefono, contacto, telefono_contacto FROM proveedores WHERE id = ?";
    private static final String INSERT_USER_SQL = "INSERT INTO proveedores (nombre, rut, direccion, correo, telefono, contacto, telefono_contacto) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_USER_SQL = "UPDATE usuarios SET nombre = ?, apellido = ?, email = ?, edad = ? WHERE idusuario = ?";
    private static final String DELETE_USER_SQL = "DELETE FROM usuarios WHERE idusuario = ?";



    @Override
    public ProviderDTO selectProviderById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<ProviderDTO> selectAllProviders() {
        List<ProviderDTO> users = new ArrayList<>();
        try (Connection connection = MySQLConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("nombre");
                String rut = rs.getString("rut");
                String email = rs.getString("correo");
                String address = rs.getString("direccion");
                String phone = rs.getString("telefono");
                String contact = rs.getString("contacto");
                String contactPhone = rs.getString("telefono_contacto");
                users.add(new ProviderDTO(id, name, rut, email, address, phone, contact, contactPhone));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public ProviderDTO insertProvider(ProviderDTO user) {
        return null;
    }

    @Override
    public ProviderDTO updateProvider(ProviderDTO user) {
        return null;
    }

    @Override
    public void deleteProvider(int id) {

    }
}
