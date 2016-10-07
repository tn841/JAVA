package swing;

import java.awt.EventQueue;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JTree;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class JListFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JListFrame frame = new JListFrame();
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
	public JListFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 12, 179, 231);
		contentPane.add(scrollPane);
		
		JTree tree = new JTree();
		scrollPane.setViewportView(tree);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(83, 129, 127, 24);
		contentPane.add(comboBox);
		
		JSlider slider = new JSlider();
		slider.setBounds(149, 279, 200, 23);
		contentPane.add(slider);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(272, 171, 146, 14);
		contentPane.add(progressBar);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(331, 197, 87, 24);
		contentPane.add(spinner);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(355, 327, 50, 24);
		contentPane.add(formattedTextField);
		
		JList list = new JList();
		list.setBounds(382, 40, 94, 181);
		contentPane.add(list);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
			}
		});
		list.setModel(new AbstractListModel() {
			String[] values = new String[]{"梯熱團", "檜熱團", "夢熱團"};

			@Override
			public int getSize() {
				return values.length;
			}

			@Override
			public Object getElementAt(int index) {
				return values[index];
			}
			
		});
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(523, 36, 34, 167);
		contentPane.add(scrollBar);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(348, 129, 20, 1);
		contentPane.add(horizontalStrut);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(207, 129, 1, 1);
		contentPane.add(horizontalBox);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("New JGoodies label");
		lblNewJgoodiesLabel.setBounds(149, 333, 219, 81);
		contentPane.add(lblNewJgoodiesLabel);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(66, 421, 283, 23);
		contentPane.add(comboBox_1);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		rigidArea.setBounds(431, 279, 177, 20);
		contentPane.add(rigidArea);
	}
}
