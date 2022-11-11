package ValidInput;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import BaseClasses.Movie;
import BaseClasses.Sessions;
import ExceptionClasses.SessionsExceptions.InvalidDateTimeException;
import ManagerClasses.SessionsCtrl;


public class SessionsLayer {
	
static SessionsCtrl sessionsCtrl = new SessionsCtrl();

    
    /** 
     * Check if session does not conflict with existing sessions based on parameters passed
     * @param cinemaCode        Code of cinema's that this session will be added to
     * @param movie             Movie that this session will be screening
     * @param sessionDateTime   Date and time which the session will begin
     * @return boolean          Return true if session is valid, else false
     */
    public static boolean isSessionValid(String cinemaCode, Movie movie, LocalDateTime sessionDateTime) {

        LocalDate sessionDate = sessionDateTime.toLocalDate();
        LocalTime sessionStartTime = sessionDateTime.toLocalTime();
        LocalTime sessionEndTime = sessionStartTime.plusMinutes((long) (movie.getRunTime()));

        ArrayList<Sessions> allSelectedSessions = sessionsCtrl.readByAttributes(cinemaCode, sessionDate);
        Sessions session_this = null;
        Sessions session_next = null;

        if (allSelectedSessions.isEmpty()) {
        	//no nothing 
        	return true;
        } 
       
        else {

            session_this = allSelectedSessions.get(0);
            if (sessionEndTime.isBefore(session_this.getStartTime())) 
                return true;

            session_this = allSelectedSessions.get(allSelectedSessions.size()-1);
            if (sessionStartTime.isAfter(session_this.getEndTime())) 
                return true;

            for (int i=0; i<(allSelectedSessions.size()-1); i++) {
                session_this = allSelectedSessions.get(i);
                session_next = allSelectedSessions.get(i+1);
                LocalTime betweenStart = session_this.getEndTime();
                LocalTime betweenEnd = session_next.getStartTime();
                if (betweenStart.isBefore(sessionStartTime) && betweenEnd.isAfter(sessionEndTime)) 
                    return true;
            }
        }

        try {
            throw new InvalidDateTimeException();
        } catch (InvalidDateTimeException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}

