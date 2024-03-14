import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.util.Scanner;
class covid_19 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean accept = true;
        covid_19 cv = new covid_19();

        while (accept){
            System.out.println("you are  male or female");
            String gender = scan.next();
            if(gender.equals("male")||gender.equals("female")) {
                accept = false;
            }
        }
        System.out.println("please input Date of brith \"yyyy-MM-dd\" to get Vaccine");
        while (!accept) {

            String dobStr = scan.next();

            try {

                LocalDate dob = LocalDate.parse(dobStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));


                LocalDate startVaccine = LocalDate.parse("2021-06-01");
                LocalDate endVaccine = LocalDate.parse("2021-08-31");


                Period startAge = Period.between(dob,startVaccine);
                Period endAge = Period.between(dob,endVaccine);

                LocalDate sixM = dob.plusMonths(6);
                LocalDate twoY = dob.plusYears(2);
                LocalDate sixtyFiveY = dob.plusYears(65);

                accept = true;

                System.out.println("วันที่เกิด : " + dob);
                System.out.println("วันที่เริ่มรับวัคซีน : " + startVaccine);
                System.out.println("อายุครบ 6 เดือน : " + sixM);
                System.out.println("อายุครบ 2 ปี : " + twoY);
                System.out.println("อายุครบ 66 ปี : " + sixtyFiveY);

                System.out.println("วันที่เริ่มฉีด ฉันอายุุ ุ: " + startAge.getYears() + " ปี, " + startAge.getMonths() + " เดือน, " + startAge.getDays() + " วัน");
                System.out.println("วันสุดท้าย ฉันอายุ ุ: " + endAge.getYears() + " ปี, " + endAge.getMonths() + " เดือน, " + endAge.getDays() + " วัน");

                if(startAge.getYears()>=65){
                    System.out.println("Eligible Flag : Y");
                    System.out.println("จัดอยู่ในกลุ่มอายุ เกิน 65 ตั้งเเต่เเรก");
                    System.out.println("วันที่เริ่มรับวัคซีน : " + startVaccine);
                    System.out.println("วันที่สุดท้าย : " + endVaccine);
                }else if(endAge.getYears()>=65){
                    System.out.println("Eligible Flag : Y");
                    System.out.println("จัดอยู่ในกลุ่มอายุ เกิน 65 ตอนช่วงฉีด");
                    System.out.println("วันที่เริ่มรับวัคซีน : " + sixtyFiveY);
                    System.out.println("วันที่สุดท้าย : " + endVaccine);
                }else if(startAge.getYears()==0 && startAge.getMonths()>=6){
                    System.out.println("Eligible Flag : Y");
                    System.out.println("จัดอยู่ในกลุ่มอายุ 6 เดือน ถึง 2 ปี");
                    System.out.println("วันที่เริ่มรับวัคซีน : " + startVaccine);
                    System.out.println("วันที่สุดท้าย : " + endVaccine);
                }else if(startAge.getYears()>=1 && startAge.getYears()<=2){
                    if(endAge.getYears()>=1 && (endAge.getYears()<=2 && endAge.getMonths() == 0 && endAge.getDays()==0)){
                        System.out.println("Eligible Flag : Y");
                        System.out.println("จัดอยู่ในกลุ่มอายุ 6 เดือน ถึง 2 ปี");
                        System.out.println("วันที่เริ่มรับวัคซีน : " + startVaccine);
                        System.out.println("วันที่สุดท้าย : " + endVaccine);
                    }else{
                        System.out.println("Eligible Flag : Y");
                        System.out.println("จัดอยู่ในกลุ่มอายุ วันเเรกตามเกณ เเต่อายุเกินก่อนถึงวันสุดท้าย");
                        System.out.println("วันที่เริ่มรับวัคซีน : " + startVaccine);
                        System.out.println("วันที่สุดท้าย : " + twoY);
                    }
                }else if(endAge.getYears()==0 && endAge.getMonths()>=6){
                    System.out.println("Eligible Flag : Y");
                    System.out.println("จัดอยู่ในกลุ่มอายุวันเริ่มฉีดไม่ถึง พึ่งถึงช่วงฉีด");
                    System.out.println("วันที่เริ่มรับวัคซีน : " + sixM);
                    System.out.println("วันที่สุดท้าย : " + endVaccine);
                }else{
                    System.out.println("Eligible Flag : N");
                    System.out.println("คุณไม่เข้าตามเกณการรับวัคซีน อายุของคุณ คือ ");
                    System.out.println("วันที่เริ่มฉีด ฉันอายุุ ุ: " + startAge.getYears() + " ปี, " + startAge.getMonths() + " เดือน, " + startAge.getDays() + " วัน");
                    System.out.println("วันสุดท้าย ฉันอายุ ุ: " + endAge.getYears() + " ปี, " + endAge.getMonths() + " เดือน, " + endAge.getDays() + " วัน");
                }
            } catch (Exception e) {
                System.out.println("คุณใส่รูปเเบบวันผิดนะครับ \nกรุณาใส่ให้ถูกดังตัวอย่าง \"yyyy-MM-dd\" เพื่อรับ Vaccine");

            }
        }
    }

}