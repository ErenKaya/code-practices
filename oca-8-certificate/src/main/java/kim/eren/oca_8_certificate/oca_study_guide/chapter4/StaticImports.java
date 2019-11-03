package kim.eren.oca_8_certificate.oca_study_guide.chapter4;
import java.util.List;
import static java.util.Arrays.asList;
public class StaticImports {
public static void main(String[] args) {
List<String> list = asList("one", "two");
for (String listItem : list) {
    System.out.println(listItem);
}
} }