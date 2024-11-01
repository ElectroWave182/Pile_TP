import java.util.Stack;

public class ExpressionPostfixée
{

	public String expr;
	
	public ExpressionPostfixée(String s)
	{
		this.expr = s;
	}
	
	public int evaluer()
	{
		Stack<Integer> chiffres = new Stack<>();
		String s = this.expr;
		char c;
		int ent1, ent2, resultat, last;
		
		while(true)
		{
			
			for(int i = 0; i < s.length(); i ++)
			{
				c = s.charAt(i);
				
				if('0' <= c && c <= '9')
				{
					chiffres.push((int)c - 48);
				}
				
				else
				{
					ent1 = chiffres.peek();
					chiffres.pop();
					ent2 = chiffres.peek();
					chiffres.pop();
					
					if(c == '+')
					{
						resultat = ent2 + ent1;
					}
					if(c == '-')
					{
						resultat = ent2 - ent1;
					}
					if(c == '*')
					{
						resultat = ent2 * ent1;
					}
					if(c == '/')
					{
						resultat = ent2 / ent1;
					}
					else
					{
						resultat = 0;
					}
					
					chiffres.push(resultat);
				}
			}
			
			last = chiffres.peek();
			chiffres.pop();
			
			if(chiffres.empty())
			{
				return last;
			}
			
			else
			{
				chiffres.push(last);
			}
			
		}
	}
	
	public static void main(String[] args)
	{
		ExpressionPostfixée e1 = new ExpressionPostfixée("12+3+");
		System.out.println(e1.evaluer());
	}
	
}
