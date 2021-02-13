package com.clinicmgmt.utility;

public class IdGenerator {

	private static int drid = 1;
	
	  private static int ptid = 1;
	  private static int pathid = 1;
	  private static int pharmid = 1;
	  private static int findingid = 1;
	  private static int receptionid = 1;
	  private static int prescid = 1;
	  private static int reportid = 1;
	 

	public static String generateDoctorId() {
		String passdrid = String.format("%04d", drid);
		passdrid = "DR" + passdrid;
		drid++;
		
		return passdrid;
	}
	
	public static String generatePatientId() {
		String passptid = String.format("%06d", ptid);
		passptid = "PT" + passptid;
		ptid++;
		
		return passptid;
	}
	
	public static String generatePathologistId() {
		String passpathid = String.format("%04d", pathid);
		passpathid = "PAT" + passpathid;
		pathid++;
		
		return passpathid;
	}
	
	public static String generatePharmacistId() {
		String passpharmid = String.format("%04d", pharmid);
		passpharmid = "PH" + passpharmid;
		pharmid++;
		
		return passpharmid;
	}
	
	public static String generateFindingsId() {
		String passfindingid = String.format("%06d", findingid);
		passfindingid = "FN" + passfindingid;
		findingid++;
		
		return passfindingid;
	}
	
	public static String generateReportId() {
		String passreportid = String.format("%06d", reportid);
		passreportid = "RP" + passreportid;
		reportid++;
		
		return passreportid;
	}
	
	public static String generateReceptionId() {
		String passreceptionid = String.format("%04d", receptionid);
		passreceptionid = "RC" + passreceptionid;
		receptionid++;
		
		return passreceptionid;
	}
	
	public static String generatePrescriptionId() {
		String passprescid = String.format("%04d", prescid);
		passprescid = "PR" + passprescid;
		prescid++;
		
		return passprescid;
	}
}
