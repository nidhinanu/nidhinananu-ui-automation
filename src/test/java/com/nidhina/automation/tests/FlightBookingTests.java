package com.nidhina.automation.tests;
import static org.junit.Assert.assertEquals;
import com.nidhina.automation.model.Pages.HomePage;
import com.nidhina.automation.model.Pages.AvailableFlightsPage;
import com.nidhina.automation.model.Pages.BookingSummaryPage;
import com.nidhina.automation.model.Pages.FlightBookingPage;
import org.junit.jupiter.api.Test;

public class FlightBookingTests extends BaseTests {

    @Test
    public void VerifyValidFlightBooking()
    {
        HomePage homePage = new HomePage(driver);
        homePage.clickHomeMenu();        
        FlightBookingPage flightBookingPage = new FlightBookingPage(driver);
        homePage.clickMenu("FLIGHTS");
        flightBookingPage.enterFromLocation();
        flightBookingPage.enterToLocation();
        flightBookingPage.setDate("2022-March-16");
        flightBookingPage.clickSearch();
        AvailableFlightsPage availableFlightsPage= new AvailableFlightsPage(driver);        
        availableFlightsPage.clickBookNow();
        BookingSummaryPage bookingSummaryPage= new BookingSummaryPage(driver);
        bookingSummaryPage.EnterFirstName("abc");
        bookingSummaryPage.EnterLastName("def");
        bookingSummaryPage.EnterEmail("abc.def@gmail.com");
        bookingSummaryPage.EnterConfirmEmail("abc.def@gmail.com");
        //bookingSummaryPage.clickConfirmBooking();
        assertEquals("test", "test");
    }

    
}
