import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
public class CarTracker {

	static IndexMinPQ carPrice = new IndexMinPQ(100);
	static IndexMinPQ carMileage = new IndexMinPQ(100);
	static HashMap <String, Car> vinCars = new HashMap<String, Car>(); //vin keys, car values
	static HashMap <Car, Integer> carIndexes = new HashMap<Car, Integer>(); //car keys, index values
	static Car[] carArray = new Car [100];
	static int carCount=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		while(true){
			System.out.println("1. Add a car \n2. Update a car \n"
					+ "3. Remove a car from consideration \n4. Retrieve the lowest price car \n"
					+ "5. Retrieve the lowest mileage car \n6. Retrieve the lowest price car by make and model \n"
					+ "7. Retrieve the lowest mileage car by make and model \n8. Exit");
			int menu=s.nextInt();
			if (menu==1){
				addCar();
			}
			else if (menu==2){
				updateCar();
			}
			else if (menu==3){
				removeCar();
			}
			else if (menu==4){
				lowestPrice();
			}
			else if (menu==5){
				lowestMileage();
			}
			else if (menu==6){
				lowestPriceMM();
			}
			else if (menu==7){
				lowestMileageMM();
			}
			else if (menu==8){
				break;
			}
			else{
				System.out.println("Invalid input. Please use a valid number.");
			}
		}
		
	}

	private static void lowestMileageMM() {
		// TODO Auto-generated method stub
		Scanner inp = new Scanner (System.in);
		Iterator min = carMileage.iterator();
		
		System.out.println("Enter a maker: ");
		String make=inp.nextLine();
		System.out.println("Enter a model: ");
		String model=inp.nextLine();
		while(min.hasNext()){
			int index=(int)min.next();
			Car comp=carArray[index];
			if(comp.getMake().equals(make) && comp.getModel().equals(model)){
				System.out.println(comp.toString());
				break;
			}
		}
	}

	private static void lowestPriceMM() {
		// TODO Auto-generated method stub
		Scanner inp = new Scanner (System.in);
		Iterator min = carPrice.iterator();
		
		System.out.println("Enter a maker: ");
		String make=inp.nextLine();
		System.out.println("Enter a model: ");
		String model=inp.nextLine();
		while(min.hasNext()){
			int index=(int)min.next();
			Car comp=carArray[index];
			if(comp.getMake().equals(make) && comp.getModel().equals(model)){
				System.out.println(comp.toString());
				break;
			}
		}
	}

	private static void lowestMileage() {
		// TODO Auto-generated method stub
		int carInd=carMileage.minIndex();
		Car lowest=carArray[carInd];
		System.out.println("Lowest Mileage car: \n");
		System.out.println(lowest.toString());
	}

	private static void lowestPrice() {
		// TODO Auto-generated method stub
		int carInd=carPrice.minIndex();
		Car lowest=carArray[carInd];
		System.out.println("Lowest Price car \n");
		System.out.println(lowest.toString());
	}

	private static void removeCar() {
		// TODO Auto-generated method stub
		Scanner inp = new Scanner (System.in);
		System.out.println("Enter a VIN number: ");
		String vinnum=inp.nextLine();
		Car removed = vinCars.get(vinnum);
		int index = carIndexes.get(removed);
		carPrice.delete(index);
		carMileage.delete(index);
		carIndexes.remove(removed);
		vinCars.remove(vinnum);
		carArray[index]=null;
	}

	private static void updateCar() {
		// TODO Auto-generated method stub
		Scanner inp = new Scanner (System.in);
		System.out.println("Enter a VIN number: ");
		String vinnum=inp.nextLine();
		System.out.println("1. Update price \n"
				+ "2. Update mileage \n"
				+ "3. Update color");
		int selection=inp.nextInt();
		while(selection!=1 && selection!=2 && selection!=3){
			System.out.println("\nInvalid input\n"
					+ "1. Update price \n"
					+ "2. Update mileage \n"
					+ "3. Update color");
			selection=inp.nextInt();
		}
		Car updated = vinCars.get(vinnum);
		if(selection==1){
			System.out.println("Enter new price: ");
			double price=inp.nextDouble();
			updated.setPrice(price);
			int index=carIndexes.get(updated);
			carPrice.changeKey(index, price);
		}
		else if(selection==2){
			System.out.println("Enter new mileage: ");
			int mileage=inp.nextInt();
			updated.setMileage(mileage);
			int index=carIndexes.get(updated);
			carMileage.changeKey(index, mileage);
		}
		else if(selection==3){
			System.out.println("Enter new color: ");
			String color=inp.nextLine();
			updated.setColor(color);
		}
	}
	
	private static void addCar() {
		// TODO Auto-generated method stub
		Scanner inp = new Scanner (System.in);
		System.out.println("Enter a VIN number: ");
		String vinnum=inp.nextLine();
		System.out.println("Enter car maker: ");
		String carmake=inp.nextLine();
		System.out.println("Enter car model: ");
		String carmodel=inp.nextLine();
		System.out.println("Enter car price: ");
		double carprice=inp.nextDouble();
		System.out.println("Enter car mileage: ");
		int carmileage=inp.nextInt(); 
		System.out.println("Enter car color: ");
		inp.nextLine();
		String carcolor=inp.nextLine();
		Car nCar=new Car(vinnum, carmake, carmodel, carprice, carmileage, carcolor);

		carPrice.insert(carCount, carprice);
		carMileage.insert(carCount, carmileage);
		
		vinCars.put(vinnum, nCar);
		carIndexes.put(nCar, carCount);
		carArray[carCount]=nCar;
		carCount++;
		if(carCount==carArray.length){
			carArray=Arrays.copyOf(carArray, carCount*2);
		}
	}

}
