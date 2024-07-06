package cl.praxis.desafioproveedores2.service;

import cl.praxis.desafioproveedores2.models.ProviderDTO;

import java.util.List;

public interface ProviderService {
    public ProviderDTO selectProviderById(int id);

    public List<ProviderDTO> selectAllProviders();

    public ProviderDTO insertProvider(ProviderDTO user);

    public ProviderDTO updateProvider(ProviderDTO user);

    public void deleteProvider(int id);

}
