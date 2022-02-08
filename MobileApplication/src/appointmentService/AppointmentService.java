package appointmentService;

import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
	
	List <Appointment> appointments = new ArrayList<Appointment>();
	
	public AppointmentService() {}
	
	public void addAppointment(Appointment appointment) {
		for (int i = 0; i < this.appointments.size(); i++) {
			if (this.appointments.get(i).getAppointmentID().equals(appointment.getAppointmentID())) {
				throw new IllegalArgumentException("AppointmentID already in use");
			}
		}
		this.appointments.add(appointment);
	}
	
	public void deleteAppointment(String appointmentID) {
		for (int i = 0; i < this.appointments.size(); i++) {
			if (this.appointments.get(i).getAppointmentID().equals(appointmentID)) {
				this.appointments.remove(i);
				return;
			}
		}
		throw new IllegalArgumentException("No such appointment ID");
	}	
	
	public Appointment getAppointment(String appointmentID) {
		for (int i = 0; i < this.appointments.size(); i++) {
			if (this.appointments.get(i).getAppointmentID().equals(appointmentID)) {
				return this.appointments.get(i);
			}
		}
		throw new IllegalArgumentException("No such appointment ID");
	}
}
