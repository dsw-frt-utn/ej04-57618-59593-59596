package app;

import data.Persistencia;
import java.util.InvalidPropertiesFormatException;
import views.AltaVehiculoView;
//import views.ListarVehiculosView;

public class Program {
    public static void main(String[] args) throws IllegalArgumentException, InvalidPropertiesFormatException {
        Persistencia.inicializar();
        AltaVehiculoView view1 = new AltaVehiculoView();
 //       ListarVehiculosView view2 = new ListarVehiculosView();
        view1.setVisible(true);
        //view2.setVisible(true);
    }
}
