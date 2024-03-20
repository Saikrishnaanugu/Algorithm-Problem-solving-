
import src.Task1;
import src.Task2;
import src.Task3A;
import src.Task3B;
import src.Task5;
import src.Task6B;



public class Stocks{
    public static void main(String[] args){
        String work = args[0];
        System.out.print(work);
        String[] redirect = new String[0];


        if(work.equalsIgnoreCase("1")){
        Task1.main(redirect);
        }
        else if(work.equalsIgnoreCase("2")){
            Task2.main(redirect);
        }
        else if(work.equalsIgnoreCase("3a")){

            Task3A.main(redirect);
        }
        else if(work.equalsIgnoreCase("3b")){

            Task3B.main(redirect);
        }
        else if(work.equalsIgnoreCase("5")){

            Task5.main(redirect);
        }
        else if(work.equalsIgnoreCase("6b")){

            Task6B.main(redirect);
        }


    }
}