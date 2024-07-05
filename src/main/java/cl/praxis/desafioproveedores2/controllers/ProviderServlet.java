package cl.praxis.desafioproveedores2.controllers;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="proveedores", value = "/")
public class ProviderServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recuperar desde el servicio la lista de los proveedores

        //mostrar la lista
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

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
            response.sendRedirect("index.jsp");
            return;
        }

        System.out.println(name);
        System.out.println(rut);
        System.out.println(address);
        System.out.println(email);
        System.out.println(phone);
        System.out.println(contact);
        System.out.println(contactPhone);

        //Crear nuevo objeto para provider y persistirlo
        //Cargar la vista con todos los providers
        doGet(request,response);
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response){}

    public void doDelete(HttpServletRequest request, HttpServletResponse response){}

}
