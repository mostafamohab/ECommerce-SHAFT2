//Package that contains all project main classes
package pages;

//Libraries Used
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RandomDateGeneratorpage {

	// Create an Object from WebDriver GUI Interface
	private SHAFT.GUI.WebDriver driver;

	// Constructor
	public RandomDateGeneratorpage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	// Methods

		@Step("Get Past Date")
		public static String getPastDate() {
		DateTimeFormatter dtf1;
		switch (System.getProperty("targetBrowserName")) {
			case "firefox":
				dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				break;
			default:
				dtf1 = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		}
		LocalDateTime past = LocalDateTime.now().minusDays(1);
		return dtf1.format(past);
		}

		@Step("Get Current Date")
		public static String getCurrentDate() {
		DateTimeFormatter dtf1;
		switch (System.getProperty("targetBrowserName")) {
			case "firefox":
				dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				break;
			default:
				dtf1 = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		}
		LocalDateTime now = LocalDateTime.now();
		return dtf1.format(now);
		}

		@Step("Get Future Date")
		public static String getFutureDate() {
		DateTimeFormatter dtf1;
		switch (System.getProperty("targetBrowserName")) {
			case "firefox":
				dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				break;
			default:
				dtf1 = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		}
		LocalDateTime future = LocalDateTime.now().plusDays(1);
		return dtf1.format(future);
		}


		@Step("Get Current Time")
		public static String getCurrentTime() {
		DateTimeFormatter dtf2;
		switch (System.getProperty("targetBrowserName")) {
			case "firefox":
				dtf2 = DateTimeFormatter.ofPattern("HH:mm");
				break;
			default:
				dtf2 = DateTimeFormatter.ofPattern("hh:mma");
		}
		LocalDateTime now = LocalDateTime.now();
		return dtf2.format(now);
		}

		//for example date format as follows : "yyyy-MM-dd"
		//for example days format as follows : "1"
		@Step("Get Past Date - Parameters")
		public static String getPastDate(String dateFormat, Integer days) {
			DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern(dateFormat);
			LocalDateTime past = LocalDateTime.now().minusDays(days);
			return dtf1.format(past);
		}

		//for example date format as follows : "yyyy-MM-dd"
		@Step("Get Current Date - Parameters")
		public static String getCurrentDate(String dateFormat) {
			DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern(dateFormat);
			LocalDateTime now = LocalDateTime.now();
			return dtf1.format(now);
		}

		//for example date format as follows : "yyyy-MM-dd"
		//for example days format as follows : "1"
		@Step("Get Future Date - Parameters")
		public static String getFutureDate(String dateFormat, Integer days) {
			DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern(dateFormat);
			LocalDateTime future = LocalDateTime.now().plusDays(days);
			return dtf1.format(future);
		}

		//for example time format as follows : "HH:mm"
		//for example hours format as follows : "1"
		@Step("Get Past Time - Parameters")
		public static String getPastTime(String timeFormat, Integer hours) {
			DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern(timeFormat);
			LocalDateTime past = LocalDateTime.now().minusHours(hours);
			return dtf2.format(past);
		}

		//for example time format as follows : "HH:mm"
		@Step("Get Current Time - Parameters")
		public static String getCurrentTime(String time) {
			DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern(time);
			LocalDateTime now = LocalDateTime.now();
			return dtf2.format(now);
		}

		//for example time format as follows : "HH:mm"
		//for example hours format as follows : "1"
		@Step("Get Future Time - Parameters")
		public static String getFutureTime(String timeFormat, Integer hours) {
			DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern(timeFormat);
			LocalDateTime future = LocalDateTime.now().plusHours(hours);
			return dtf2.format(future);
		}

}


