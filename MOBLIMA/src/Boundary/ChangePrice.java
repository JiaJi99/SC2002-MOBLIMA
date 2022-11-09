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
            sc.nextDouble();
            
            break;


            default : 
            System.out.println("Wrong option , terminating update, returning ");
            return;
        }

    }
}
