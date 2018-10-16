import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CodeSmellDetector {

    public void run() {
        File dir = new File("C:/Users/Niklavs/Documents/IntelliJProjects/CS409TestSystem/src");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
//                FileInputStream in = null;
//                try {
//                    in = new FileInputStream(child);
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }

                CompilationUnit cu = null;
                try {
                    System.out.println(child.getName());
                    if (child.isFile()) {
                        cu = JavaParser.parse(child);
                        cu.accept(new SwitchStatementDetector(), null);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
//        cu.accept(new LongMethodDetector(), null);
//        cu.accept(new LargeClassBasicDetector(), null);
//        cu.accept(new LongParameterListDetector(), null);
//        cu.accept(new SwitchStatementDetector(), null);
//        cu.accept(new DataClassDetector(), null);
            }


        }
    }
}
