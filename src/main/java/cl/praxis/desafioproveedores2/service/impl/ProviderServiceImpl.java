package cl.praxis.desafioproveedores2.service.impl;

import cl.praxis.desafioproveedores2.dao.ProviderDAO;
import cl.praxis.desafioproveedores2.dao.impl.ProviderDAOImpl;
import cl.praxis.desafioproveedores2.models.ProviderDTO;
import cl.praxis.desafioproveedores2.service.ProviderService;

import java.util.List;

public class ProviderServiceImpl implements ProviderService {

    private final ProviderDAO dao;

    public ProviderServiceImpl() {
        dao = new ProviderDAOImpl();
    }

    @Override
    public ProviderDTO selectProviderById(int id) {
        return null;
    }

    @Override
    public List<ProviderDTO> selectAllProviders() {
        return dao.selectAllProviders();
    }

    @Override
    public ProviderDTO insertProvider(ProviderDTO provider) {
        return dao.insertProvider(provider);
    }

    @Override
    public ProviderDTO updateProvider(ProviderDTO provider) {
        return null;
    }

    @Override
    public void deleteProvider(int id) {

    }
}
