package cl.praxis.desafioproveedores2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProviderDTO {
    private int id;
    private String name;
    private String rut;
    private String email;
    private String address;
    private String phone;
    private String contact;
    private String contactPhone;

    public ProviderDTO(String name, String rut, String address, String email, String phone, String contact, String contactPhone) {
        this.name = name;
        this.rut = rut;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.contact = contact;
        this.contactPhone = contactPhone;
    }
}
