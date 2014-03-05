import java.util.ArrayList;
import java.util.Arrays;

public class Phonewords
{
  public static void main(String args[])
  {
    ArrayList<ArrayList<Character>> list = new ArrayList<ArrayList<Character>>();

    if (args != null && args.length > 0)
    {
      String number = args[0];

      for (int i = 0; i < number.length(); i++)
      {
        list.add(getCharList(number.charAt(i)));
      }

      System.out.println("Number of Combinations for " + number + ": " + getComboAmt(list));
      System.out.println("=================================================");
      displayCombos(list, "", 0);
    } else
    {
      System.out.println("Error: No arguments were passed in");
    }
  }

  private static ArrayList<Character> getCharList(char c)
  {
    ArrayList<Character> list = new ArrayList<Character>();

    switch (c)
    {
    case '0':
      list = new ArrayList<Character>(Arrays.asList('0'));
      break;
    case '1':
      list = new ArrayList<Character>(Arrays.asList('1'));
      break;
    case '2':
      list = new ArrayList<Character>(Arrays.asList('A', 'B', 'C'));
      break;
    case '3':
      list = new ArrayList<Character>(Arrays.asList('D', 'E', 'F'));
      break;
    case '4':
      list = new ArrayList<Character>(Arrays.asList('G', 'H', 'I'));
      break;
    case '5':
      list = new ArrayList<Character>(Arrays.asList('J', 'K', 'L'));
      break;
    case '6':
      list = new ArrayList<Character>(Arrays.asList('M', 'N', 'O'));
      break;
    case '7':
      list = new ArrayList<Character>(Arrays.asList('P', 'Q', 'R', 'S'));
      break;
    case '8':
      list = new ArrayList<Character>(Arrays.asList('T', 'U', 'V'));
      break;
    case '9':
      list = new ArrayList<Character>(Arrays.asList('W', 'X', 'Y', 'Z'));
      break;
    }

    return list;
  }

  private static int getComboAmt(ArrayList<ArrayList<Character>> list)
  {
    int combos = 1;

    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).size() > 0)
        combos *= list.get(i).size();
    }

    return combos;
  }

  static int count = 1;

  private static void displayCombos(ArrayList<ArrayList<Character>> list, String base, int pos)
  {
    ArrayList<Character> cList = list.get(pos);

    for (int i = 0; i < cList.size(); i++)
    {
      if (pos + 1 < list.size())
      {
        if (pos + 1 < base.length())
        {
          base += cList.get(i);
        } else
        {
          base = base.substring(0, pos) + cList.get(i);
        }
      } else
      {
        System.out.print(count + ": " + base + cList.get(i) + "\n");
        count++;
      }

      if (pos + 1 < list.size())
      {
        displayCombos(list, base, pos + 1);
      }
    }
  }
}
