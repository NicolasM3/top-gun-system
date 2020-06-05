package app;
import java.lang.reflect.*;

public class ListaEncadeadaDesordenadaSemRepeticao<X>
{
    public class No
    {
        private No ante;
        private X  info;
        private No prox;

        public No (No a, X i, No p)
        {
			this.ante = a;
            this.info = i;
            this.prox = p;
        }

        public No (X i)
        {
			this.ante = null;
            this.info = i;
            this.prox = null;
        }

        public No getAnte ()
        {
            return this.ante;
        }
        
        public X getInfo ()
        {
            return this.info;
        }

        public No getProx ()
        {
            return this.prox;
        }

        public void setAnte (No a)
        {
            this.ante = a;
        }
        
        public void setInfo (X i)
        {
            this.info = i;
        }

        public void setProx (No p)
        {
            this.prox = p;
        }
    }

    protected No primeiro, ultimo;

    public ListaEncadeadaDesordenadaSemRepeticao()
    {
        this.primeiro = this.ultimo = null;
    }

    protected X meuCloneDeX (X x)
    {
        X ret=null;

        try
        {
            Class<?> classe = x.getClass();
            Class<?>[] tiposDosParms = null;
            Method metodo = classe.getMethod("clone",tiposDosParms);
            Object[] parms = null;
            ret = (X)metodo.invoke(x,parms);
        }
        catch (Exception erro)
        {}

        return ret;
    }

    public void insiraNoInicio(X i) throws Exception
    {
        if (i == null)
            throw new Exception("Infomacao passada nula");

        if (this.tem(i))
            throw new Exception("Informacao já existente");

        X inserir=null;
        if (i instanceof Cloneable)
            inserir = meuCloneDeX (i);
        else
            inserir = i;
            
        this.primeiro = new No (null,inserir,this.primeiro);

        if (this.primeiro.getProx()!=null)
            this.primeiro.getProx().setAnte (this.primeiro);

        this.primeiro.setAnte (null);
        
        if (this.ultimo==null)
            this.ultimo=this.primeiro;
    }

    public void inseraNoFim(X i) throws Exception
    {
        if (i==null)
            throw new Exception ("Informacao passada nula");

        if (this.tem(i))
            throw new Exception("Informacao ja existente");
        
        X inserir=null;
        if (i instanceof Cloneable)
            inserir = meuCloneDeX (i);
        else
            inserir = i;
            
        if (this.ultimo==null)
        {
            this.ultimo   = new No (inserir);
            this.primeiro = this.ultimo;
        }
        else
        {
            this.ultimo.setProx (new No (this.ultimo,inserir,null));
            this.ultimo = this.ultimo.getProx();
        }
    }
    
    public void removaDoFim () throws Exception
    {
        if (this.primeiro==null)
            throw new Exception ("Nada para remover");

        this.ultimo = this.ultimo.getAnte();

        if (this.ultimo==null)
            this.primeiro=null;
        else
            this.ultimo.setProx(null);
    }

    public void removaDoInicio () throws Exception
    {
        if (this.primeiro==null)
            throw new Exception ("Nada para remover");

        this.primeiro = this.primeiro.getProx();

        if (this.primeiro==null)
            this.ultimo = null;
        else
            this.primeiro.setAnte(null);
    }
    
    public void remova (X i) throws Exception
    {
        if (i==null)
            throw new Exception ("Informacao passada nula");

        if (this.primeiro==null)
            throw new Exception ("A lista esta vazia");

        if (i.equals(this.primeiro.getInfo()))
        {
			this.primeiro = this.primeiro.getProx();

			if (this.primeiro==null)
				this.ultimo = null;
			else
				this.primeiro.setAnte(null);
				
			return;
        }

        No atual=this.primeiro;

        for(;;)
        {
            if (atual==null)
                throw new Exception ("Lista esta¡ vazia (Esse erro nao deveria acontecer)");

            if (i.equals(atual.getInfo()))
            {
                // ### ATUAL NAO SERA O PRIMEIRO ###
				if (atual==this.primeiro)            
				{
					this.primeiro = this.primeiro.getProx();

					if (this.primeiro==null) 
						this.ultimo = null;
					else
						this.primeiro.setAnte (null);
						
					return;
				}
				
				if (atual==this.ultimo)
				{
					this.ultimo = this.ultimo.getAnte();

					if (this.ultimo==null)
						this.primeiro=null;
					else
						this.ultimo.setProx(null);
						
					return;
				}
				
				atual.getAnte().setProx(atual.getProx());
				atual.getProx().setAnte(atual.getAnte());
                return;
            }

            atual=atual.getProx();
        }
    }

    public boolean tem (X i) throws Exception
    {    	
		if (i==null)
		    throw new Exception ("Informacao ausente");
		
        No atual=this.primeiro;

        while (atual!=null)
        {
            if (i.equals(atual.getInfo()))
            {
                return true;
            }   
            atual = atual.getProx();
        }
        
        return false;
    }

    public int getQtd ()
    {
        No  atual=this.primeiro;
        int ret  =0;

        while (atual!=null)
        {
            ret++;                
            atual = atual.getProx();
        }
        
        return ret;
    }
    
    // !TODO ARRUMAR GETDOINICIO
    public X getDoInicio () throws Exception
    {
        if (this.primeiro==null)
            throw new Exception ("Lista vazia, n ada a obter");

        X ret = this.primeiro.getInfo();
        if (ret instanceof Cloneable)
            ret = meuCloneDeX (ret);
            
        return ret;
    }
    
    // !TODO ARRUMAR GETDOFIM
    public X getDoFim () throws Exception
    {
        if (this.primeiro==null)
            throw new Exception ("Nada a obter");

        X ret = this.ultimo.getInfo();
        if (ret instanceof Cloneable)
            ret = meuCloneDeX (ret);
            
        return ret;
    }

    public boolean isVazia ()
    {
        return this.primeiro==null;
    }

    // !TODO INVERTASE

    // !TODO INVERSAO
    
    // !TODO ARRUMAR TOSTRING
    public String toString()
    {
        String ret="[";

        No atual=this.primeiro;

        while (atual!=null)
        {
            ret=ret+atual.getInfo().toString();

            if (atual!=this.ultimo)
                ret=ret+",";

            atual=atual.getProx();
        }

        return ret+"]";
    }
    
    public ListaEncadeadaDesordenadaSemRepeticao(ListaEncadeadaDesordenadaSemRepeticao<X> modelo) throws Exception
    {
    	if (modelo==null)
            throw new Exception ("Modelo ausente");

    	// Lista esta vazia, retorna null
        if (modelo.primeiro==null)
            return;

        this.primeiro = new No (modelo.primeiro.getInfo());

        No atualDoThis   = this  .primeiro;
        No atualDoModelo = modelo.primeiro.getProx();

        while (atualDoModelo!=null)
        {
            atualDoThis.setProx (new No (atualDoModelo.getInfo()));
            atualDoThis   = atualDoThis  .getProx ();
            atualDoModelo = atualDoModelo.getProx ();
        }

        this.ultimo = atualDoThis;
    }
    
    public Object clone ()
    {
    	ListaEncadeadaDesordenadaSemRepeticao<X> ret=null;

        try
        {
            ret = new ListaEncadeadaDesordenadaSemRepeticao(this);
        }
        catch (Exception erro)
        {
        	
        } 

        return ret;
    }

    // !TODO METODOS OBRIGATORIO(JA FEITO: toString())
}