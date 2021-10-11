import java.util.*;

class AP_Assignment {
    public static class COVIN {
        Scanner jc = new Scanner(System.in);

        String VaccineName;
        int Total_dose;
        int Gap_of_dose;

        String Name_of_Hospital;
        int Pincode_Hospital;
        static long Hospital_ID = 100000;

        String Name_of_Citizen;
        int Age_Citizen;
        long Citizen_Unique_ID;

        static ArrayList<String> Vaccine_Name = new ArrayList<>();
        static ArrayList<ArrayList<Integer>> Vaccine_Details = new ArrayList<>();

        static ArrayList<String> Name_Hospital = new ArrayList<>();
        static ArrayList<ArrayList<Integer>> Hospital_Details = new ArrayList<>();

        static ArrayList<String> Name_Citizen = new ArrayList<>();
        static ArrayList<ArrayList<Long>> Details_Citizens = new ArrayList<>();

        static ArrayList<ArrayList<ArrayList<Integer>>> Hospital_Slots = new ArrayList<>();

        public COVIN() {
            while (Hospital_Slots.size() < 20) {
                Hospital_Slots.add(null);
            }
        }

        public void show_Menu(){
            System.out.println("""
                    COVIN portal initialised -->
                    ==================================
                    1. Add Vaccine
                    2. Register Hospital
                    3. Register Citizen
                    4. Add Slot for Vaccination
                    5. Book Slot for Vaccination
                    6. List all Slots for a Hospital
                    7. Check Vaccination Status
                    8. Exit
                    ==================================""");

            System.out.println("Choose Action : ");
            int Option = jc.nextByte();

            if (Option == 1){
                Vaccine_Input();
            }
            else if (Option == 2){
                Hospital_Input();
            }
            else if(Option == 3){
                Citizen_Registration();
            }
            else if(Option == 4){
                Create_Slots();
            }
            else if(Option == 5){
                Book_a_Slot();
            }
            else if (Option == 6){
                Hospital_Status();
            }
            else if (Option == 7){
                Citizen_Vaccination_Status();
            }
            else if (Option == 8){
                Exit();
            }
            else{
                System.out.println("Invalid Input!! Try again!!\n");
                show_Menu();
            }
        }

        public void Exit(){
            System.out.println("The Portal has been Terminated!!");
            System.exit(0);
        }

        public void New_Vaccine(String x, int y, int z){
            this.VaccineName = x;
            this.Total_dose = y;
            this.Gap_of_dose = z;

            System.out.print("\nName of Vaccine : " + VaccineName + "\nTotal dose of Vaccine : " + Total_dose +
            "\nGap between Dose : " + Gap_of_dose +"\n\n");

            Vaccine_Name.add(VaccineName);

            ArrayList<Integer> Single_Vaccine = new ArrayList<>();
            Single_Vaccine.add(Total_dose);
            Single_Vaccine.add(Gap_of_dose);
            Vaccine_Details.add(Single_Vaccine);

            System.out.println("Information Updated.\n");

            show_Menu();
        }

        public void Vaccine_Input(){
            System.out.println("\nEnter Vaccine Name : ");
            String Vaccine_name = jc.next();

            System.out.println("Total number of doses required : ");
            int Vaccine_dose = jc.nextInt();

            int Vaccine_Gap;
            if (Vaccine_dose == 1){
                Vaccine_Gap = 0;
            }
            else{
                System.out.println("Days before Consecutive Vaccines : ");
                Vaccine_Gap = jc.nextInt();
            }

            New_Vaccine(Vaccine_name, Vaccine_dose, Vaccine_Gap);
        }

        public void Hospital_Input(){
            System.out.println("\nName of Hospital : ");
            String Hospital_Name = jc.next();

            System.out.println("Pincode : ");
            String Hospital_Pincode = jc.next();
            if(Hospital_Pincode.length() != 6){
                System.out.println("Pincode is of 6 Digits!! Kindly fill the form again from the start!!");
                Hospital_Input();
            }
            else{
                int Pincode_of_Hospital = Integer.parseInt(Hospital_Pincode);
                show_Hospital(Hospital_Name, Pincode_of_Hospital);
            }
        }

        public void show_Hospital(String x, int y){
            this.Name_of_Hospital = x;
            this.Pincode_Hospital = y;
            System.out.print("\nName of the Hospital : " + Name_of_Hospital + "\nHospital Pincode : " + Pincode_Hospital + "\nUnique Hospital ID : " + Hospital_ID + "\n\n");

            System.out.println("Information Updated.\n");

            Name_Hospital.add(Name_of_Hospital);

            ArrayList<Integer> Details_Hospital = new ArrayList<>();
            Details_Hospital.add((int)(Hospital_ID-100000));
            Details_Hospital.add(Pincode_Hospital);

            Hospital_Details.add(Details_Hospital);

            Hospital_ID++;
            show_Menu();
        }

        public void Citizen_Registration(){
            System.out.println("Enter your name : ");
            String Citizen_Name = jc.next();

            System.out.println("Enter your age : ");
            int Citizen_Age = jc.nextInt();

            if (Citizen_Age < 18){
                System.out.println("You are not eligible for Vaccination. You have not been registered!!");
                Citizen_Registration();
            }
            else{
                System.out.println("Enter your unique 12 Digit iD : ");
                String Citizen_ID = jc.next();
                if (Citizen_ID.length() != 12){
                    System.out.println("Error!! Please type your unique 12 Digit ID!! Please Register again from the start");
                    Citizen_Registration();
                }
                else{
                    long ID_Citizen = Long.parseLong(Citizen_ID);
                    show_Citizen(Citizen_Name, Citizen_Age, ID_Citizen);
                }
            }
        }

        public void show_Citizen(String x, int y, long z){
            this.Name_of_Citizen = x;
            this.Age_Citizen = y;
            this.Citizen_Unique_ID = z;
            System.out.println("\nName of the Citizen : " + Name_of_Citizen + "\nAge of Citizen : " + Age_Citizen + "\nUnique ID of Citizen : " + Citizen_Unique_ID +
            "\nVaccination Status : Registered!!\n");

            Name_Citizen.add(Name_of_Citizen);
            ArrayList<Long> Citizen_Details = new ArrayList<>();
            Citizen_Details.add((long) Age_Citizen);
            Citizen_Details.add(Citizen_Unique_ID);
            Citizen_Details.add((long)0);   // No. of Doses
            Citizen_Details.add((long)0);   // Vaccine Number/Name
            Details_Citizens.add(Citizen_Details);

            System.out.println("Information Updated.\n");

            show_Menu();
        }

        public void Create_Slots(){

            ArrayList<ArrayList<Integer>> Hospital_Slots_Details = new ArrayList<>();
            while(Hospital_Slots_Details.size() < 10){
                Hospital_Slots_Details.add(null);
            }

            System.out.println("Enter Hospital ID : ");
            int HospitalID = jc.nextInt();

            if ((HospitalID >= 100000) && (HospitalID <= Hospital_ID)){
                System.out.println("Enter the Slots to be added : ");
                int no_of_slots = jc.nextInt();
                for (int j = 0; j<no_of_slots; j++) {
                    System.out.println("\nEnter Day Number : ");
                    int Day_No = jc.nextInt();
                    System.out.println("Enter Quantity : ");
                    int Quantity = jc.nextInt();
                    System.out.println("Select Vaccine : ");
                    for (int i = 0; i < Vaccine_Name.size(); i++) {
                        System.out.println(i + ". " + Vaccine_Name.get(i));
                    }
                    int Select_Vaccine = jc.nextInt();
                    if ((Select_Vaccine < Vaccine_Name.size()) && (Select_Vaccine >= 0)) {
                        int z = HospitalID - 100000;

                        ArrayList<Integer> Hospital_Vaccine_Details = new ArrayList<>();
                        Hospital_Vaccine_Details.add(Day_No);
                        Hospital_Vaccine_Details.add(Quantity);
                        Hospital_Vaccine_Details.add(Select_Vaccine);

                        Hospital_Slots_Details.set(j, Hospital_Vaccine_Details);
                        Hospital_Slots.set(z, Hospital_Slots_Details);

                        System.out.println("\nName of Hospital : " + Name_Hospital.get(z) + "\nUnique Code of the Hospital : " +
                                (z + 100000) + "\nNo. of Slots in the Hospital : " + j + "\nDay Number : " + Day_No + "\nQuantity of Vaccines : "
                                + Quantity + "\nVaccine Chosen : " + Vaccine_Name.get(Select_Vaccine) +"\n");

                        System.out.println("Information Updated!!!\n");
                    }
                    else {
                        System.out.println("No Option as Such!! Try creating the Slot again!!\n");
                        Create_Slots();
                    }
                }
                show_Menu();
            }
            else{
                System.out.println("Wrong Hospital ID!! Please add slot from the start!!\n");
                Create_Slots();
            }
        }

        public void Book_a_Slot(){
            System.out.println("Enter your Unique 12-digit ID : ");
            long ID_input = jc.nextLong();
            for(int i = 0; i < Details_Citizens.size(); i++){
                if ((ID_input)==(Details_Citizens.get(i).get(1))){
                    System.out.println("""
                            ID Confirmed.
                            Please choose the option by which you want to Book A Slot :
                            0. By Pincode
                            1. By Vaccine""");

                    int Option = jc.nextByte();
                    if (Option == 0){
                        System.out.println("Enter the Pincode : ");
                        int Enter_Pincode = jc.nextInt();
                        int k = 0;
                        do{
                            if(Enter_Pincode == Hospital_Details.get(k).get(1)){
                                System.out.println("Hospital Name : " + Name_Hospital.get(k) +
                                " (Hospital ID : " + (Hospital_Details.get(k).get(0)+100000) + ")");
                            }
                            k++;
                        }
                        while (k < Hospital_Details.size());
                        System.out.println("Enter Code of the Hospital : ");
                        int Enter_Hospital_Code = jc.nextInt();

                        int j =0;
                        do{
                            if(Enter_Pincode == Hospital_Details.get(j).get(1) &&
                             (Enter_Hospital_Code-100000) == Hospital_Details.get(j).get(0)){
                                if (Hospital_Slots.get(Enter_Hospital_Code-100000).isEmpty()){
                                    System.out.println("No Slots Available!! Try entering Different Pincode...!!");
                             }
                                 else {
                                    for (int l = 0; l < Hospital_Slots.get(Enter_Hospital_Code - 100000).size(); l++) {
                                        if (Hospital_Slots.get(Enter_Hospital_Code - 100000) == null){
                                            continue;
                                        }
                                        else if(Hospital_Slots.get(Enter_Hospital_Code - 100000).get(l) == null){
                                            continue;
                                        }
                                        else {
                                            System.out.println(l + ". Day : " + Hospital_Slots.get(Enter_Hospital_Code - 100000).get(l).get(0)
                                                    + " Available Quantity : " + (Hospital_Slots.get(Enter_Hospital_Code - 100000).get(l).get(1))
                                                    + " Vaccine Name : " + Vaccine_Name.get(Hospital_Slots.get(Enter_Hospital_Code - 100000).get(l).get(2)));
                                        }
                                    }
                                    System.out.println("Choose Slot : ");
                                    int Select_Slot = jc.nextByte();
                                    System.out.println(Name_Citizen.get(i) + " - given one dose of vaccine of " +
                                            Hospital_Slots.get(Enter_Hospital_Code - 100000).get(Select_Slot).get(2) + "\n Information Updated. \n");

                                    int z = Hospital_Slots.get(Enter_Hospital_Code - 100000).get(Select_Slot).get(1);
                                    Hospital_Slots.get(Enter_Hospital_Code - 100000).get(Select_Slot).set(1, z - 1);

                                    long x = Details_Citizens.get(i).get(2);
                                    Details_Citizens.get(i).set(2, x + 1);

                                    Details_Citizens.get(i).set(3, (long) Hospital_Slots.get(Enter_Hospital_Code - 100000).get(Select_Slot).get(2));

                                    show_Menu();
                                }
                            }
                            j++;
                        }
                        while(j < Hospital_Details.size());

                    }
                    else if (Option == 1){
                        System.out.println("The Vaccines available are : ");
                        for (int j = 0; j < Vaccine_Name.size(); j++){
                            System.out.println(j + ". " + Vaccine_Name.get(j));
                        }
                        System.out.println("Choose Vaccine : ");
                        int Choose_Vaccine = jc.nextByte();
                        int l = 0;
                        for (int j = 0; j < Hospital_Slots.size(); j++){
                            if (Hospital_Slots.get(j).isEmpty()){
                                continue;
                            }
                            else {
                                for (int k = 0; k < Hospital_Slots.get(j).size(); k++) {
                                    if (Hospital_Slots.get(j).get(k).get(2) == Choose_Vaccine) {
                                        System.out.println(l + ". " + Name_Hospital.get(j) + "; Pincode : " + Hospital_Details.get(j).get(1) +
                                                "; Day - " + Hospital_Slots.get(j).get(k).get(0) + "of Hospital" + "; Vaccine : " + Choose_Vaccine + "   Hospital ID : " + (j + 100000));
                                        l++;
                                    }
                                }
                            }
                        }

                        System.out.println("Choose Hospital Option (Enter Hospital ID) : ");
                        long Choose_Hospital_Option = jc.nextLong();
                        int z = (int) (Choose_Hospital_Option-100000);
                        for (int k = 0; k < Hospital_Slots.get(z).size(); k++){
                            if(Hospital_Slots.get(z).get(k).get(2) == Choose_Vaccine){
                                System.out.println("You have been given of 1 dose of vaccine " + Choose_Vaccine + " on Day - "
                                + Hospital_Slots.get(z).get(k).get(0) + " from " + Name_Hospital.get(z) +" Hospital!!");

                                int x = Hospital_Slots.get(z).get(k).get(1);
                                Hospital_Slots.get(z).get(k).set(1, x-1);
                            }
                        }
                        show_Menu();
                    }
                    else{
                        System.out.println("Wrong Input!! Book the Slot from the Start!!");
                        Book_a_Slot();
                    }
                }
                
            }
        }

        public void Hospital_Status(){
            System.out.println("Enter Hospital ID : ");
            long Hospital_ID = jc.nextLong();
            int z = (int)(Hospital_ID-100000);
            if(z>=0 && z < Hospital_Details.size()){
                System.out.println("Hospital Login Confirmed!! Loading Details....\n");
                System.out.println("Hospi1" +
                        "tal Name : " + Name_Hospital.get(z));
                for(int i = 0; i < Hospital_Slots.get(z).size(); i++) {
                    if (Hospital_Slots.get(z).get(i) != null) {
                        System.out.println("Day --> " + Hospital_Slots.get(z).get(i).get(0) + "; Quantity : " +
                        Hospital_Slots.get(z).get(i).get(1) + "; Vaccine : " + Vaccine_Name.get(Hospital_Slots.get(z).get(i).get(2)));
                        show_Menu();
                    }
                }
            }
            else {
                System.out.println("Hospital ID not found!! Please Try again!! \n");
                Hospital_Status();
            }
        }

        public void Citizen_Vaccination_Status(){
            System.out.println("Enter Unique ID Number : ");
            long Unique_ID = jc.nextLong();

            for(int i = 0; i < Name_Citizen.size(); i++){
                if (Details_Citizens.get(i).get(1) == Unique_ID){
                    long x = (Details_Citizens.get(i).get(3));  // Citizen Vaccine No.
                    int y = (int)x;
                    long z = (Details_Citizens.get(i).get(2));  // Citizen Doses taken
                    int a = (int) z;
                    int b = Vaccine_Details.get(y).get(0);      // Total No. of Doses to be Taken
                    System.out.println("Citizen Login Confirmed. Loading Details...");
                    System.out.println("Citizen Name : " + Name_Citizen.get(i));
                    if(a == 0){
                        System.out.println("Status : Registered!!\n");
                    }
                    else if (a < b && a > 0){
                        System.out.println("Status : Partially Vaccinated!!\nDoses Remaining : " + (b-a) + " out of " + b + "Doses Remaining!!");
                        System.out.println("Vaccine Taken : " + Vaccine_Name.get(y));
                    }
                    else if (a == b){
                        System.out.println("Status : Fully vaccinated!!");
                    }
                }
            }
            System.out.println("\n");
            show_Menu();
        }

    }
    public static void main(String[] args) {
        COVIN cv = new COVIN();
        cv.show_Menu();
    }
}