package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.Controlador;
import exceptions.HabitacionException;
import exceptions.HuespedException;
import exceptions.ReservaException;
import views.HabitacionView;
import views.HuespedView;

public class VentanaPrincipal extends JFrame{
	
	private JButton btnverificarHuesped,btnregistrarHuesped,btnreservar,btnverificarHabitacionesDisponibles,btnagregarHabitacionAReserva,btncobrarSeña,btntomarReserva,btncancelarReserva,btncumplidaReserva,btnvencidaReserva;
	private JPanel panel1,panel2;
	
	public VentanaPrincipal() {
		configurar();
		eventos();
		this.setVisible(true);
		//this.pack();
		//this.setLocation(300,300);
	}


	private void eventos() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		btnverificarHuesped.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				JLabel lbldoc=new JLabel("Documento");
				JTextField txt=new JTextField();
				JButton buscar= new JButton("Buscar");
				
				panel2.setLayout(new GridLayout(1,3));
				panel2.add(lbldoc);
				panel2.add(txt);
				panel2.add(buscar);
				
				panel2.revalidate(); // Revalidar el panel2 para actualizar el diseño
	            panel2.repaint(); // Repintar el panel2 para mostrar los cambios
				
				buscar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							String respuesta= Controlador.getInstancia().verificarHuesped(Integer.parseInt(txt.getText()));
							
							JOptionPane.showMessageDialog(null,respuesta );
							
						} catch (NumberFormatException | HuespedException | ParseException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
						panel2.removeAll();
						panel2.revalidate(); // Revalidar el panel2 para actualizar el diseño
			            panel2.repaint(); // Repintar el panel2 para mostrar los cambios
						
					}
				});
				
				
			}
		});
		
		btnregistrarHuesped.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				JLabel lblnom=new JLabel("Nombre");
				JTextField txt1=new JTextField();
				JLabel lblap=new JLabel("Apellido");
				JTextField txt2=new JTextField();
				JLabel lbldoc=new JLabel("Documento");
				JTextField txt3=new JTextField();
				JButton Registrar= new JButton("Registrar");
				
				panel2.setLayout(new GridLayout(4,2));
				
				panel2.add(lblnom);
				panel2.add(txt1);
				panel2.add(lblap);
				panel2.add(txt2);
				panel2.add(lbldoc);
				panel2.add(txt3);
				panel2.add(new JLabel());
				panel2.add(Registrar);
				
				panel2.revalidate(); // Revalidar el panel2 para actualizar el diseño
	            panel2.repaint(); // Repintar el panel2 para mostrar los cambios
	            
	            Registrar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						try {
							Controlador.getInstancia().registrarHuesped(txt1.getText(), txt2.getText(), Integer.parseInt(txt3.getText()));
							JOptionPane.showMessageDialog(null,"Registrado!" );
							panel2.removeAll();
						} catch (NumberFormatException | ParseException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
						panel2.removeAll();
						panel2.revalidate(); // Revalidar el panel2 para actualizar el diseño
			            panel2.repaint(); // Repintar el panel2 para mostrar los cambios
						
					}
				});
				
			}
		});
		
		btnreservar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				
				panel2.setLayout(new GridLayout(4,2));
				
				JLabel lbldoc=new JLabel("Documento");
				JComboBox<HuespedView> box=new JComboBox<HuespedView>();
				List<HuespedView> huespedes = null;
				try {
					huespedes = Controlador.getInstancia().getHuespedes();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				}
				for(HuespedView h:huespedes) {
					box.addItem(h);
				}
				JLabel lblfechi=new JLabel("Fecha in");
				JTextField txt2=new JTextField();
				JLabel lbldias=new JLabel("Dias");
				JTextField txt3=new JTextField();
				JButton Reservar= new JButton("Registrar");
				
				panel2.add(lbldoc);
				panel2.add(box);
				panel2.add(lblfechi);
				panel2.add(txt2);
				panel2.add(lbldias);
				panel2.add(txt3);
				panel2.add(new JLabel());
				panel2.add(Reservar);
				
				panel2.revalidate(); // Revalidar el panel2 para actualizar el diseño
	            panel2.repaint(); // Repintar el panel2 para mostrar los cambios
	            
	            Reservar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int id = 0;
						try {
							id = Controlador.getInstancia().reservar(((HuespedView)box.getSelectedItem()).getDocumento(), txt2.getText(), Integer.parseInt(txt3.getText()));
						} catch (NumberFormatException | HuespedException | ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "su id de reserva es: "+id);
						panel2.removeAll();
						panel2.revalidate(); // Revalidar el panel2 para actualizar el diseño
			            panel2.repaint(); // Repintar el panel2 para mostrar los cambios
						
					}
				});
				
			}
		});
		
		btnverificarHabitacionesDisponibles.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				panel2.setLayout(new GridLayout(4,2));
				JLabel tipo= new JLabel("Tipo");
				JComboBox<String> tipos= new JComboBox<String>();
				tipos.addItem("simple");
				tipos.addItem("matrimonial");
				tipos.addItem("doble");
				JLabel fechai= new JLabel("Fecha in");
				JTextField txtFechai=  new JTextField();
				JLabel fechao= new JLabel("Fecha out");
				JTextField txtFechao=  new JTextField();
				JButton Verificar=new JButton("Buscar");
				panel2.add(tipo);
				panel2.add(tipos);
				panel2.add(fechai);
				panel2.add(txtFechai);
				panel2.add(fechao);
				panel2.add(txtFechao);
				panel2.add(new JLabel());
				panel2.add(Verificar);
				panel2.revalidate(); // Revalidar el panel2 para actualizar el diseño
	            panel2.repaint(); // Repintar el panel2 para mostrar los cambios
				Verificar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							List<HabitacionView> habitaciones=Controlador.getInstancia().verificarHabitacionesDisponibles((String)tipos.getSelectedItem(),txtFechai.getText(),txtFechao.getText());
							if(habitaciones.size()==0) {
								JOptionPane.showMessageDialog(null, "NO hay habitaciones disponibles entre esas fechas de ese tipo");
							}
							else {
						
							String s = null;
							for(HabitacionView h:habitaciones) {
								s+=h.isEstado()+" "+h.getPiso()+" "+h.getTipo()+" "+h.getPrecio();
							}
							JOptionPane.showMessageDialog(null, s);
							}
						} catch (ParseException e1) {
							JOptionPane.showMessageDialog(null, e1);
						}
						panel2.revalidate(); // Revalidar el panel2 para actualizar el diseño
			            panel2.repaint(); // Repintar el panel2 para mostrar los cambios
						
					}
				});
				
				
			}
		});
		btnagregarHabitacionAReserva.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel2.removeAll();
				panel2.setLayout(new GridLayout(3,2));
				JLabel lblNumero=new JLabel("Numero Habitacion");
				JTextField txt1= new JTextField();
				JLabel lblId= new JLabel("Id Reserva");
				JTextField txt2= new JTextField();
				JButton agregar=new JButton("Agregar");
				panel2.add(lblNumero);
				panel2.add(txt1);
				panel2.add(lblId);
				panel2.add(txt2);
				panel2.add(new JLabel());
				panel2.add(agregar);
				
				panel2.revalidate();
				panel2.repaint();
				
				agregar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							Controlador.getInstancia().agregarHabitacionAReserva(Integer.parseInt(txt1.getText()), Integer.parseInt(txt2.getText()));
							JOptionPane.showMessageDialog(null, "Agregado");
						} catch (NumberFormatException | ReservaException | HabitacionException | ParseException e1) {
							JOptionPane.showMessageDialog(null, e1);
						}
						panel2.removeAll();
						panel2.revalidate();
						panel2.repaint();
						
						
					}
				});
			}
		});
		
	}


	private void configurar() {
		Container c=this.getContentPane();
		c.setLayout(new GridLayout(2,1));
		panel1= new JPanel();
		panel2= new JPanel();
		
		panel1.setLayout(new GridLayout(2,5));
		btnverificarHuesped=new JButton("Verificar Huesped");
		btnregistrarHuesped= new JButton("Registrar Huesped");
		btnreservar= new JButton ("Reservar");
		btnverificarHabitacionesDisponibles= new JButton("Verificar Habitaciones Disponibles");
		btnagregarHabitacionAReserva= new JButton("Agregar Habitacion A Reserva");
		btncobrarSeña= new JButton("Cobrar Seña");
		btntomarReserva= new JButton("Tomar Reserva");
		btncancelarReserva=new JButton("Cancelar Reserva");
		btncumplidaReserva= new JButton("Cumplida Reserva");
		btnvencidaReserva= new JButton("Vencida Reserva");
		panel1.add(btnverificarHuesped);
		panel1.add(btnregistrarHuesped);
		panel1.add(btnreservar);
		panel1.add(btnverificarHabitacionesDisponibles);
		panel1.add(btnagregarHabitacionAReserva);
		panel1.add(btncobrarSeña);
		panel1.add(btntomarReserva);
		panel1.add(btncancelarReserva);
		panel1.add(btncumplidaReserva);
		panel1.add(btnvencidaReserva);
		c.add(panel1);
		c.add(panel2);
		
	}
}
