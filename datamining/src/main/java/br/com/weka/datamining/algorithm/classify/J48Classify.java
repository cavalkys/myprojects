package br.com.weka.datamining.algorithm.classify;

import java.text.DecimalFormat;

import org.apache.log4j.Logger;

import br.com.weka.datamining.algorithm.AlgorithmBase;
import br.com.weka.datamining.domain.Devedor;
import br.com.weka.datamining.exception.ClassifyException;
import weka.classifiers.trees.J48;
import weka.core.DenseInstance;
import weka.core.Instance;

/**
 * 
 * @author caval
 *
 *Algoritmo de Classificacao
 *Utiliza Aprendizagem de Arvores de Decisao
 *
 */
public class J48Classify extends AlgorithmBase{

	private static final Logger logger = Logger.getLogger(NaiveBayesClassify.class.getName());
	
	public J48Classify() {}

	public Devedor classificaDevedor(Devedor devedor) throws ClassifyException {
		
		logger.info("algoritmo=J48 - Aplicando classificacao para o devedor : " + devedor);
		
		try {
			
			//carregando arquivo de aprendizado
			this.carregaBaseARFF(FILE_ARFF_PATH, CLASS_INDEX);
			
			J48 arvore = new J48();
			
			logger.info("algoritmo=J48 - Criando tabela de classificacao...");
			arvore.buildClassifier(this.instancias);
			
			//criando classificacao
			Instance novoDevedor = new DenseInstance(this.instancias.numAttributes());
			novoDevedor.setDataset(this.instancias);
			novoDevedor.setValue(IDADE_INDEX, devedor.getFaixaIdade());
			novoDevedor.setValue(SEXO_INDEX, devedor.getSexo());
			novoDevedor.setValue(VALOR_DIVIDA_INDEX, devedor.getFaixaValorDivida());
			novoDevedor.setValue(ATRASO_INDEX, devedor.getFaixaAtraso());
			novoDevedor.setValue(CREDOR_INDEX, devedor.getCredor());
			
			// Aplicando Previsao
			logger.info("algoritmo=J48 - Aplicando Previsao...");
			double resultado[] = arvore.distributionForInstance(novoDevedor);
			DecimalFormat df = new DecimalFormat("#,###0.0000");
			double fazAcordo = resultado[RES_FAZ_ACORDO_INDEX];
			double naoFazAcordo = resultado[RES_NAO_FAZ_ACORDO_INDEX];
			logger.info("algoritmo=J48 - Probabilidade de nao fazer acordo : "+ df.format(naoFazAcordo));
			logger.info("algoritmo=J48 - Probabilidade de fazer acordo : "+ df.format(fazAcordo));
			
			if(fazAcordo > naoFazAcordo) {
				devedor.setFazAcordo(true);
				logger.info("algoritmo=J48 - Devedor Faz Acordo");
			}
			else {
				devedor.setFazAcordo(false);
				logger.info("algoritmo=J48 - Devedor Nao Faz Acordo");
			}
			
			return devedor;
			
		} catch (Exception e) {
			logger.error("algoritmo=J48 - Erro ao classificar devedor..", e);
			throw new ClassifyException();
		}
	}

}
