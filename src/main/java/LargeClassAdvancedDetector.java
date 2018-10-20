import SupportClasses.BusynessScorer;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class LargeClassAdvancedDetector extends VoidVisitorAdapter<Void> {
    @Override
    public void visit(ClassOrInterfaceDeclaration n, Void args) {
        double busynessScore = BusynessScorer.getScore(n);
        if (busynessScore > 70) {
            System.out.println("Class \"" + n.getName() + "\" is too busy. Busyness score: " + busynessScore);
        }
        super.visit(n, args);
    }
}