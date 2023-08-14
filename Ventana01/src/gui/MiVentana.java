package gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MiVentana extends JFrame {
	
	private JLabel lblNombre, lblApellido, lblFechaNacimiento, lblProfesion;
	private JTextField txtNombre, txtApellido, txtFechaNacimiento, txtProfesion;
	private JButton btnAceptar, btnBorrar;
	
	public MiVentana() {
	
		configurar();
		eventos();
		this.setVisible(true);
		this.pack();
		this.setLocation(100, 100);
	}

	private void configurar() {
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(5,2));
		lblNombre = new JLabel("Nombre");
		lblApellido = new JLabel("Apellido");
		lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblProfesion = new JLabel("Profesion");
		txtNombre = new JTextField();
		txtApellido = new JTextField();
		txtFechaNacimiento = new JTextField();
		txtProfesion = new JTextField();
		btnAceptar = new JButton("Aceptar");
		btnBorrar = new JButton("Borrar");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		panel.add(btnAceptar);
		panel.add(btnBorrar);
		c.add(lblNombre);
		c.add(txtNombre);
		c.add(lblApellido);
		c.add(txtApellido);
		c.add(lblFechaNacimiento);
		c.add(txtFechaNacimiento);
		c.add(lblProfesion);
		c.add(txtProfesion);
		c.add(new JLabel());
		c.add(panel);
	}

	private void eventos() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//ManejoBoton mb = new ManejoBoton(txtNombre, txtApellido, txtFechaNacimiento, txtProfesion);
		ManejoBotonesInterna mb = new ManejoBotonesInterna();
		btnAceptar.addActionListener(mb);
		//btnBorrar.addActionListener(mb);
		btnBorrar.addActionListener(new ManejoBotonesInterna());
		
	}
	
	class ManejoBotonesInterna implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent boton) {
			if(boton.getActionCommand().equals("Borrar")) {
				txtNombre.setText("");
				txtApellido.setText("");
				txtFechaNacimiento.setText("");
				txtProfesion.setText("");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Se Aceptaron los datos");
			}
		}
		
		
	}

}
