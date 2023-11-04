public class Main {
    public static void main(String[] args) {
        String inputString = "EXTRACT_AVC_US_SalesDiagnostic_API_AR_DLY_20230207140014.csvd";

        // Extract the specific substring
        String extractedString = extractSubstring(inputString);

        System.out.println("Extracted String: " + extractedString);
    }

    public static String extractSubstring(String inputString) {
        // Check if the inputString contains "_"
        int startIndex = inputString.indexOf("_");
        if (startIndex != -1) {
            // Increment startIndex to exclude the "_" character
            startIndex++;

            // Find the index of the next "_"
            int endIndex = inputString.indexOf("_", startIndex);

            // Check if the second "_" is found
            if (endIndex != -1) {
                // Extract the substring between the two "_" characters
                return inputString.substring(startIndex, endIndex);
            }
        }

        // Return an empty string if the pattern is not found
        return "";
    }
}

