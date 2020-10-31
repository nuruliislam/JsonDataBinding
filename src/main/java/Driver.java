package main.java;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON  file and map to Java POJO: 
			Product theProduct = mapper.readValue(
						new File("data/product.json"), Product.class);
			
			// print Customer Name and Product Name
			System.out.println("Customer Name = " + theProduct.getCustomerName());
			System.out.println("Product name = " + theProduct.getProductName());

			// print out address
			Address tempAddress = theProduct.getAddress();
			
			System.out.println("Street = " + tempAddress.getStreet());
			System.out.println("City = " + tempAddress.getCity());
			
			
			System.out.println("List of Features:");
			for (String feature : theProduct.getFeatures()) {
				System.out.println(feature);
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}