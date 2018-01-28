<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="vehicle form-inline" method="post" action="vehicle-search">
    <ul>
        <li>
            <div class="form-group">
                <label for="brand">Marka: </label>
                <input type="text" class="form-control" name="brand" value="${brand}" id="brand">
            </div>
        </li>
        <li>
            <div class="form-group">
                <label for="model">Model:</label>
                <input type="text" class="form-control" value="${model}" id="model">
            </div>
        </li>
        <li>
            <div class="form-group">
                <label for="year">Rok produkcji:</label>
                <input type="number" min="1955" max="2100" class="form-control" name="year" value="${year}" id="year">
            </div>
        </li>
        <li>
            <div class="form-group">
                <label for="volume">Pojemność silnika [cm&sup3;]:</label>
                <input type="text" class="form-control" value="${formattedVolume}" id="volume">
            </div>
        </li>
        <li>
            <div class="form-group">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="fuelType" id="fuelGasoline" value="gasoline" <c:if test="${checkFuel != null}">checked</c:if>>
                    <label class="form-check-label" for="fuelGasoline">
                        Benzyna
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="fuelType" id="fuelDiesel" value="diesel" <c:if test="${checkFuel == null}">checked</c:if>>
                    <label class="form-check-label" for="fuelDiesel">
                        Olej napędowy
                    </label>
                </div>
            </div>
        </li>
        <li>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Szukaj</button>
            </div>
        </li>
    </ul>
</form>