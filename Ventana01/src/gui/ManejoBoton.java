package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ManejoBoton implements ActionListener {

	private JTextField txtNombre, txtApellido, txtFechaNacimiento, txtProfesion;
	
	public ManejoBoton(JTextField txtNombre, JTextField txtApellido, JTextField txtFechaNacimiento, JTextField txtProfesion) {
		this.txtNombre = txtNombre;
		this.txtApellido = txtApellido;
		this.txtFechaNacimiento = txtFechaNacimiento;
		this.txtProfesion = txtProfesion;
	}
	
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
