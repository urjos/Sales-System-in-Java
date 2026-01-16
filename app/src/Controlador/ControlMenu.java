package Controlador;
import Modelo.ConsultasProveedores;
import Modelo.Proveedores;
import Vista.frmProveedores;
import Modelo.ConsultasClientes;
import Modelo.Clientes;
import Vista.frmClientes;
import Modelo.ConsultasProducto;
import Modelo.Producto;
import Vista.frmProducto;
import Vista.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlMenu implements ActionListener{
    private final Menu vistaMenu;
    private frmClientes vistaClientes;
    private frmProveedores vistaProveedores;
    private frmProducto vistaProducto;
    
    public ControlMenu(Menu vistaMenu){
        this.vistaMenu = vistaMenu;
        
        // Conectar botones del formulario
        this.vistaMenu.btnClientes.addActionListener(this);
        this.vistaMenu.btnProveedores.addActionListener(this);
        this.vistaMenu.btnProducto.addActionListener(this);
        this.vistaMenu.btnSalir.addActionListener(this);
    }
    
    public void iniciar(){
        vistaMenu.setTitle("Gestion de Ventas");
        vistaMenu.setVisible(true);
        vistaMenu.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaMenu.btnClientes) {
            abrirClientes();
        }
        if (e.getSource() == vistaMenu.btnProducto) {
            abrirProducto();
        }
        if (e.getSource() == vistaMenu.btnProveedores) {
            abrirProveedores();
        }
        if (e.getSource() == vistaMenu.btnSalir) {
            System.exit(0);
        }
    }
    
    public void abrirClientes(){
        if (vistaClientes == null) {
            Clientes modelo = new Clientes();
            ConsultasClientes consulta = new ConsultasClientes();
            frmClientes vistaClientes = new frmClientes();

            ControlClientes crtl = new ControlClientes(modelo, consulta, vistaClientes, vistaMenu);
            crtl.iniciar();
        }
        vistaMenu.setVisible(false);
        vistaClientes.setVisible(true);
    }
    
    public void abrirProducto(){
        if (vistaProducto == null) {
            Producto modelo = new Producto();
            ConsultasProducto consulta = new ConsultasProducto();
            frmProducto vistaProducto = new frmProducto();

            ControlProducto crtl = new ControlProducto(modelo, consulta, vistaProducto, vistaMenu);
            crtl.iniciar();
        }
        vistaMenu.setVisible(false);
        vistaProducto.setVisible(true);
    }
    
    public void abrirProveedores(){
        if (vistaProducto == null) {
            Proveedores modelo = new Proveedores();
            ConsultasProveedores consulta = new ConsultasProveedores();
            frmProveedores vistaProveedores = new frmProveedores();

            ControlProveedores crtl = new ControlProveedores(modelo, consulta, vistaProveedores, vistaMenu);
            crtl.iniciar();
        }
        vistaMenu.setVisible(false);
        vistaProveedores.setVisible(true);
    }
}
