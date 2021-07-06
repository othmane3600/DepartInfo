package metierEntite;

public class SectSemestre {
 private int IdSect;
 private int IdSem;
public SectSemestre(int idSect, int idSem) {
	super();
	IdSect = idSect;
	IdSem = idSem;
}
public int getIdSect() {
	return IdSect;
}
public void setIdSect(int idSect) {
	IdSect = idSect;
}
public int getIdSem() {
	return IdSem;
}
public void setIdSem(int idSem) {
	IdSem = idSem;
}
 
}
