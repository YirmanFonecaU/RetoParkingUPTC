package co.edu.uptc.presenter;

import co.edu.uptc.model.ModelSystem;


public class Presenter {
    private static Presenter presenter;
    private ModelSystem model;
    

    
    public Presenter(){
        this.model = new ModelSystem();
        System.out.println("ModelSystem creado en Presenter!");
    }
    public boolean verifyRol(String user){
        return model.validateRol(user);
    }
    public boolean logIn(String user, String password){
        return model.LogIn(user, password);
    }
  
    


    public static Presenter getInstance() {
        if (presenter == null) {
            presenter = new Presenter();
            System.out.println("Creo instacia presenter!");
        }
        return presenter;
    }
    
    
}
