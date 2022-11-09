import java.time.LocalDateTime;
import java.util.ArrayList;

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


        ArrayList<Cineplex> cineplexList  = cinplexCtrl.read();
        System.out.println("=========AVAILABLE LOCATIONS=========== \n Enter choice :");


        for (int i =0;i<cineplexList.size();i++){

            String cinplexString = cineplexList.get(i).getCineplexName();
            System.out.println(i+1+")");
            System.out.print(" "+cinplexString);


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
