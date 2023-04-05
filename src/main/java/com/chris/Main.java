package com.chris;

import com.chris.UI.GuiMessage;
import com.chris.UI.Window;
import com.chris.algorithm.AlgorithmController;
import com.chris.util.PathCheck;

public class Main {

    public static void main(String[] args) {

        AlgorithmController algorithmController = new AlgorithmController();
        String path;
        String number;
        String finalPath;

        //Calling new window makes the hideous dialog window show up
        Window window = new Window();

        //get the information needed from the window that hopefully the user inputted
        number = window.getNumber();
        path = window.getPath();
        finalPath = window.getFinalPath();

        //hard code som file name I happened to come up with
        if (finalPath == null || finalPath.equals("")) {
            finalPath = "classAssignmentsLists";
        }

        GuiMessage message = null;
        if (path != null && number != null) {

            //AYYYYE its a miracle some validation
            String valid = PathCheck.checkPath(path);
            if (!path.contains(".xlsx")) {
                valid = "nExcel";
            }

            if (valid == null) {
                //try to give an alert that we're moving and grooving
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
            boolean failed = false;
            try {
                //lets call algorithmController
                algorithmController.run(path, number, finalPath);
            } catch (Exception e) {

                message1 = new GuiMessage("Process Failed.");
                failed = true;
                message1.toFront();
            }
            if (!failed) {
                message.closeMessage();

                //  System.out.println("Took "+(endTime - startTime) + " ns");
                message1 = new GuiMessage("Process Ended. Written to Desktop/" + finalPath);
                message1.toFront();
            }

        } else {
            GuiMessage message1;
            message1 = new GuiMessage("Process Failed. Incorrect Path or number of runs");
            message1.toFront();
        }

    }
}

