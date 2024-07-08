<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Proveedores</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<h1 class="text-center">Proveedores</h1>
<br/>

<section class="container d-flex">

    <form method="post" action="providers?action=insert">
        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre</label>
            <input type="text" class="form-control" id="nombre" name="nombre" required>
        </div>
        <div class="mb-3">
            <label for="rut" class="form-label">RUT</label>
            <input type="text" class="form-control" id="rut" name="rut" required>
        </div>
        <div class="mb-3">
            <label for="direccion" class="form-label">Dirección</label>
            <input type="text" class="form-control" id="direccion" name="direccion" required>
        </div>
        <div class="mb-3">
            <label for="correo" class="form-label">Correo Electrónico</label>
            <input type="email" class="form-control" id="correo" name="correo" required>
        </div>
        <div class="mb-3">
            <label for="telefono" class="form-label">Teléfono</label>
            <input type="text" class="form-control" id="telefono" name="telefono">
        </div>
        <div class="mb-3">
            <label for="contacto" class="form-label">Contacto</label>
            <input type="text" class="form-control" id="contacto" name="contacto">
        </div>
        <div class="mb-3">
            <label for="telefono_contacto" class="form-label">Teléfono de Contacto</label>
            <input type="text" class="form-control" id="telefono_contacto" name="telefono_contacto">
        </div>
        <button type="submit" class="btn btn-primary">Guardar</button>
    </form>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>RUT</th>
            <th>Dirección</th>
            <th>Correo</th>
            <th>Teléfono</th>
            <th>Contacto</th>
            <th>Teléfono de Contacto</th>
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="proveedor" items="${listProviders}">
            <tr>
                <td>${proveedor.id}</td>
                <td>${proveedor.name}</td>
                <td>${proveedor.rut}</td>
                <td>${proveedor.address}</td>
                <td>${proveedor.email}</td>
                <td>${proveedor.phone}</td>
                <td>${proveedor.contact}</td>
                <td>${proveedor.contactPhone}</td>
                <td>
                    <a class="btn btn-warning" href="providers?action=edit&id=${proveedor.id}">Editar</a>
                    <a class="btn btn-danger" href="providers?action=delete&id=${provider.id}" onclick="return confirm('Are you sure?')">Eliminar</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>