package Boundary;
//import Boundary.LoginPanel;
import javax.swing.*;

import Boundary.BrowseAdminFlightsPanel;
import Controller.GuestUser;
import Controller.UserController;
import Controller.AdminController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class AirlineReservationSystem extends JFrame {

    //public static AirlineReservationSystem onlyInstance;
    private UserController usc;
    private AdminController adControl;
    private GuestUser gsc;
    static CardLayout cardLayout;
    static JPanel cardsPanel; // This will contain all the "pages"

    private final String LOGIN_CARD = "Login Card";
    private final String SIGNUP_CARD = "Sign-Up Card";
    private final String USER_NAVIGATION_CARD = "User Navigation Card";
    private final String CREW_NAVIGATION_CARD = "Crew Navigation Card";
    private final String BROWSE_PASSENGERS_CARD = "Browse Passengers Card";

    private final String CREW_FLIGHT_CARD = "Crew flight Card";
    private final String REGISTER_PANEL = "Register membership Card";
    private final String USER_BROWSE_FLIGHTS_CARD = "User Browse Flights Card";
    private final String ADMIN_BROWSE_FLIGHTS_CARD = "Admin Browse Flights Card";
    private final String SEAT_MAP_CARD = "Seat Map Card";
    private final String CHECKOUT_CARD = "Checkout Card";
    private final String ADMINVIEW_CARD = "Admin Card";

    private LoginPanel loginPanel;

    // public AirlineReservationSystem getOnlyInstance(UserController usc, AdminController adControl) {
    //     if (onlyInstance == null) {
    //         onlyInstance = new AirlineReservationSystem(usc, adControl);
    //     }
    //     return onlyInstance;
    // }
    

    public AirlineReservationSystem(UserController usc, AdminController adControl) {

        this.usc = usc;
        this.adControl = adControl;
        cardLayout = new CardLayout();
        cardsPanel = new JPanel(cardLayout);

        // Create the card panels.
        loginPanel = new LoginPanel();
        

        // Add the cards to the cardsPanel
        cardsPanel.add(loginPanel, LOGIN_CARD);
        cardsPanel.add(createSignUpPanel(this.usc), SIGNUP_CARD);
        cardsPanel.add(createUserNavigationPanel(), USER_NAVIGATION_CARD);
        cardsPanel.add(createCrewNavigationPanel(), CREW_NAVIGATION_CARD);
        cardsPanel.add(createBrowsePassengersPanel(this.usc), BROWSE_PASSENGERS_CARD);

        cardsPanel.add(createCrewFlightPanel(this.usc), CREW_FLIGHT_CARD);
        cardsPanel.add(createRegisterPanel(), REGISTER_PANEL);
        cardsPanel.add(createUserBrowseFlightsPanel(this.usc), USER_BROWSE_FLIGHTS_CARD);
        cardsPanel.add(createAdminBrowseFlightsPanel(), ADMIN_BROWSE_FLIGHTS_CARD);
        cardsPanel.add(createAdminViewPanel(this.adControl), ADMINVIEW_CARD);
        cardsPanel.add(createSeatMapPanel(this.usc), SEAT_MAP_CARD);
         cardsPanel.add(createCheckoutPanel(this.usc), CHECKOUT_CARD);

        // Show the initial card.
        cardLayout.show(cardsPanel, LOGIN_CARD);

        // Add the cardsPanel to the frame.
        add(cardsPanel);

        // Set up the frame.
        setTitle("Airline Reservation System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // onlyInstance = this;
    }
    
    public LoginPanel getLoginPanel(){  return loginPanel;  }
    private JPanel createBrowsePassengersPanel(UserController usc) {
        return new BrowsePassengersPanel(usc);
    }
    
    
    private JPanel createAdminViewPanel(AdminController adControl) {
        // Assuming SignUpPanel has a constructor that takes no arguments
        return new AdminViewPanel(this.adControl);
    }

    private JPanel createCrewNavigationPanel() {
        return new CrewNavigationPanel();
    }
    private JPanel createSignUpPanel(UserController usc) {
        // Assuming SignUpPanel has a constructor that takes no arguments
        return new SignUpPanel(usc);
    }

    private JPanel createCrewFlightPanel(UserController usc){
        return new CrewFlightPanel(usc);
    }
    private JPanel createUserNavigationPanel() {
        // Assuming SignUpPanel has a constructor that takes no arguments
        return new UserNavigationPanel();
    }
    private JPanel createRegisterPanel() {
        // Assuming SignUpPanel has a constructor that takes no arguments
        return new RegisterPanel();
    }
    
    private JPanel createUserBrowseFlightsPanel(UserController usc) {
        return new BrowseUserFlightsPanel(usc);
    }

    private JPanel createAdminBrowseFlightsPanel() {
        return new BrowseAdminFlightsPanel(usc);
    }
    
    private JPanel createSeatMapPanel(UserController usc) {
        // Assuming SeatMapPanel has a constructor that takes no arguments
        return new SeatMapPanel(usc);
    }
    
    private JPanel createCheckoutPanel(UserController usc) {
        Set<String> selectedSeats = new HashSet<>();
        // Assuming you will pass the actual selected seats to the constructor
        return new CheckoutPanel(usc);
    }

}

    // private JPanel createLoginPanel(JPanel cardsPanel) {
    //     LoginPanel loginPanel = new LoginPanel();
    //     return loginPanel;
    // }
    // private JPanel createSignUpPanel() {
    //     SignUpPanel signupPanel = new SignUpPanel();
    //     return signupPanel;
    // }
    // private JPanel createBrowseFlightsPanel() {
    //     BrowseFlightsPanel browseFlightsPanel = new BrowseFlightsPanel();
    //     JButton nextButton = new JButton("Select Flight and Browse Seats");
    //     nextButton.addActionListener(e -> cardLayout.show(cardsPanel, SEAT_MAP_CARD));
    //     browseFlightsPage.add(nextButton, BorderLayout.SOUTH);
    //     return browseFlightsPanel;
    //     // // Create components for browseFlightsPanel...
    //     // JPanel panel = new JPanel(new BorderLayout());
    //     //  JButton nextButton = new JButton("Select Flight and Browse Seats");
    //     // nextButton.addActionListener(e -> cardLayout.show(cardsPanel, SEAT_MAP_CARD));
    //     //  panel.add(nextButton, BorderLayout.SOUTH);
    //     // return panel;
    // }

    // private JPanel createSeatMapPanel() {
    //     SeatMapPa seatMapPanel = new SeatMapPa();
    //     JButton nextButton = new JButton("Choose Seats and Checkout");
    //      nextButton.addActionListener(e -> cardLayout.show(cardsPanel, CHECKOUT_CARD));
    //      seatMapPanel.add(nextButton, BorderLayout.SOUTH);
    //     // Add any additional components or listeners if needed
    //     return seatMapPanel;
    //     // // Create components for seatMapPanel...
    //     // JPanel panel = new JPanel(new BorderLayout());
    //     // JButton nextButton = new JButton("Choose Seats and Checkout");
    //     // nextButton.addActionListener(e -> cardLayout.show(cardsPanel, CHECKOUT_CARD));
    //     // panel.add(nextButton, BorderLayout.SOUTH);
    //     // return panel;
    // }

    // private JPanel createCheckoutPanel() {

    //  Set<String> selectedSeats = new HashSet<>();
    // selectedSeats.add("10A"); // Dummy data for selected seats

    // CheckoutPanel checkoutPanel = new CheckoutPanel(selectedSeats);
    // return checkoutPanel;
    //     // Create components for checkoutPanel...
    //     // JPanel panel = new JPanel(new BorderLayout());
    //     // JButton nextButton = new JButton("Confirm Booking");
    //     // nextButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Booking Confirmed!"));
    //     // panel.add(nextButton, BorderLayout.SOUTH);
    //     // return panel;
    // }


