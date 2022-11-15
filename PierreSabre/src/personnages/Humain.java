package personnages;

public class Humain {
	
	final int MAXCONNAISSANCE = 30;
	private String nom;
	private String boisson;
	private int argent;
	protected int nbConnaissance = 0;
	private Humain[] connaissance = new Humain[MAXCONNAISSANCE];
	
	
	public Humain(String nom, String boisson, int argent) {
		this.nom = nom;
		this.boisson = boisson;
		this.argent = argent;
	}
	
	public String getNom() {
		return nom;
	}
	public int getArgent() {
		return argent;
	}
	
	public void setArgent(int argent) {
		this.argent = argent;
	}
	
	public void parler(String texte) {
		System.out.println("("+nom+") - " + texte);
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boisson);
	}
	
	public void boire() {
		parler("Mmmm, un bon verre de " + boisson + " ! GLOUPS !");
	}
	
	public void acheter(String bien, int prix) {
		if (argent >= prix) {
			parler("J'ai "+argent+" sous en poche. Je vais pouvoir m'offrir " + bien + " a " + prix + " sous");
			perdreArgent(prix);
		} else {
			parler("Je n'ai plus que "+argent+" sous en poche. Je ne peux meme pas m'offrir " + bien + " a " + prix + " sous");
		}
	}
	
	public void gagnerArgent(int gain) {
		argent += gain;
	}
	
	public void perdreArgent(int perte) {
		argent -= perte;
	}
	
	public void faireConnaissanceAvec(Humain autreHumain) {
		direBonjour();
		autreHumain.repondre(this);
		memoriser(autreHumain);
	}
	
	private void memoriser(Humain humain) {
		if (nbConnaissance < MAXCONNAISSANCE) {
			connaissance[nbConnaissance] = humain;
			nbConnaissance ++;
		} else {
			for(int i=0; i<MAXCONNAISSANCE-1; i++) {
				connaissance[i]=connaissance[i+1];
			}
			connaissance[MAXCONNAISSANCE-1] = humain;
		}
	}
	
	private void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);
	}
	
	public void listerConnaissance() {
		String texte;
		if (nbConnaissance>0) {
			texte = "Je connais beaucoup de monde dont : ";
			for (int i=0; i<nbConnaissance-1;i++) {
				texte += connaissance[i].getNom()+", ";
			}texte += connaissance[nbConnaissance-1].getNom();
			parler(texte);
		}
		
	}
}
