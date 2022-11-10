package moblima.Manager;

import java.util.ArrayList;

import moblima.BusinessLayer.CinemasLayer;
import moblima.Model.*;


public class CinemasController {

    /**
     * The Cineplex Controller that this controller will reference
     */
    private CineplexController cineplexesCtrl;

    /**
     * The file name of the database file that this controller will access
     */
    public String FILENAME;

    /**
     * Declaring constant for better readability and easier referencing to attribute
     */
    public final static int CODE = 0;
    public final static int CINEMA_TYPE = 1;
    public final static int SEATING_PLAN = 2;
    public final static int SESSIONS = 3;

    
    /**
     * Default constructor 
     */
    @SuppressWarnings("static-access")
    public CinemasController() {
        this.cineplexesCtrl = new CineplexController();
        this.FILENAME = cineplexesCtrl.FILENAME;
    }

    
    /**
     * a
     * @param cineplexesCtrl
     */
    @SuppressWarnings("static-access")
    public CinemasController(CineplexController cineplexesCtrl) {
        this.cineplexesCtrl = cineplexesCtrl;
        this.FILENAME = cineplexesCtrl.FILENAME;
    }

    
    
    public CineplexController getCineplexesController(){
        return this.cineplexesCtrl;
    }

 
    public void setCineplexesController(CineplexController cineplexesCtrl){
        this.cineplexesCtrl = cineplexesCtrl;
    }

    /**
     * Create a new Cinema and appends it to cineplex arraylist
     * Attributes are validated before creation
     * If invalid attributes are thrown, throws error and do nothing
     * If database file does not exist, a new data file is create and saved
     * else new cinema is added to the database under the cineplex choosen
     * @param cineplexName  	Name of cineplex that the new cinemas is to be added
     * @param code				New cinemas' code
     * @param seatingPlan		New cinemas' seat plan
     */
    public void create(
            String cineplexName, String code, SeatPlan seatingPlan 
    ) {
        if (CinemasLayer.isCinemaValid(cineplexName, code, seatingPlan)){
            Cinemas cinema = new Cinemas(code, seatingPlan);
            ArrayList<Cineplex> allData = this.cineplexesCtrl.read();
            ArrayList<Cineplex> returnData = new ArrayList<Cineplex>();
            for (int i=0; i<allData.size(); i++){
                Cineplex cineplex_i = allData.get(i);
                if (cineplex_i.getCineplexName().equals(cineplexName)){
                    ArrayList<Cinemas> cinemas = cineplex_i.getWholeCineplex();
                    cinemas.add(cinema);
                    cineplex_i.setCinePlex(cinemas);
                }
                returnData.add(cineplex_i);
            }
            this.cineplexesCtrl.replaceExistingFile(FILENAME, returnData);
        } else {
            // do nothing
        }
    } 

    /**
     * Read and return every cinemax that exist under all the cineplex
     * @return Model.{@link cinemas} Return list of all cinemas if found, else empty list
     */
    public ArrayList<Cinemas> read() {
        ArrayList<Cinemas> returnData = new ArrayList<Cinemas>();
        ArrayList<Cineplex> cineplexListing = this.cineplexesCtrl.read(); 
        Cineplex cineplex = null;

        for (int i=0; i<cineplexListing.size(); i++){
            cineplex = cineplexListing.get(i);
            cineplex.getWholeCineplex().forEach(n->returnData.add(n));
        }
        return returnData;
    }

    
    
    /**
     * Read and return a list of cinemas under a given cineplex in the database
     * @param name		Name of cineplex to search for
     * @return			Model.(@link Cinemas}  Return list of Cinemas if found,else empty list
     */
    public ArrayList<Cinemas> readByCineplexName(String name){
        ArrayList<Cinemas> returnData = new ArrayList<Cinemas>();
        ArrayList<Cineplex> cineplexListing = this.cineplexesCtrl.read();
        Cineplex cineplex = null;

        for (int i=0; i<cineplexListing.size(); i++){
            cineplex = cineplexListing.get(i);
            if(cineplex.getCineplexName().equals(name)){
                cineplex.getWholeCineplex().forEach(n->returnData.add(n));
            }
        }
        return returnData;
    }

    
    
    /**
     * Read and return a list of cinema based on given attribute in the data based
     * @param col    			Given attribute based on constant	
     * @param valueToSearch		Value of given attributed to searh for
     * @return model.{@link Cinemas}	Return list of cinemas if any,else empty list
     */
    public ArrayList<Cinemas> readByAttribute(int col, Object valueToSearch) {
        ArrayList<Cinemas> returnData = new ArrayList<Cinemas>();
        ArrayList<Cinemas> cinemaListing = read();
        Cinemas cinema = null;

        for (int j=0; j<cinemaListing.size(); j++){
            cinema = cinemaListing.get(j);
            switch (col) {
                case CODE:
                    if (cinema.getCinemaCode().equals((String) valueToSearch))
                        returnData.add(cinema);
                    break;
                default:
                    break;
            }
        }
        return returnData;
    }

    
    /** 
     * UPDATE a Cinema's with new value based on a given attribute and cinema code in Database file
     * @param col       Given attribute to be check for (based on constant as defined)
     * @param code      Code of cinema to be updated
     * @param newValue  New value of cinema's attribute 
     */
    @SuppressWarnings("unchecked")
    public void updateByAttribute(int col, String code, Object newValue) {
        ArrayList<Cineplex> allData = this.cineplexesCtrl.read();
        ArrayList<Cineplex> returnData = new ArrayList<Cineplex>();

        for (int i=0; i<allData.size(); i++){
            Cineplex cineplex_i = allData.get(i);
            
            ArrayList<Cinemas> cinemas = cineplex_i.getWholeCineplex();
            ArrayList<Cinemas> cinemaLiisting = new ArrayList<Cinemas>();

            // Check if there's a match for cinema based on cinema's code
            for (int j=0; j<cinemas.size(); j++){
                Cinemas cinema_j = cinemas.get(j);
                if (cinema_j.getCinemaCode().equals(code)){
                    switch (col) {

                        case SESSIONS:
                            cinema_j.setShowTimes((ArrayList<Sessions>) newValue);
                            break; 
                        default:
                            break;
                    } 
                }
                cinemaLiisting.add(cinema_j);
            }

            cineplex_i.setCinePlex(cinemaLiisting);
            returnData.add(cineplex_i);
        }
        this.cineplexesCtrl.replaceExistingFile(FILENAME, returnData);
    }

    
    /** 
     * Delete a Cinema in the Database file, based on given cinema code
     * @param code  Code of cinema which will be deleted
     */
    public void delete(String code) {
        ArrayList<Cineplex> allData = this.cineplexesCtrl.read();
        ArrayList<Cineplex> returnData = new ArrayList<Cineplex>();

        for (int i=0; i<allData.size(); i++){
            Cineplex cineplex_i = allData.get(i);

            // ensure cineplex has more than 3 cinemas before allowing deletion
                if (cineplex_i.getWholeCineplex().size() > 3){
                    ArrayList<Cinemas> cinemas = cineplex_i.getWholeCineplex();
                    ArrayList<Cinemas> newCinemas = new ArrayList<Cinemas>();

                    // Check if there's a match for cinema based on cinema's code
                    for (int j=0; j<cinemas.size(); j++){
                        Cinemas cinema_j = cinemas.get(j);
                        if (!cinema_j.getCinemaCode().equals(code))  // add cinema if code does not match
                            newCinemas.add(cinema_j);
                    }
                    cineplex_i.setCinePlex(newCinemas);
                }
            returnData.add(cineplex_i);
        }
        this.cineplexesCtrl.replaceExistingFile(FILENAME, returnData);
    } 
    
}
