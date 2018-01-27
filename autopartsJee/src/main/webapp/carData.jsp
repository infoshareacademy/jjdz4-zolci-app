<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="car-data form-inline" method="post" action="/car-data">
    <ul>
        <li>Marka: <span class="blue-data">${brandName}</span></li>
        <li>Model: <span class="blue-data">${modelName}</span></li>
        <li>Rok produkcji: <span class="blue-data">${productionYear}</span></li>
        <li>Pojemność: <span class="blue-data">${vehicleVolume}</span></li>
        <li>Paliwo: <span class="blue-data">${fuelType}</span></li>
        <li><button type="submit" class="btn btn-primary">Ładuj Aztec z pliku</button></li>
        <li><button id="aztec-btn" class="btn btn-primary">Ładuj Aztec z sesji</button></li>
        <li><label for="atena-session" class="hidden">Kod sesji: </label>
        <input class="hidden form-control" type="text" id="atena-session"></li>
    </ul>
</form>