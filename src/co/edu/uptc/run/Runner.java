package co.edu.uptc.run;

import co.edu.uptc.presenter.Presenter;
import co.edu.uptc.view.*;


public class Runner {
    public static void main(String[] args) throws Exception {
        Presenter presenter = Presenter.getInstance();
        new LogIngPane();  
        
    }

}
