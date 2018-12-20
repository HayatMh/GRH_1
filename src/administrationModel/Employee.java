package administrationModel;

import java.sql.*;
import java.util.*;

public class Employee implements EmplDAO,MessageDAO {

	private int Matricule,ResteConge;
	private String Nom,Prenom,Departement,Adresse,DateNaiss,Email,Occupation;
	private double Salaire ;
	
	public Employee() {};
	
	public Employee(String nom, String prenom, String departement, String adresse,String occupation, String dateNaiss, String email ,
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
	
	

	public Employee(int matricule, String nom, String prenom, String departement, String adresse,String occupation,String dateNaiss, String email ,
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

	@Override
	public int demanderConge(Conge cg) {
		int r=0;
		try {
			ConnexionDB cx=new ConnexionDB();
			String qr="insert into sys.conge values(seq_conge.nextval,"+this.Matricule+",'"+cg.getDateDebut()+"',"+cg.getJrRestant()+","+cg.getJrDemande()+
					",'"+cg.getStatus()+"','"+cg.getTypeCg()+"')";
			
			cx.getSt().executeUpdate(qr);
			cx.getCon().commit();
			
			r=1;
			
			cx.getCon().close();
			
		}
		catch(SQLException e) {e.printStackTrace();}
		
		return r;
	}

	@Override
	public int changerMdp(int mdpa, int mdpn) {
		int r=0,xx=0;
		if(String.valueOf(mdpn).length()==5)
		{
			try {
		
			ConnexionDB cx=new ConnexionDB();
			String q="select mdp from login where matricule="+this.Matricule;
			ResultSet rs=null;
			rs=cx.getSt().executeQuery(q);
			while(rs.next())
				xx=rs.getInt("mdp");
			if(xx==mdpa)
			{
				String qr="update login set mdp="+mdpn+" where matricule="+this.Matricule;
				cx.getSt().executeUpdate(qr);
				r=1;
			}
			else System.out.println("ancien mdp incorrect");
		}
		catch(SQLException e) {e.printStackTrace();}}
		else System.out.println("taille du nv mdp incorrecte");
		return r;
		
	}
	
	public boolean emailExists(String eml) {
		boolean ext=false;
		
		ArrayList <String> mails= new ArrayList <String>();
		try { 	ConnexionDB cx= new ConnexionDB();
		
		String qr="select email from employee";
		
		ResultSet rs= null;
	   	rs=cx.getSt().executeQuery(qr);
		while(rs.next()) {
			String m= rs.getString("email");
			mails.add(m);
		}
		cx.getCon().close();
		}
		
		catch (SQLException e) { e.printStackTrace();}
		
		Iterator<String> it=mails.iterator();
		while(it.hasNext())
		{
			String tst=it.next();
			if(tst.equals(eml))
				ext=true; break;
		}
		
		return ext;
	}

	@Override
	public int envoyerMsg(Message msg) {
		int r=0;
		try { ConnexionDB cx= new ConnexionDB();
		
		String str="insert into message values (seq_msg.nextval,'"+msg.getSrc()+"','"+msg.getDst()+"','"+msg.getMsg()+"','non-lu','"
				+msg.getObjet()+"')";
		cx.getSt().executeUpdate(str);
		cx.getCon().commit();
		r=1;
		cx.getCon().close();	
			
		}
		catch (SQLException e) {e.printStackTrace();}
		return r;
	}

	@Override
	public int lireMsg(Message msg) {
		int r=0;
		try { ConnexionDB cx= new ConnexionDB();
		
		String str="update message set status= lu where num_msg ="+msg.getNum_msg();
		cx.getSt().executeUpdate(str);
		cx.getCon().commit();
		r=1;
		cx.getCon().close();	
			
		}
		catch (SQLException e) {e.printStackTrace();}
		return r;
		
	}
	
	

}
