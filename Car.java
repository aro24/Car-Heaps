
public class Car {
	String vin;
	String make;
	String model;
	double price;
	int mileage;
	String color;
	
	public Car(String vinnum, String carmake, String carmodel, double carprice, int carmileage, String carcolor){
		vin=vinnum;
		make=carmake;
		model=carmodel;
		price=carprice;
		mileage=carmileage;
		color=carcolor;
	}
	public void setVIN(String vinnum){
		vin=vinnum;
	}
	public String getVIN(){
		return vin;
	}
	public void setMake(String carmake){
		make=carmake;
	}
	public String getMake(){
		return make;
	}
	public void setMode(String carmodel){
		model=carmodel;
	}
	public String getModel(){
		return model;
	}
	public void setPrice(double carprice){
		price=carprice;
	}
	public double getPrice(){
		return price;
	}
	public void setMileage(int carmileage){
		mileage=carmileage;
	}
	public int getMileage(){
		return mileage;
	}
	public void setColor(String carcolor){
		color=carcolor;
	}
	public String getColor(){
		return color;
	}
	public String toString(){
		String str="VIN: "+this.getVIN() 
				+"\nMaker: "+this.getMake() 
				+"\nModel: "+this.getModel()
				+"\nPrice: "+this.getPrice()
				+"\nMileage: "+this.getMileage()
				+"\nColor: "+this.getColor();
		return str;
	}
}
