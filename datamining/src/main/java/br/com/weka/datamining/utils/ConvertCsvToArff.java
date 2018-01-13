package br.com.weka.datamining.utils;

import java.io.File;

import org.apache.log4j.Logger;

import br.com.weka.datamining.exception.ConverterException;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

/**
 * 
 * @author cavalkys
 *
 */
public class ConvertCsvToArff {
	
	private static final Logger logger = Logger.getLogger(ConvertCsvToArff.class.getName());


	public void convertCsvToArff(String csvFilePath, String arffFilePath) throws ConverterException {
		try {
			
			logger.info("Convertendo file " + csvFilePath + " para ARFF...");
			
			// Load Csv
			CSVLoader loader = new CSVLoader();
			loader.setSource(new File(csvFilePath));
			Instances data = loader.getDataSet();
			
			//Save ARFF
			ArffSaver saver = new ArffSaver();
			saver.setInstances(data);
			saver.setFile(new File(arffFilePath));
			saver.writeBatch();
			
			logger.info("Arquivo ARFF gerado - " + arffFilePath);
			
		} catch (Exception e) {
			logger.error("Erro ao converte arquivo", e);			
			throw new ConverterException("Erro ao converter arquivo");
		}
	}
}
