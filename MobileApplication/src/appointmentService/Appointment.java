package appointmentService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Appointment {
	private String appointmentID;
	private Date appointmentDate;
	private String appointmentDescription;
	
	public Appointment(String appointmentID, String appointmentDate, String appointmentDescription) {
		if (appointmentID == null || appointmentID.length() > 10) {
			throw new IllegalArgumentException("Invalid appointment ID");
		}
		
		this.appointmentID = appointmentID;
		
		setAppointmentDate(appointmentDate);
		setAppointmentDescription(appointmentDescription);
	}
	
	
	public void setAppointmentDate(String appointmentDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyy HH:mm");
		Date date;
		try {
			date = dateFormat.parse(appointmentDate);
		} catch (ParseException e) {
			throw new IllegalArgumentException("invalid date format MM/dd/yyy HH:mm");
		}
		
		if (date.before(new Date())) {
			throw new IllegalArgumentException("Invalid appointment date");
		}
		
		this.appointmentDate = date;
	}
	
	
	public void setAppointmentDescription(String appointmentDescription) {
		if (appointmentDescription == null || appointmentDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid appointment description");
		}
		
		this.appointmentDescription = appointmentDescription;
	}

	
	public String getAppointmentID() {
		return this.appointmentID;
	}
	
	
	public String getAppointmentDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyy HH:mm");
		
		return dateFormat.format(this.appointmentDate);
	}
	
	
	public String getAppointmentDescription() {
		return this.appointmentDescription;
	}
}
