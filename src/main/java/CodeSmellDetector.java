import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CodeSmellDetector {

    public void run() {
        FileInputStream in = null;
        try {
            in = new FileInputStream("JavaClassExample.java");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        CompilationUnit cu = JavaParser.parse(in);
        cu.accept(new LongMethodDetector(), null);
        cu.accept(new LargeClassBasicDetector(), null);
        cu.accept(new LongParameterListDetector(), null);
        cu.accept(new SwitchStatementDetector(), null);



    }
}
