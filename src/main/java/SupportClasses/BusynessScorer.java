package SupportClasses;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;

public class BusynessScorer {

    private static final double METHOD_W = 1;
    private static final double CONSTRUCTOR_W = 2;
    private static final double INTERFACE_W = 2;
    private static final double FIELD_W = 0.5;
    private static final double STATEMENT_W = 0.5;

    public static double getScore(ClassOrInterfaceDeclaration classToScore) {
        double score = 0;
        score += classToScore.getMethods().size() * METHOD_W;
        score += classToScore.getConstructors().size() * CONSTRUCTOR_W;
        score += classToScore.getImplementedTypes().size() * INTERFACE_W;
        score += classToScore.getFields().size() * FIELD_W;
        score += countStatements(classToScore) * STATEMENT_W;
//        System.out.println("METHOD_W : " + classToScore.getMethods().size() * METHOD_W);
//        System.out.println("STATEMENT_W : " + countStatements(classToScore) * STATEMENT_W);
//        System.out.println("CONSTRUCTOR_W : " + classToScore.getConstructors().size() * CONSTRUCTOR_W);
//        System.out.println("INTERFACE_W : " + classToScore.getImplementedTypes().size() * INTERFACE_W);
//        System.out.println("FIELD_W : " + classToScore.getFields().size() * FIELD_W);
        return score;
    }

    private static double countStatements(ClassOrInterfaceDeclaration classToScore) {
        StatementCounter sc = new StatementCounter();
        classToScore.accept(sc, null);
        return sc.getCount();
    }
}
