import java.io.File;

public class PathCheck {
    public static String checkPath(String path){
     File file=new File(path);

      if(file.canRead()){
          return null;
      }else{
          return "Cannot open file";
      }
    }
}
