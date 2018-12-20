package administrationModel;

public class FicheDePaie {
	
	private int numFDP,matricule,hrTravail,conge,nbrHrRetard,nbrHrSupp;
	private double salaire,prime,netaPayer;
	private int mois;
	private Employee emp;
	
	public FicheDePaie() {}
	
	public FicheDePaie( Employee emp ,int hrTravail, int nbrHrRetard, int nbrHrSupp, double prime, int mois) {
		super();
		this.emp = emp;
		this.hrTravail = hrTravail;
		this.mois = mois;
		this.conge = 18-emp.getResteConge();
		this.nbrHrRetard = nbrHrRetard;
		this.nbrHrSupp = nbrHrSupp;
		this.salaire = emp.getSalaire();
		this.prime = prime;
		double nap=emp.getSalaire()*(hrTravail+0.5*nbrHrSupp)+prime;
		this.netaPayer = nap;
	
		
	}
	
	
	public FicheDePaie(int numFDP, int matricule, int hrTravail, int conge, int nbrHrRetard, int nbrHrSupp,
			double salaire, double prime, double netaPayer, int mois) {
		super();
		this.numFDP = numFDP;
		this.matricule = matricule;
		this.hrTravail = hrTravail;
		this.conge = conge;
		this.nbrHrRetard = nbrHrRetard;
		this.nbrHrSupp = nbrHrSupp;
		this.salaire = salaire;
		this.prime = prime;
		this.netaPayer = netaPayer;
		this.mois = mois;
	}

	@Override
	public String toString() {
		return "FicheDePaie [numFDP=" + numFDP + ", matricule=" + matricule + ", hrTravail=" + hrTravail + ", conge="
				+ conge + ", nbrHrRetard=" + nbrHrRetard + ",\n nbrHrSupp=" + nbrHrSupp + ", salaire=" + salaire
				+ ", prime=" + prime + ", netaPayer=" + netaPayer + ", mois=" + mois + ", emp=" + emp + "]";
	}

	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public int getNumFDP() {
		return numFDP;
	}
	public void setNumFDP(int numFDP) {
		this.numFDP = numFDP;
	}	
	public int getMois() {
		return mois;
	}
	public void setMois(int mois) {
		this.mois = mois;
	}
	public int getMatricule() {
		return matricule;
	}
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}
	public int getHrTravail() {
		return hrTravail;
	}
	public void setHrTravail(int hrTravail) {
		this.hrTravail = hrTravail;
	}
	public int getConge() {
		return conge;
	}
	public void setConge(int conge) {
		this.conge = conge;
	}
	public int getNbrHrRetard() {
		return nbrHrRetard;
	}
	public void setNbrHrRetard(int nbrHrRetard) {
		this.nbrHrRetard = nbrHrRetard;
	}
	public int getNbrHrSupp() {
		return nbrHrSupp;
	}
	public void setNbrHrSupp(int nbrHrSupp) {
		this.nbrHrSupp = nbrHrSupp;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	public double getPrime() {
		return prime;
	}
	public void setPrime(double prime) {
		this.prime = prime;
	}
	public double getNetaPayer() {
		return netaPayer;
	}
	public void setNetaPayer(double netaPayer) {
		this.netaPayer = netaPayer;
	}
	

}
