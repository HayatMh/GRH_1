package administrationModel;

public class Employee {

	private int Matricule,ResteConge;
	private String Nom,Prenom,Departement,Adresse,DateNaiss,Email,Occupation;
	private double Salaire ;
	
	public Employee() {};
	
	public Employee(String nom, String prenom, String departement,String occupation, String adresse,String dateNaiss, String email ,
			double salaire, int resteConge) {
		super();
		if(resteConge<=18)
		ResteConge = resteConge;
		else ResteConge = 0;
		Nom = nom;
		Prenom = prenom;
		Departement = departement;
		Adresse = adresse;
		Occupation = occupation;
		DateNaiss = dateNaiss;
		Email = email;
		Salaire = salaire;
	}
	
	

	public Employee(int matricule, String nom, String prenom, String departement,String occupation, String adresse,String dateNaiss, String email ,
			double salaire, int resteConge) {
		super();
		Matricule = matricule;
		if(resteConge<18)
		ResteConge = resteConge;
		else ResteConge = 0;
		Nom = nom;
		Prenom = prenom;
		Departement = departement;
		Occupation = occupation;
		Adresse = adresse;
		DateNaiss = dateNaiss;
		Email = email;
		Salaire = salaire;
	}
	

	public int getMatricule() {
		return Matricule;
	}

	public void setMatricule(int matricule) {
		Matricule = matricule;
	}

	public int getResteConge() {
		return ResteConge;
	}

	public void setResteConge(int resteConge) {
		ResteConge = resteConge;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getDepartement() {
		return Departement;
	}

	public void setDepartement(String departement) {
		Departement = departement;
	}

	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	public double getSalaire() {
		return Salaire;
	}

	public void setSalaire(double salaire) {
		Salaire = salaire;
	}
	
	public String getDateNaiss() {
		return DateNaiss;
	}

	public void setDateNaiss(String dateNaiss) {
		DateNaiss = dateNaiss;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getOccupation() {
		return Occupation;
	}

	public void setOccupation(String occupation) {
		Occupation = occupation;
	}

	@Override
	public String toString() {
		return "Employee [Matricule=" + Matricule + ", ResteConge=" + ResteConge + ", Nom=" + Nom + ", Prenom=" + Prenom
				+ ", Departement=" + Departement +", Occupation=" + Occupation + ", Adresse=" + Adresse + ", DateNaiss=" + DateNaiss + ", Email="
				+ Email +  ", Salaire=" + Salaire + "]";
	}

}
