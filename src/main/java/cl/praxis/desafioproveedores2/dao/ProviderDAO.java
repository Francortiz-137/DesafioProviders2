package cl.praxis.desafioproveedores2.dao;

import cl.praxis.desafioproveedores2.models.ProviderDTO;

import java.sql.SQLException;
import java.util.List;

public interface ProviderDAO {
    public ProviderDTO selectProviderById(int id) throws SQLException;

    public List<ProviderDTO> selectAllProviders();

    public ProviderDTO insertProvider(ProviderDTO user);

    public ProviderDTO updateProvider(ProviderDTO user);

    public void deleteProvider(int id);
}
