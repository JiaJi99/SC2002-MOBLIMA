package UserInterface;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import BaseClasses.Price;
import ManagerClasses.HolidaysCtrl;
import ManagerClasses.PriceCtrl;

public class ChangePrice {
    Scanner sc= new Scanner(System.in);
    /**
     * To display change price UI
     * User to input price parameter to update
     * User to input new price
     * If input are vaild write new price to database
     */
        public void changePriceMethod(){
        
        PriceCtrl priceCtrl = new PriceCtrl();
        Price oldPrice = priceCtrl.read();
        

        System.out.println("Choose option to chagne price of category");
        System.out.println("1. Student \n 2. Adult \n3. Senior \n 4.Weekend & Holiday\n5.After 6 pm \n 6. 3D movies \n 7. Configure holiday dates");
        int option ;
        option = sc.nextInt();
        double  newPrice ;
        switch(option){
            case 1 : 
            System.out.println("Enter new student price");
            
            newPrice = sc.nextDouble();
            if (newPrice<0){
                System.out.println("Sorry updated price cannot be negative, terminating update, returning to main menu");
                return;
            }
            else {
                priceCtrl.changePrice(oldPrice,PriceCtrl.STUDENT,newPrice);
            }
            break;

            case 2 : 
            System.out.println("Enter new adult price");

            newPrice = sc.nextDouble();
            if (newPrice<0){
                System.out.println("Sorry updated price cannot be negative, terminating update, returning to main menu");
                return;
            }
            else {
                priceCtrl.changePrice(oldPrice,PriceCtrl.ADULT,newPrice);
            }
            break;

            case 3 : 
            System.out.println("Enter new senior price");

            newPrice = sc.nextDouble();
            if (newPrice<0){
                System.out.println("Sorry updated price cannot be negative, terminating update, returning to main menu");
                return;
            }
            else {
                priceCtrl.changePrice(oldPrice,PriceCtrl.SENIOR,newPrice);
            }
            break;

            case 4 : 
            System.out.println("Enter new weekend price");
            // double  newPrice ;
            newPrice = sc.nextDouble();
            if (newPrice<0){
                System.out.println("Sorry updated price cannot be negative, terminating update, returning to main menu");
                return;
            }
            else {
                priceCtrl.changePrice(oldPrice,PriceCtrl.WEEKEND,newPrice);
            }
            break;

            case 5 : 
            System.out.println("Enter new after 6 price");
            // double  newPrice ;
            newPrice = sc.nextDouble();
            if (newPrice<0){
                System.out.println("Sorry updated price cannot be negative, terminating update, returning to main menu");
                return;
            }
            else {
                priceCtrl.changePrice(oldPrice,PriceCtrl.AFTER6,newPrice);
            }
            break;


            case 6 : 
            System.out.println("Enter new 3D movie price");
            // double  newPrice ;
            newPrice = sc.nextDouble();
            if (newPrice<0){
                System.out.println("Sorry updated price cannot be negative, terminating update, returning to main menu");
                return;
            }
            else {
                priceCtrl.changePrice(oldPrice,PriceCtrl._3D,newPrice);
            }
            break;
            case 7: // holiday date configure 
            HolidaysCtrl holidaysCtrl = new HolidaysCtrl() ;
            LocalDate inputDate = getDateFromUser(); 
            holidaysCtrl.create(inputDate);
            System.out.println("Holiday date recorded");
            break;
            default : 
            System.out.println("Wrong option , terminating update, returning ");
            return;
        }

        sc.close();
    }

    public  LocalDate getDateFromUser(){
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

}
