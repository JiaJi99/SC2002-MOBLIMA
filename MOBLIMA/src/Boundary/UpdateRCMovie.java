import java.util.Scanner;

import moblima.Manager.MoviesCtrl;
import moblima.Model.MovieAgeCategory;
import moblima.Model.MovieType;

public class UpdateRCMovie {
    private static MoviesCtrl moviesCtrl = new MoviesCtrl();

    public void main(){
        Scanner sc = new Scanner(System.in);
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

    public void createMovie(){
        Scanner scTemp = new Scanner( System.in);
        scTemp.nextLine();
        System.out.println("Enter movie title ");
        String title = scTemp.nextLine();

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
                String synopsis = InputController.getStringFromUser();
                System.out.println("Enter movie rating (  2 .PG /3.  NC /4 . M /5.  R/ 6. E) :");
                System.out.println("choose option");
                int option = sc.nextInt();
                MovieAgeCategory ageCat;
                switch(option){
                    case 2 : ageCat = PG; break;
                    case 3 : ageCat = NC; break;
                    case 4 : ageCat = M; break;
                    case 5 : ageCat = R; break;
                    case 6 : ageCat = E; break;
                    
                }
                System.out.println("Enter movie duration: integer in mins ");
                int duration = InputController.getIntFromUser();
        
                System.out.println("Enter movie release date (DD/MM/YYYY) : ");
                LocalDate movieReleaseDate = InputController.getDateFromUser();
        
                System.out.println("Enter movie end date (DD/MM/YYYY) : ");
                LocalDate movieEndDate = InputController.getDateFromUser();
                


                    if (movieEndDate.isBefore(movieReleaseDate)) {
                        System.out.println("Invalid Movie End Date!\n" +
                                        "Returning to menu");
                        return;
                    }
                System.out.println("Enter movie director: ");
                String director = InputController.getStringFromUser();

                System.out.println("Enter number of casts (at least 2): ");
                int numCast = InputController.getIntFromUser();
                if (numCast < 2) {
                    System.out.println("Invalid number of casts!\n" +
                                       "Returning to menu");
                    return;
                }
                ArrayList<String> cast = new ArrayList<>();
                for (int i = 0; i < numCast; i++) {
                    System.out.println("Enter name of cast " + (i+1) + ": ");
                    cast.add(InputController.getStringFromUser());
                    }
        
                moviesCtrl.create()
                



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
        int input = -1;
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
