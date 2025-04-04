package co.edu.uptc.presenter;

import co.edu.uptc.model.ModelSystem;
import co.edu.uptc.view.LogIngPane;

public class Presenter {
    LogIngPane objectLogIngPane;
    private static Presenter presenter;
    private ModelSystem model;
    public Presenter(){
        objectLogIngPane= new LogIngPane();
        
    }

    public static Presenter getInstance() {
        if (presenter == null) {
            presenter = new Presenter();
            System.out.println("Creo instacia presenter!");
        }
        return presenter;
    }

    public void init(){
        
    }
}
