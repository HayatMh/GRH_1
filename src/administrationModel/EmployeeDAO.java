package administrationModel;

public interface EmployeeDAO {
	
	public int ajouterEmp (Employee emp);
	public int modifierEmp (int matricule);
	public int supprimerEmp (int matricule);	
	public int afficherEmp (int matricule);	
	

}
