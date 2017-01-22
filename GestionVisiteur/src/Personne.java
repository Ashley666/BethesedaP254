import javax.swing.JTextField;


public class Personne {
	
	private String nom;
	
	private String prenom;
	
	private String adresse;
	
	private int telephone;

	public Personne(String nom, String prenom, String adresse, int telephone) {
		
		this.nom = nom;
		
		this.prenom = prenom;
		
		this.adresse = adresse;
		
		this.telephone = telephone;
		
	}

	public String getNom() {
		
		return nom;
		
	}

	public void setNom(String nom){
		
		this.nom = nom;
		
	}

	public String getPrenom() {
		
		return prenom;
		
	}

	public void setPrenom(String prenom) {
		
		this.prenom = prenom;
		
	}

	public String getAdresse() {
		
		return adresse;
		
	}

	public void setAdresse(String adresse) {
		
		this.adresse = adresse;
		
	}

	public int getTelephone() {
		
		return telephone;
		
	}

	public void setTelephone(int telephone) {
		
		this.telephone = telephone;
		
	}
	
	public void getNom(JTextField nom){
		
		this.nom = nom.getText();
		
	}
	
	public void getPrenom(JTextField prenom){
		
		this.prenom = prenom.getText();
		
	}
	
	public void getAdresse(JTextField adresse){
		
		this.adresse = adresse.getText();
		
	}
	
	public void getTelephone(JTextField telephone){
		
		this.telephone = Integer.valueOf(telephone.getText().toString());//telephone.getText();
		
	}
	
	
	
	
	
}
