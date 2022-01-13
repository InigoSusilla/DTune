import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;


public class VentanaIniciarSesion extends JFrame {
	

	private static Logger logger = Logger.getLogger( "Inicio de sesi�n" );

	private JPanel contentPane;
	private JTextField infoUsuario;
	private static Usuario user;
	private JPasswordField infoContrasena;


	/**
	 * Create the frame.
	 */
	public VentanaIniciarSesion() {
		setLocationRelativeTo(null);
		setTitle("DTune Iniciar Sesi\u00F3n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelIniciarSesion = new JPanel();
		contentPane.add(panelIniciarSesion, BorderLayout.SOUTH);
		panelIniciarSesion.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnInicioSesion = new JButton("Iniciar Sesi\u00F3n");
		panelIniciarSesion.add(btnInicioSesion);
		
		btnInicioSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String cont = infoContrasena.getText();
				String usu = infoUsuario.getText();
				if(usu.equals("") || cont.equals("") ) {
					JOptionPane.showMessageDialog(null,"El nombre y/o la contrase�a esta vacio");
				}else {
					int resul = BaseDeDatos.comprobacionUsuario(usu, cont);
					if (resul == 1) {
						
						JOptionPane.showMessageDialog(null, "Usuario y contrase�a correctos");
						
						
						//Borrado de ventanas a mano
						Window [] ventanas = Window.getWindows();
						ventanas[ventanas.length-3].dispose();
						ventanas[ventanas.length-4].dispose();

						
						Usuario u = BaseDeDatos.esAdministrador2(usu);
						user = u;
						if(u instanceof Administrador) {
							if( ((Administrador)u).aniadirCancion()) {
								logger.log( Level.INFO, "El administrador: " + u.getNombre() + " ha iniciado sesion correctamente");
								VentanaMain.btnAnadirCancion.setVisible(true);
								VentanaMain.btnEstadisticas.setVisible(true);
							}
						}
					}else if(resul == 2) {
						JOptionPane.showMessageDialog(null,"Contrase�a incorrecta");
					}else if(resul == 3) {
						JOptionPane.showMessageDialog(null,"Usuario no encontrado");
					}
				}	
		}
		});
		
		JPanel panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.CENTER);
		panelBotones.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBotonesUsuarios = new JPanel();
		panelBotones.add(panelBotonesUsuarios, BorderLayout.NORTH);
		
		JLabel lblUsuario = new JLabel("Usuario");
		panelBotonesUsuarios.add(lblUsuario);
		
		infoUsuario = new JTextField();
		panelBotonesUsuarios.add(infoUsuario);
		infoUsuario.setColumns(10);
		
		JPanel panelBotonesContrasena = new JPanel();
		panelBotones.add(panelBotonesContrasena, BorderLayout.CENTER);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		panelBotonesContrasena.add(lblContrasena);
		
		infoContrasena = new JPasswordField();
		panelBotonesContrasena.add(infoContrasena);
			
		setSize(350,150);
		setVisible(true);
	} 	
	
	public static Usuario getUsuario() {
		return user;
		
	}

}
