package pl.isa.autopartsJee.vehiclesearch;

public class ProductionYearsCalc {
	
	private Integer startYear;
	private Integer endYear;

	protected ProductionYearsCalc(String startYear, String endYear) {
		
		this.startYear = Integer.valueOf(startYear);
		this.endYear = Integer.valueOf(endYear);
	}
	
	protected List<String> getProductionYearsList() {
		
		Optional<Integer> end = Optional.ofNullable(endYear);
		if (end.isPresent()) {
			return explodeToYearsList(this.startYear, end.get());
		}
		
		LocalDate now = LocalDate.now();
		this.endYear = now.getYear();
		
		return explodeToYearsList(this.startYear, this.endYear);
	}
	
	private List<String> explodeToYearsList(Integer startYear, Integer endYear) {
		
		List<String> years = new ArrayList<>();
		for (int i = startYear.intValue; i <= endYear.intValue(); i++) {
			years.put(i.toString());
		}
		
		return years;
	}
	
	// LocalDate now = LocalDate.now();
	// endYear = now.getYear(); // int
}
