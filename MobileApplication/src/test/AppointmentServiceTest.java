package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import appointmentService.Appointment;
import appointmentService.AppointmentService;

class AppointmentServiceTest {
	
	public AppointmentService createTestAppointments() {
		AppointmentService appointments = new AppointmentService();
		
		appointments.addAppointment(new Appointment("1", "06/02/2030 13:00", "appointment description"));
		appointments.addAppointment(new Appointment("2", "06/03/2030 09:45", "appointment for something"));
		
		return appointments;
		
	}

	@Test
	void testAddAppointment() {
		AppointmentService appointments = createTestAppointments();
		
		assertTrue(appointments.getAppointment("1").getAppointmentDate().equals("06/02/2030 13:00"));
		assertTrue(appointments.getAppointment("1").getAppointmentDescription().equals("appointment description"));
		
		assertThrows(IllegalArgumentException.class, () -> {
			appointments.addAppointment(new Appointment("1", "04/19/2033 03:15", "appointment description"));
		});
		
		appointments.addAppointment(new Appointment("3", "07/09/2030 8:00", "A description"));
	}
	
	@Test
	void testDeleteAppointment() {
		AppointmentService appointments = createTestAppointments();
		
		appointments.deleteAppointment("2");
		
		assertThrows(IllegalArgumentException.class, () -> {
			appointments.getAppointment("2");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			appointments.deleteAppointment("2");
		});
	}

}
