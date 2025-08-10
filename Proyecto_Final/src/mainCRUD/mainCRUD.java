package mainCRUD;
import Controlador.ControlMenu;
import Vista.Menu;

public class mainCRUD {
    public static void main(String[] args) {
        Menu vista = new Menu();
        ControlMenu crtl = new ControlMenu(vista);
        crtl.iniciar();
        vista.setVisible(true);
    }
}
