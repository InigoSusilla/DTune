import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;

public class VentanaPrintCarrito extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrintCarrito frame = new VentanaPrintCarrito();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrintCarrito() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel PanelPagar = new JPanel();
		contentPane.add(PanelPagar, BorderLayout.WEST);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setForeground(Color.GREEN);
		btnPagar.setBackground(Color.RED);
		PanelPagar.add(btnPagar);
		
		JPanel PanelVolver = new JPanel();
		contentPane.add(PanelVolver, BorderLayout.EAST);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(Color.GREEN);
		PanelVolver.add(btnVolver);
		
		JPanel PanelCancelar = new JPanel();
		contentPane.add(PanelCancelar, BorderLayout.CENTER);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.GREEN);
		PanelCancelar.add(btnCancelar);
		
		setSize(300, 100);
	}

}
