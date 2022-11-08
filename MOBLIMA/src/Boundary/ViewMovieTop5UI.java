import java.util.Collection;
import java.util.Collections;

import moblima.Manager.MoviesCtrl;
import moblima.Model.Movie;

public class ViewMovieTop5UI {
    private MoviesCtrl moviesCtrl = new MoviesCtrl();
    ArrayList<Movie> movieList = moviesCtrl.read();
    public void listTop5(AccountManager accountMgr){
        System.out.println("----------Top By Rating-----------");
        Collections.sort(movieList, new SortByRating());

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
            if (accountMgr.getAdminLoggedIn()){
                TransactionsController transCtrl = new TransactionsController();
                ArrayList<Transaction> transList = transCtrl.read();
                int sales = 0;
                Movie a = movieList.get(i);
                for (int i =0;i<transList.size();i++){
                    if (transList.get(i).getMovie().equals(a)) sales++;

                }
                
                System.out.println("Num Sales : " + sales);
            }
            System.out.println("----");
    
        }

    }




}
class SortByRating implements Comparator<Movie> {
	public int compare(Movie a, Movie b) {
		String ratingA = a.avg_rating();
		String ratingB = b.avg_rating();
		if(ratingA == "N/A" && ratingB == "N/A") return 0;
		if(ratingA == "N/A") return 1;
		if(ratingB == "N/A") return -1;
		double difference = Double.parseDouble(ratingA) - Double.parseDouble(ratingB);
		if (difference > 0) return -1;
		if (difference < 0) return 1;
		return 0;
	}
}

class SortBySales implements Comparator<Movie> {
	public int compare(Movie a, Movie b) {
		TransactionsController transCtrl = new TransactionsController();
		ArrayList<Transaction> transList = transCtrl.read();
		int salesA = 0, salesB = 0;
		for (int i = 0; i < transList.size(); i++) {
			if (transList.get(i).getMovie().equals(a)) salesA++;
			if (transList.get(i).getMovie().equals(b)) salesB++;
		}
		return salesA - salesB;
	}
}

