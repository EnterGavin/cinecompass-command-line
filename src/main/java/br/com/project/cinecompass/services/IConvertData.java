package br.com.project.cinecompass.services;

public interface IConvertData {

   <T> T getDados(String Json, Class<T> classe);
}
