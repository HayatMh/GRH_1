package administrationModel;

import java.util.*;
import java.sql.*;
import java.util.regex.Pattern;

public class Administrateur implements EmployeeDAO,FicheDePaieDAO,CongeDAO,LoginDAO{

	private static Scanner input = new Scanner(System.in); 

	static public ArrayList <Integer> matricules(){
	    ArrayList <Integer> mats= new ArrayList <Integer>();
		try { 	ConnexionDB cx= new ConnexionDB();
		
		String qr="select matricule from employee";
		
		ResultSet rs= null;
	   	rs=cx.getSt().executeQuery(qr);
		while(rs.next()) {
			int m= rs.getInt("matricule");
			mats.add(m);
		}
		cx.getCon().close();
		}
		
		catch (SQLException e) { e.printStackTrace();}
		
		return mats;
	}
	
	static public HashSet <Integer> moisfdp(int m){
	    HashSet <Integer> lst= new HashSet <Integer>();
		try { 	ConnexionDB cx= new ConnexionDB();
		
		String qr="select mois from fdp where matricule= "+m;
		ResultSet rs= null;
	   	rs=cx.getSt().executeQuery(qr);
		while(rs.next()) {
			int mx= rs.getInt("mois");
			lst.add(mx);
		}	
		cx.getCon().close();
		}
		catch (SQLException e) { e.printStackTrace();}
		
		return lst;
	}
	
	static public boolean exists(int matricule) {
		boolean exists=false;
		ArrayList <Integer> matric = new ArrayList <Integer>();
		matric=matricules();
		Iterator<Integer> it=matric.iterator();
		
		while (it.hasNext()){
			int x=(int) it.next();
			if (x==matricule) 
				{
				  exists=true; break;
				}}
		
		return exists;
	}
	
	static public boolean existsMofM(int mt,int ms) {
		boolean exist=false;
		HashSet <Integer> list = new HashSet <Integer>();
		list=moisfdp(mt);
		Iterator<Integer> it=list.iterator();
		while (it.hasNext()){
			int x=(int) it.next();
			if (x==ms) 
				{
				  exist=true; break;
				}}
		
		return exist;
	}
	
	public static boolean validEmail(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 
	
	// ------------------------------------------------------------------------------------------------------
	
	@Override
	public int ajouterEmp(Employee emp) {
		
		Administrateur admin = new Administrateur();
		int r=0;
		int x=0;;
	try {	ConnexionDB cx= new ConnexionDB(); 
	
	       
		if (validEmail(emp.getEmail()))
		{
		String qr="insert into sys.employee values (seq_matricule.nextval,'"+emp.getNom()+"','"+emp.getPrenom()+"','"
		+emp.getDepartement()+"','"+emp.getAdresse()+"',"+emp.getSalaire()+","+emp.getResteConge()+",'"+emp.getEmail()+"','"+emp.getDateNaiss()+"','"+emp.getOccupation()+"')";

		
			cx.getSt().executeUpdate(qr);
			cx.getCon().commit();
			
		String qry="select matricule from employee where email='"+emp.getEmail()+"'";
		
		ResultSet rs=null;
		rs=cx.getSt().executeQuery(qry);
		while(rs.next()) {
			x=rs.getInt("matricule");
		}
			
			admin.ajouterLogin(x, emp.getDepartement(), emp.getOccupation());
			
			r=1;
			
			cx.getCon().close(); 
		}
		else System.out.println("email invalid");
		
		}
		catch (SQLException e) { e.printStackTrace();}
		
		return r;
	}
	
	@Override
	public int supprimerEmp(int matricule) {
		
		int r=0;
		boolean exst=exists(matricule);
		
		 if(exst) {
			 try { ConnexionDB cx= new ConnexionDB();
				
				String qr="delete from employee where matricule="+matricule;
				
				cx.getSt().executeUpdate(qr);
				cx.getCon().commit();
				r=1;
				
				cx.getCon().close(); 
					
				}
		        catch (SQLException e) { e.printStackTrace();} 
		 }
		 else 
			 {
			    System.out.println("Le num de matricule n'existe pas !");
			    r=0;
			 }
		
		return r;
		
	}
	
	@Override
	public int modifierEmp(int matricule) {
		
		int r=0;
		boolean exst=exists(matricule);
		String qr;
		if(exst) {
			System.out.println("quoi modifier?");
			String mod=input.next();
			input.nextLine();
			System.out.println("modification : ");
			String modd=input.nextLine();
			System.out.println("valider modifiction ? o/n");
			char valider=input.next().charAt(0);
			if (valider=='o') {
			try {
				ConnexionDB cx=new ConnexionDB();
			switch(mod) {
			case "nom":
				qr="update employee set nom = '"+modd+"' where matricule = "+matricule;
				cx.getSt().executeUpdate(qr);
				break;
			case "prenom":
				qr="update employee set prenom = '"+modd+"' where matricule = "+matricule;
				cx.getSt().executeUpdate(qr);
				break;
			case "salaire":
				qr="update employee set salaire = "+Double.parseDouble(modd)+" where matricule = "+matricule;
				cx.getSt().executeUpdate(qr);
				break;
			case "resteconge":
				qr="update employee set resteconge = "+Integer.parseInt(modd)+" where matricule = "+matricule;
				cx.getSt().executeUpdate(qr);
				break;
			case "adresse":
				qr="update employee set adresse = '"+modd+"' where matricule = "+matricule;
				cx.getSt().executeUpdate(qr);
				break;
			case "departement":
				qr="update employee set departement = '"+modd+"' where matricule = "+matricule;
				cx.getSt().executeUpdate(qr);
				break;
			case "email":
				if (validEmail(modd))
				{
				qr="update employee set email = '"+modd+"' where matricule = "+matricule;
				cx.getSt().executeUpdate(qr);
				}
				else System.out.println("email invalid !");
				break;
			case "datenaissance":
				qr="update employee set datenaissance = '"+modd+"' where matricule = "+matricule;
				cx.getSt().executeUpdate(qr);
				break;
			default :
				System.out.println("mauvais input !");
				break;
			} // + modifier occupation
			
			cx.getCon().commit();
			r=1;
			
			cx.getCon().close(); 
			}
			catch (SQLException e) { e.printStackTrace();} 	
		}				
		
		else System.out.println("aucune modification faite.");
	}
		else {
			System.out.println("Le num de matricule n'existe pas !");
			r=0;
		}
		
		return r;
	}
	
	@Override
	public int afficherEmp(int matricule) {
		
		int r=0;
		String qr;
 		boolean exst=exists(matricule);
		 if(exst) {
			try { ConnexionDB cx= new ConnexionDB();
			 qr="select * from employee where matricule ="+matricule;
			 ResultSet rs=null;
			 rs= cx.getSt().executeQuery(qr);
			 while(rs.next()) {
				
			   Employee emp=new Employee(rs.getString("nom"),rs.getString("prenom"),rs.getString("departement"),rs.getString("adresse"),rs.getString("occupation"),rs.getString("datenaissance"),rs.getString("email"),rs.getDouble("salaire"),rs.getInt("resteconge"));
			
			   System.out.println(emp); }

				r=1;
				
				cx.getCon().close();
			 
			}
		  catch (SQLException e) {e.printStackTrace();}
		 }
		 else
			 {
			 System.out.println("Le num de matricule n'existe pas !");
			 r=0;
			 }
			
		
		return r;
	}
	
	
	public static Employee retournerEmp(int matricule) {
		String qr;
		Employee emp =null ;
 		boolean exst=exists(matricule);
		 if(exst) {
			try { ConnexionDB cx= new ConnexionDB();
			 qr="select * from employee where matricule ="+matricule;
			 ResultSet rs=null;
			 rs= cx.getSt().executeQuery(qr);
			 while(rs.next()) {
				
			emp=new Employee(matricule,rs.getString("nom"),rs.getString("prenom"),rs.getString("departement"),
	rs.getString("adresse"),rs.getString("occupation"),rs.getString("datenaissance"),rs.getString("email"),rs.getDouble("salaire"),rs.getInt("resteconge"));
			   
			 }
				
				cx.getCon().close();
			 
			}
		  catch (SQLException e) {e.printStackTrace();}
		 }
		 else
	
			 System.out.println("Le num de matricule n'existe pas !");
			
		return emp;
		
	}

//--------------------------------------------------------------------------------------------------------------
	
	@Override
	public int modifierFDP(int matricule, int mois) {
		int r=0;
		if (exists(matricule) && existsMofM(matricule, mois))
		{
			try { ConnexionDB cx= new ConnexionDB(); 
			
			String qr="select * from fdp where matricule="+matricule+" and mois="+mois;
			ResultSet rs=null;
			rs=cx.getSt().executeQuery(qr);
			while(rs.next()) {
			// doit etre liee a l'interface et tte la structure va changer
			// aura la forme suivante : exemple:
			// hrtravail_field.setText(rs.getInt("hrtravail")); ....
			
			}
			// et apres modification : exemple :
			// String qr2="update fdp set hrtravail ="+hrtravail_field.getText()" where matricule= "+matricule+" and mois= "+mois;
			// cx.getSt().executeUpdate();
			// cx.getCon().commit();
			
			r=1;
			cx.getCon().close();
			}
		catch (SQLException e) {e.printStackTrace();}
		}
		
		else { System.out.println("le num de matricule ou fdp du mois "+mois+" n'existe pas !");
		r=0;}
		
		return r;
	}

	@Override
	public int afficherFDP(int matricule, int mois) {
		int r=0;
		if (exists(matricule) && existsMofM(matricule, mois))
		{
			try { ConnexionDB cx= new ConnexionDB(); 
			
			String qr="select * from fdp where matricule="+matricule+" and mois="+mois;
			ResultSet rs=null;
			rs=cx.getSt().executeQuery(qr);
			while(rs.next()) {
				
			FicheDePaie	fdp= new FicheDePaie(rs.getInt("numfdp"),rs.getInt("matricule"),rs.getInt("hrtravail"),rs.getInt("conge"),rs.getInt("hrretard"),
						rs.getInt("hrsupp"),rs.getDouble("salaire"),rs.getDouble("prime"),rs.getDouble("netapayer"),rs.getInt("mois"));
			
			System.out.println(fdp);
			
			}
			r=1;
			cx.getCon().close();
			
				
			}
			catch (SQLException e) {e.printStackTrace();}
		}
		else {
			System.out.println("le num de matricule ou fdp du mois "+mois+" n'existe pas !");
			r=0;
		}
		return r;
	}
	
	@Override
	public int ajouterFDP(FicheDePaie fdp) {
		int r=0;
		
		
		
		try {	ConnexionDB cx= new ConnexionDB(); 
		
		    
			String qr="insert into sys.fdp values (seq_fdp.nextval,"+fdp.getEmp().getMatricule()+","+fdp.getHrTravail()+","
			+fdp.getConge()+","+fdp.getNbrHrRetard()+","+fdp.getNbrHrSupp()+","+fdp.getMois()+","+fdp.getEmp().getSalaire()+","+fdp.getPrime()+","+fdp.getNetaPayer()+")";

			
				cx.getSt().executeUpdate(qr);
				cx.getCon().commit();
				
				r=1;
				
				cx.getCon().close(); 
			}
			catch (SQLException e) { e.printStackTrace();}
			
		
			return r;
	}

//--------------------------------------------------------------------------------------------------------------
	

	@Override
	public int accepterConge(int numcg) {
		int r=0;
		try {
			ConnexionDB cx= new ConnexionDB();
			String qr="update conge set status='accpete' where numcg="+numcg;

			cx.getSt().executeUpdate(qr);
			cx.getCon().commit();
			
			r=1;
			
			cx.getCon().close(); 
			
		}
		catch(SQLException e) {e.printStackTrace();}
		return r;
	}
	
	@Override
	public int refuserConge(int numcg) {
		int r=0;
		try {
			ConnexionDB cx= new ConnexionDB();
			String qr="update conge set status='refuse' where numcg="+numcg;

			cx.getSt().executeUpdate(qr);
			cx.getCon().commit();
			
			r=1;
			
			cx.getCon().close(); 
			
		}
		catch(SQLException e) {e.printStackTrace();}
		return r;
	}

	@Override
	public int afficherConges() {
		int r=0;
		try { 
			ConnexionDB cx= new ConnexionDB();
			String qr="select * from conge ";
			ResultSet rs=null;
			rs= cx.getSt().executeQuery(qr);
			while(rs.next()) {
			
				Conge cg=new Conge(rs.getInt("numcg"),rs.getInt("matricule"),rs.getString("datedbt"),rs.getInt("jrrest"),
						rs.getInt("jrdmd"),rs.getString("status"),rs.getString("typecg"));
		
				System.out.println(cg); }

			r=1;
			
			cx.getCon().close();
		 
		}
	  catch (SQLException e) {e.printStackTrace();}
	 
	 
		return r;
	}
	
//--------------------------------------------------------------------------------------------------------------

	@Override
	public int ajouterLogin(int matricule,String dp,String occ) {
		int r=0;
		String dr="non-admin";
		try {
			ConnexionDB cx=new ConnexionDB();
			if(occ.equals("Manager") && dp.equals("RH")) dr="admin";
			String qry="insert into sys.login values ("+matricule+","+genererMdp()+",'"+dr+"')";
			cx.getSt().executeUpdate(qry);
			cx.getCon().commit();
			r=1;
			cx.getCon().close();
			
		}
		catch (SQLException e) {e.printStackTrace();}
		return r;
	}

	@Override
	public int genererMdp() {
		
		double d = Math.random()*100000;
		int nmdp=(int) d;
		while (nmdp < 10000 || uniqueMdp(nmdp)) {
			 d = Math.random()*100000;
			 nmdp=(int) d;
		}
		return nmdp;
	}
	
	public boolean uniqueMdp(int xx) {
		boolean rpt=false;
		HashSet<Integer> mp=new HashSet<Integer>();
		try {
			ConnexionDB cx= new ConnexionDB();
			String q="select mdp from login";
			ResultSet rs=null;
			rs=cx.getSt().executeQuery(q);
			while(rs.next()) {
				int mp1=rs.getInt("mdp");
				mp.add(mp1);
			}
			Iterator<Integer> it= mp.iterator();
			while (it.hasNext()) {
				int pt=(int) it.next();
				if(xx==pt)
				{
					rpt=true; break;
				}
			}
			cx.getCon().close();
		}
		catch(SQLException e) {e.printStackTrace();}
		
		return rpt;
	}
	
}	
	

	
//--------------------------------------------------------------------------------------------------------------
	
		/*public static void main(String args[]) {
			
			Administrateur admin=new Administrateur();
			int y;
			
			int x,var6;
			double var5;
			String str;
			String var[]=new String[4];
			Employee emp1=new Employee();
			String em,dte,occ="Manager";
			
			
			System.out.println("entrer nom:");
			var[0]=input.next();
			emp1.setNom(var[0]);
			System.out.println("entrer prenom:");
			var[1]=input.next();
			emp1.setPrenom(var[1]);
			System.out.println("entrer departement:");
			var[2]=input.next();
			emp1.setDepartement(var[2]);
			System.out.println("entrer email:");
			em=input.next();
			emp1.setEmail(em);
			System.out.println("entrer datenaiss:");
			dte=input.next();
			emp1.setDateNaiss(dte);
			System.out.println("entrer Salaire:");
			var5=input.nextDouble();
			emp1.setSalaire(var5);
			System.out.println("entrer ResteConge:");
			var6=input.nextInt();
			emp1.setResteConge(var6);
			input.nextLine();
			System.out.println("entrer adresse:");
			var[3]=input.nextLine();
			emp1.setAdresse(var[3]);
			
			emp1.setOccupation(occ);
	
			if (admin.ajouterEmp(emp1)==1)
			    System.out.println("done");
			
			
			/*boolean a =exists(302);
			if (a)
				System.out.println("EXISTS");
			else 
				System.out.println("NOPE");*/
			/*
			
			
			System.out.println("entrer matricule:");
			y=input.nextInt();
			
			if ( admin.supprimerEmp(y)==1 )
			System.out.println("done 2");
			
			
			System.out.println("entrer matricule:");
			y=input.nextInt();
			
			if ( admin.modifierEmp(y)==1 )
			System.out.println("done 3");
			
			System.out.println("entrer matricule:");
			y=input.nextInt();
			
			if ( admin.afficherEmp(y)==1 )
			System.out.println("done 4");
			
			Employee empp=retournerEmp(302);
			
            FicheDePaie f=new FicheDePaie(empp,132,0,2,66.25,05);
			
			if(admin.ajouterFDP(f)==1)
				System.out.println("done f");
			
			
			admin.afficherFDP(302, 04);*/
			
			/*admin.accepterConge(26);
			admin.refuserConge(27);
			admin.afficherConges();*/
			
			
			
			
			
				
		//}*/

		
//}
