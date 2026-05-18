package az.developia._AprelPraktika.entity;

public class Car {
	
	private String marka;
	private String model;
	private Integer year;
	
	public Car(String marka, String model, Integer year) {
        this.marka = marka;
        this.model = model;
        this.year = year;
    }
	
    public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
    
}
