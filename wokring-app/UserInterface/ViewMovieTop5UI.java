package UserInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import ManagerClasses.AccountManager;
import ManagerClasses.MoviesCtrl;
import ManagerClasses.TransactionsCtrl;
import BaseClasses.Movie;
import BaseClasses.Transaction;


public class ViewMovieTop5UI {
	
	/**
	 * Controller that this UI will reference
	 */
    private MoviesCtrl moviesCtrl = new MoviesCtrl();
	
	/**
	 * list of movie from database
	 */
    ArrayList<Movie> movieList = moviesCtrl.read();
	
	
	/**
	 *List the top 5 movies by sales 
	 *@param accountMgr
	 */
    public void listTop5(AccountManager accountMgr){
        System.out.println("----------Top By Rating-----------");
        Collections.sort(this.movieList, new SortByRating());

        for (int i =0;i<movieList.size()&&i<5;i++ ){
            System.out.println("Title: " + movieList.get(i).getTitle());
            System.out.println("Rating: " + movieList.get(i).avgRating());
            System.out.println("----");
    
        }

        System.out.println("----------Top By Sales-----------");
        Collections.sort(movieList, new SortBySales());
        for (int i =0;i<movieList.size()&&i<5;i++ ){
            System.out.println("Title: " + movieList.get(i).getTitle());
            System.out.println("Rating: " + movieList.get(i).avgRating());
            if (accountMgr.getAdminLoggedIn()==true){
                TransactionsCtrl transCtrl = new TransactionsCtrl();
                ArrayList<Transaction> transList = transCtrl.read();
                int sales = 0;
                Movie a = movieList.get(i);
                for (int j =0;j<transList.size();j++){
                    // if (transList.get(j).getMovie().equals(a)) sales++;
					if (transList.get(i).getMovie().getTitle().equals(a.getTitle())) sales++;


                }
                
                System.out.println("Num Sales : " + sales);
            }
            System.out.println("----");
    
        }

    }




}

class SortByRating implements Comparator<Movie> {

	
	/**
	 * To compare two movie by rating and return int 
	 *@param a  	movie object
	 *@param b	movie to compare to
	 *@return int  	Return -1 if a has bigger rating, 1 if a has a smaller rating, else 0 if a and b have equal rating
	 */
	public int compare(Movie a, Movie b) {
		String ratingA = a.avgRating();
		String ratingB = b.avgRating();
		if(ratingA == "N/A" && ratingB == "N/A") return 0;
		if(ratingA == "N/A") return 1;
		if(ratingB == "N/A") return -1;
		double difference = Double.parseDouble(ratingA) - Double.parseDouble(ratingB);
		if (difference > 0) return -1;
		if (difference < 0) return 1;
		return 0;
	}
}

/**
 * To sort by sales
 */
class SortBySales implements Comparator<Movie> {
	public int compare(Movie a, Movie b) {
		TransactionsCtrl transCtrl = new TransactionsCtrl();
		ArrayList<Transaction> transList = transCtrl.read();
		int salesA = 0, salesB = 0;
		for (int i = 0; i < transList.size(); i++) {
			if (transList.get(i).getMovie().getTitle().equals(a.getTitle())) salesA++;
			if (transList.get(i).getMovie().getTitle().equals(b.getTitle())) salesB++;
		}
		return salesB - salesA;
	}
}

