import java.io.*;
import java.util.ArrayList;


class RunPython {

    void runScript(ArrayList loc_files) {

        String path = new File("").getAbsolutePath();
        // ALRIGHT SO BEFORE I FUCKING FORGET, JUST IMPLIMENT TO FIND PYTHON PATH SOMEHOW OR MAYBE A DAMN EXE CONVERT
        // AND THEN ALSO JUST SHOVE THAT SHIT IN HERE IN TEH CMD STRING ARRAY SO IT FINALLY FUCKING RUNS
        try {
            String[] cmd = {path + "\\GUI\\src\\Computation\\dist\\report_generator\\report_generator.exe",
                    loc_files.get(0).toString(), loc_files.get(1).toString()};
            Process p = Runtime.getRuntime().exec(cmd);

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
