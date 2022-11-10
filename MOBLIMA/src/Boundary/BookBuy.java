import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import moblima.Model.Cinemas;
import moblima.Model.Cineplex;
import moblima.Model.Movie;
import moblima.Model.MovieStatus;
import moblima.Model.Sessions;

public class BookBuy {
    private CineplexController cinplexCtrl;
    private CinemasController cinemasController;
    private MoviesCtrl moviesCtrl;
    private SessionsCtrl sessionsCtrl;
    private PriceCtrl priceCtrl;


    private String movieName;
    private String cinemaCode;
    private LocalDateTime localDateTime;
    private Cinemas chosenCinema;
    private Session chosenSession;
    private SeatingPlan giveSeatPlan;
    private int numTickets;


    public BookBuy(){
        this.cinplexCtrl = new CineplexController();
        this.cinemasController = new CinemasController();
        this.moviesCtrl = new  MoviesCtrl();
        this.priceCtrl = new PriceCtrl();
        this.sessionsCtrl = new SessionsCtrl();
    }


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
        int option = -1;
        option= sc.nextInt();

        switch(option){
            case 0: System.out.print("Terminating book, retuning to main menu");
                    return;
                 break;

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
                calPrice();
            }

        }




    }

    public ArrayList<Cinemas> cinmeasWithActiveSession(String nameCineplex){
        ArrayList<Cinemas> returnCinemasList= new ArrayList<Cinemas>();
        ArrayList<Cinemas> cinemaList  = cinemasController.readByCineplexName(nameCineplex);
        movieName ="";
        System.out.println("\n\nSearch using movie name for active shows");
        Sessions tempSession;
        Cinemas curCinema;        
        boolean printedCinemaCode = false;
        boolean printeSep = false;
        for (int i = 0;i<cinemaList.size();i++){
            printedCinemaCode = false;
            curCinema = cinemaList.get(i);
            for (int j = 0;j<curCinema.getShowtimes().size();j++){
                tempSession
            }
        }
    }



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
}
