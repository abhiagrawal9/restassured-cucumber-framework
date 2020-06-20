package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Helper {
	RequestSpecification req;
	Properties prop;

	public RequestSpecification requestSpecification() throws Exception {
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		req = new RequestSpecBuilder()
				.setBaseUri(getConfigProperties("baseURL"))
				.addQueryParam("key", "qaclick123")
				.setContentType(ContentType.JSON)
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.build();
		return req;
	}

	public String getConfigProperties(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/" + "config.properties");
		prop.load(file);
		return prop.getProperty(key);
	}
}
