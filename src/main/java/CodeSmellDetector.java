import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.File;
import java.io.FileNotFoundException;

class CodeSmellDetector {

    void run() {
        File dir = new File("C:/Users/Niklavs/Documents/IntelliJProjects/CS409TestSystem/src");
        File oneFile = new File("C:\\Users\\Niklavs\\Documents\\IntelliJProjects\\CodeSmellDetector\\src\\main\\java\\SupportClasses\\JavaClassExample.java");
        try {
//            parseFilesInDir(dir);
            parseOneFile(oneFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void parseFilesInDir(File dir) throws FileNotFoundException {
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                if (child.isFile()) {
                    System.out.println("===================================");
                    System.out.println("File being analysed: " + child.getName());
                    searchForSmells(JavaParser.parse(child));
                    System.out.println("===================================");
                } else {
                    parseFilesInDir(child);
                }
            }
        }
    }

    private void parseOneFile(File child) throws FileNotFoundException {
        System.out.println("===================================");
        System.out.println("File being analysed: " + child.getName());
        searchForSmells(JavaParser.parse(child));
        System.out.println("===================================");

    }

    private void searchForSmells(CompilationUnit cu) {
//        cu.accept(new LongMethodDetector(), null);
//        cu.accept(new LargeClassBasicDetector(), null);
//        cu.accept(new LongParameterListDetector(), null);
        cu.accept(new SwitchStatementDetector(), null);
//        cu.accept(new DataClassDetector(), null);
//        cu.accept(new PrimitiveObsessionDetector(), null);
//        cu.accept(new MessageChainsDetector(), null);
    }
}
