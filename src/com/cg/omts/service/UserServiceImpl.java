package com.cg.omts.service;

import java.sql.SQLException;
import java.util.List;

import com.cg.omts.dao.IUserDao;
import com.cg.omts.dao.UserDaoImpl;
import com.cg.omts.dto.Booking;
import com.cg.omts.dto.Movie;
import com.cg.omts.dto.Screen;
import com.cg.omts.dto.Seat;
import com.cg.omts.dto.Show;
import com.cg.omts.dto.Theatre;
import com.cg.omts.dto.Ticket;
import com.cg.omts.dto.Transaction;
import com.cg.omts.exceptions.OMTSException;

public class UserServiceImpl implements IUserService{
	
	IUserDao userDao = new UserDaoImpl();
	@Override
	public Movie getMovieDetails(int movieId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getMovieDetails(movieId);
	}
	@Override
	public List<Integer> getTheatresByMovie(int movieId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getTheatresByMovie(movieId);
	}
	@Override
	public List<String> getTheatreNames(List<Integer> theatreIdList) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getTheatreNames(theatreIdList);
	}
	@Override
	public List<Integer> getTheatresByCity(String city) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getTheatresByCity(city);
	}
	@Override
	public List<Movie> getAllMovies() throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getAllMovies();

	}
	@Override
	public int generateTicket(Ticket ticket) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.generateTicket(ticket);
	}
	@Override
	public int allocateSeat(List<Integer> selectedSeatsList, int screenId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.allocateSeat(selectedSeatsList, screenId);
	}
	@Override
	public int assignSeatsToTickets(int ticketId, List<Integer> seatsList) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.assignSeatsToTickets(ticketId, seatsList);
	}
	@Override
	public int setTicketStatus(int ticketId, String status) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.setTicketStatus(ticketId, status);
	}
	@Override
	public int addTransaction(Transaction transaction, int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.addTransaction(transaction, ticketId);
	}
	@Override
	public int addBooking(Booking booking, int ticketId, int transactionId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.addBooking(booking, ticketId, transactionId);
	}
	@Override
	public int setSeatStatus(int seatId, String status) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.setSeatStatus(seatId, status);
	}
	@Override
	public int deleteBookingDetails(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.deleteBookingDetails(ticketId);
	}
	@Override
	public List<Integer> getSeatsByTicket(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getSeatsByTicket(ticketId);
	}
	@Override
	public int deleteAllocatedSeats(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.deleteAllocatedSeats(ticketId);
	}
	@Override
	public int deleteSeatDetails(List<Integer> seatList) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.deleteSeatDetails(seatList);
	}
	@Override
	public Transaction getTransactionDetails(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getTransactionDetails(ticketId);
	}
	@Override
	public int deleteTransaction(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.deleteTransaction(ticketId);
	}
	@Override
	public int cancelTicket(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.cancelTicket(ticketId);
	}
	@Override
	public int getCurrentBalance(Transaction transaction) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getCurrentBalance(transaction);
	}
	@Override
	public int refundAfterCancellation(Transaction transaction, int currentBalance) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.refundAfterCancellation(transaction, currentBalance);
	}
	@Override
	public Seat getSeatPrice(int screenId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getSeatPrice(screenId);
	}
	@Override
	public List<Screen> getScreenByTheatreId(int theatreId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getScreenByTheatreId(theatreId);
	}
	@Override
	public Booking getBookingDetails(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getBookingDetails(ticketId);
	}
	@Override
	public List<Show> getShowsByMovieAndTheatre(int screenId, int theatreId, int movieId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getShowsByMovieAndTheatre(screenId, theatreId, movieId);
	}
	@Override
	public boolean validatePayment(int accountNo, int cvv, String password) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.validatePayment(accountNo, cvv, password);
	}
	@Override
	public Seat seatAvailability(int seatId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.seatAvailability(seatId);
	}
	@Override
	public Ticket getTicket(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getTicket(ticketId);
	}
	@Override
	public List<Theatre> getTheatres(List<Integer> theatreIdList) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getTheatres(theatreIdList);
	}
	@Override
	public String getScreenName(int screenId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getScreenName(screenId);
	}
	@Override
	public String getShowName(int showId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getShowName(showId);
	}
	@Override
	public List<Movie> getMoviesById(List<Integer> movieIdList) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getMoviesById(movieIdList);
	}
	@Override
	public List<Integer> getMoviesByTheatre(List<Integer> theatreIdList) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getMoviesByTheatre(theatreIdList);
	}
	@Override
	public int getTransactionIdByBookingId(int bookingId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getTicketIdByBookingId(bookingId);
	}
	@Override
	public int getTicketIdByBookingId(int bookingId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getTicketIdByBookingId(bookingId);
	}
	@Override
	public List<Ticket> getTicketByIDS(List<Integer> ticketIdList) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getTicketByIDS(ticketIdList);
	}
	@Override
	public List<Transaction> getTransactionByTicket(List<Integer> ticketIdList) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getTransactionByTicket(ticketIdList);
	}
	@Override
	public List<Booking> getBookingByUser(List<Transaction> transactionId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getBookingByUser(transactionId);
	}
	@Override
	public int assignTicketToUser(int ticketId, int userId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.assignTicketToUser(ticketId, userId);
	}
	@Override
	public List<Integer> getTicketIdsByUser(int userId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getTicketIdsByUser(userId);
	}
	@Override
	public int deleteTicketFromUser(int ticketId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.deleteTicketFromUser( ticketId);
	}
	@Override
	public List<String> getShowNamesByTheatre(List<Integer> theatreIdList) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getShowNamesByTheatre(theatreIdList);
	}
	@Override
	public List<String> getScreenNameByTheatre(List<Integer> theatreIdList) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getScreenNamesByTheatre(theatreIdList);
	}
	@Override
	public int getSeatsAvailable(int screenId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getSeatsAvailable(screenId);
	}
	@Override
	public Screen getScreen(int screenId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getScreen(screenId);
	}
	@Override
	public String getTheatreName(int theatreId) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.getTheatreNames(theatreId);
	}
	@Override
	public int makePayment(int accountNo, int currentBalance, int totalCost) throws OMTSException {
		// TODO Auto-generated method stub
		return userDao.makePayment(accountNo,currentBalance, totalCost);
	}
	

}
