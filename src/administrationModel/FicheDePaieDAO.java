package administrationModel;

public interface FicheDePaieDAO {
	
	public int modifierFDP(int matricule,int mois);
	public int afficherFDP(int matricule,int mois);
	public int ajouterFDP(FicheDePaie fdp);
	

}
