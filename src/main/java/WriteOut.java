import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import org.apache.poi.openxml4j.exceptions.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteOut {
   private static XSSFWorkbook workbook=new XSSFWorkbook();



    public static void writeOut(ArrayList<Room> outList, int sheetNum,
                                TreeMap<String,ArrayList<Integer>> roomResults,long startTime) throws IOException, InvalidFormatException {
        // Create a Workbook
        //Blank workbook

       XSSFSheet sheet= workbook.createSheet("test" + sheetNum);


        //Create a blank sheet

        //This data needs to be written (Object[])
        int rowNum=0;
        int colNum=0;
        int index=0;
        int currColumn=0;
            for(Room room : outList){
                Row row;
                Cell cell;
                if(index==0) {
                    row = sheet.createRow(rowNum);
                    cell=row.createCell(colNum);
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    cell.setCellValue(room.getName());
                }else{
                    row=sheet.getRow(0);
                    currColumn=colNum+10;
                    rowNum=0;

                    cell=row.createCell(currColumn);
                    cell.setCellType(Cell.CELL_TYPE_STRING);

                    cell.setCellValue(room.getName());
                }


                    for (Student student : room.getStudentList()) {
                        rowNum++;
                        if(index==0) {
                            row = sheet.createRow(rowNum);
                        }else{
                           colNum= currColumn;
                           row=sheet.getRow(rowNum);
                           if(row==null){
                               row = sheet.createRow(rowNum);
                           }
                        }

                        cell = row.createCell(colNum++);
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        cell.setCellValue(student.getName());
                        cell = row.createCell(colNum++);
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        cell.setCellValue(student.getChoice1());
                        cell = row.createCell(colNum++);
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        cell.setCellValue(student.getChoice2());
                        cell = row.createCell(colNum++);
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        cell.setCellValue(student.getChoice3());
                        cell = row.createCell(colNum++);
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        cell.setCellValue(student.getChoice4());
                        cell = row.createCell(colNum++);
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        cell.setCellValue(student.getChoice5());
                        cell = row.createCell(colNum++);
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        cell.setCellValue(student.getGender());
                        cell = row.createCell(colNum++);
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        cell.setCellValue(student.getSportPlayed());
                        cell = row.createCell(colNum++);
                        cell.setCellType(Cell.CELL_TYPE_BOOLEAN);
                        cell.setCellValue(student.getConditionalAdmit());
                        colNum = currColumn;
                    }
                index++;


            }
            XSSFSheet sheet2= workbook.createSheet("results" + sheetNum);

               Set<String> rooms = roomResults.keySet();

                    int rowIn=0;
                    int colIn=0;
                    for(String s : rooms){
                        int i=0;
                        ArrayList<Integer> counts=roomResults.get(s);
                        Row row=sheet2.createRow(rowIn++);
                        Cell cell = row.createCell(colIn);
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        cell.setCellValue(s);
                        row=sheet2.createRow(rowIn++);
                        cell = row.createCell(colIn);
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        cell.setCellValue("Students in choice 1");
                        cell=row.createCell(colIn+1);
                        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                        cell.setCellValue(counts.get(i++));
                        row=sheet2.createRow(rowIn++);
                        cell = row.createCell(colIn);
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        cell.setCellValue("Students in choice 2");
                        cell=row.createCell(colIn+1);
                        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                        cell.setCellValue(counts.get(i++));
                        row=sheet2.createRow(rowIn++);
                        cell = row.createCell(colIn);
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        cell.setCellValue("Students in choice 3");
                        cell=row.createCell(colIn+1);
                        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                        cell.setCellValue(counts.get(i++));
                        row=sheet2.createRow(rowIn++);
                        cell = row.createCell(colIn);
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        cell.setCellValue("Students in choice 4");
                        cell=row.createCell(colIn+1);
                        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                        cell.setCellValue(counts.get(i++));
                        row=sheet2.createRow(rowIn++);
                        cell = row.createCell(colIn);
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        cell.setCellValue("Students in choice 5");
                        cell=row.createCell(colIn+1);
                        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                        cell.setCellValue(counts.get(i++));
                        row=sheet2.createRow(rowIn++);
                        cell = row.createCell(colIn);
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        cell.setCellValue("Males in Class");
                        cell=row.createCell(colIn+1);
                        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                        cell.setCellValue(counts.get(i++));
                        row=sheet2.createRow(rowIn++);
                        cell = row.createCell(colIn);
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        cell.setCellValue("Females in Cllas");
                        cell=row.createCell(colIn+1);
                        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                        cell.setCellValue(counts.get(i++));
                        row=sheet2.createRow(rowIn++);
                        cell = row.createCell(colIn);
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        cell.setCellValue("Athletes in Cllas");
                        cell=row.createCell(colIn+1);
                        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                        cell.setCellValue(counts.get(i++));
                        row=sheet2.createRow(rowIn++);
                        cell = row.createCell(colIn);
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        cell.setCellValue("Conditional in wrong");
                        cell=row.createCell(colIn+1);
                        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                        cell.setCellValue(counts.get(i++));
                        row=sheet2.createRow(rowIn++);
                        cell = row.createCell(colIn);
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        cell.setCellValue("Students of Color ");
                        cell=row.createCell(colIn+1);
                        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                        cell.setCellValue(counts.get(i++));
                        row=sheet2.createRow(rowIn++);
                        cell = row.createCell(colIn);
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        cell.setCellValue("International Students");
                        cell=row.createCell(colIn+1);
                        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                        cell.setCellValue(counts.get(i++));
                        row=sheet2.createRow(rowIn++);
                        cell = row.createCell(colIn);
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        cell.setCellValue("Total in wrong");
                        cell=row.createCell(colIn+1);
                        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                        cell.setCellValue(counts.get(i++));
                    }
        long endTime = System.nanoTime();
        double fullTime=(endTime - startTime)*0.000000001;

        System.out.println("made it here");
        Row row=sheet2.createRow(rowIn++);
                Cell cell = row.createCell(colIn++);
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                cell.setCellValue(fullTime);
                //cell=row.createCell(colIn+1);
                //cell.setCellType(Cell.CELL_TYPE_NUMERIC);
               // cell.setCellValue(counts.get(i++));

            try {
                //Write the workbook in file system
                String username = System.getProperty("user.name");
                String os=System.getProperty("os.name");
                FileOutputStream out;
                if(os.contains("Window")){
                    out=new FileOutputStream(new File("C:\\Users\\"+username+"\\Desktop\\classAssignments.xlsx"));
                }else {
                     out = new FileOutputStream(new File("/Users/" + username + "/Desktop/classAssignments.xlsx"));
                }
                    workbook.write(out);
                    out.close();
               // System.out.println(" written successfully on disk.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}

