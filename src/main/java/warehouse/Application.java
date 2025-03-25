package warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import warehouse.model.ProductData;
import warehouse.model.Warehouse;
import warehouse.repository.ProductDataRepository;
import warehouse.repository.WarehouseRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private ProductDataRepository productDataRepository;
    @Autowired
    private WarehouseRepository warehouseRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Initialize product data repository
		productDataRepository.deleteAll();
		warehouseRepository.deleteAll();

		ProductData one = new ProductData("1","1","Bio Orangensaft Sonne","Getraenk", 2500);
		ProductData two = new ProductData("1","2","Bio Apfelsaft Gold","Getraenk", 3420);
		ProductData three = new ProductData("1","3","Ariel Waschmittel Color","Waschmittel", 478);
		ProductData four = new ProductData("1","4","Mampfi Katzenfutter Rind","Tierfutter", 1324);
		ProductData five = new ProductData("2","5","Saugstauberbeutel Ingres","Reinigung", 7390);

		// save a couple of product data
		productDataRepository.save(one);
		productDataRepository.save(two);
		productDataRepository.save(three);
		productDataRepository.save(four);
		productDataRepository.save(five);
		System.out.println();

		//makes list of products for warehouse 1
		List<ProductData> products = new ArrayList<>();
		products.add(one);
		products.add(two);
		products.add(three);
		products.add(four);
		products.add(five);

		//saves a couple of warehouses
		warehouseRepository.save(new Warehouse("1","Lager 1","Hamburg","5623","Hamburg","Germany"));
		warehouseRepository.save(new Warehouse("2","Lager 2","Berlin","7893","Berlin","Germany"));
		System.out.println();

		//saves the product data in warehouse 1
		productDataRepository.save(new ProductData("1","6","Bio Orangensaft Sonne","Getraenk", 2500));

		// fetch all products
		System.out.println("ProductData found with findAll():");
		System.out.println("-------------------------------");
		for (ProductData productdata : productDataRepository.findAll()) {
			System.out.println(productdata);
		}
		System.out.println();

		// Fetch single product
		System.out.println("Record(s) found with ProductID(\"5\"):");
		System.out.println("--------------------------------");
		System.out.println(productDataRepository.findByProductID("5"));
		System.out.println();

		// Fetch all products of Warehouse 1
		System.out.println("Record(s) found with findByWarehouseID(\"1\"):");
		System.out.println("--------------------------------");
		for (ProductData productdata : productDataRepository.findByWarehouseID("1")) {
			System.out.println(productdata);
		}
		System.out.println();

		// Fetch all products of Warehouse 2
		System.out.println("Record(s) found with findByWarehouseID(\"2\"):");
		System.out.println("--------------------------------");
		for (ProductData productdata : productDataRepository.findByWarehouseID("2")) {
			System.out.println(productdata);
		}
		System.out.println("Record(s) found with findByWarehouseID(\"1\"):");
		System.out.println("--------------------------------");
		for (ProductData productdata : productDataRepository.findByWarehouseID("1")) {
			System.out.println(productdata);
		}
	}
}