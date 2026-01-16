package Controlador;
import Modelo.Proveedores;
import Modelo.ConsultasProveedores;
import Vista.Menu;
import Vista.frmProveedores;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControlProveedores implements ActionListener {
    // Variables para cada paquete
    private final Proveedores modelo;
    private final ConsultasProveedores consultas;
    private final frmProveedores vista;
    private final Menu vistaMenu;
    
    public ControlProveedores(Proveedores modelo, ConsultasProveedores consultas, frmProveedores vista, Menu vistaMenu){
        this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;
        this.vistaMenu = vistaMenu;
        
        // Conectar botones del formulario
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnNuevo.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
        this.vista.btnMenu.addActionListener(this);
    }
    
    public void iniciar(){
        vista.setTitle("Proveedores");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        cargarTabla(); // Cargar la tabla al iniciar la vista
    }
    
    // Método para cargar los datos en el JTable1
    public void cargarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.tProveedores.getModel();
        modeloTabla.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM PROVEEDORES"; // Consulta SQL para obtener todos los datos

        try {
            con = consultas.getConexion(); // Obtener la conexión de la clase ConsultasClientes
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            // Recorrer los resultados y agregarlos al JTable
            while (rs.next()) {
                Object[] columna = new Object[4]; // Número de columnas en la tabla clientes
                columna[0] = rs.getInt("id");
                columna[1] = rs.getString("descripcion");
                columna[2] = rs.getString("direccion");
                columna[3] = rs.getString("telefono");
                modeloTabla.addRow(columna); // Agregar fila al modelo de la tabla
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            modelo.setDescripcion(vista.txtDescripcion.getText());
            modelo.setDireccion(vista.txtDireccion.getText());
            modelo.setTelefono(vista.txtTelefono.getText());

            if(consultas.Guardar(modelo)){
                JOptionPane.showMessageDialog(null, "Registro guardado exitosamente");
                cargarTabla(); // Actualizar el JTable después de guardar
            } else {
                JOptionPane.showMessageDialog(null, "¡Error! No se guardó los datos");
            }
        } 

        if (e.getSource() == vista.btnEditar) {
            modelo.setId(Integer.parseInt(vista.txtId.getText()));
            modelo.setDescripcion(vista.txtDescripcion.getText());
            modelo.setDireccion(vista.txtDireccion.getText());
            modelo.setTelefono(vista.txtTelefono.getText());
            
            if(consultas.Editar(modelo)){
                JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente");
                cargarTabla(); // Actualizar la tabla después de editar
            } else {
                JOptionPane.showMessageDialog(null, "¡Error! No se pudo actualizar los datos");
            }
        } 
        
        if (e.getSource() == vista.btnEliminar) {
            modelo.setId(Integer.parseInt(vista.txtId.getText()));
            if(consultas.Eliminar(modelo)){
                JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente");
                cargarTabla(); // Actualizar la tabla después de eliminar
            } else {
                JOptionPane.showMessageDialog(null, "¡Error! No se eliminó los datos");
            }
        }

        if (e.getSource() == vista.btnBuscar) {
            modelo.setId(Integer.parseInt(vista.txtId.getText()));

            if(consultas.Buscar(modelo)){
                JOptionPane.showMessageDialog(null, "¡Se encontraron los datos!");
                
                vista.txtId.setText(String.valueOf(modelo.getId()));
                vista.txtDescripcion.setText(modelo.getDescripcion());
                vista.txtDireccion.setText(modelo.getDireccion());
                vista.txtTelefono.setText(modelo.getTelefono());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró datos");
            }
        } 
        
        if(e.getSource() == vista.btnCancelar){
            Limpiar();
        }
        
        if(e.getSource() == vista.btnNuevo){
            Limpiar();
        }
        
        if(e.getSource() == vista.btnMenu){
            vista.setVisible(false);
            vistaMenu.setVisible(true);
        }
    }
    
    public void Limpiar(){
        vista.txtId.setText(null);
        vista.txtDescripcion.setText(null);
        vista.txtDireccion.setText(null);
        vista.txtTelefono.setText(null);
    }
}
