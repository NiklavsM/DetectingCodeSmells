import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;

class CodeSmellDetector {

    void run() {
        ClassLoader classLoader = getClass().getClassLoader();
        File dir = new File(Objects.requireNonNull(classLoader.getResource("TestSystem")).getFile());
//        File oneFile = new File("C:\\Users\\Niklavs\\Documents\\IntelliJProjects\\CodeSmellDetector\\src\\main\\java\\SupportClasses\\JavaClassExampleMAIN.java");

        try {
            parseFilesInDir(dir);
//            parseFile(oneFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void parseFilesInDir(File dir) throws FileNotFoundException {
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                if (child.isFile()) {
                    parseFile(child);
                } else {
                    parseFilesInDir(child);
                }
            }
        }
    }

    private void parseFile(File file) throws FileNotFoundException {
        System.out.println("================================================");
        System.out.println("File: " + file.getName());
        System.out.println("------------------------------------------------");
        searchForSmells(JavaParser.parse(file));
        System.out.println("================================================");

    }

    private void searchForSmells(CompilationUnit cu) {
        cu.accept(new LongMethodDetector(), null);
        cu.accept(new LargeClassBasicDetector(), null);
        cu.accept(new LongParameterListDetector(), null);
        cu.accept(new SwitchStatementDetector(), null);
        cu.accept(new DataClassDetector(), null);
        cu.accept(new PrimitiveObsessionDetector(), null);
        cu.accept(new MessageChainsDetector(), null);
        cu.accept(new TemporaryFieldDetector(), null);
        cu.accept(new LazyClassDetector(), null);
        cu.accept(new LargeClassAdvancedDetector(), null);
    }
}
