package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import appointmentService.Appointment;

class AppointmentTest {

	@Test
	void testAppointment() {
		Appointment testAppointment = new Appointment("32", "04/19/2033 03:15", "appointment for stuff");
		
		assertTrue(testAppointment.getAppointmentID().equals("32"));
		assertTrue(testAppointment.getAppointmentDate().equals("04/19/2033 03:15"));
		assertTrue(testAppointment.getAppointmentDescription().equals("appointment for stuff"));
	}
	
	
	@Test
	void testAppointmentIDValid() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, "04/19/2033 03:15", "appointment for stuff");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("27910249234", "04/19/2033 03:15", "appointment for stuff");
		});
	}
	
	
	@Test
	void testAppointmentDateValid() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("32", "04/19/2033", "appointment for stuff");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("32", "04/19/1990 03:15", "appointment for stuff");
		});
	}
	
	
	@Test
	void testAppointmentDescriptionValid() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("32", "04/19/2033 03:15", null);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("32", "04/19/2033 03:15", "a really long description 1234567890-34s3ryeudospsk4");
		});
	}
}
