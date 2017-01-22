import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;



public class Panneau extends JPanel{
	
	//declaration des variables pour la gestion des visiteurs
	private ImageIcon img;
	private JLabel nom = new JLabel("Nom"), prenom = new JLabel("Prenom"),adresse = new JLabel("Adresse"), telephone = new JLabel("Telephone");
	private JLabel nc = new JLabel(""), pc = new JLabel(""), ac = new JLabel(""), tc = new JLabel(""), cc = new JLabel(""), icon = new JLabel("",JLabel.CENTER) ;
	private JTextField tno = new JTextField("nom"), tpr = new JTextField("prenom"), tad  = new JTextField(""), tte = null,f=null, tCode = new JTextField();
	private JFormattedTextField au = new JFormattedTextField(NumberFormat.getIntegerInstance());
	private JFormattedTextField entre = new JFormattedTextField(NumberFormat.getIntegerInstance());
	private JTable table1, table2;
	private Object[][] champ1, champ2;
	private String[] nomAdhe = {"Code","Nom","Prenom","Adresse","Telephone","Date courante"};
	private JButton[] btn;
	private  JCheckBox box1 = new JCheckBox("ID"),box2 = new JCheckBox("CODE");
	private JOptionPane opt;
	private JPanel information = new JPanel(new GridLayout(5,5,0,0));
	int id;
	
	
	public Panneau(){
		
		System.out.println("Initialisation de notre panneau");
		
	}
	
	
	//methode pour creer un adherent et interface graphique inclue
	public JPanel enregistreVisiteur()
	{

		//declartion des panneaux pour la partie creer un adherent
		//des autre panneaux aussi
		JPanel pano = new JPanel(new BorderLayout());color(pano,false);
		JPanel form = new JPanel(new GridLayout(1,2));
		JPanel panBout = new JPanel(new FlowLayout());
		JPanel panEst = new JPanel(new GridLayout(8,1));
		JPanel panInfo= new JPanel(new GridLayout(4,8));panInfo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Information sur le visiteur", TitledBorder.CENTER, TitledBorder.TOP));
		JPanel panIco = new JPanel(new BorderLayout());
		JButton tn = new JButton("Visiteur present");
		
		try{
			 MaskFormatter t1 = new MaskFormatter("+509-##-##-####");
			
			 tte = new JFormattedTextField(t1);

		
		}catch(ParseException x){
			
			System.out.println("Erreur de saisi: "+x.getMessage());
		}
		
		Font fon = new Font("Serif", Font.BOLD, 18);
		
		
			
		//ajout des composants pour l'enregistrement
		panInfo.add(nom);panInfo.add(tno);
		panInfo.add(prenom);panInfo.add(tpr);
		panInfo.add(telephone);panInfo.add(tte);
		panInfo.add(adresse);panInfo.add(tad);color(panInfo,false);
		
		//espace pour selectioner la photo de l'adherent
		panIco.setBackground(Color.white);
		JPanel x = new JPanel(new BorderLayout());color(x,false);
		JPanel y = new JPanel();color(y,false);
		x.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Visiteur present", TitledBorder.CENTER, TitledBorder.TOP));
		y.add(tn);
		entre.setPreferredSize(new Dimension(50,50));
		entre.setHorizontalAlignment(JTextField.CENTER);
		entre.setFont(fon);
		
		x.add(entre, BorderLayout.NORTH);
		x.add(y, BorderLayout.SOUTH);
		panIco.add(x, BorderLayout.CENTER);
		
		//ajout de la partie centre  charger de lister les adherents enregistrer
		//dans notre base de donner et tout
		
		champ1 = new Object[50][6];
		table1 = new JTable(champ1, nomAdhe);
		
		//ajout des bouton dans la clause des action propres aux adherets
		btn = new JButton[7];
		btn[0] = new JButton("effacer");
		btn[1] = new JButton("Lister");
		btn[2] = new JButton("enregistrer");
		
		for(int i = 0; i < 3; i++)
			panBout.add(btn[i]);color(panBout,true);
		
		form.add(panInfo);
		form.add(panIco);
		
		
		
		/**
		 * 
		 * Partie reserver pour les gestion d'evenements dans la clause de gestion d'adherent
		 * avec les boutons declarer si dessus
		 * 
		 */
		//pour nettroyer les champs a toute heure
		btn[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				nouveau(tno,tpr,tad,tte,null,null,null);
				
			}
		});
		
		//pour tout afficher consernat les adhents  inscris
		btn[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
//				afficher(table1,champ1,nomAdhe,db.resultat(adhe.selection()));
				
			}
		});
		
		//pour faire les enregistrement des adherents
		btn[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String code = "AD53X-63";
				
			}
			
		});
		
		
		
		pano.add(form, BorderLayout.NORTH);
		pano.add(panBout, BorderLayout.SOUTH);
		
		pano.add(new JScrollPane(table1), BorderLayout.CENTER);
		
		return pano;
	}
	
	
	public void color(JPanel pan, Boolean val)
	{
		if(val)
		{
			pan.setBackground(Color.white);
			pan.setBorder(BorderFactory.createLineBorder(Color.black));
		}else
			pan.setBackground(Color.white);
		
		
	}
	
	public void nouveau(JTextField t1, JTextField t2, JTextField t3, JTextField t4, JTextField t5, JTextField t6, JTextField t7)
	{
		try{
		t1.setText("");t2.setText("");t3.setText("");t4.setText("");t5.setText("");t6.setText("");t7.setText("");
		tte.setText("+509");
		}catch(NullPointerException e){
			System.out.println("Obet non initialiser");
		}
	}
	
	

}
