import java.awt.*;
import javax.swing.*;

import java.awt.event.*;


public class Fenetre extends JFrame {
	
	//declaration de notre panneau principal
	private JPanel premierPanel = new JPanel(new BorderLayout());
		
	//declaration d'un carde layout pour gerer nos defferents panneaux
	private CardLayout card = new CardLayout();
	
	//declartion des de l'objet panneau de notre application
	private Panneau pan = new Panneau();
	
	//declaration de la variable qui va gerer le livre des requetes
	RequestBook livre = new RequestBook();
	
	//declaration des variables pour notre menu
	private String[] nomItem1 = {"Nouveau projet","Ouvrir un projet","anregistrer","anregistrer sou...","importer un projet","proprieter","Sortir"};
	private String[] nomItem2 = {"undo","reundo","rechercher","copie","coller","effacer","remplacer"};
	private String[] nomItem3 = {"rechercher"};
	private String[] nomItem4 = {"aide","manuel d'utilisateur",};
	private String[] nomItem5 = {"licence du programme","a propos du concepteur"};
	private  JMenuBar menu = new JMenuBar();
	private JMenu ficher,editer,rechercher,aide,apropos;
	private JMenuItem[] item = new JMenuItem[nomItem1.length];
	private JMenuItem[] item1 = new JMenuItem[nomItem2.length];
	private JMenuItem[] item2 = new JMenuItem[nomItem3.length];
	private JMenuItem[] item3 = new JMenuItem[nomItem4.length];
	private JMenuItem[] item4 = new JMenuItem[nomItem5.length];
	private String[] nomList = {"Nouveau","Enregistrer","Rechercher","Editer","Supprimer"};
	private JButton[] bouton = new JButton[nomList.length];
	

	
	 
	
	public Fenetre()
	{
		premierPanel.setBackground(Color.white);
		
		this.setTitle("Gestion des visiteurs");
		
		this.setSize(1000,600);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLocationRelativeTo(null);
		
		this.setResizable(false);
		
		//methode pour l;initialisation de nos composant
		initComp();
		
		this.getContentPane().add(premierPanel);
						
		this.setVisible(true);
		
		
	}
	
	public void initComp()
	{
			//delcaration de l'instanche ficher pour mettre nos elements
			ficher = new  JMenu("Ficher");

			//ajout de chaque element dans notre objet menu
			//ficher.add(item[i]);
			
			footer(ficher,nomItem1,item);
		
			//declaration de l'instance editer pour nos elements
			editer = new JMenu("Editer");

			//editer.add(item1[i]);
			footer(editer,nomItem2,item1);
			
		
		
			//declaration de l'instance rechercher pour nos elements
			rechercher = new JMenu("Rechercher");
	
			//ajou de l'ement dans notre objet
			footer(rechercher,nomItem3,item2);
			
			aide = new JMenu("aide");
			//ajou de l'ement dans notre objet
			footer(aide,nomItem4,item3);
				
			//declaration de l'instance rechercher pour nos elements
			apropos = new JMenu("a propos");
				
			//ajou de l'ement dans notre objet
			footer(apropos,nomItem5,item4);
			
			JPanel panier = pan.enregistreVisiteur();
			panier.setBackground(Color.white);

			/*for(int i = 0; i < nomList.length; i++)
			{
				bouton[i] = new JButton(nomList[i]);
				panier.add(bouton[i]);
				
			}*/
			panier.setBorder(BorderFactory.createLineBorder(Color.black));			
			premierPanel.add(panier);
			
			
			/*
			 * partie reserver pour mettre les composant dans le cardLAyout
			 * por pouvoir les afficher sans auun prbleme 
			 * 
			 */
			
			evenment(item[1], premierPanel, nomItem1[1]);
			
				
		/*
		 * Ajout ddes composant du menu dans le menu bar et initialisation du menu bar
		*/
			menu.add(ficher);
					
			menu.add(editer);
					
			menu.add(rechercher);
					
			menu.add(aide);
					
			menu.add(apropos);
					
			this.setJMenuBar(menu);
					
		
					
			item[6].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
						System.exit(0);
					}
				});				
		
			}

	
	void footer(JMenu menu, String[] nom, JMenuItem[] menuIt)
			{
				for(int i = 0; i < nom.length; i++)
				{
					
					menuIt[i] =new JMenuItem(nom[i]);
							
					if(i %2 == 0 && i != 0)
						menu.addSeparator();
					
					menu.add(menuIt[i]);
			
				}
				
			}
			
			public void evenment(JMenuItem item, final JPanel pa, final String nom)
			{
				
				item.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
							
						card.show(pa, nom);
							
						}
					});
				
				
			}
			

			//la classe intern pour lancer le projet
			class projetListener implements ActionListener{
				public void actionPerformed(ActionEvent e){
					
				}
			}
			
			//la classe intern pour les recherche
			class RechercheListener implements ActionListener{
				public void actionPerformed(ActionEvent e){
					
				}
			}
			
		

			
}