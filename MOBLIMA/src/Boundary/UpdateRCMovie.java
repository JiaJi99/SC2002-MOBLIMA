import java.util.Scanner;

import moblima.Manager.MoviesCtrl;

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
        
    }

}
