
public class User
{
    User(String Name,int PIN,Account[] accounts){
        this.Name = Name;
        this.PIN = PIN;
        this.accounts = accounts;
    }
    String Name;
    int PIN ;
    Account[] accounts ;

    public String getName ()
    {
        return Name;
    }

    public void setName (String name)
    {
        Name = name;
    }

    public int getPIN ()
    {
        return PIN;
    }

    public void setPIN (int PIN)
    {
        this.PIN = PIN;
    }

    public Account[] getAccounts ()
    {
        return accounts;
    }

    public void setAccounts (Account[] accounts)
    {
        this.accounts = accounts;
    }
}
