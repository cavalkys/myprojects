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

	protected static final String FILE_ARFF_PATH = "src/main/resources/analise_dividas.arff";
	protected static final int CLASS_INDEX = 5;
	
	protected static final int IDADE_INDEX = 0;
	protected static final int SEXO_INDEX = 1;
	protected static final int VALOR_DIVIDA_INDEX = 2;
	protected static final int ATRASO_INDEX = 3;
	protected static final int CREDOR_INDEX = 4;
	
	protected static final int RES_FAZ_ACORDO_INDEX = 1;
	protected static final int RES_NAO_FAZ_ACORDO_INDEX = 0;
	
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
