package br.com.weka.datamining;

import br.com.weka.datamining.algorithm.classify.J48Classify;
import br.com.weka.datamining.algorithm.classify.NaiveBayesClassify;
import br.com.weka.datamining.constants.Credor;
import br.com.weka.datamining.constants.FaixaAtraso;
import br.com.weka.datamining.constants.FaixaIdade;
import br.com.weka.datamining.constants.FaixaValorDivida;
import br.com.weka.datamining.constants.Sexo;
import br.com.weka.datamining.domain.Devedor;
import br.com.weka.datamining.exception.ClassifyException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        NaiveBayesClassify nb = new NaiveBayesClassify();       
        J48Classify j48 = new J48Classify();
        try {
        	
        	Devedor devedor = new Devedor();
        	devedor.setCredor(Credor.SANTANDER);
        	devedor.setFaixaAtraso(FaixaAtraso.ENTRE_360_E_1080);
        	devedor.setFaixaIdade(FaixaIdade.ENTRE_35_E_45);
        	devedor.setFaixaValorDivida(FaixaValorDivida.MAIOR_QUE_5000);
        	devedor.setSexo(Sexo.FEMININO);
        	
        	nb.classificaDevedor(devedor);
        	j48.classificaDevedor(devedor);
        	
        	
		}  catch (ClassifyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
    }
}
