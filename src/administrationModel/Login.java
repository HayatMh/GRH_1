package administrationModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
	
	private int matricule,mdp;
	private String droit;
	
	public Login(int matricule, int mdp, String droit) {
		super();
		this.matricule = matricule;
		this.mdp = mdp;
		this.droit = droit;
	}

	public Login() {
		super();
	}

	
	public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	public int getMdp() {
		return mdp;
	}

	public void setMdp(int mdp) {
		this.mdp = mdp;
	}

	public String getDroit() {
		return droit;
	}

	public void setDroit(String droit) {
		this.droit = droit;
	}
	//login function
	public int connexion(int x,int y) {
		int v=0;
		try { 	
		ConnexionDB cx= new ConnexionDB();
		String query = "SELECT * FROM login WHERE matricule = ? and mdp = ?";
	     PreparedStatement s = cx.getCon().prepareStatement(query);
	     s.setLong(1, x);
	     s.setLong(2, y);
	   ResultSet rs = s.executeQuery();
       boolean exist=false;
		while(rs.next()) {
			exist=true;
			Login lr=new Login(rs.getInt("matricule"),rs.getInt("mdp"),rs.getString("droit"));	
			if(lr.getDroit().equals("admin"))
				v=1;
			else
				v=2;
		}
	  if(!exist) v=3;
		cx.getCon().close();
		}
		catch (SQLException e) { e.printStackTrace();}
		return v;
	}
	
	
	

}
