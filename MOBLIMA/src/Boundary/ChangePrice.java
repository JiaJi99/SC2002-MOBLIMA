import java.util.Scanner;

import moblima.Manager.PriceCtrl;

public class ChangePrice {
    public void changePriceMethod(){
        Scanner sc= new Scanner(System.in);
        PriceCtrl priceCtrl = new PriceCtrl();
        Price oldPrice = priceCtrl.read();
        

        System.out.println("Choose option to chagne price of category");
        System.out.println("1. Student \n 2. Adult \n3. Senior \n 4.Weekend\n5.After 6 pm \n 6. 3D movies");
        int option ;
        option = sc.nextInt();
        switch(option){
            case 1 : 
            System.out.println("Enter new student price");
            double  newPrice ;
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
            double  newPrice ;
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
            double  newPrice ;
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
            double  newPrice ;
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
            double  newPrice ;
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
            double  newPrice ;
            newPrice = sc.nextDouble();
            if (newPrice<0){
                System.out.println("Sorry updated price cannot be negative, terminating update, returning to main menu");
                return;
            }
            else {
                priceCtrl.changePrice(oldPrice,PriceCtrl._3D,newPrice);
            }
            break;

            default : 
            System.out.println("Wrong option , terminating update, returning ");
            return;
        }

        sc.close();
    }
}
