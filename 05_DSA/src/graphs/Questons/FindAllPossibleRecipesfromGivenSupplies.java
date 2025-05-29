package graphs.Questons;
import java.util.*;

public class FindAllPossibleRecipesfromGivenSupplies {
    public static void main(String[] args) {

    }

//    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
//        Map<String, List<String>> recipeGraph = new HashMap<>();
//        Set<String> available = new HashSet<>(Arrays.asList(supplies));
//        Set<String> recipesSet = new HashSet<>(Arrays.asList(recipes));
//        List<String> result = new ArrayList<>();
//
//        // Build graph (Recipe → Ingredients)
//        for (int i = 0; i < recipes.length; i++) {
//            recipeGraph.put(recipes[i], ingredients.get(i));
//        }
//
//        boolean added;
//        do {
//            added = false;
//            for (String recipe : recipesSet) {
//                if (!available.contains(recipe) && available.containsAll(recipeGraph.get(recipe))) {
//                    available.add(recipe);
//                    result.add(recipe);
//                    added = true; // Mark that we made progress
//                }
//            }
//        } while (added); // Continue until no new recipes are added
//
//        return result;
//    }


//    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
//        Map<String, Integer> inDegree = new HashMap<>();
//        Map<String, List<String>> graph = new HashMap<>();
//        Set<String> available = new HashSet<>(Arrays.asList(supplies));
//        Queue<String> queue = new LinkedList<>();
//        List<String> result = new ArrayList<>();
//
//        // Build graph with in-degree
//        for (int i = 0; i < recipes.length; i++) {
//            String recipie = recipes[i];
//            inDegree.put(recipie, ingredients.get(i).size());
//
//            for(String ingredient : ingredients.get(i)){
//                graph.putIfAbsent(ingredient, new ArrayList<>());
//                graph.get(ingredient).add(recipie);
//            }
//        }
//
//        queue.addAll(available);
//
//        while (!queue.isEmpty()){
//            String curr = queue.poll();
//
//            for (String neighbour : graph.get(curr)){
//
//            }
//        }
//
//
//        return result;
//    }
}
