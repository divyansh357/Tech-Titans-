public class sol 
{
    public static void main(String[] args)
    {
        String input = "abstract";
        System.out.println(countVowels(input));
    }
    public static int countVowels(String input)
    {
        String vowels = "aeiouAEIOU";
        int vowelCount = 0;
        for (int i = 0; i < input.length(); i++)
        {
            char currentChar = input.charAt(i);
            // Check if the character is a vowel
            if(vowels.indexOf(currentChar)!= -1) 
            {
                vowelCount++;
            }
        }
        return vowelCount;
    }
}
