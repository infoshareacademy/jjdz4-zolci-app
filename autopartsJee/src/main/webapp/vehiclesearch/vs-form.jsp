<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form>
    <div class="form-group">
        <label for="brand">Marka:</label>
        <input type="text" class="form-control block" id="brand">
    </div>
    <div class="form-group">
        <label for="model">Model:</label>
        <input type="text" class="form-control" id="model">
    </div>
    <div class="form-group">
        <label for="year">Rok produkcji:</label>
        <input type="number" min="1955" max="2100" class="form-control" id="year">
    </div>
    <div class="form-group">
        <label for="volume">Pojemność silnika [cm&sup3;]:</label>
        <input type="number" min="100" max="90000" class="form-control" id="volume">
    </div>
    <div class="form-group">
        <div class="form-check">
            <input class="form-check-input" type="radio" name="fuelType" id="fuelGasoline" value="gasoline" checked>
            <label class="form-check-label" for="fuelGasoline">
                Benzyna
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="fuelType" id="fuelDiesel" value="diesel">
            <label class="form-check-label" for="fuelDiesel">
                Olej napędowy
            </label>
        </div>
    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-primary">Szukaj</button>
    </div>
</form>