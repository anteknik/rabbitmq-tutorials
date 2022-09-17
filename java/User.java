import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

	private long id;
	private String nama;
	private String alamat;

	public User(){}

	public User(long id, String nama,String alamat){

	this.id=id;
	this.nama=nama;
	this.alamat=alamat;
	}

	//public String toString(){//overriding the toString() method  
  	//return "User is"+nama+" "+alamat+" "+id;  
	//}	

}