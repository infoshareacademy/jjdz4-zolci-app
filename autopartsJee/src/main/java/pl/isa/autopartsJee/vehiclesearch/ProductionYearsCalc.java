package pl.isa.autopartsJee.vehiclesearch;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class ProductionYearsCalc {

    private Integer startYear;
    private Integer endYear;

    ProductionYearsCalc(String startYear, String endYear) {

        this.startYear = Integer.valueOf(startYear);

        Optional<String> end = Optional.ofNullable(endYear);
        if (end.isPresent()) {
            this.endYear = Integer.valueOf(end.get());
        }
        else {
            LocalDate now = LocalDate.now();
            this.endYear = Integer.valueOf(now.getYear());
        }
    }

    List<String> getProductionYearsList() {

        List<String> years = new ArrayList<>();
        for (int i = startYear.intValue(); i <= endYear.intValue(); i++) {
            years.add(String.valueOf(i));
        }

        return years;
    }
}
