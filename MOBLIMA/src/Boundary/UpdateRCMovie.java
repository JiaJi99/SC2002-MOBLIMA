import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import moblima.Manager.MoviesCtrl;
import moblima.Model.Language;
import moblima.Model.MovieAgeCategory;
import moblima.Model.MovieType;

public class UpdateRCMovie {
    private static MoviesCtrl moviesCtrl = new MoviesCtrl();
    public static Scanner sc = new Scanner(System.in);
    public void main(){
        boolean returnMainMenu = false;
        while (returnMainMenu!=true){
            System.out.print("\n\nCreate/Update/Remove Movie: \n\n" +
            "1. Create Movie Listing\n" +
            "2. Update Movie Listing\n" +
            "3. Remove Movie Listing\n" +
            "4. Return to Main Menu\n\n" +
            "Select : ");
        
        int option = -1;
        option = sc.nextInt();
        switch(option){
            case 1:
                createMovie();
                break;
            case 2:
                updateMovie();
                break;
            case 3:
                removeMovie();
                break;
            case 4:
                returnMainMenu = true;
                break;
        }

    }
    }

        public void removeMovie(){
            MoviesCtrl moviesCtrl = new MoviesCtrl();
            ArrayList<Movie> moviesList =  moviesCtrl.read();
            if (moviesList.size()==0){
                System.out.println("Sorry no movies here yet ");
            }else {
                for (int i =0;i<moviesList.size();i++){
                    System.out.println("\n\nTitle : "+moviesList.get(i).getTitle()+"\n ID : "+ moviesList.get(i).getID());
                }
                System.out.println("Enter movie id to remove");
                int movieId ;
                movieId = sc.nextInt();
                Movie m  ;
                boolean found = false;
                for (int i =0;i<moviesList.size();i++){
                    if (moviesList.get(i).getID()==movieId){
                        m = moviesList.get(i);
                        found = true;
                    }
                }

                if (found == true){
                    moviesCtrl.deleteById(m.getID());
                    System.out.println("Movie"+ movieId+"deleted successfully");
                }
                else {
                    System.out.println("Movie not found going back to menu");

                }
            }

        }

        public void updateMovie(){
            MoviesCtrl moviesCtrl = new MoviesCtrl();
            ArrayList<Movie> moviesList =  moviesCtrl.read();
            if (moviesList.size()==0){
                System.out.println("Sorry no movies here yet ");
            }else {
                for (int i =0;i<moviesList.size();i++){
                    System.out.println("\n\nTitle : "+moviesList.get(i).getTitle()+"\n ID : "+ moviesList.get(i).getID());
                }
                System.out.println("Enter movie id to update/edit");
                int movieId ;
                movieId = sc.nextInt();
                Movie m  ;
                boolean found = false;

                for (int i =0;i<moviesList.size();i++){
                    if (moviesList.get(i).getID()==movieId){
                        m = moviesList.get(i);
                        found = true;
                    }
                }

                if (found == false ){
                    System.out.println("sorry not found going back to main menu");
                    return ;
                }

                System.out.printf("Choose option" + "1. Movie Name\n" +
                "2. Movie Type (2D, 3D, Blockbuster)\n" +
                "3. Synopsis/Summary\n" +
                "4. Director Name \n" +
                "5. Runtime Duration \n" +
                "6. Movie Release date\n" +
                "7. Last Day of Showing \n" +
                "8. Cast Names List \n\n" +
                "9. Language"+
                "10. Movie Age Category"

                );

                int choice ;
                choice = sc.nextInt();
                sc.nextLine();//clearning buffer just in case new line character is taken in
                switch(choice){
                    case 1: System.out.println("Enter new movie name");
                            String newMovieName = "";
                            newMovieName = getStringFromUser();
                            moviesCtrl.updateMovie(1,movieId,newMovieName);
                            break;
                    case 2: int chooseMovieType =-1;
                            System.out.println("Enter number to choose option");
                            System.out.println("1. Blockbuster");
                            System.out.println("2. 3D");
                            System.out.println("3.  2D");
                            chooseMovieType= sc.nextInt();

                        switch(chooseMovieType){
                            case 1: moviesCtrl.updateMovie(MoviesCtrl.TYPE,movieId,MovieType.BLOCKBUSTER);
                                break;

                            case 2 :moviesCtrl.updateMovie(MoviesCtrl.TYPE,movieId,MovieType.IN_2D);
                                break;
                            case 3:moviesCtrl.updateMovie(MoviesCtrl.TYPE,movieId,MovieType.IN_3D);
                                break;
                            default : System.out.println("invalid choice, terminating update");
                            return;
                        }

                            break;
                    case 3: System.out.println("Enter updated Synopsis:");
                            String updatedSyn = "";
                            updatedSyn = getStringFromUser();
                            moviesCtrl.updateMovie(MoviesCtrl.SYNOPSIS,movieId,updatedSyn);
                            break;
                    case 4: System.out.println("Correct Director's Name:");
                            String newName = "";
                            newName = getStringFromUser();
                            moviesCtrl.updateMovie(MoviesCtrl.DIRECTOR,movieId,newName);
                            break;
                    case 5: System.out.println("Enter updated runtime duration:");
                            int runTimeNew = getIntFromUser();
                            if (runTimeNew<0){
                                System.out.println("Negative runtime not allowed, terminating update");
                            }
                            moviesCtrl.updateMovie(MoviesCtrl.DURATION,movieId,runTimeNew);
                            break;
                    case 6: System.out.println("Enter new  Release date ");
                            System.out.println("Note: Enter date in (DD/MM/YYYY) format only:");
                            LocalDate newRDate = getDateFromUser();
                            if (newRDate.isAfter(moviesCtrl.readByID(movieId).getEndDate())){
                                System.out.println("Movie date is after end date stored, fist edit end date");
                                System.out.println("Terminating movie update, going back to menu");
                                return ;
                            }
                            moviesCtrl.updateMovie(MoviesCtrl.MOVIE_START_DATE,movieId,newRDate);
                            break;
                    case 7: System.out.println("Enter new  end of showing date ");
                            System.out.println("Note: Enter date in (DD/MM/YYYY) format only:");
                            LocalDate newEDate = getDateFromUser();
                            if (newEDate.isBefore(moviesCtrl.readByID(movieId).getEndDate())){
                                System.out.println("Movie end date is before start date stored, fist edit start date");
                                System.out.println("Terminating movie update, going back to menu");
                                return ;
                            }
                            moviesCtrl.updateMovie(MoviesCtrl.MOVIE_END_DATE,movieId,newEDate);
                            break;
                    case 8: 
                            break;
                    case 9: 
                            break;
                    case 10: 
                            break;
                    case 11: 
                            break;

                    default :
                    System.out.println("Wrong input, terminating update, back to main menu");
                    return;
                    break;
                            
                }





        }


    }
        public void createMovie(){
        sc.nextLine();
        System.out.println("Enter movie title ");
        String title = sc.nextLine();
        System.out.println("Select movie types: \n" +
                                        "	1. 2D\n" +
                                        "	2. 3D\n" +
                                        "	3. Blockbuster\n\n" +
                                        "Enter option: ");
        int option = sc.nextInt();
        MovieType typeInput;
        switch (option){		
                case 1:
                typeInput = MovieType.TWO_D;
                    break;
                case 2:
                typeInput = MovieType.THREE_D;
                    break;
                case 3:
                typeInput = MovieType.BLOCKBUSTER;
                    break;
                default:
                    System.out.println("Wrong input!\n" +
                                    "Going back");
                    return;
                }


                System.out.println("Enter movie synopsis: ");
                String synopsis = getStringFromUser();
                System.out.println("Enter movie rating (  2 .PG /3.  NC /4 . M /5.  R/ 6. E) :");
                System.out.println("choose option");
                 option = sc.nextInt();
                MovieAgeCategory ageCat;
                switch(option){
                    case 2 : ageCat = MovieAgeCategory.PG; break;
                    case 3 : ageCat = MovieAgeCategory.NC; break;
                    case 4 : ageCat = MovieAgeCategory.M; break;
                    case 5 : ageCat = MovieAgeCategory.R; break;
                    case 6 : ageCat = MovieAgeCategory.E; break;
                    
                }
                System.out.println("Enter movie duration: integer in mins ");
                int duration = getIntFromUser();
        
                System.out.println("Enter movie release date (DD/MM/YYYY) : ");
                LocalDate movieReleaseDate =getDateFromUser();
        
                System.out.println("Enter movie end date (DD/MM/YYYY) : ");
                LocalDate movieEndDate = getDateFromUser();
                


                    if (movieEndDate.isBefore(movieReleaseDate)) {
                        System.out.println("Invalid Movie End Date!\n" +
                                        "Returning to menu");
                        return;
                    }
                System.out.println("Enter movie director: ");
                String director = getStringFromUser
                System.out.println("Enter number of casts (at least 2): ");
                int numCast = getIntFromUser();
                if (numCast < 2) {
                    System.out.println("Invalid number of casts!\n" +
                                       "Returning to menu");
                    return;
                }
                ArrayList<String> cast = new ArrayList<>();
                for (int i = 0; i < numCast; i++) {
                    System.out.println("Enter name of cast " + (i+1) + ": ");
                    cast.add(getStringFromUser());
                    }
                Language lang ;
                System.out.println("Enter movie language 1 : English \n 2 Chinese \n 3: Japanese: \n Enter option");
                    switch (option) {
                        case 1:lang = Language.ENGLISH; break;
                        case 2:lang = Language.CHINESE; break;
                        case 3 :lang = Language.JAPANESE;    break;
                        default : System.out.println("wrong input, returning");return ;
                    }

                moviesCtrl.create(title,typeInput,lang,ageCat,synopsis,director,duration,cast,movieReleaseDate,movieEndDate);
                
		System.out.println("\n Returning");


        }
        
        


        public static String getStringFromUser(){
            String input = "";
            while(input.equals("")){
                input = sc.nextLine();
                if(input.equals("")){
                    System.out.println("Cannot be empty, try again!");
                }
            }
            return input;
        }

        public static LocalDateTime getDateTimeFromUser(){
        LocalDateTime result = null;
        String date;
        boolean validInput = false;
        while(!validInput){
            try{
                date = sc.nextLine();
                result = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
                validInput = true;
            }
            catch(DateTimeParseException e){
                System.out.println("Must be of pattern DD/MM/YYYY HH:MM!");
            }
        }
        return result;
    }

    public static LocalDate getDateFromUser(){
        LocalDate result = null;
        String date;
        boolean validInput = false;
        while(!validInput){
            try{
                date = sc.nextLine();
                result = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                validInput = true;
            }
            catch(DateTimeParseException e){
                System.out.println("Must be of pattern DD/MM/YYYY!");
            }
        }
        return result;
    }

    public static int getIntFromUser(){
        int input = -5;
        boolean validInput = false;
        while(!validInput) {
            if(sc.hasNextInt()){
                input = sc.nextInt();
                validInput = true;
            }
            else{
                System.out.println("Wrong input!");
            }
            sc.nextLine();
        }
        return input;
    }

}
