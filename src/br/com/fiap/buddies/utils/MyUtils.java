package br.com.fiap.buddies.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;

public final class MyUtils {

	public static ModelAndView redirectToErrorPage(Exception exception) {
		ModelAndView model = new ModelAndView("home/error-page");
		model.addObject("msgErro", exception.getMessage());
		model.addObject("paginaAtiva", "Página de Erro");
		return model;
	}
	
	public static void incrementarBreadcrumb(ModelAndView model, String paginaAtiva) {
		model.addObject("paginaAtiva", paginaAtiva);
	}
	
	public static void incrementarBreadcrumb(ModelAndView model, String paginaAtiva, String urlPaginaAtiva, String proximaPaginaAtiva) {
		model.addObject("paginaAtiva", paginaAtiva);
		model.addObject("urlPaginaAtiva", urlPaginaAtiva);
		model.addObject("proximaPaginaAtiva", proximaPaginaAtiva);
	}
	
	/**
	 * @author Joao Lopes
	 * Pega todos os arquivos de todas as subpastas de um determinador diretorio e
	 * coloca esses arquivos em um unico vetor
	 * @param directoryName, nome do diretorio
	 * @return a lista com todos os arquivos
	 * @throws Exception
	 */
	public static List<File> listf(String directoryName) throws Exception {

		try {
			File directory = new File(directoryName);
			List<File> resultList = new ArrayList<File>();

			// get all the files from a directory
			File[] fList = directory.listFiles();
			resultList.addAll(Arrays.asList(fList));

			for (File file : fList) {
				if (file.isDirectory()) {
					resultList.remove(file);
					resultList.addAll(listf(file.getAbsolutePath()));
				}
			}
			return resultList;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao adquirir arquivos do destino especificado: " + directoryName);
		}

	}
	
}
