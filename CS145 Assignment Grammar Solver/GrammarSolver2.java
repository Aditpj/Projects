import java.util.*;
public class GrammarSolver2 {

private TreeMap <String, String[]> Term;

public GrammarSolver2(List<String> Rules) {
      if ((Rules.isEmpty() || Rules.size() == 0)) {
         throw new IllegalArgumentException();
      }
      Term = new TreeMap<>();
      for (String word : Rules) {
         word = word.trim();
         String[] clean = word.split("::=");
         String[] Terminals = clean[1].split("[|]");
         for (int i = 0; i < 2; i++) {
            clean[i] = clean[i].trim();
         }
         Term.put(clean[0], Terminals);
      }
   }
public boolean contains(String Symbol) {
      Symbol = Symbol.trim();
      if (Symbol == null) {
         throw new IllegalArgumentException();
      }
      return Term.containsKey(Symbol);
   }
public Set<String> getSymbols() {
      return Term.keySet();
   }
public String generate(String Symbol) {
      Symbol = Symbol.trim();
      String result = "";
      Random rand = new Random();
      if ((Symbol.length() == 0) || (Symbol == null)) {
         throw new IllegalArgumentException();
      }
      if (!contains(Symbol)) {
         return Symbol;
      }
      String[] temp = Term.get(Symbol);
      int choose = rand.nextInt(temp.length);
      String[] choice = temp[choose].split("[ \t]+");
      for (String word : choice) {
         if (!contains(word)) {
            result += " " + word;
         }
         else {
            result += generate(word);
         }
      }
      return result;
   }
}