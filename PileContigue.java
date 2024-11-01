public class PileContigue<E> implements Pile<E>
{

	public Object[] tableau;
	
	public PileContigue()
	{
		this.tableau = new Object[10];
	}
	
	public boolean estVide()
	{
		return this.tableau.equals(new Object[this.tableau.length]);
	}

	public void empiler(E e)
	{
		for(int i = tableau.length; i > 0; i--)
		{
			if(!(this.tableau[i].equals(null)))
			{
				this.tableau[i + 1] = e;
				break;
			}
		}
	}

	public void depiler() throws ExceptionPileVide
	{
		PileContigue<E> p = new PileContigue<>(this.tableau);
		if(p.estVide())
		{
			throw new ExceptionPileVide();
		}
		
		for(int i = tableau.length; i > 0; i--)
		{
			if(!(this.tableau[i].equals(null)))
			{
				this.tableau[i] = null;
				break;
			}
		}
	}

	@SuppressWarnings("unchecked")
	public E sommet() throws ExceptionPileVide
	{
		PileContigue<E> p = new PileContigue<>(this.tableau);
		if(p.estVide())
		{
			throw new ExceptionPileVide();
		}
		
		for(int i = tableau.length; i > 0; i--)
		{
			if(!(this.tableau[i].equals(null)))
			{
				return (E) this.tableau[i];
			}
		}
		return null;
	}
	
	public static void main(String[] args)
	{
		
	}
	
}
