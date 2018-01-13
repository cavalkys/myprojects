package br.com.weka.datamining.algorithm.classify;

import java.text.DecimalFormat;

import org.apache.log4j.Logger;

import br.com.weka.datamining.algorithm.AlgorithmBase;
import br.com.weka.datamining.domain.Devedor;
import br.com.weka.datamining.exception.ClassifyException;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.DenseInstance;
import weka.core.Instance;

/**
 * 
 * @author cavalkys
 *
 */
public class NaiveBayesClassify extends AlgorithmBase {

	private static final Logger logger = Logger.getLogger(NaiveBayesClassify.class.getName());
	
	private static final String FILE_ARFF_PATH = "src/main/resources/analise_dividas.arff";
	private static final int CLASS_INDEX = 5;
	
	private static final int IDADE_INDEX = 0;
	private static final int SEXO_INDEX = 1;
	private static final int VALOR_DIVIDA_INDEX = 2;
	private static final int ATRASO_INDEX = 3;
	private static final int CREDOR_INDEX = 4;
	
	private static final int RES_FAZ_ACORDO_INDEX = 1;
	private static final int RES_NAO_FAZ_ACORDO_INDEX = 0;
	
	public NaiveBayesClassify() {}

	public Devedor classificaDevedor(Devedor devedor) throws ClassifyException {
		
		logger.info("Aplicando classificacao para o devedor : " + devedor);
		
		try {
			
			//carregando arquivo de aprendizado
			this.carregaBaseARFF(FILE_ARFF_PATH, CLASS_INDEX);
			
			NaiveBayes nb = new NaiveBayes();
			
			logger.info("Criando tabela de classificacao...");
			nb.buildClassifier(this.instancias);
			
			//criando classificacao
			Instance novoDevedor = new DenseInstance(this.instancias.numAttributes());
			novoDevedor.setDataset(this.instancias);
			novoDevedor.setValue(IDADE_INDEX, devedor.getFaixaIdade());
			novoDevedor.setValue(SEXO_INDEX, devedor.getSexo());
			novoDevedor.setValue(VALOR_DIVIDA_INDEX, devedor.getFaixaValorDivida());
			novoDevedor.setValue(ATRASO_INDEX, devedor.getFaixaAtraso());
			novoDevedor.setValue(CREDOR_INDEX, devedor.getCredor());
			
			// Aplicando Previsao
			logger.info("Aplicando Previsao...");
			double resultado[] = nb.distributionForInstance(novoDevedor);
			DecimalFormat df = new DecimalFormat("#,###0.0000");
			double fazAcordo = resultado[RES_FAZ_ACORDO_INDEX];
			double naoFazAcordo = resultado[RES_NAO_FAZ_ACORDO_INDEX];
			logger.info("Probabilidade de nao fazer acordo : "+ df.format(naoFazAcordo));
			logger.info("Probabilidade de fazer acordo : "+ df.format(fazAcordo));
			
			if(fazAcordo > naoFazAcordo) {
				devedor.setFazAcordo(true);
				logger.info("Devedor Faz Acordo");
			}
			else {
				devedor.setFazAcordo(false);
				logger.info("Devedor Nao Faz Acordo");
			}
			
			return devedor;
			
		} catch (Exception e) {
			logger.error("Erro ao classificar devedor..", e);
			throw new ClassifyException();
		}
	}
}
