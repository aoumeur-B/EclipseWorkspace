package dao;

import java.sql.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import util.DBUtil;

import model.Ordinateur;

public class OrdinateurDAOImplementation implements OrdinateurDAO{
	
	
	private Connection conn;

	public OrdinateurDAOImplementation() {
		conn = DBUtil.getConnection();
	}

	@Override
	public void addOrdinateur(Ordinateur ordinateur) {
		// TODO Auto-generated method stub
		
		try {
			String query = "insert into ordinateur (fabricant, model, tailleDD, tailleMemoire, tailleEcran,typeProcesseur) values (?,?,?,?,?,?)";
			PreparedStatement preparedStatement =(PreparedStatement) conn.prepareStatement( query );
			preparedStatement.setString( 1, ordinateur.getFabricant() );
			preparedStatement.setString( 2, ordinateur.getModel() );
			preparedStatement.setString( 3, ordinateur.getTailleDD() );
			preparedStatement.setString( 4, ordinateur.getTailleMemoire() );
			preparedStatement.setString( 5, ordinateur.getTailleEcran() );
			preparedStatement.setString( 6, ordinateur.getTypeProcesseur() );
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteOrdinateur(int ordinateurID) {
		// TODO Auto-generated method stub
		
		
		try {
			String query="delete  from ordinateur where ordinateurId=? ";
			PreparedStatement  preparedStatement =conn.prepareStatement(query);
			preparedStatement.setInt(1,ordinateurID);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void updateOrdinateur(Ordinateur ordinateur) {
		// TODO Auto-generated method stub
		
		try {
			String query="update ordinateur set fabricant=?, model=?, tailleDD=?, tailleMemoire=?, tailleEcran=?,typeProcesseur=? where ordinateurId=?";
			PreparedStatement preparedStatement=conn.prepareStatement(query);
			preparedStatement.setString(1, ordinateur.getFabricant());
			preparedStatement.setString(2, ordinateur.getModel());
			preparedStatement.setString(3, ordinateur.getTailleDD());
			preparedStatement.setString(4, ordinateur.getTailleMemoire());
			preparedStatement.setString(5, ordinateur.getTailleEcran());
			preparedStatement.setString(6, ordinateur.getTypeProcesseur());
			preparedStatement.setInt(7, ordinateur.getOrdinateurId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Ordinateur> getAllOrdinateurs() {
		// TODO Auto-generated method stub
		List<Ordinateur> ordinateurs= new ArrayList<Ordinateur>();
		
		try {
			Statement statement=(Statement) conn.createStatement();
			ResultSet resultSet=statement.executeQuery( "select * from ordinateur" );
			
			while( resultSet.next() ) {
				Ordinateur ordinateur = new Ordinateur();
				ordinateur.setOrdinateurId( resultSet.getInt( "ordinateurId" ) );
				ordinateur.setFabricant( resultSet.getString( "fabricant" ) );
				ordinateur.setModel( resultSet.getString( "model" ) );
				ordinateur.setTailleDD( resultSet.getString( "tailleDD" ) );
				ordinateur.setTailleMemoire( resultSet.getString( "tailleMemoire" ) );
				ordinateur.setTailleEcran( resultSet.getString( "tailleEcran" ) );
				ordinateur.setTypeProcesseur( resultSet.getString( "typeProcesseur" ) );
				ordinateurs.add(ordinateur);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ordinateurs;
	}

	@Override
	public Ordinateur getOrdinateurById(int ordinateurID) {
		// TODO Auto-generated method stub
	Ordinateur ordinateur=new Ordinateur();
	
	try {
		String query="select * from ordinateur where ordinateurId=?";
		PreparedStatement preparedStatement=conn.prepareStatement(query);
		preparedStatement.setInt(1, ordinateurID);
		ResultSet resultSet = preparedStatement.executeQuery();
		while( resultSet.next() ) {
			ordinateur.setOrdinateurId( resultSet.getInt( "ordinateurId" ) );
			ordinateur.setFabricant( resultSet.getString( "fabricant" ) );
			ordinateur.setModel( resultSet.getString( "model" ) );
			ordinateur.setTailleDD( resultSet.getString( "tailleDD" ) );
			ordinateur.setTailleMemoire( resultSet.getString( "tailleMemoire" ) );
			ordinateur.setTailleEcran( resultSet.getString( "tailleEcran" ) );
			ordinateur.setTypeProcesseur( resultSet.getString( "typeProcesseur" ) );
			
		}
		
		resultSet.close();
		preparedStatement.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
		return ordinateur;
	}

	
	
	
}
