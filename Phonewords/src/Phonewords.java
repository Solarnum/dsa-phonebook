import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Phonewords
{
	/*I was thinking there might be a way to do this problem without using any ArrayLists or anything. Basically 
	 * just for loops for each number that would be like
	 * 
	 * for i->0 to DigitArray[0].length-1 
	 * 
	 * It's probably doable and probably would cut the time down by a little bit. But its probably not worth it.
	 * I'm up way too late right now :|
	 */
	private  static char[][] DigitArray = {{'0'},{'1'},{'A', 'B', 'C'},{'D', 'E', 'F'},
		{'G', 'H', 'I'},{'J', 'K', 'L'}, {'M', 'N', 'O'},{'P', 'Q', 'R', 'S'},
		{'T', 'U', 'V'},{'W', 'X', 'Y', 'Z'}};
	
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
      
      //System.out.println("Number of Combinations for " + number + ": " + getComboAmt(list));
      System.out.println("Number of Combinations for " + number + ": " + getComboAmt_v2(number));
      System.out.println("=================================================");
      //displayCombos(list, "", 0);
      displayCombos_v2(number, "", 0);
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
      //list = new ArrayList<Character>(Arrays.asList('0'));
    	list = new ArrayList<Character>('0');
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
  
  private static int getIntegerValue(String str)
  {
	  int num = 0;
	  try
	  {
		  num = Integer.parseInt(str);
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	  
	  return num;
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
  
  private static int getComboAmt_v2(String str)
  {
    int combos = 1;

    for (int i = 0; i < str.length(); i++)
    {
      int index = getIntegerValue(str.substring(i, i+1));
      if (DigitArray[index].length > 0)
        combos *= DigitArray[index].length;
    }

    return combos;
  }

  private static void displayCombos_v2(String str, String base, int pos)
  {
    int index = getIntegerValue(str.substring(pos, pos+1));

    for (int i = 0; i < DigitArray[index].length; i++)
    {
      if (pos + 1 < str.length())
      {
        if (pos + 1 < base.length())
        {
          base += DigitArray[index][i];
        } else
        {
          base = base.substring(0, pos) + DigitArray[index][i];
        }
      } else
      {
        System.out.print(count + ": " + base + DigitArray[index][i] + "\n");
        count++;
      }

      if (pos + 1 < str.length())
      {
        displayCombos_v2(str, base, pos + 1);
      }
    }
  }
}
