package administrationModel;

public class Conge {
	
	int numConge,matricule,JrRestant,JrDemande;
	String DateDebut,TypeCg;
	String Status = "En attente de confirmation";
	
	public Conge(int matricule, String dateDebut,  int jrRestant, int jrDemande, String status ,String typeCg) {
		super();
		this.matricule = matricule;
		JrRestant = jrRestant;
		JrDemande = jrDemande;
		DateDebut = dateDebut;
		TypeCg = typeCg;
		Status = status;
	}

	public Conge(int numConge, int matricule, String dateDebut, int jrRestant, int jrDemande, 
			String status, String typeCg) {
		super();
		this.numConge = numConge;
		this.matricule = matricule;
		JrRestant = jrRestant;
		JrDemande = jrDemande;
		DateDebut = dateDebut;
		TypeCg = typeCg;
		Status = status;
	}

	public int getNumConge() {
		return numConge;
	}

	public void setNumConge(int numConge) {
		this.numConge = numConge;
	}

	public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	public int getJrRestant() {
		return JrRestant;
	}

	public void setJrRestant(int jrRestant) {
		JrRestant = jrRestant;
	}

	public int getJrDemande() {
		return JrDemande;
	}

	public void setJrDemande(int jrDemande) {
		JrDemande = jrDemande;
	}

	public String getDateDebut() {
		return DateDebut;
	}

	public void setDateDebut(String dateDebut) {
		DateDebut = dateDebut;
	}

	public String getTypeCg() {
		return TypeCg;
	}

	public void setTypeCg(String typeCg) {
		TypeCg = typeCg;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "Conge [numConge=" + numConge + ", matricule=" + matricule + ", JrRestant=" + JrRestant + ", JrDemande="
				+ JrDemande + ",\n DateDebut=" + DateDebut + ", TypeCg=" + TypeCg + ", Status=" + Status + "]";
	}
	
	
	
	
}
