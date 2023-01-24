package Testcase;

import java.awt.AWTException;
import java.io.IOException;

//import javax.swing.undo.AbstractUndoableEdit;
//
//import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Base.Videos_data;
import Base.Videos_libraries_data;
import Pages.Login;
import Pages.Revenue_Report;
import Pages.Services;
import Pages.User_Report;
import Pages.Videos_categories;
import Pages.Appointments;
import Pages.Clinician;
import Pages.Clinician_Report;
import Pages.Clinician_disable;
import Base.Appointments_data;
import Base.Clinician_data;
import Base.Clinics_data;
import Base.Services_data;
import Pages.Clinician_edit;
import Pages.Clinics;
import Pages.Clinics_disable;
import Pages.Clinics_edit;
public class Login_TC extends TestBase {
		Login loginPage;
		Clinician clinician;
		Clinician_edit edit;
		Clinician_disable disabled;
		Clinics clinic;
		Clinics_edit editc;
		Clinics_disable disabledc;
		Clinics_disable disabledc1;
		Clinics_disable room;
		Services services;
		Services editService;
		Services enableDisable;
		Services disableds;
		Videos_categories addVideoCategories;
		Videos_categories editVideoCategories;
		Videos_categories enableDisableVideoCategories;
		Videos_categories addVideoLibraries;
		Videos_categories editVideoLibraries;
		User_Report userReport;
		Clinician_Report clinicianReport;
		Revenue_Report revenueReport;
		Appointments appo;
		
		
		
		public Login_TC() {
			super();
		}

		@BeforeMethod
		public void setUp() {

			loginPage = new Login();
		clinician = new Clinician();
			edit = new Clinician_edit();
			disabled = new Clinician_disable();
			clinic = new Clinics();
			editc = new Clinics_edit();
			disabledc = new Clinics_disable();
			disabledc1 = new Clinics_disable();
			room = new Clinics_disable();
			services = new Services();
			editService = new Services();
			enableDisable = new Services();
			disableds = new Services();
			addVideoCategories = new Videos_categories();
			editVideoCategories = new Videos_categories();
			enableDisableVideoCategories = new Videos_categories();
			addVideoLibraries = new Videos_categories();
			editVideoLibraries = new Videos_categories();
			userReport = new User_Report();
			clinicianReport = new Clinician_Report();
			revenueReport = new Revenue_Report();
			appo = new Appointments();
		
		}
		@Test
		public void loginTest() throws IOException, InterruptedException {
			loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
			Thread.sleep(4000);
			System.out.println("Admin Logged In");
		}
		@Test
		public void ClinicianLoginTest() throws IOException, InterruptedException {
			disabled.login(prop_Clinician_disable.getProperty("emailc"), prop_Clinician_disable.getProperty("passwordc"));
			Thread.sleep(3000);
//			System.out.println("Clinician cannot be  Logged In");
			System.out.println("Enable Disable Problem");
		}
		
		@Test
		public void AddClinicianTest() throws IOException, InterruptedException{
			loginTest();
			Thread.sleep(3000);
//			String actualUrl="http://182.76.66.74/PranaTelehealthTesting/user/profile";
//			String expectedUrl= driver.getCurrentUrl();
//			System.out.println(expectedUrl);
			
			Clinician_data d = new Clinician_data();
			d.Full_Name = prop_clinician.getProperty("Full_Name");
			d.Specialization = prop_clinician.getProperty("Specialization");
			d.ACC_No = prop_clinician.getProperty("ACC_No");
			d.Vendor_No = prop_clinician.getProperty("Vendor_No");
			d.DOB = prop_clinician.getProperty("DOB");
			d.Provider_Id = prop_clinician.getProperty("Provider_Id");
			d.Experience = prop_clinician.getProperty("Experience");
			d.Clinic_Name = prop_clinician.getProperty("Clinic_Name");
			d.Email_id = prop_clinician.getProperty("Email_id");
			d.Secondary_Email = prop_clinician.getProperty("Secondary_Email");
			d.Gender = prop_clinician.getProperty("Gender");
			d.Mobile_Number = prop_clinician.getProperty("Mobile_Number");
			
			
			clinician.AddClinician(d);
//			System.out.println("Clinician Added Successfully");	
					
		}
		@Test
		public void AddClinicianCheck() throws IOException, InterruptedException {
			loginTest();
			Thread.sleep(3000);
			
			Clinician_data add = new Clinician_data();
			add.Email_id = prop_clinician.getProperty("Email_id");
			System.out.println(add.Email_id);
			edit.EditClinician(add);
			Thread.sleep(3000);			
			System.out.println("Clinician Added checked");
		}
		
		@Test
		public void EditClinicianTest() throws IOException, InterruptedException {
			loginTest();
			Thread.sleep(3000);
			
			Clinician_data e = new Clinician_data();
			e.Email_id = prop_clinician.getProperty("Email_id");
			System.out.println(e.Email_id);
			edit.EditClinician(e);
			Thread.sleep(3000);
			System.out.println("Clinician EditButton clicked");
			//edit.ViewClinician(e);

		}
		
		@Test
		public void DisableClinicianTest() throws IOException, InterruptedException {
			loginTest();
			Thread.sleep(3000);
			
			Clinician_data dis = new Clinician_data();
			dis.Full_Name = prop_clinician.getProperty("Full_Name");
			System.out.println(dis.Full_Name);
			
			disabled.DisableClinician(dis);
			Thread.sleep(3000);
			  
//			System.out.println("Clinician disabled  Successfully");

		}
		
		@Test
		public void AddClinics() throws IOException, InterruptedException {
			loginTest();
			Thread.sleep(3000);
			
			Clinics_data datac = new Clinics_data();
			datac.Clinic_Name = prop_Clinics.getProperty("Clinic_Name");
			datac.Room_Name1 = prop_Clinics.getProperty("Room_Name1");
			datac.Room_Name2 = prop_Clinics.getProperty("Room_Name2");
			datac.Address_Line1 = prop_Clinics.getProperty("Address_Line1");
			datac.Address_Line2 = prop_Clinics.getProperty("Address_Line2");
					
			clinic.AddClinics(datac);
			Thread.sleep(3000);			
//			System.out.println("Clinics Added Successfully");
		}
		
		@Test
		public void EditClinicsTest() throws IOException, InterruptedException {
			loginTest();
			Thread.sleep(3000);
			
			Clinics_data clini = new Clinics_data();
			clini.Clinic_Name = prop_Clinics.getProperty("Clinic_Name");
			System.out.println(clini.Clinic_Name);
			editc.EditClinics(clini);
			Thread.sleep(3000);
			System.out.println("Clinics EditButton clicked");
			editc.ViewClinics(clini);

		}
		
		@Test
		public void DisableClinicsTest() throws IOException, InterruptedException {
			loginTest();
			Thread.sleep(3000);
			
			Clinics_data dis2 = new Clinics_data();
			dis2.Clinic_Name = prop_Clinics.getProperty("Clinic_Name");
			System.out.println(dis2.Clinic_Name);
			
			disabledc.DisableClinics(dis2);
			Thread.sleep(3000);
			  
//			System.out.println("Clinician disabled  Successfully");

		}
		
		@Test
		public void DisableClinicsCheck() throws IOException, InterruptedException {
			loginTest();
			Thread.sleep(3000);
			
			disabledc1.DisableClinics1();
			Thread.sleep(3000);			
			

		}
		
		@Test
		public void RoomsCheck() throws IOException, InterruptedException {
			loginTest();
			Thread.sleep(3000);
			
			room.RoomsClinics();
			Thread.sleep(3000);			
			

		}
		
		@Test
		public void AddServicesTest() throws IOException, InterruptedException {
			loginTest();
			Thread.sleep(3000);	
			
			Services_data serviceData = new Services_data();
			serviceData.Duration = prop_services.getProperty("Duration");
			serviceData.Price = prop_services.getProperty("Price");
			serviceData.Add_New_Service = prop_services.getProperty("Add_New_Service");			
			services.AddServices(serviceData);
			Thread.sleep(3000);				

		}
		
		@Test
		public void EditServicesTest() throws IOException, InterruptedException {
			loginTest();
			Thread.sleep(1000);	
			
//			Services_data serviceEdit = new Services_data();
//			serviceEdit.Service= prop_services.getProperty("Service");
//			System.out.println(serviceEdit.Service);
			editService.AddServices2("massage");
			Thread.sleep(3000);
			System.out.println("Services EditButton clicked");
			
			editService.EditViewServices("massage");

		}
		
		@Test
		public void EnableDisableServicesTest() throws IOException, InterruptedException {
			loginTest();
			Thread.sleep(1000);	
			
			Services_data serviceEnableDisable = new Services_data();
			serviceEnableDisable.Add_New_Service = prop_services.getProperty("Add_New_Service");
			System.out.println(serviceEnableDisable.Add_New_Service);
			enableDisable.EnableDisableServices(serviceEnableDisable);
			
			

		}
		
		@Test
		public void EnableDisableServicesCheck() throws IOException, InterruptedException {

		
			enableDisable.login(prop_services.getProperty("emailu"), prop_services.getProperty("passwordu"),"Jeeva clinic","massage Theraphy");
			

		}
		
		@Test
		public void AddVideoCategories() throws IOException, InterruptedException, Exception{

			loginTest();
			Thread.sleep(1000);
			Videos_data addImage = new Videos_data();
			addImage.Category = prop_Video_categories.getProperty("Category");
			addImage.Description = prop_Video_categories.getProperty("Description");
			addImage.Sub_Category_Name1 = prop_Video_categories.getProperty("Sub_Category_Name1");
			addImage.Sub_Category_Name2 = prop_Video_categories.getProperty("Sub_Category_Name2");
			addVideoCategories.AddVideoCategories(addImage);
			EditVideoCategories();
			

		}
		
		@Test
		public void EditVideoCategories() throws IOException, InterruptedException, Exception{

			loginTest();
			Thread.sleep(1000);
			Videos_data editImage = new Videos_data();
			editImage.Category = prop_Video_categories.getProperty("Category");
			editImage.Description = prop_Video_categories.getProperty("Description");
			editImage.Sub_Category_Name1 = prop_Video_categories.getProperty("Sub_Category_Name1");
			editImage.Sub_Category_Name2 = prop_Video_categories.getProperty("Sub_Category_Name2");
			editVideoCategories.EditVideoCategories(editImage);

		}
		
		@Test
		public void EnableDisableVideoCategoriesTest() throws IOException, InterruptedException{

			loginTest();
			Thread.sleep(1000);
			Videos_data enableDisableImage = new Videos_data();
			enableDisableImage.Category = prop_Video_categories.getProperty("Category");
			enableDisableVideoCategories.EnableDisableVideoCategories(enableDisableImage);

		}
		
		@Test
		public void EnableDisableVideoCategoriesCheck() throws IOException, InterruptedException{

			loginTest();
			Thread.sleep(1000);
			Videos_data enableDisableImageCheck = new Videos_data();
			enableDisableImageCheck.Category = prop_Video_categories.getProperty("Category");
			enableDisableVideoCategories.EnableDisableVideoCategoriesCheck(enableDisableImageCheck);
			Thread.sleep(1000);
		}
		
		@Test
		public void AddVideoLibraries() throws Exception{

			loginTest();
			Thread.sleep(1000);
			Videos_libraries_data addVlibraries= new Videos_libraries_data();
			addVlibraries.Title = prop_Video_categories.getProperty("Title");
			addVlibraries.Category = prop_Video_categories.getProperty("Category");
			addVlibraries.Sub_Category = prop_Video_categories.getProperty("Sub_Category");
			addVlibraries.Short_Description = prop_Video_categories.getProperty("Short_Description");
			addVlibraries.Description = prop_Video_categories.getProperty("Description");
			addVlibraries.Heading = prop_Video_categories.getProperty("Heading");
			addVlibraries.Content = prop_Video_categories.getProperty("Content");
			addVideoLibraries.addVideoLibraries(addVlibraries);
			Thread.sleep(1000);
		}
		
		@Test
		public void EditVideoLibraries() throws IOException, InterruptedException{

			loginTest();
			Thread.sleep(1000);
			Videos_libraries_data editVlibraries = new Videos_libraries_data();
			editVlibraries.Title = prop_Video_categories.getProperty("Title");
			editVlibraries.Category = prop_Video_categories.getProperty("Category");
			editVlibraries.Sub_Category = prop_Video_categories.getProperty("Sub_Category");
			editVlibraries.Short_Description = prop_Video_categories.getProperty("Short_Description");
			editVlibraries.Description = prop_Video_categories.getProperty("Description");
			editVlibraries.Heading = prop_Video_categories.getProperty("Heading");
			editVlibraries.Content = prop_Video_categories.getProperty("Content");
			editVlibraries.Sub = prop_Video_categories.getProperty("Sub");
			editVideoLibraries.editVideoLibraries();
			editVideoLibraries.View_VideoLibraries();	
						
		}
		@Test
		public void EditVideoLibrariesCheck() throws IOException, InterruptedException{
			loginTest();
			Thread.sleep(1000);
			editVideoLibraries.VideoLibraries_check_exerciseLibrary();
			Thread.sleep(1000);
			editVideoLibraries.login(prop_Video_categories.getProperty("emailu"), prop_Video_categories.getProperty("passwordu"));
			Thread.sleep(1000);			
		}
		
		@Test
		public void UserReport_ListAllClients() throws IOException, InterruptedException{
			loginTest();
			Thread.sleep(1000);
			userReport.ViewUserReport();
			Thread.sleep(1000);
			
		}
		
		@Test
		public void UserReport_OneSpecificClients() throws IOException, InterruptedException{
			loginTest();
			Thread.sleep(1000);
			userReport.ViewUserReport_OnespecificClient();
			Thread.sleep(1000);
			
		}
		
		@Test
		public void ClinicianReport() throws IOException, InterruptedException{
			loginTest();
			Thread.sleep(3000);
			clinicianReport.ViewClinicianReport();
			Thread.sleep(1000);
			
		}
		
		@Test
		public void RevenueReport() throws IOException, InterruptedException{
			loginTest();
			Thread.sleep(3000);
			revenueReport.ViewRevenueReport();
			Thread.sleep(3000);
			
			
		}
		
		@Test
		public void CreateAppointments() throws IOException, InterruptedException{
			loginTest();
			Thread.sleep(3000);
//			Appointments_data dataA = new Appointments_data();
//			dataA.Clini_location = Prop_Appointments.getProperty("Clini_location");
			appo.ClickAppointments();
			
		}
		@Test
		public void ViewAppointments() throws IOException, InterruptedException{
			loginTest();
			Thread.sleep(3000);
			appo.ViewAppointments();
			
		}
		@Test
		public void EditAppointments() throws IOException, InterruptedException{
			loginTest();
			Thread.sleep(3000);
			appo.EditAppointments();
			
		}
		@Test
		public void RescheduleAppointments() throws IOException, InterruptedException{
			loginTest();
			Thread.sleep(3000);
			appo.RescheduleAppointments();
			
		}
		@Test
		public void CreateGroupClassAppointments() throws IOException, InterruptedException{
			loginTest();
			Thread.sleep(3000);
			appo.GroupclassAppointments();
			
		}
		
	}