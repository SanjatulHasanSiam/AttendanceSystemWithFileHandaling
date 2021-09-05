import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class creatingAttendanceSheets {
    //Method for making a file with initial absent values of the given month
    public static void month(String id, String month, int mNumber) throws IOException {
        if (mNumber == 1 || mNumber == 3 || mNumber == 5 || mNumber == 7 || mNumber == 8 || mNumber == 10 || mNumber == 12) {
            String filePath = "DataBase\\"+id;
            File f=new File(filePath);
            f.mkdirs();
            FileWriter fw = new FileWriter(f.getPath()+ "\\" + id + mNumber + ".txt");
            PrintWriter pw = new PrintWriter(fw);
            String s;
            for (int i = 1; i <= 31; i++) {
                s = String.format("%02d", i) + " " + month + " 2021 Absent";
                pw.println(s);
            }
            pw.flush();
            pw.close();
        } else if (mNumber == 2) {
            String filePath = "DataBase\\"+id;
            File f=new File(filePath);
            f.mkdirs();
            FileWriter fw = new FileWriter(f.getPath()+ "\\" + id + mNumber + ".txt");
            PrintWriter pw = new PrintWriter(fw);
            String s;
            for (int i = 1; i <= 28; i++) {
                s = String.format("%02d", i) + " " + month + " 2021 Absent";
                pw.println(s);
            }
            pw.flush();
            pw.close();
        } else {
            String filePath = "DataBase\\"+id;
            File f=new File(filePath);
            f.mkdirs();
            FileWriter fw = new FileWriter(f.getPath()+ "\\" + id + mNumber + ".txt");
            PrintWriter pw = new PrintWriter(fw);
            String s;
            for (int i = 1; i <= 30; i++) {
                s = String.format("%02d", i) + " " + month + " 2021 Absent";
                pw.println(s);
            }
            pw.flush();
            pw.close();
        }

    }

    //This method creates attendence sheet for 12 months by calling the month method
    public static void attSheet(String id) throws IOException {
        //making a directory for each id
        /*File idDirectory = new File(id);
        idDirectory.mkdir();*/
        for (int j = 1; j <= 12; j++) {
            switch (j) {
                case 1:
                    month(id, "January", 1);
                    break;
                case 2:
                    month(id, "February", 2);
                    break;
                case 3:
                    month(id, "March", 3);
                    break;
                case 4:
                    month(id, "April", 4);
                    break;
                case 5:
                    month(id, "May", 5);
                    break;
                case 6:
                    month(id, "June", 6);
                    String June;
                    break;
                case 7:
                    month(id, "July", 7);
                    String July;
                    break;
                case 8:
                    month(id, "August", 8);
                    String August;
                    break;
                case 9:
                    month(id, "September", 9);
                    String September;
                    break;
                case 10:
                    month(id, "October", 10);
                    String October;
                    break;
                case 11:
                    month(id, "November", 11);
                    String November;
                    break;
                case 12:
                    month(id, "December", 12);
                    break;
            }

        }

    }

    public static void main(String[] args) throws IOException {
        //We have to call the attSheet method for each student
        attSheet("ASH1925023M");
        attSheet("ASH1925025M");


    }
}
