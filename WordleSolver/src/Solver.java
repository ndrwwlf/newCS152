import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@SuppressFBWarnings({"DM_DEFAULT_ENCODING", "WMI_WRONG_MAP_ITERATOR"})
public class Solver {
    @SuppressFBWarnings({"DLS_DEAD_LOCAL_STORE", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT"})
    public static void main(String[] args) throws IOException {

        String e = "blane";
        String ee = "blaee";
        long eInt = e.chars().filter(ch -> ch == 'e').count();
        long eeInt = ee.chars().filter(ch -> ch == 'e').count();
        ArrayList<String> words = getWords("words5-knuth.txt");

        HashMap<String, Integer> wordMap = new HashMap<>();
        wordMap = fillMap(words);

        String[][] guessResults = new String[5][1];
//        guessResults = guess("slate");

//        String thisGuess = "slate";
        String thisGuess = makeGuess(words);
//        String thisGuess = "salet";

        boolean won = false;

        while (!won) {

            StdOut.println("Guess: " + thisGuess);
            guessResults = guess(thisGuess);

            boolean game = true;
            for (int i = 0; i < guessResults.length; i++) {
                if (guessResults[i][0].charAt(1) != 'g') {
                    game = false;
                    break;
                }
            }

            if (game) {
                won = true;
                StdOut.println("Looks like you won!");
//                String[] args2 = new String[];
//                main(args2);
                return;
            }

            wordMap = parseGuess(guessResults, wordMap);

            ArrayList<String> possList = getPossibles(wordMap);

            thisGuess = makeGuess(possList);
            StdOut.println("Guess: " + thisGuess);
            StdOut.println(possList);


//        ranks = suggest(guessResults);
//        StdOut.println(posibles);

        }
    }

    // https://gist.github.com/colmmacc/5783eb809f5714c30d8a8ee759e0af59
    // https://stackoverflow.com/questions/275944/how-do-i-count-the-number-of-occurrences-of-a-char-in-a-string
    public static String makeGuess(ArrayList<String> possWords) {

        HashMap<String, Integer> wordRankMap = new HashMap<>();

        HashMap<Character, Integer> letterMap = new HashMap<>();

        for (String word : possWords) {

            for (Character ch : word.toCharArray()) {
                int count = 0;
                if (letterMap.containsKey(ch)) {
                    count += letterMap.get(ch);
                    count++;
                    letterMap.replace(ch, count);
                } else {
                    letterMap.put(ch, 1);
                }
            }
        }
        for (String word : possWords) {

            int count = 0;

//            if (word.contains("e")) count += 1233;
//            if (word.contains("e")) count += word.chars().filter(ch -> ch == 'e').count() * 1233;
            if (word.length() - word.replace("e", "").length() > 0) count += 1233 * (letterMap.get('e') + 1);
//            if ((word.length() - word.replace("e", "").length()) > 0)
//                count += 1233 * (word.length() - word.replace("e", "").length());
//            if (word.length() - word.replace("e", "").length() > 0) count += 1233;
//            if (word.contains("a")) count += word.chars().filter(ch -> ch == 'a').count() * 979;
//            if (word.contains("r")) count += word.chars().filter(ch -> ch == 'r').count() * 899;
//            if (word.contains("o")) count += word.chars().filter(ch -> ch == 'o').count() * 754;
//            if (word.contains("t")) count += word.chars().filter(ch -> ch == 't').count() * 729;
//            if (word.contains("l")) count += word.chars().filter(ch -> ch == 'l').count() * 719;
//            if (word.contains("i")) count += word.chars().filter(ch -> ch == 'i').count() * 671;
//            if (word.contains("s")) count += word.chars().filter(ch -> ch == 's').count() * 669;
//            if (word.contains("n")) count += word.chars().filter(ch -> ch == 'n').count() * 575;
//            if (word.contains("c")) count += word.chars().filter(ch -> ch == 'c').count() * 477;
//            if (word.contains("u")) count += word.chars().filter(ch -> ch == 'u').count() * 467;
//            if (word.contains("y")) count += word.chars().filter(ch -> ch == 'y').count() * 425;
//            if (word.contains("d")) count += word.chars().filter(ch -> ch == 'd').count() * 393;
//            if (word.contains("h")) count += word.chars().filter(ch -> ch == 'h').count() * 389;
//            if (word.contains("p")) count += word.chars().filter(ch -> ch == 'p').count() * 367;
//            if (word.contains("m")) count += word.chars().filter(ch -> ch == 'm').count() * 316;
//            if (word.contains("g")) count += word.chars().filter(ch -> ch == 'g').count() * 311;
//            if (word.contains("b")) count += word.chars().filter(ch -> ch == 'b').count() * 281;
//            if (word.contains("f")) count += word.chars().filter(ch -> ch == 'f').count() * 230;
//            if (word.contains("k")) count += word.chars().filter(ch -> ch == 'k').count() * 210;
//            if (word.contains("w")) count += word.chars().filter(ch -> ch == 'w').count() * 195;
//            if (word.contains("v")) count += word.chars().filter(ch -> ch == 'v').count() * 153;
//            if (word.contains("z")) count += word.chars().filter(ch -> ch == 'z').count() * 40;
//            if (word.contains("x")) count += word.chars().filter(ch -> ch == 'x').count() * 37;
//            if (word.contains("q")) count += word.chars().filter(ch -> ch == 'q').count() * 29;
//            if (word.contains("j")) count += word.chars().filter(ch -> ch == 'j').count() * 27;

//            if (word.contains("a")) count += 979;
//            if (word.contains("r")) count += 899;
//            if (word.contains("o")) count += 754;
//            if (word.contains("t")) count += 729;
//            if (word.contains("l")) count += 719;
//            if (word.contains("i")) count += 671;
//            if (word.contains("s")) count += 669;
//            if (word.contains("n")) count += 575;
//            if (word.contains("c")) count += 477;
//            if (word.contains("u")) count += 467;
//            if (word.contains("y")) count += 425;
//            if (word.contains("d")) count += 393;
//            if (word.contains("h")) count += 389;
//            if (word.contains("p")) count += 367;
//            if (word.contains("m")) count += 316;
//            if (word.contains("g")) count += 311;
//            if (word.contains("b")) count += 281;
//            if (word.contains("f")) count += 230;
//            if (word.contains("k")) count += 210;
//            if (word.contains("w")) count += 195;
//            if (word.contains("v")) count += 153;
//            if (word.contains("z")) count += 40;
//            if (word.contains("x")) count += 37;
//            if (word.contains("q")) count += 29;
//            if (word.contains("j")) count += 27;

            if (word.length() - word.replace("a", "").length() > 0) count += 979 * (letterMap.get('a') + 1);
            if (word.length() - word.replace("r", "").length() > 0) count += 899 * (letterMap.get('r') + 1);
            if (word.length() - word.replace("o", "").length() > 0) count += 754 * (letterMap.get('o') + 1);
            if (word.length() - word.replace("t", "").length() > 0) count += 729 * (letterMap.get('t') + 1);
            if (word.length() - word.replace("l", "").length() > 0) count += 719 * (letterMap.get('l') + 1);
            if (word.length() - word.replace("i", "").length() > 0) count += 671 * (letterMap.get('i') + 1);
            if (word.length() - word.replace("s", "").length() > 0) count += 669 * (letterMap.get('s') + 1);
            if (word.length() - word.replace("n", "").length() > 0) count += 575 * (letterMap.get('n') + 1);
            if (word.length() - word.replace("c", "").length() > 0) count += 477 * (letterMap.get('c') + 1);
            if (word.length() - word.replace("u", "").length() > 0) count += 467 * (letterMap.get('u') + 1);
            if (word.length() - word.replace("y", "").length() > 0) count += 425 * (letterMap.get('y') + 1);
            if (word.length() - word.replace("d", "").length() > 0) count += 393 * (letterMap.get('d') + 1);
            if (word.length() - word.replace("h", "").length() > 0) count += 389 * (letterMap.get('h') + 1);
            if (word.length() - word.replace("p", "").length() > 0) count += 367 * (letterMap.get('p') + 1);
            if (word.length() - word.replace("m", "").length() > 0) count += 316 * (letterMap.get('m') + 1);
            if (word.length() - word.replace("g", "").length() > 0) count += 311 * (letterMap.get('g') + 1);
            if (word.length() - word.replace("b", "").length() > 0) count += 281 * (letterMap.get('b') + 1);
            if (word.length() - word.replace("f", "").length() > 0) count += 230 * (letterMap.get('f') + 1);
            if (word.length() - word.replace("k", "").length() > 0) count += 210 * (letterMap.get('k') + 1);
            if (word.length() - word.replace("w", "").length() > 0) count += 195 * (letterMap.get('w') + 1);
            if (word.length() - word.replace("v", "").length() > 0) count += 153 * (letterMap.get('v') + 1);
            if (word.length() - word.replace("z", "").length() > 0) count += 40 * (letterMap.get('z') + 1);
            if (word.length() - word.replace("x", "").length() > 0) count += 37 * (letterMap.get('x') + 1);
            if (word.length() - word.replace("q", "").length() > 0) count += 29 * (letterMap.get('q') + 1);
            if (word.length() - word.replace("j", "").length() > 0) count += 27 * (letterMap.get('j') + 1);
//            if (word.length() - word.replace("a", "").length() > 0)
//                count += 979 * (word.length() - word.replace("a", "").length());
//            if (word.length() - word.replace("r", "").length() > 0)
//                count += 899 * (word.length() - word.replace("r", "").length());
//            if (word.length() - word.replace("o", "").length() > 0)
//                count += 754 * (word.length() - word.replace("o", "").length());
//            if (word.length() - word.replace("t", "").length() > 0)
//                count += 729 * (word.length() - word.replace("t", "").length());
//            if (word.length() - word.replace("l", "").length() > 0)
//                count += 719 * (word.length() - word.replace("l", "").length());
//            if (word.length() - word.replace("i", "").length() > 0)
//                count += 671 * (word.length() - word.replace("i", "").length());
//            if (word.length() - word.replace("s", "").length() > 0)
//                count += 669 * (word.length() - word.replace("s", "").length());
//            if (word.length() - word.replace("n", "").length() > 0)
//                count += 575 * (word.length() - word.replace("n", "").length());
//            if (word.length() - word.replace("c", "").length() > 0)
//                count += 477 * (word.length() - word.replace("c", "").length());
//            if (word.length() - word.replace("u", "").length() > 0)
//                count += 467 * (word.length() - word.replace("u", "").length());
//            if (word.length() - word.replace("y", "").length() > 0)
//                count += 425 * (word.length() - word.replace("y", "").length());
//            if (word.length() - word.replace("d", "").length() > 0)
//                count += 393 * (word.length() - word.replace("d", "").length());
//            if (word.length() - word.replace("h", "").length() > 0)
//                count += 389 * (word.length() - word.replace("h", "").length());
//            if (word.length() - word.replace("p", "").length() > 0)
//                count += 367 * (word.length() - word.replace("p", "").length());
//            if (word.length() - word.replace("m", "").length() > 0)
//                count += 316 * (word.length() - word.replace("m", "").length());
//            if (word.length() - word.replace("g", "").length() > 0)
//                count += 311 * (word.length() - word.replace("g", "").length());
//            if (word.length() - word.replace("b", "").length() > 0)
//                count += 281 * (word.length() - word.replace("b", "").length());
//            if (word.length() - word.replace("f", "").length() > 0)
//                count += 230 * (word.length() - word.replace("f", "").length());
//            if (word.length() - word.replace("k", "").length() > 0)
//                count += 210 * (word.length() - word.replace("k", "").length());
//            if (word.length() - word.replace("w", "").length() > 0)
//                count += 195 * (word.length() - word.replace("w", "").length());
//            if (word.length() - word.replace("v", "").length() > 0)
//                count += 153 * (word.length() - word.replace("v", "").length());
//            if (word.length() - word.replace("z", "").length() > 0)
//                count += 40 * (word.length() - word.replace("z", "").length());
//            if (word.length() - word.replace("x", "").length() > 0)
//                count += 37 * (word.length() - word.replace("x", "").length());
//            if (word.length() - word.replace("q", "").length() > 0)
//                count += 29 * (word.length() - word.replace("q", "").length());
//            if (word.length() - word.replace("j", "").length() > 0)
//                count += 27 * (word.length() - word.replace("j", "").length());

            wordRankMap.put(word, count);
        }

//        for (String word : wordRankMap.keySet()) {
//            if (word.substring(2, 5).equals("tch")) {
//                wordRankMap.replace(word, wordRankMap.get(word) * 2);
//            }
//        }
//        for (String word : wordRankMap.keySet()) {
//            if (word.substring(2, 5).equals("nch")) {
//                wordRankMap.replace(word, wordRankMap.get(word) * 2);
//            }
//        }
//        for (String word : wordRankMap.keySet()) {
//            if (word.substring(2, 5).equals("ing")) {
//                wordRankMap.replace(word, wordRankMap.get(word) * 2);
//            }
//        }

        Map<String, Integer> sortedMap = wordRankMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        ArrayList<String> wordList = new ArrayList<>(sortedMap.keySet());

//        for (String word : wordList){
//            word.substring(2,4).equals("tch"){
//                sortedMap.replace(word, sortedMap.get(word) * 2);
//            }
//        }

        for (String word : wordList) {

        }

        StdOut.println(wordList);
        StdOut.println(sortedMap.keySet());
        StdOut.println(wordRankMap.keySet());
        StdOut.println(possWords);
        return wordList.get(0);
    }

    public static ArrayList<String> getPossibles(HashMap<String, Integer> wordMap) {

        ArrayList<String> posibles = new ArrayList<>();

        for (String key : wordMap.keySet()) {
            if (wordMap.get(key) >= 0) {
                posibles.add(key);

            }
        }

        return posibles;
    }

    public static ArrayList<String> getWords(String filePath) throws IOException {
        Scanner s = new Scanner(new File(filePath));
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()) {
            list.add(s.next());
        }
        s.close();

        return list;
    }

    public static String suggest(HashMap<Character, String> posWords) {

        return null;
    }

    public static HashMap<String, Integer> parseGuess(String[][] guessResults, HashMap<String, Integer> wordMap) {

        HashMap<String, Integer> greenMap = new HashMap<>();

        for (int h = 0; h < guessResults.length; h++) {
            if (guessResults[h][0].charAt(1) == 'y') {
                ArrayList<String> badWords = new ArrayList<>();
                for (String key : wordMap.keySet()) {

                    if (key.substring(h, h + 1).equals(String.valueOf(guessResults[h][0].charAt(0)))) {
                        badWords.add(key);
//                        word.length() - word.replace("e", "").length() > 0
//                    } else if (key.indexOf(guessResults[h][0].charAt(0)) == -1) {
                    } else if (key.length() - key.replace(String.valueOf(guessResults[h][0].charAt(0)), "").length() == 0) {
//                        StdOut.print("yellow sum is 0, key: " + key + ", guess index: [" + h + "], guess char: " + guessResults[h][0].charAt(0));
                        badWords.add(key);
                    }
                }
                for (int i = 0; i < badWords.size(); i++) {

                    for (String key : wordMap.keySet()) {

                        if (badWords.get(i).equals(key)) {
                            wordMap.replace(key, -1);
                        }
                    }
                }
            }
        }

        for (int h = 0; h < guessResults.length; h++) {
            if (guessResults[h][0].charAt(1) == 'g') {

                int count = 0;
                if (greenMap.containsKey(String.valueOf(guessResults[h][0].charAt(0)))) {
                    count = greenMap.get(String.valueOf(guessResults[h][0].charAt(0)));
                }
                greenMap.put(String.valueOf(guessResults[h][0].charAt(0)), count + 1);

                ArrayList<String> badWords = new ArrayList<>();
                for (String key : wordMap.keySet()) {

                    if (!key.substring(h, h + 1).equals(String.valueOf(guessResults[h][0].charAt(0)))) {
//                    wordMap.remove(key);
                        badWords.add(key);
                    }
                }

                for (int i = 0; i < badWords.size(); i++) {

                    for (String key : wordMap.keySet()) {

                        if (badWords.get(i).equals(key)) {
                            wordMap.replace(key, -1);
                        }
                    }
                }
            }
        }


        for (int h = 0; h < guessResults.length; h++) {
            if (guessResults[h][0].charAt(1) == 'w') {
                ArrayList<String> badWords = new ArrayList<>();
                for (String key : wordMap.keySet()) {

//                    if (key.indexOf(guessResults[h][0].charAt(0)) != -1) {

                    int count = 0;
                    if (greenMap.containsKey(String.valueOf(guessResults[h][0].charAt(0)))) {
                        count = greenMap.get(String.valueOf(guessResults[h][0].charAt(0)));
                    }
                    if (key.length() - key.replace(String.valueOf(guessResults[h][0].charAt(0)), "").length() > count) {
                        badWords.add(key);
                    }
                }
                for (int i = 0; i < badWords.size(); i++) {

                    for (String key : wordMap.keySet()) {

                        if (badWords.get(i).equals(key)) {
                            wordMap.replace(key, -1);
                        }
                    }
                }
            }

        }
        wordMap.replace("noire", -1);
        wordMap.replace("latin", -1);
        wordMap.replace("mungy", -1);
        wordMap.replace("bumpf", -1);
        wordMap.replace("oring", -1);
        wordMap.replace("ioctl", -1);
        wordMap.replace("unarc", -1);
        return wordMap;
    }

    public static String[][] guess(String thisGuess) {

        Scanner sc = new Scanner(System.in);

        HashMap<Character, String> wordMap = new HashMap<>();

        String[][] wordArr = new String[5][1];
        StdOut.println("What colors are the letters?");
        String input = sc.next();

//        StdOut.println("What color was first letter?");
//        String first = sc.next();
        String first = String.valueOf(input.charAt(0));
        wordArr[0][0] = thisGuess.charAt(0) + first;
        wordMap.put(thisGuess.charAt(0), first);

//        StdOut.println("What color was second letter?");
//        String second = sc.next();
        String second = String.valueOf(input.charAt(1));
        wordArr[1][0] = String.valueOf(thisGuess.charAt(1)) + second;
        wordMap.put(thisGuess.charAt(1), second);

//        StdOut.println("What color was third letter?");
//        String third = sc.next();
        String third = String.valueOf(input.charAt(2));
        wordArr[2][0] = String.valueOf(thisGuess.charAt(2)) + third;
        wordMap.put(thisGuess.charAt(2), third);

//        StdOut.println("What color was fourth letter?");
//        String fourth = sc.next();
        String fourth = String.valueOf(input.charAt(3));
        wordArr[3][0] = String.valueOf(thisGuess.charAt(3)) + fourth;
        wordMap.put(thisGuess.charAt(3), fourth);

//        StdOut.println("What color was fifth letter?");
//        String fifth = sc.next();
        String fifth = String.valueOf(input.charAt(4));
        wordArr[4][0] = String.valueOf(thisGuess.charAt(4)) + fifth;
        wordMap.put(thisGuess.charAt(4), fifth);

        return wordArr;
    }

    public static HashMap<String, Integer> fillMap(ArrayList<String> wordList) {

        HashMap<String, Integer> wordMap = new HashMap<>();

        for (int i = 0; i < wordList.size(); i++) {

            wordMap.put(wordList.get(i), 0);
        }

        return wordMap;
    }
}
