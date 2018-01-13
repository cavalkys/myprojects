package br.com.weka.datamining;

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
        NaiveBayesClassify classify = new NaiveBayesClassify();        
        try {
        	
        	Devedor devedor = new Devedor();
        	devedor.setCredor(Credor.CARSYSTEM);
        	devedor.setFaixaAtraso(FaixaAtraso.ENTRE_1080_E_1800);
        	devedor.setFaixaIdade(FaixaIdade.ENTRE_35_E_45);
        	devedor.setFaixaValorDivida(FaixaValorDivida.MAIOR_QUE_5000);
        	devedor.setSexo(Sexo.MASCULINO);
        	
        	devedor = classify.classificaDevedor(devedor);
        	
        	
		}  catch (ClassifyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
    }
}
