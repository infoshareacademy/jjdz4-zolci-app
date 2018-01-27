<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="car-data form-inline" method="post" action="/car-data">
    <ul>
        <li>Marka: <span class="blue-data">${brand}</span></li>
        <li>Model: <span class="blue-data">${model}</span></li>
        <li>Rok produkcji: <span class="blue-data">${year}</span></li>
        <li>Wersja: <span class="blue-data">${version}</span></li>
        <li>Wariant: <span class="blue-data">${variant}</span></li>
        <li>Rodzaj paliwa: <span class="blue-data">${fuel}</span></li>
        <li>Pojemność silnika: <span class="blue-data">${volume}</span></li>
        <li>Moc silnika: <span class="blue-data">${power}</span></li>
        <li>Numer VIN: <span class="blue-data">${vin}</span></li>
        <li>Nr rejestracyjny: <span class="blue-data">${registry}</span></li>
        <li><button type="submit" id="aztec-btn" class="hide-btn btn-primary">Kopiuj Aztec z pliku</button>
        <li><button type="button" class="hide-btn btn btn-primary">Kopiuj Aztec z sesji</button></li>
        <li><label for="atena-session" class="hidden">Kod sesji:</label></li>
        <li><input class="hidden form-control" type="text" id="atena-session"></li>
        <li><button type="submit" class="hidden btn btn-primary">Kopiuj</button></li>
    </ul>
</form>