package administrationModel;

public interface LoginDAO {
	
	public int ajouterLogin(int matricule,String dp,String occ);
	public int genererMdp();
	

}
