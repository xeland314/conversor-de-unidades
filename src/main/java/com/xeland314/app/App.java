package com.xeland314.app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.xeland314.conversores.ConversorUniversal;
import com.xeland314.conversores.UnidadBase;
import com.xeland314.conversores.divisas.Dinero;
import com.xeland314.conversores.divisas.Divisa;
import com.xeland314.conversores.divisas.Monedas;
import com.xeland314.conversores.longitud.Longitud;
import com.xeland314.conversores.longitud.UnidadLongitud;
import com.xeland314.conversores.longitud.UnidadesLongitud;
import com.xeland314.conversores.temperatura.Temperatura;
import com.xeland314.conversores.temperatura.UnidadTemperatura;
import com.xeland314.conversores.temperatura.UnidadesTemperatura;
import com.xeland314.conversores.tiempo.Tiempo;
import com.xeland314.conversores.tiempo.UnidadTiempo;
import com.xeland314.conversores.tiempo.UnidadesTiempo;

public class App {

	private JFrame frmConversorDeUnidades;
	private JTextField campoEntrada;
	private JTextField campoResultado;
	private JTextPane panelConversion;
	private JComboBox<String> listaConversiones;
	private JComboBox<String> opcionesUnidadBase;
	private JComboBox<String> opcionesResultado;
	private JButton boton;
	private Font currentFont = new Font("DejaVu Sans", Font.PLAIN, 12);

	private String[] opcionesConversion;
	private boolean hanCargadoLasOpciones;
	public App() {
		initialize();
		opcionesConversion = new String[]{
			"Longitud", "Tiempo", "Temperatura", "Divisa"
		};
		this.hanCargadoLasOpciones = false;
		this.setConversiones();
	}

	public void start() {
		this.frmConversorDeUnidades.setVisible(true);
	}
	
	private void setConversiones() {
		for (String opcion : opcionesConversion) {
			this.listaConversiones.addItem(opcion);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConversorDeUnidades = new JFrame();
		frmConversorDeUnidades.setResizable(false);
		frmConversorDeUnidades.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/resources/Logo_mini.png"));
		frmConversorDeUnidades.setFont(this.currentFont);
		frmConversorDeUnidades.setTitle("Conversor De Unidades");
		frmConversorDeUnidades.setBounds(100, 100, 446, 336);
		frmConversorDeUnidades.setMinimumSize(new Dimension(480, 400));
		frmConversorDeUnidades.setMaximumSize(new Dimension(480, 400));
		frmConversorDeUnidades.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{40, 100, 100, 200, 40};
		gridBagLayout.rowHeights = new int[]{20, 120, 20, 30, 30, 20, 20, 30, 20, 20, 20};
		frmConversorDeUnidades.getContentPane().setLayout(gridBagLayout);

		Component verticalGlue_1 = Box.createVerticalGlue();
		GridBagConstraints gbc_verticalGlue_1 = new GridBagConstraints();
		gbc_verticalGlue_1.anchor = GridBagConstraints.NORTH;
		gbc_verticalGlue_1.gridwidth = 5;
		gbc_verticalGlue_1.insets = new Insets(0, 0, 5, 0);
		gbc_verticalGlue_1.gridx = 0;
		gbc_verticalGlue_1.gridy = 0;
		frmConversorDeUnidades.getContentPane().add(verticalGlue_1, gbc_verticalGlue_1);

		JScrollPane scrollPane = new JScrollPane();
		panelConversion = new JTextPane();
		panelConversion.setEditable(false);
		panelConversion.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
		panelConversion.setForeground(Color.BLUE);
		panelConversion.setAutoscrolls(true);
		panelConversion.enableInputMethods(true);
		scrollPane.setViewportView(panelConversion);
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.gridwidth = 3;
		gbc_textPane.insets = new Insets(0, 0, 5, 5);
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 1;
		gbc_textPane.gridy = 1;
		frmConversorDeUnidades.getContentPane().add(scrollPane, gbc_textPane);

		listaConversiones = new JComboBox<String>();
		listaConversiones.setFont(currentFont);
		listaConversiones.addActionListener(new CambiarOpcionesConversion());
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.gridwidth = 3;
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.fill = GridBagConstraints.BOTH;
		gbc_comboBox_2.gridx = 1;
		gbc_comboBox_2.gridy = 3;
		frmConversorDeUnidades.getContentPane().add(listaConversiones, gbc_comboBox_2);

		campoEntrada = new JTextField();
		campoEntrada.setFont(currentFont);
		campoEntrada.enableInputMethods(true);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 4;
		frmConversorDeUnidades.getContentPane().add(campoEntrada, gbc_textField);
		campoEntrada.setColumns(10);

		opcionesUnidadBase = new JComboBox<String>();
		opcionesUnidadBase.setFont(currentFont);
		opcionesUnidadBase.addActionListener(new CambiarOpcionesResultado());
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.BOTH;
		gbc_comboBox_1.gridx = 3;
		gbc_comboBox_1.gridy = 4;
		frmConversorDeUnidades.getContentPane().add(opcionesUnidadBase, gbc_comboBox_1);

		campoResultado = new JTextField();
		campoResultado.setFont(currentFont);
		campoResultado.setEditable(false);
		campoResultado.enableInputMethods(true);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 5;
		frmConversorDeUnidades.getContentPane().add(campoResultado, gbc_textField_1);
		campoResultado.setColumns(10);

		opcionesResultado = new JComboBox<String>();
		opcionesResultado.setFont(currentFont);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 5;
		frmConversorDeUnidades.getContentPane().add(opcionesResultado, gbc_comboBox);

		boton = new JButton();
		boton.setFont(currentFont);
		boton.setHorizontalAlignment(SwingConstants.CENTER);
		boton.setText("Calcular");
		boton.addActionListener(new ConvertirButtonListener());
		GridBagConstraints gbc_lblFrmula = new GridBagConstraints();
		gbc_lblFrmula.gridwidth = 3;
		gbc_lblFrmula.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFrmula.insets = new Insets(0, 0, 5, 5);
		gbc_lblFrmula.gridx = 1;
		gbc_lblFrmula.gridy = 7;
		frmConversorDeUnidades.getContentPane().add(boton, gbc_lblFrmula);

		JLabel lblCreditos = new JLabel("Desarrollado por xeland314");
		lblCreditos.setFont(new Font("DejaVu Sans", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 9;
		frmConversorDeUnidades.getContentPane().add(lblCreditos, gbc_lblNewLabel);

		Component verticalGlue = Box.createVerticalGlue();
		GridBagConstraints gbc_verticalGlue = new GridBagConstraints();
		gbc_verticalGlue.gridwidth = 5;
		gbc_verticalGlue.gridx = 0;
		gbc_verticalGlue.gridy = 10;
		frmConversorDeUnidades.getContentPane().add(verticalGlue, gbc_verticalGlue);
	}

    private class ConvertirButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
			String input = (String) campoEntrada.getText();
			String conversion = (String) listaConversiones.getSelectedItem();
			String unidadEntrada = (String) opcionesUnidadBase.getSelectedItem();
			String unidadSalida = (String) opcionesResultado.getSelectedItem();
			if(unidadSalida.isBlank() || unidadSalida.isEmpty()) {
				return;
			}
			if(conversion.equals("Longitud")) {
				UnidadLongitud unidad = (UnidadLongitud) ConversorUniversal.getUnidad(unidadEntrada, conversion);
				UnidadLongitud unidad2 = (UnidadLongitud) ConversorUniversal.getUnidad(unidadSalida, conversion);
				try {
					Longitud entrada = new Longitud(input, unidad);
					Longitud salida = ConversorUniversal.convertir(entrada, unidad2);
					campoResultado.setText(salida.getValorFormateado().toPlainString());
					panelConversion.setText(
						String.format("%s =\n%s", entrada.toString(), salida.toString())
					);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (conversion.equals("Tiempo")) {
				UnidadTiempo unidad = (UnidadTiempo) ConversorUniversal.getUnidad(unidadEntrada, conversion);
				UnidadTiempo unidad2 = (UnidadTiempo) ConversorUniversal.getUnidad(unidadSalida, conversion);
				try {
					Tiempo entrada = new Tiempo(input, unidad);
					Tiempo salida = ConversorUniversal.convertir(entrada, unidad2);
					campoResultado.setText(salida.getValorFormateado().toPlainString());
					panelConversion.setText(
						String.format("%s =\n%s", entrada.toString(), salida.toString())
					);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (conversion.equals("Temperatura")) {
				UnidadTemperatura unidad = (UnidadTemperatura) ConversorUniversal.getUnidad(unidadEntrada, conversion);
				UnidadTemperatura unidad2 = (UnidadTemperatura) ConversorUniversal.getUnidad(unidadSalida, conversion);
				try {
					Temperatura entrada = new Temperatura(input, unidad);
					Temperatura salida = ConversorUniversal.convertir(entrada, unidad2);
					campoResultado.setText(salida.getValorFormateado().toPlainString());
					panelConversion.setText(
						String.format("%s =\n%s", entrada.toString(), salida.toString())
					);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if (conversion.equals("Divisa")) {
				Divisa divisa = (Divisa) ConversorUniversal.getUnidad(unidadEntrada, conversion);
				Divisa divisa2 = (Divisa) ConversorUniversal.getUnidad(unidadSalida, conversion);
				try {
					Dinero entrada = new Dinero(input, divisa);
					Dinero salida = ConversorUniversal.convertir(entrada, divisa2);
					campoResultado.setText(salida.getValorFormateado().toPlainString());
					panelConversion.setText(
						String.format("%s =\n%s", entrada.toString(), salida.toString())
					);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
        }
    }

	private class CambiarOpcionesConversion implements ActionListener {

		private void clearInputs() {
			opcionesUnidadBase.removeAllItems();
			opcionesResultado.removeAllItems();
			campoEntrada.setText("");
			campoResultado.setText("");
			panelConversion.setText("");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			hanCargadoLasOpciones = false;
			String seleccion = (String) listaConversiones.getSelectedItem();
			this.clearInputs();
			if (seleccion.equals("Longitud")) {
				for (UnidadesLongitud unidad : UnidadesLongitud.values()) {
					opcionesUnidadBase.addItem(unidad.get().getNombre());
				}
			} else if (seleccion.equals("Tiempo")) {
				for (UnidadesTiempo unidad : UnidadesTiempo.values()) {
					opcionesUnidadBase.addItem(unidad.get().getNombre());
				}
			} else if (seleccion.equals("Temperatura")) {
				for (UnidadesTemperatura unidad : UnidadesTemperatura.values()) {
					opcionesUnidadBase.addItem(unidad.get().getNombre());
				}
			} else if (seleccion.equals("Divisa")) {
				for (Monedas divisa : Monedas.values()) {
					opcionesUnidadBase.addItem(divisa.get().getNombre());
				}
			}
			hanCargadoLasOpciones = true;
		}
	}

	private class CambiarOpcionesResultado implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(!hanCargadoLasOpciones) {
				return;
			}
			String seleccionConversion = (String) listaConversiones.getSelectedItem();
			String seleccionUnidad = (String) opcionesUnidadBase.getSelectedItem();
			opcionesResultado.removeAllItems();
			UnidadBase unidad = null;
			if (seleccionConversion.equals("Longitud")) {
				unidad = (UnidadLongitud) ConversorUniversal.getUnidad(seleccionUnidad, seleccionConversion);
			} else if (seleccionConversion.equals("Tiempo")) {
				unidad = (UnidadTiempo) ConversorUniversal.getUnidad(seleccionUnidad, seleccionConversion);
			} else if (seleccionConversion.equals("Temperatura")) {
				unidad = (UnidadTemperatura) ConversorUniversal.getUnidad(seleccionUnidad, seleccionConversion);
			} else if (seleccionConversion.equals("Divisa")) {
				unidad = (Divisa) ConversorUniversal.getUnidad(seleccionUnidad, seleccionConversion);
			}
			Set<String> posiblesConversiones = unidad.getListaDePosiblesConversiones();
			for (String conversion : posiblesConversiones) {
				opcionesResultado.addItem(conversion);
			}
		}
	}

}
