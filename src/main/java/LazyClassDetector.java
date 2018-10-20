import SupportClasses.BusynessScorer;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class LazyClassDetector extends VoidVisitorAdapter<Void> {
    @Override
    public void visit(ClassOrInterfaceDeclaration n, Void args) {
        double busynessScore = BusynessScorer.getScore(n);
        if (busynessScore < 10) {
            System.out.println("Class \"" + n.getName() + "\" is lazy. Busyness score: " + busynessScore);
        }
        super.visit(n, args);
    }
}
