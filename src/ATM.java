import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATM extends Account
{
    Scanner s = new Scanner(System.in);
    float balance = 0;
    ArrayList<User> users = new ArrayList<>();
    Random r = new Random();
    Account[] accounts = new Account[3];
    int round = 0;
    public void start()
    {
        accounts[0] = new Account();
        accounts[1] = new Account();
        accounts[2] = new Account();

        accounts[0].setName("AA1");
        accounts[1].setName("AA2");
        accounts[2].setName("AA3");
        for (int i = 0; i < 3; i++)
        {
            accounts[0].setBalance(r.nextDouble());
            accounts[1].setBalance(r.nextDouble());
            accounts[2].setBalance(r.nextDouble());
            if(i==0)
                users.add(new User("ahmad", 150, accounts));
            if(i==1)
                users.add(new User("khalid", 333,accounts));
            if(i==2)
                users.add(new User("Ali", 444,accounts));
        }


        System.out.println("Welcome ATM Safoua ");
        System.out.println("Enter your name : ");
        String enteredName = s.next();
        System.out.println("Enter your pin : ");
        int enteredPin = s.nextInt();

        for (User user : users)
        {
            round++;
            if (enteredName.equals(user.Name) && enteredPin == user.PIN)
            {
                System.out.println("Enter your choice :");
                System.out.println("1- Debt Account");
                System.out.println("2- credit Account");
                System.out.println("3- Saving Account");
                int choice = s.nextInt();
                balance += accounts[choice].getBalance();
                menu();
            break;
            } else {
                System.out.println("Enter a Valid Account ");
                start();
            }

        }
    }


    private void menu() {
        System.out.println("Enter your choice :");
        System.out.println("1- Check Balance");
        System.out.println("2- Deposit Money");
        System.out.println("3- Withdraw Money");
        System.out.println("4- Info Account");
        System.out.println("5- EXIT");
        int choice = s.nextInt();

        switch (choice)
        {
            case 1:
                System.out.println("Your Balance is : " + balance);
                System.out.println("*****************************************************");
                System.out.println("*                                                   *");
                System.out.println("*                 Goodbye Safoua ATM                *");
                System.out.println("*                                                   *");
                System.out.println("*****************************************************");
                start();
                break;
            case 2:
                System.out.println("How many Deposit are you want : ");
                float enterDeposit = s.nextFloat();
                balance+=enterDeposit;
                System.out.println("Your Balance is :" + balance);
                System.out.println("*****************************************************");
                System.out.println("*                                                   *");
                System.out.println("*                 Goodbye Safoua ATM                *");
                System.out.println("*                                                   *");
                System.out.println("*****************************************************");
                start();
                break;
            case 3:
                System.out.println("How many Withdraw are you want : ");
                double enterWithdraw = s.nextDouble();
                if (enterWithdraw > balance)
                {
                    System.out.println("Your request cannot be executed !!");
                    System.out.println("Your Balance is not enough  ");

                } else
                {
                    System.out.println("Successful");
                    balance-=enterWithdraw;
                    System.out.println("Your Balance is :" + balance);
                    System.out.println("*****************************************************");
                    System.out.println("*                                                   *");
                    System.out.println("*                Goodbye Safoua ATM                 *");
                    System.out.println("*                                                   *");
                    System.out.println("*****************************************************");
                    start();
                }
                break;
            case 4:
                System.out.println("Name : " + users.get(round).Name);
                System.out.println("your Account :");
                System.out.println(" Debt Account =" +users.get(round).accounts[0] );
                System.out.println(" credit Account ="+users.get(round).accounts[1] );
                System.out.println(" Saving Account ="+users.get(round).accounts[2] );
                System.out.println("*****************************************************");
                System.out.println("*                                                   *");
                System.out.println("*                 Goodbye Safoua ATM                *");
                System.out.println("*                                                   *");
                System.out.println("*****************************************************");
                start();
                break;
            case 5:
                start();
                break;
        }
    }
}