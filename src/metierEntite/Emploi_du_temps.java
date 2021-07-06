package metierEntite;

import com.mysql.jdbc.Blob;

public class Emploi_du_temps {
	private int IdEmploi;
	private Blob Emploi;
	
	
	public int getIdEmploi() {
		return IdEmploi;
	}
	public void setIdEmploi(int idEmploi) {
		IdEmploi = idEmploi;
	}
	public Blob getEmploi() {
		return Emploi;
	}
	public void setEmploi(Blob emploi) {
		Emploi = emploi;
	}
	public Emploi_du_temps(int idEmploi, Blob emploi) {
		super();
		IdEmploi = idEmploi;
		Emploi = emploi;
	}
}
