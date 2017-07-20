package dao;

import java.util.List;

import model.Ordinateur;


public interface OrdinateurDAO {

	public void addOrdinateur( Ordinateur ordinateur );
	public void deleteOrdinateur( int ordinateurID );
	public void updateOrdinateur( Ordinateur ordinateur );
	public List<Ordinateur> getAllOrdinateurs();
	public Ordinateur getOrdinateurById( int ordinateurID );
	
}
