<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="car-data" method="post" action="/car-data">
    <ul>
        <li>Marka: <span class="blue-data">${brandName}</span></li>
        <li>Model: <span class="blue-data">${modelName}</span></li>
        <li>Rok produkcji: <span class="blue-data">${productionYear}</span></li>
        <li>Pojemność: <span class="blue-data">${vehicleVolume}</span></li>
        <li>Paliwo: <span class="blue-data">${fuelType}</span></li>
        <li><button type="submit" class="btn btn-primary">Z pliku</button></li>
    </ul>
</form>