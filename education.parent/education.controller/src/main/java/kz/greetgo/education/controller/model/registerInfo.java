package kz.greetgo.education.controller.model;

public class registerInfo {
    public String UserN;
    public String UserS;
    public String Email;
    public String Password;
    public String Activate;
    public String Id;
    public registerInfo(String UserN, String UserS, String Email, String Password, String Activate,String Id){
        this.UserN = UserN;
        this.UserS = UserS;
        this.Email = Email;
        this.Password = Password;
        this.Activate = Activate;
        this.Id = Id;
    }
    public registerInfo(){
    }
    public String getActivate(){return Activate;}
    public  void getActivate(String activate){Activate = activate;}

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUserN() {
        return UserN;
    }

    public void setUserN(String userN) {
        UserN = userN;
    }

    public String getUserS() {
        return UserS;
    }

    public void setUserS(String userS) {
        UserS = userS;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
