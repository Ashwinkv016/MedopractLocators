package pages;



import genericPages.CommonMethod;

public class AddPrescriptionPage extends CommonMethod{

	

	public AddPrescriptionPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public void getclickPrescription() {
		 click("prescriptionMenu");
	}

	public void getPatientNameField() {
		enterData("prescriptionPatientName","valied_PatientName");
	}
	
	public void getpatientNameSuggestion() {
		 click("prescriptionNameFieldSugg");
	}

	public void getEmailField() {
        enterData("prescriptionEmail","emailId");
	}

	public void getClickingPlusSign() {
		 click("prescriptionMedicineplus");
	}

	public void getMedicineNameField1() {
		 enterData("prescriptionMedicineName","medicineName1");
	}
	
	public void getMedicineNameField2() {
		 enterData("prescriptionMedicineName","medicineName2");
	}
	
	public void getTotalNumberDays1() {
	enterData("prescriptionDaysInput","noOfDays1");
	}
	
	public void getTotalNumberDays2() {
		enterData("prescriptionDaysInput","noOfDays2");
		}

	public void getTimingsInput1() {
     enterData("prescriptionTimings","instructions1");
	}
	
	public void getTimingsInput2() {
	     enterData("prescriptionTimings","instructions2");
		}

	public void getAmountInput1() {
          enterData("prescriptionAmountInput","amountToTake1");
	}
	
	public void getAmountInput2() {
        enterData("prescriptionAmountInput","amountToTake2");
	}

	public void getSaveAndPrintButton() {
		click("PrescriptionsaveAndPrintBtn");
	}

	public void getBackButton() {
	   click("addPrescriptionsBackBtn");
	}

    public void getyesButtonField() {
    	 click("prescriptionSaveYesBtn");
    }
    
    public void getprescriptionBackBtn() {
    	click("prescriptionBackBtn");
    }
		
    public void getprintPrescription() {
    	 click("printPrescriptionBtn");
    }	
	
    public void getdownloadPrescription() {
    	click("downloadPrescriptionBtn");
    }
	
//    public void getbackPrescriptionbtn() {
//    	 prescriptionBackBtn.click();
 //   }
	
    public void getdeleteMedicineField() {
    	click("prescriptionDeleteMedicine");
    }
}

