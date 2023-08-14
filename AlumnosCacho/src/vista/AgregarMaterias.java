package vista;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controlador.Controlador;
import exceptions.AlumnoException;
import exceptions.MateriaException;
import views.AlumnoView;
import views.MateriaView;

public class AgregarMaterias extends JFrame {

	private static final long serialVersionUID = 1436868563480765780L;
	private JLabel lblAlumno, lblMateria;
	private JComboBox<AlumnoView> cboAlumnos;
	private JComboBox<MateriaView> cboMaterias;
	private JButton btnAgregar, btnSalir, btnBorrar;
	
	
	public AgregarMaterias() {
		construyoInterface();
		manejoEventos();
		this.setVisible(true);
		this.setSize(320, 200);
	}


	private void construyoInterface() {
		Container c = this.getContentPane();
		c.setLayout(null);
		
		lblAlumno = new JLabel("Alumnos");
		lblAlumno.setBounds(20, 10, 100, 30);
		lblMateria = new JLabel("Materias");
		lblMateria.setBounds(20, 60, 100, 30);
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(20, 110, 80, 30);
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(110, 110, 80, 30);
		btnSalir  = new JButton("Salir");
		btnSalir.setBounds(200, 110, 80, 30);
		cboAlumnos = new JComboBox<AlumnoView>();
		cboAlumnos.setBounds(130, 10, 150, 30);
		cboMaterias = new JComboBox<MateriaView>();
		cboMaterias.setBounds(130, 60, 150, 30);
		
		List<MateriaView> materias = Controlador.getInstancia().getMaterias();
		for(MateriaView mv : materias)
			cboMaterias.addItem(mv);
		
		List<AlumnoView> alumnos = Controlador.getInstancia().getAlumno();
		for(AlumnoView av : alumnos)
			cboAlumnos.addItem(av);
		
		c.add(cboAlumnos);
		c.add(btnAgregar);
		c.add(btnBorrar);
		c.add(btnSalir);
		c.add(lblAlumno);
		c.add(lblMateria);
		c.add(cboMaterias);
	}

	private void manejoEventos() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MateriaView materia = (MateriaView)cboMaterias.getSelectedItem();
				AlumnoView alumno = (AlumnoView) cboAlumnos.getSelectedItem();
				/*
				 * esto lo descomento para que se lance la excepcion ya que por defecto
				 * todos los elementos de la lista desplegable deberian existir como objetos
				 * 
				 * alumno.setNumero(999);
				 *
				*/
				try {
					Controlador.getInstancia().agregarMateriaAlumno(alumno.getNumero(), materia.getCodigo());
				} catch (AlumnoException | MateriaException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				cboMaterias.setSelectedIndex(0);
				cboAlumnos.setSelectedIndex(0);
			}
		});
		
		btnBorrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cboMaterias.setSelectedIndex(0);
				cboAlumnos.setSelectedIndex(0);
			}
		});
	}
}
