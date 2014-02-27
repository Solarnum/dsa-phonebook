import java.util.Arrays;
import java.util.LinkedList;

public class Phonewords
{
  public static void main(String args[])
  {
    LinkedList<LinkedList<Character>> list = new LinkedList<LinkedList<Character>>();

    if (args != null && args.length > 0)
    {
      String number = args[0];

      for (int i = 0; i < number.length(); i++)
      {
        list.add(getCharList(number.charAt(i)));
      }

      System.out.println("Combinations for \"" + number + "\": " + getComboAmt(list));
      System.out.println("=============================");
      displayCombos();
    }
  }

  private static LinkedList<Character> getCharList(char c)
  {
    LinkedList<Character> list = new LinkedList<Character>();

    switch (c)
    {
    case '0':
      list = new LinkedList<Character>(Arrays.asList('0'));
      break;
    case '1':
      list = new LinkedList<Character>(Arrays.asList('1'));
      break;
    case '2':
      list = new LinkedList<Character>(Arrays.asList('A', 'B', 'C'));
      break;
    case '3':
      list = new LinkedList<Character>(Arrays.asList('D', 'E', 'F'));
      break;
    case '4':
      list = new LinkedList<Character>(Arrays.asList('G', 'H', 'I'));
      break;
    case '5':
      list = new LinkedList<Character>(Arrays.asList('J', 'K', 'L'));
      break;
    case '6':
      list = new LinkedList<Character>(Arrays.asList('M', 'N', 'O'));
      break;
    case '7':
      list = new LinkedList<Character>(Arrays.asList('P', 'Q', 'R', 'S'));
      break;
    case '8':
      list = new LinkedList<Character>(Arrays.asList('T', 'U', 'V'));
      break;
    case '9':
      list = new LinkedList<Character>(Arrays.asList('W', 'X', 'Y', 'Z'));
      break;
    }

    return list;
  }

  private static int getComboAmt(LinkedList<LinkedList<Character>> list)
  {
    int combos = 1;

    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).size() > 0)
        combos *= list.get(i).size();
    }

    return combos;
  }

  private static void displayCombos()
  {
  }
}
