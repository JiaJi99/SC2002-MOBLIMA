import java.time.LocalDateTime;

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
        this.moviesCtrl = new MoviesCtrl();
        this.priceCtrl = new PriceCtrl();
        this.sessionsCtrl = new SessionsCtrl();

    }


    public void bookbuyMethod(){
        
    }
}
