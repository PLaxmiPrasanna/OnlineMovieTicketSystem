package com.cg.omts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Ticket;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.utility.DBConnection;

public class UserDaoImpl implements IUserDao{

	static Connection connection = null;
	static PreparedStatement prepareStatement = null;
	static ResultSet resultSet = null;
	
	@Override
	public Movie getMovieDetails(int movieId) throws OMTSException {
		// TODO Auto-generated method stub
		Movie movie = null;
		Boolean isFound = false;
		try {
			
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_MOVIE_DETAILS);
			prepareStatement.setInt(1, movieId);
			resultSet = prepareStatement.executeQuery();
			
			isFound = resultSet.next();
			if(isFound == true) {
				movie = new Movie();
				movie.setMovieId(resultSet.getInt(1));
				movie.setMovieName(resultSet.getString(2));
				movie.setMovieGenre(resultSet.getString(3));
				movie.setMovieDirector(resultSet.getString(4));
				movie.setMovieLength(resultSet.getInt(5));
				movie.setLanguage(resultSet.getString(6));
				movie.setMovieReleaseDate(resultSet.getDate(7));
			}
		} catch (SQLException e) {
			throw new OMTSException("problem while creating PS object");
		} 
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("problem while closing");
			}

		}
		return movie;
	}
	
	@Override
	public List<Integer> getTheatresByMovie(int movieId) throws OMTSException {
		// TODO Auto-generated method stub
		List<Integer> theatreIdList = new ArrayList<Integer>();
		try {
			
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_THEATRES_BY_MOVIE);
			prepareStatement.setInt(1, movieId);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				theatreIdList.add(resultSet.getInt(1));
			}
		} catch (SQLException e) {
			throw new OMTSException("problem while creating PS object"+e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("problem while closing");
			}
		}
		
		return theatreIdList;
	}

	@Override
	public List<String> getTheatreNames(List<Integer> theatreIdList) throws OMTSException {
		// TODO Auto-generated method stub
		List<String> theatreNamesList = new ArrayList<String>();
		try {
			
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_THEATRE_NAME_BY_ID);
			
			for(Integer theatreId : theatreIdList) {
				prepareStatement.setInt(1, theatreId);
				resultSet = prepareStatement.executeQuery();
					while(resultSet.next()) {
						theatreNamesList.add(resultSet.getString(1));
					}
			}
		} catch (SQLException e) {
			throw new OMTSException("problem while creating PS object"+e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new OMTSException("problem while closing");
			}
		}
		return theatreNamesList;
	}	
	
	@Override
	public List<Movie> getAllMovies() throws OMTSException{
		List<Movie> movieList = new ArrayList<Movie>();
		Movie movie = null;
		try {
			connection =  DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_ALL_MOVIES);
			resultSet = prepareStatement.executeQuery();	
			while(resultSet.next()) {
				movie = new Movie();
				movie.setMovieId(resultSet.getInt(1));
				movie.setMovieName(resultSet.getString(2));
				movie.setMovieGenre(resultSet.getString(3));
				movie.setMovieDirector(resultSet.getString(4));
				movie.setMovieLength(resultSet.getInt(5));
				movie.setLanguage(resultSet.getString(6));
				movie.setMovieReleaseDate(resultSet.getDate(7));
				movieList.add(movie);
				
			}	
		}catch(SQLException e) {
			throw new OMTSException("problem occured while creating PS object"+e.getMessage());
		}
		finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem occured while closing connection");
			}
		}
		return movieList;
	}
	
	@Override
	public List<Integer> getTheatresByCity(String city) throws OMTSException {
		List<Integer> theatreIdList = new ArrayList<>();

		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GET_THEATREID);
			prepareStatement.setString(1, city);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				theatreIdList.add(resultSet.getInt(1));
			}
		}catch(SQLException e) {
			throw new OMTSException("problem occured while creating PS object");
		}
		finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem occured while closing connection");
			}
		}
		return theatreIdList;			
	}	
	
	@Override
	public int generateTicket(int userId, Ticket ticket) throws OMTSException {
		// TODO Auto-generated method stub
		int isInserted = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.GENERATE_TICKET);   
			prepareStatement.setInt(1, userId);  
			prepareStatement.setInt(2,ticket.getTicketId()); 
			prepareStatement.setInt(3, ticket.getNoOfSeats());
			prepareStatement.setInt(4, ticket.getScreenId());
			prepareStatement.setInt(5, ticket.getTheatreId());
			prepareStatement.setInt(6, ticket.getShowId());
			prepareStatement.setInt(7, ticket.getMovieId());
			isInserted = prepareStatement.executeUpdate();  
		}catch(SQLException e){ 
			throw new OMTSException("problem inserting Theatre Details into Database");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isInserted;
	}

	@Override
	public int allocateSeat(List<Integer> selectedSeatsList, int screenId) throws OMTSException {
		// TODO Auto-generated method stub
		int isInserted = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.ALLOCATE_SEATS);   
			for(Integer selectedSeat : selectedSeatsList) {
				prepareStatement.setInt(1, selectedSeat);
				prepareStatement.setString(2, "BLOCKED");
				prepareStatement.setInt(3, screenId);
				isInserted = prepareStatement.executeUpdate();  
			}
		}catch(SQLException e){ 
			throw new OMTSException("problem inserting Theatre Details into Database");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isInserted;
	}

	@Override
	public int setTicketStatus(int ticketId, String status) throws OMTSException {
		// TODO Auto-generated method stub
		int isInserted = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.SET_TICKET_STATUS);   
			prepareStatement.setString(1, status);
			prepareStatement.setInt(2, ticketId);
			isInserted = prepareStatement.executeUpdate();  	
		}catch(SQLException e){ 
			throw new OMTSException("problem inserting Theatre Details into Database");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isInserted;
	}

	@Override
	public int assignSeatsToTickets(int ticketId, List<Integer> seatsList) throws OMTSException {
		// TODO Auto-generated method stub
		int isInserted = 0;
		try {
			connection = DBConnection.getConnection();
			prepareStatement = connection.prepareStatement(IUserQueryConstants.ASSIGN_SEATS_TO_TICKET);   
			for(Integer seat : seatsList) {
				prepareStatement.setInt(1, ticketId);
				prepareStatement.setInt(2, seat);
				isInserted = prepareStatement.executeUpdate();  
			}
		}catch(SQLException e){ 
			throw new OMTSException("problem inserting Theatre Details into Database");
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new OMTSException("problem while closing Database");
			}
		}
		return isInserted;
	}
	
	
//	public static void main(String[] args) throws OMTSException { 
//		/*
//		 * Ticket ticket = new Ticket(); ticket.setTicketId(1); ticket.setNoOfSeats(1);
//		 * ticket.setScreenId(1); ticket.setMovieId(1); ticket.setShowId(1);
//		 * ticket.setTheatreId(1);
//		 */
//		List<Integer> selectedSeatsList = new ArrayList<Integer>();
//		selectedSeatsList.add(1);
//		selectedSeatsList.add(2);
//		selectedSeatsList.add(3);
//		selectedSeatsList.add(4);
//		
//		System.out.println(setTicketStatus(1, "PROCESSING"));
//		System.out.println(assignSeatsToTickets(1, selectedSeatsList));
//	
//	}
	 

}
