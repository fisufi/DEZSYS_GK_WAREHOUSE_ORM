package warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import warehouse.model.ProductData;
import warehouse.repository.ProductDataRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private ProductDataRepository productDataRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Initialize product data repository
		productDataRepository.deleteAll();

		// save a couple of product data
		productDataRepository.save(new ProductData("1","00-443175","Bio Orangensaft Sonne","Getraenk", 2500));
		productDataRepository.save(new ProductData("1","00-871895","Bio Apfelsaft Gold","Getraenk", 3420));
		productDataRepository.save(new ProductData("1","01-926885","Ariel Waschmittel Color","Waschmittel", 478));
		productDataRepository.save(new ProductData("1","02-234811","Mampfi Katzenfutter Rind","Tierfutter", 1324));
		productDataRepository.save(new ProductData("2","03-893173","Saugstauberbeutel Ingres","Reinigung", 7390));
		System.out.println();

		// fetch all products
		System.out.println("ProductData found with findAll():");
		System.out.println("-------------------------------");
		for (ProductData productdata : productDataRepository.findAll()) {
			System.out.println(productdata);
		}
		System.out.println();

		// Fetch single product
		System.out.println("Record(s) found with ProductID(\"00-871895\"):");
		System.out.println("--------------------------------");
		System.out.println(productDataRepository.findByProductID("00-871895"));
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
	}
}