import java.util.Stack;

public class Expression
{

	public String expr;
	
	public Expression(String e)
	{
		this.expr = e;
	}
	
	public boolean estCorrecte()
	{
		String chaine = this.expr;
		Stack<Character> pile = new Stack<>();
		char c;
		boolean sortie = true;
		
		for(int i = 0; i < chaine.length(); i++)
		{
			c = chaine.charAt(i);
			if(c == '(' || c == ')')
			{
				pile.push(c);
			}
		}
		
		char top;
		int cpt = 0;
		
		while(!(pile.empty()))
		{
			if(cpt < 0)
			{
				return false;
			}
			
			top = pile.peek();
			if(top == ')')
			{
				cpt += 1;
			}
			else
			{
				cpt -= 1;
			}
			
			pile.pop();
		}
		
		sortie = sortie && cpt == 0;
		
		pile = new Stack<>();
		for(int i = 0; i < chaine.length(); i++)
		{
			c = chaine.charAt(i);
			if(c == '{' || c == '}')
			{
				pile.push(c);
			}
		}
		
		cpt = 0;
		
		while(!(pile.empty()))
		{
			if(cpt < 0)
			{
				return false;
			}
			
			top = pile.peek();
			if(top == '}')
			{
				cpt += 1;
			}
			else
			{
				cpt -= 1;
			}
			
			pile.pop();
		}
		
		sortie = sortie && cpt == 0;
		
		pile = new Stack<>();
		for(int i = 0; i < chaine.length(); i++)
		{
			c = chaine.charAt(i);
			if(c == '[' || c == ']')
			{
				pile.push(c);
			}
		}
		
		cpt = 0;
		
		while(!(pile.empty()))
		{
			if(cpt < 0)
			{
				return false;
			}
			
			top = pile.peek();
			if(top == ']')
			{
				cpt += 1;
			}
			else
			{
				cpt -= 1;
			}
			
			pile.pop();
		}
		
		return sortie && cpt == 0;
	}
	
	public static void main(String[] args)
	{
		Expression e1 = new Expression("(((a+b)*c)+(a+d)*e)/(2*a)");
		boolean test1 = e1.estCorrecte();
		Expression e2 = new Expression("((a+b)");
		boolean test2 = e2.estCorrecte();
		Expression e3 = new Expression("(a+b))*(c");
		boolean test3 = e3.estCorrecte();
		Expression e4 = new Expression("e<-sommet(empiler(empiler(d ́epiler(empiler(pile_vide(),a)),b),c))");
		boolean test4 = e4.estCorrecte();
		Expression e5 = new Expression("(define (smallest L A)(cond ( (null? L) A)( (< (car L) A) (smallest (cdr L)(car L)))(else (smallest (cdr L) A ))))");
		boolean test5 = e5.estCorrecte();
		Expression e6 = new Expression("print(L[len(L)//2-1],L[len(l)//2])");
		boolean test6 = e6.estCorrecte();
		Expression e7 = new Expression("$(’form div’).filter(’span .actif’).each(function() {$(this).bind(’click’, function() {$(this).prop(’disabled’, true);});});");
		boolean test7 = e7.estCorrecte();
		
		System.out.println(test1);
		System.out.println(test2);
		System.out.println(test3);
		System.out.println(test4);
		System.out.println(test5);
		System.out.println(test6);
		System.out.println(test7);
	}
}
