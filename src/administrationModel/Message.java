package administrationModel;

public class Message {
	
	int num_msg;
	String objet,src,dst,msg,status;
	

	public Message(int num_msg, String src, String dst,String objet,  String msg, String status) {
		super();
		this.num_msg = num_msg;
		this.objet = objet;
		this.src = src;
		this.dst = dst;
		this.msg = msg;
		this.status = status;
	}
	
	
	public Message(String src, String dst,String objet,String msg, String status) {
		super();
		this.objet = objet;
		this.src =src;
		this.dst =dst;
		this.msg = msg;
		this.status = status;
	}
	


	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getDst() {
		return dst;
	}
	public void setDst(String dst) {
		this.dst = dst;
	}
	public int getNum_msg() {
		return num_msg;
	}
	public void setNum_msg(int num_msg) {
		this.num_msg = num_msg;
	}

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
	}
	

}
