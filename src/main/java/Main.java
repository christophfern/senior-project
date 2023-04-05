
public class Main {

    public static void main(String[] args) {

        RunAll runAll = new RunAll();
        String path;
        String number;
        String finalPath;




            Window window = new Window();
            number = window.getNumber();
            path = window.getPath();
            finalPath=window.getFinalPath();

            if(finalPath==null || finalPath==""){
                finalPath="classAssignmentsLists";
            }

            GuiMessage message = null;
            if (path != null && number != null) {

                String valid = PathCheck.checkPath(path);
                if (!path.contains(".xlsx")) {
                    valid = "nExcel";
                }

                if (valid == null) {
                    message = new GuiMessage("Process Beginning");

                    message.toFront();

                } else if (valid.equals("nExcel")) {
                    message = new GuiMessage("Not an Excel File. Please Try again");
                    message.toFront();
                } else {
                    message = new GuiMessage("Unable to open file. Please try again.");
                    message.toFront();
                }

            GuiMessage message1;
                boolean failed=false;
            try {
                runAll.run(path, number,finalPath);
            } catch (Exception e) {

                message1 = new GuiMessage("Process Failed.");
                failed=true;
                message1.toFront();
            }
            if(!failed) {
                message.closeMessage();

              //  System.out.println("Took "+(endTime - startTime) + " ns");
                message1 = new GuiMessage("Process Ended. Written to Desktop/" + finalPath);
                message1.toFront();
            }

        } else{
                GuiMessage message1;
                message1 = new GuiMessage("Process Failed. Incorrect Path or number of runs");
                message1.toFront();
            }

    }
}

