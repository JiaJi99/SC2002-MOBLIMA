package UserInterface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import ManagerClasses.*;
import BaseClasses.*;
public class BookBuy {
    
    /**
     * All the controllers that this UI will reference
     */
    private CineplexController cinplexCtrl;
    private CinemasController cinemasController;
    private MoviesCtrl moviesCtrl;
    private SessionsCtrl sessionsCtrl;
    private PriceCtrl priceCtrl;


    private String movieName;
    private String cinemaCode;
    private LocalDateTime localDateTime;
    private Cinemas chosenCinema;
    private Sessions chosenSession;
    private SeatPlan giveSeatPlan;
    private int numTickets;

    
    public BookBuy(){
        this.cinplexCtrl = new CineplexController();
        this.cinemasController = new CinemasController();
        this.moviesCtrl = new  MoviesCtrl();
        this.priceCtrl = new PriceCtrl();
        this.sessionsCtrl = new SessionsCtrl();
    }

    /**
     * To display and allow user to select the choices of available cineplex
     */
    public void bookbuyMethod(){
        ArrayList<Cinemas> tempCinemasList;//= new ArrayList<Cinemas>();
        int option;
        printActiveMovies();
        Scanner sc = new Scanner(System.in);

        ArrayList<Cineplex> cineplexList  = cinplexCtrl.read();
        System.out.println("=========AVAILABLE LOCATIONS=========== \n Enter choice :");

        for (int i =0;i<cineplexList.size();i++){
            String cinplexString = cineplexList.get(i).getCineplexName();
            System.out.println(i+1+")");
            System.out.print(" "+cinplexString + "\n");
        } 
        System.out.println("Enter 0 to return to main menu page");
        // int option = -1;
        option= sc.nextInt();

        switch(option){
            case 0: System.out.print("Terminating book, retuning to main menu");
                    return;


        }

        if (option<0 || option>cineplexList.size() ){
            System.out.print("Terminating book, retuning to main menu");
            return;
        }
        else{
            Cineplex chosenCineplex = cineplexList.get(option-1);
            tempCinemasList = cinmeasWithActiveSession(chosenCineplex.getCineplexName());
            if (tempCinemasList.size()==0){
                System.out.println("Sorry no shows running or planned in the chosen cinplex\n Please choose another option  ");
                bookbuyMethod();
                return;
            }
            else{
                choseDateTime(tempCinemasList);
                calPriceUI();
            }

        }




    }

    
    /**
     * To select seat id and save transcation 
     */
    public void createSeatStoreTrans(){
        Scanner sc3 = new Scanner(System.in);
        int id, amountLeft = numTickets;
        boolean successSeat = false;
        giveSeatPlan.printFloorPlan();

        for (int i =1;i<=amountLeft;i++){
            System.out.println("Choose seat id for " + i + " ticket: ");
            id = sc3.nextInt();
            successSeat = sessionsCtrl.assignSeat(giveSeatPlan,id,chosenSession.getId());
            if(successSeat==false){
                System.out.println("Unsuccessful booking due to seat booking error");
                break;

            }
        }
        // creating the transaction and saving it ;
        String name , emial , mobileNumber;
        System.out.println("Enter details to confirm and sotre stransaction\n Enter name");
         name = getStringFromUser();
        System.out.println("Enter email");
        emial = getStringFromUser();
        System.out.println("Enter phone number ");
        mobileNumber = getStringFromUser();
        TransactionsCtrl tempTransactionCtrl = new TransactionsCtrl();
        tempTransactionCtrl.create(cinemaCode, name, emial,mobileNumber,chosenSession.getMovie());
        System.out.println("Booking Complete, check confirmation via email or message");
    }
    
    /**
     * To display total price of the transcation
     */
    public void calPriceUI(){
        Scanner sc2 = new Scanner(System.in);
        double totalprice ;
        totalprice = 0;
        System.out.println("number of Tickets");
         numTickets =  sc2.nextInt();
         while (numTickets<1){
            System.out.println("atleast one ticket required");
            numTickets =  sc2.nextInt();
         }
         int age;
         Price priceCurrent = priceCtrl.read();
         double individualPrice;
         for (int i =1;i<=numTickets;i++){
            System.out.println("Ticket number "+i);
            boolean validInput = false;
            while(validInput==false){
                System.out.println("Enter age  :");
                age = sc2.nextInt();
                
                individualPrice = priceCtrl.calPrice(chosenSession,age,priceCurrent);
                totalprice+=individualPrice;
                System.out.println("Price of this ticket is :"+individualPrice);
            }
         }
         System.out.println("Total Price of tickets is :"+totalprice);
         int chooseOption = -1;

         System.out.println("Enter 1 to procced to transaction");
         chooseOption = sc2.nextInt();
         if (chooseOption ==1){
            createSeatStoreTrans();
         }
         else {
            System.out.println("Terminating purchase, going back");
            return;
         }



    }

    
    /**
     * For admin to choose showtime for cinema and session timing.
     * Create new sessions
     */
    public void choseDateTime(ArrayList<Cinemas> mainCiList){
        Sessions tempSession ;
        Cinemas curCinema ;
        System.out.println("Enter cinema code for choosing the showtime ");
        cinemaCode  = getStringFromUser();
        System.out.println("Choose showtime and date ");
        System.out.println("Note, enter showtime in in format DD/MM/YYYY HH:MM");
        localDateTime = getDateTimeFromUser();
        for (int i =0;i<mainCiList.size();i++){
            curCinema = mainCiList.get(i);
            String tempCode = curCinema.getCinemaCode();
            if (tempCode.equals(cinemaCode)){
                for (int j = 0;j<curCinema.getShowtimes().size();j++){
                    tempSession = curCinema.getShowtimes().get(j);
                    if(tempSession.getSessionDateTime().equals(localDateTime));
                    chosenSession = tempSession;
                    chosenCinema = curCinema;
                    giveSeatPlan = tempSession.getSeatsAvailability();
                    return;
                }
            }
        }

    }

    /**
     * To return List of cinemas with active session for a given cineplex
     */
    public ArrayList<Cinemas> cinmeasWithActiveSession(String nameCineplex){
        ArrayList<Cinemas> returnCinemasList= new ArrayList<Cinemas>();
        ArrayList<Cinemas> cinemaList  = cinemasController.readByCineplexName(nameCineplex);
        movieName ="";
        System.out.println("\n\nSearch using movie name for active shows\n Enter movie name");
        movieName = getStringFromUser();
        
        Sessions tempSession;
        Cinemas curCinema;        
        boolean printedCinemaCode = false;

        for (int i = 0;i<cinemaList.size();i++){
            printedCinemaCode = false;
            curCinema = cinemaList.get(i);
            for (int j = 0;j<curCinema.getShowtimes().size();j++){
                tempSession = curCinema.getShowtimes().get(i);
                String moiveNameTemp = tempSession.getMovie().getTitle();
                if (moiveNameTemp.equals(movieName) && (printedCinemaCode==false)){
                    System.out.println(movieName+" shows available :");
                    System.out.println("Cinema code :" +curCinema.getCinemaCode());

                }
                printedCinemaCode = true;
                System.out.println("\nShow timing : "+tempSession.getSessionDateTime());
                

            }

            returnCinemasList.add(curCinema);
        }

        System.out.println("====All shows listed =====");
        return returnCinemasList;
    }


    /**
     * To print all movies from movie databased that MovieStatus are coming soon, preview or now showing
     * 
     */
    public void printActiveMovies(){
        System.out.println("==============Active Movies================");
        ArrayList<Movie> tempMovieList= moviesCtrl.read();
        for (int i =0;i<tempMovieList.size();i++){
            Movie tempMovie = tempMovieList.get(i);
            MovieStatus tempMovieStatus=  tempMovie.ShowStatus();
            if (tempMovieStatus== MovieStatus.COMING_SOON || tempMovieStatus==MovieStatus.PREVIEW|| tempMovieStatus == MovieStatus.NOW_SHOWING){
                System.out.println("Title : "+ tempMovie.getTitle());


            }
        }
    }

    /**
     * To get input from User 
     * Loops until non empty input is given
     */
    public static String getStringFromUser(){
        Scanner sc45 = new Scanner(System.in);

        String input = "";
        while(input.equals("")){
            input = sc45.nextLine();
            if(input.equals("")){
                System.out.println("Cannot be empty, try again!");
            }
        }
        return input;
    }

    /**
     * Get Date time input from user and validate input
     *@return LocalDateTime  input of local date time is valid and return, else loop 
     */
    public static LocalDateTime getDateTimeFromUser(){
        Scanner sc44 = new Scanner(System.in);
        LocalDateTime result = null;
        String date;
        boolean validInput = false;
        while(!validInput){
            try{
                date = sc44.nextLine();
                result = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
                validInput = true;
            }
            catch(DateTimeParseException e){
                System.out.println("Must be of pattern DD/MM/YYYY HH:MM!");
            }
        }
        return result;
    }

}
