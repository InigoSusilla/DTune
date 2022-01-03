import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class VentanaIniciarSesion extends JFrame {


	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField infoUsuario;
	private JTextField txtContrasea;
	private JTextField infoContrasena;
	private static Usuario user;


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
					JOptionPane.showMessageDialog(null,"El nombre y/o la contraseņa esta vacio");
				}else {
					int resul = BaseDeDatos.comprobacionUsuario(usu, cont);
					if (resul == 1) {
						JOptionPane.showMessageDialog(null, "Usuario y contraseņa correctos");
						/*if(BaseDeDatos.esAdministrador(usu) ) {
							if( ((Administrador)usu) )
								VentanaMain.btnAnadirCancion.setVisible(true);
						}*/
						Usuario u = BaseDeDatos.esAdministrador2(usu);
						user = u;
						if(u instanceof Administrador) {
							if( ((Administrador)u).aniadirCancion()) {
								VentanaMain.btnAnadirCancion.setVisible(true);
							}
						}
					}else if(resul == 2) {
						JOptionPane.showMessageDialog(null,"Contraseņa incorrecta");
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
		
		txtUsuario = new JTextField();
		txtUsuario.setEditable(false);
		txtUsuario.setText("Usuario");
		panelBotonesUsuarios.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		infoUsuario = new JTextField();
		panelBotonesUsuarios.add(infoUsuario);
		infoUsuario.setColumns(10);
		
		JPanel panelBotonesContrasena = new JPanel();
		panelBotones.add(panelBotonesContrasena, BorderLayout.CENTER);
		
		txtContrasea = new JTextField();
		txtContrasea.setEditable(false);
		txtContrasea.setText("Contrase\u00F1a");
		panelBotonesContrasena.add(txtContrasea);
		txtContrasea.setColumns(10);
		
		infoContrasena = new JTextField();
		panelBotonesContrasena.add(infoContrasena);
		infoContrasena.setColumns(10);
			
		setSize(350,150);
		setVisible(true);
	} 	
	
	public static Usuario getUsuario() {
		return user;
		
	}

}
