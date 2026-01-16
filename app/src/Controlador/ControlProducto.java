package Controlador;
import Modelo.Producto;
import Modelo.ConsultasProducto;
import Vista.frmProducto;
import Vista.Menu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
public class ControlProducto implements ActionListener{
    //Vamos a crear una variable para cada PAQUETE
    private final Producto modelo;
    private final ConsultasProducto consultas;
    private final frmProducto vista;
    private final Menu vistaMenu;
    
    public ControlProducto(Producto modelo, ConsultasProducto consultas, frmProducto vista, Menu vistaMenu){
        this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;
        this.vistaMenu = vistaMenu;
        
        // Realizamos la conexión con el FORMULARIO
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnMenu.addActionListener(this);
    }
    
    public void iniciar(){
        vista.setTitle("Productos");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            modelo.setCodigo(vista.txtCodigo.getText());
            modelo.setNombre(vista.txtNombre.getText());
            modelo.setMarca(vista.txtMarca.getText());
            modelo.setModelo(vista.txtModelo.getText());
            modelo.setPrecio(Double.parseDouble(vista.txtPrecio.getText()));
            modelo.setCantidad(Integer.parseInt(vista.txtCantidad.getText()));
            if(consultas.Guardar(modelo)){
                JOptionPane.showMessageDialog(null, "Registro guardado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "¡Error! No se guardó los datos");
            }
        } 
        
        if (e.getSource() == vista.btnModificar) {
            modelo.setId(Integer.parseInt(vista.txtId.getText()));
            modelo.setCodigo(vista.txtCodigo.getText());
            modelo.setNombre(vista.txtNombre.getText());
            modelo.setMarca(vista.txtMarca.getText());
            modelo.setModelo(vista.txtModelo.getText());
            modelo.setPrecio(Double.parseDouble(vista.txtPrecio.getText()));
            modelo.setCantidad(Integer.parseInt(vista.txtCantidad.getText()));
            if(consultas.Modificar(modelo)){
                JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "¡Error! No se actualizó los datos");
            }
        } 
        
        if (e.getSource() == vista.btnEliminar) {
            modelo.setId(Integer.parseInt(vista.txtId.getText()));
            if(consultas.Eliminar(modelo)){
                JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "¡Error! No se eliminó los datos");
            }
        } 
        
        if (e.getSource() == vista.btnBuscar) {
            modelo.setId(Integer.parseInt(vista.txtId.getText()));
           
            if(consultas.Buscar(modelo)){
                JOptionPane.showMessageDialog(null, "¡Se encontraron los datos!");
                
                vista.txtCodigo.setText(modelo.getCodigo());
                vista.txtNombre.setText(modelo.getNombre());
                vista.txtMarca.setText(modelo.getMarca());
                vista.txtModelo.setText(modelo.getModelo());
                vista.txtPrecio.setText(String.valueOf(modelo.getPrecio()));
                vista.txtCantidad.setText(String.valueOf(modelo.getCantidad()));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró datos");
            }
        } 
        
        if(e.getSource() == vista.btnLimpiar){
            Limpiar();
        }
        
        if(e.getSource() == vista.btnMenu){
            vista.setVisible(false);
            vistaMenu.setVisible(true);
        }
    } 
    
    public void Limpiar(){
            vista.txtId.setText(null);
            vista.txtCodigo.setText(null);
            vista.txtNombre.setText(null);
            vista.txtMarca.setText(null);
            vista.txtModelo.setText(null);
            vista.txtPrecio.setText(null);
            vista.txtCantidad.setText(null);
    }
}
