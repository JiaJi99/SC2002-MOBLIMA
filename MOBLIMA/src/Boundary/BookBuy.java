import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import moblima.Model.Cinemas;
import moblima.Model.Cineplex;
import moblima.Model.Movie;
import moblima.Model.MovieStatus;

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
        ArrayList<Cinemas> tempCinemasList= new ArrayList<Cinemas>();
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
        else if(Cin)




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
