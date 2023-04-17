import java.util.*;

public class Numbers implements NumberRangeSummarizer {

    private List<Integer> col = new ArrayList<Integer>();

    @Override
    public Collection<Integer> collect(String input) {
        input = input + " ";
        String newNumber = "";
        boolean negative = false;

        for (int i = 0; i < input.length(); i++) {

            char currentChar = input.charAt(i);

            if (currentChar == '-') {
                negative = true;
            } else if (currentChar >= '0' && currentChar <= '9') {
                newNumber += currentChar;

                if (i < input.length() - 1) {
                    char nextChar = input.charAt(i + 1);
                    if (nextChar < '0' || nextChar > '9') {
                        if (negative) {
                            newNumber = "-" + newNumber;
                        }
                        if (!col.contains(Integer.parseInt(newNumber))) {
                            col.add(Integer.parseInt(newNumber));
                        }
                        newNumber = "";
                        negative = false;
                    }
                }
            } else {
                negative = false;
            }
        }
        Collections.sort(col);
        return col;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        List<Integer> sortedInput = new ArrayList<>(input);
        Collections.sort(sortedInput);

        String sortedNumbers = "";
        for (int i = 0; i < sortedInput.size(); i++) {
            if (i == 0) {
                if (sortedInput.get(i) == sortedInput.get(i + 1) - 1) {
                    sortedNumbers = sortedNumbers + sortedInput.get(i) + "-";
                } else {
                    sortedNumbers = sortedNumbers + sortedInput.get(i) + ", ";
                }
            } else if (i > 0 && i < sortedInput.size() - 1) {
                if (sortedInput.get(i) == sortedInput.get(i - 1) + 1 && sortedInput.get(i) == sortedInput.get(i + 1) - 1) {

                } else if (sortedInput.get(i) == (sortedInput.get(i - 1) + 1)) {
                    sortedNumbers = sortedNumbers + sortedInput.get(i) + ", ";
                } else if (sortedInput.get(i) == (sortedInput.get(i + 1) - 1)) {
                    sortedNumbers = sortedNumbers + sortedInput.get(i) + "-";
                } else {
                    sortedNumbers = sortedNumbers + sortedInput.get(i) + ", ";
                }
            } else if (i == sortedInput.size() - 1) {
                if (sortedInput.get(i) == sortedInput.get(i - 1) + 1) {
                    sortedNumbers = sortedNumbers + sortedInput.get(i);
                } else {
                    sortedNumbers = sortedNumbers + sortedInput.get(i);
                }
            }
        }
        return sortedNumbers;
    }
}