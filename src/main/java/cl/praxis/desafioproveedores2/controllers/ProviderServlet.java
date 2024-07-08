package cl.praxis.desafioproveedores2.controllers;


import cl.praxis.desafioproveedores2.models.ProviderDTO;
import cl.praxis.desafioproveedores2.service.ProviderService;
import cl.praxis.desafioproveedores2.service.impl.ProviderServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="providers", value = "/providers")
public class ProviderServlet extends HttpServlet {

    ProviderService providerService;

    @Override
    public void init() throws ServletException {
        providerService = new ProviderServiceImpl();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        try {
            switch (action) {
                case "insert":
                    insertProvider(request, response);
                    break;
                case "delete":
                    deleteProvider(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateProvider(request, response);
                    break;
                case "view":
                    viewProvider(request, response);
                    break;
                default:
                    listProviders(request, response);
                    break;
            }
        } catch(SQLException ex) {
            throw new ServletException(ex);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

    private void insertProvider(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Recibir parametros desde el formulario
        String name = request.getParameter("nombre");
        String rut = request.getParameter("rut");
        String address = request.getParameter("direccion");
        String email = request.getParameter("correo");
        String phone = request.getParameter("telefono");
        String contact = request.getParameter("contacto");
        String contactPhone = request.getParameter("telefono_contacto");

        // Validar que los campos requeridos no sean null o vacíos
        if (name == null || name.isEmpty() ||
                rut == null || rut.isEmpty() ||
                address == null || address.isEmpty() ||
                email == null || email.isEmpty()) {
            response.sendRedirect("providers");
            return;
        }

        //Crear nuevo objeto para provider y persistirlo
        ProviderDTO newProvider = new ProviderDTO(name, rut, address, email, phone, contact, contactPhone);
        providerService.insertProvider(newProvider);

        //Cargar la vista con todos los providers
        response.sendRedirect("providers");
    }

    // Método para eliminar un proveedor
    private void deleteProvider(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        providerService.deleteProvider(id);
        response.sendRedirect("providers");
    }

    // Método para mostrar el formulario de edición de usuario
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProviderDTO existingProvider = providerService.selectProviderById(id);
        request.setAttribute("provider", existingProvider);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    // Método para actualizar un usuario existente y redirigir a la lista de usuarios
    private void updateProvider(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("nombre");
        String rut = request.getParameter("rut");
        String address = request.getParameter("direccion");
        String email = request.getParameter("correo");
        String phone = request.getParameter("telefono");
        String contact = request.getParameter("contacto");
        String contactPhone = request.getParameter("telefono_contacto");
        ProviderDTO provider = new ProviderDTO(id, name, rut, address, email, phone, contact, contactPhone);
        System.out.println("Actualizando usuario: " + provider);
        providerService.updateProvider(provider);
        response.sendRedirect("providers");
    }

    private void listProviders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recuperar desde el servicio la lista de los proveedores
        List<ProviderDTO> listProviders = providerService.selectAllProviders();
        System.out.println(listProviders);
        request.setAttribute("listProviders", listProviders);
        //mostrar la lista
        request.getRequestDispatcher("providers.jsp").forward(request, response);
    }

    // Método para ver los detalles de un usuario
    private void viewProvider(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProviderDTO provider = providerService.selectProviderById(id);
        request.setAttribute("provider", provider);
        request.getRequestDispatcher("providers.jsp").forward(request, response);
    }
}
