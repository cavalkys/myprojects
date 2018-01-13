package br.com.weka.datamining.algorithm;

import org.apache.log4j.Logger;

import br.com.weka.datamining.exception.CargaFileException;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 * 
 * @author cavalkys
 *
 */
public class AlgorithmBase {
	
	private static final Logger logger = Logger.getLogger(AlgorithmBase.class.getName());

	protected Instances instancias;
	
	public AlgorithmBase() {}

	public void carregaBaseARFF(String filePath, int classIndex) throws CargaFileException {
		try {
			logger.info("Carregando arquivo " + filePath + " e aplicando classe "+ classIndex);
			DataSource dataSource = new DataSource(filePath);
			this.instancias = dataSource.getDataSet();
			this.instancias.setClassIndex(classIndex);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CargaFileException("Erro ao carregar arquivo Arff");
		}
	}
	
}
